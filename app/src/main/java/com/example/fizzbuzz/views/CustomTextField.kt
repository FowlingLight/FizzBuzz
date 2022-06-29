package com.example.fizzbuzz.views

import android.content.Context
import android.util.AttributeSet
import android.view.*
import androidx.lifecycle.*
import com.example.fizzbuzz.databinding.CustomTextFieldBinding

class CustomTextField(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var _liveData = MutableLiveData<String>()

    val getLiveText: LiveData<String> = _liveData

    init {
        val binding = CustomTextFieldBinding.inflate(LayoutInflater.from(context))

        binding.view = this
    }

    fun clearData() {
        _liveData.postValue("")
    }
}