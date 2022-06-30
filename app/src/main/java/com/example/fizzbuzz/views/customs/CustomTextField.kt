package com.example.fizzbuzz.views.customs

import android.content.Context
import android.text.*
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.databinding.*
import androidx.lifecycle.MutableLiveData
import com.example.fizzbuzz.databinding.CustomTextFieldBinding
import com.example.fizzbuzz.utils.doNothing

class CustomTextField(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    var _liveData = MutableLiveData<String>()

    var binding = CustomTextFieldBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.view = this
        binding.lifecycleOwner
    }

    fun clearData() {
        _liveData.postValue("")
    }

    fun getText(): String? = _liveData.value

    companion object {
        @BindingAdapter("showError")
        @JvmStatic
        fun setShowError(view: CustomTextField, value: Boolean?) {
            if (value != view.binding.showError) view.binding.showError = value
        }

        @InverseBindingAdapter(attribute = "showError")
        @JvmStatic
        fun getShowError(view: CustomTextField): Boolean? = view.binding.showError

        @BindingAdapter("valueAttrChanged")
        @JvmStatic
        fun setListener(view: CustomTextField, listener: InverseBindingListener) {
            view.binding.textInputEditText.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    doNothing()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    doNothing()
                }

                override fun afterTextChanged(s: Editable?) {
                    listener.onChange()
                }
            })
        }

        @BindingAdapter("value")
        @JvmStatic
        fun setValue(view: CustomTextField, value: String) {
            if (value != view.binding.textInputEditText.text?.toString()) {
                view.binding.textInputEditText.setText(value)
            }
        }

        @InverseBindingAdapter(attribute = "value")
        @JvmStatic
        fun getValue(view: CustomTextField): String {
            return view.binding.textInputEditText.text.toString()
        }
    }
}