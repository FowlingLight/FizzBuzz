package com.example.fizzbuzz.views.customs

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.*
import androidx.lifecycle.*
import com.example.fizzbuzz.databinding.CustomTextFieldBinding

class CustomTextField(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    var _liveData = MutableLiveData<String>()

    lateinit var binding: CustomTextFieldBinding

    init {
        val binding = CustomTextFieldBinding.inflate(LayoutInflater.from(context), this, true)

        binding.view = this
        binding.lifecycleOwner
    }

    fun clearData() {
        _liveData.postValue("")
    }

    fun getText(): String? = _liveData.value

    companion object {
        @BindingAdapter("customText")
        @JvmStatic
        fun setTextValue(view: CustomTextField, value: String?) {
            if (value != view._liveData.value) view._liveData.postValue(value)
        }

        @InverseBindingAdapter(attribute = "customText")
        @JvmStatic
        fun getTextValue(view: CustomTextField): String? = view._liveData.value

        @BindingAdapter("showError")
        @JvmStatic
        fun setShowError(view: CustomTextField, value: Boolean?) {
            if (value != view.binding.showError) view.binding.showError = value
        }

        @InverseBindingAdapter(attribute = "showError")
        @JvmStatic
        fun getShowError(view: CustomTextField): Boolean? = view.binding.showError
    }
}