package com.example.fizzbuzz.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.*
import com.example.fizzbuzz.databinding.FragmentFormBinding

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val viewModel: FormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFormBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@FormFragment
            fragment = this@FormFragment
            viewModel = this@FormFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun onValidateClick() {
        viewModel._showErrors.postValue(true)
        //TODO GO TO NEXT FRAGMENT
        //findNavController().navigate()
    }
}