package com.example.fizzbuzz.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.*
import androidx.navigation.fragment.findNavController
import com.example.fizzbuzz.databinding.FragmentFormBinding
import com.example.fizzbuzz.viewmodels.FormViewModel

class FormFragment : Fragment() {

    companion object {
        const val TAG = "FormFragment"
    }

    private lateinit var binding: FragmentFormBinding
    private val viewModel: FormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v(TAG, "onCreateView")
        binding = FragmentFormBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@FormFragment
            fragment = this@FormFragment
            viewModel = this@FormFragment.viewModel
        }

        return binding.root
    }

    fun onValidateClick() {
        Log.v(TAG, "onValidateClick")

        if (viewModel.checkValidForm()) {
            viewModel.data.apply {
                val firstNumber = firstNumber.get()?.toInt() ?: -1
                val secondNumber = secondNumber.get()?.toInt() ?: -1
                val firstWord = firstWord.get() ?: ""
                val secondWord = secondWord.get() ?: ""
                val limit = limit.get()?.toInt() ?: -1

                findNavController().navigate(
                    FormFragmentDirections.actionFormFragmentToFizzBuzzListFragment(
                        firstNumber,
                        secondNumber,
                        firstWord,
                        secondWord,
                        limit
                    )
                )
            }
        }
    }
}