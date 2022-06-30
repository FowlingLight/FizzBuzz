package com.example.fizzbuzz.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.fizzbuzz.databinding.FragmentFizzBuzzListBinding
import com.example.fizzbuzz.utils.*
import com.example.fizzbuzz.views.adapters.FizzBuzzAdapter
import kotlin.math.min

class FizzBuzzListFragment : Fragment() {

    companion object {
        const val TAG = "FizzBuzzListFragment"
    }

    private lateinit var binding: FragmentFizzBuzzListBinding
    private val args: FizzBuzzListFragmentArgs by navArgs()

    private var index = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.v(TAG, "onCreateView")

        binding = FragmentFizzBuzzListBinding.inflate(inflater, container, false)

        binding.apply {
            lifecycleOwner = this@FizzBuzzListFragment
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.v(TAG, "onViewCreated")

        super.onViewCreated(view, savedInstanceState)

        val adapter = FizzBuzzAdapter()

        binding.fizzBuzzRecyclerView.apply {
            this.adapter = adapter
            addOnScrollListener(object :
                RecyclerView.OnScrollListener() {

                // Asks for another page if the limit isn't reached
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if (!recyclerView.canScrollVertically(1) && index < args.limit) {
                        Log.v(TAG, "Asking for more")

                        adapter.addData(
                            getFizzBuzzList(
                                args.firstNumber,
                                args.secondNumber,
                                args.firstWord,
                                args.secondWord,
                                min(args.limit, MAX_FIZZ_BUZZ_PER_PAGE * (index + 1)),
                                MAX_FIZZ_BUZZ_PER_PAGE * index
                            )
                        )
                        index += 1
                    }
                }
            })
        }

        // Asks for the first page
        adapter.addData(
            getFizzBuzzList(
                args.firstNumber,
                args.secondNumber,
                args.firstWord,
                args.secondWord,
                min(args.limit, MAX_FIZZ_BUZZ_PER_PAGE),
                0
            )
        )
    }
}