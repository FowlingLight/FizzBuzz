package com.example.fizzbuzz.views.customs

import android.content.Context
import android.text.*
import android.util.*
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import androidx.core.view.isVisible
import androidx.databinding.*
import com.example.fizzbuzz.R
import com.example.fizzbuzz.databinding.CustomTextFieldBinding
import com.example.fizzbuzz.utils.doNothing

class CustomTextField(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    var binding = CustomTextFieldBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.clearTextImageView.apply {
            setOnClickListener {
                clearData()
            }
            isVisible = binding.textInputEditText.text.toString().isNotEmpty()
        }

        // Search for the stock android:inputType attribute
        val styledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomTextField)

        for (i in 0 until styledAttributes.indexCount) {
            when (val attr = styledAttributes.getIndex(i)) {
                R.styleable.CustomTextField_android_inputType -> {
                    val inputType = styledAttributes.getInt(attr, EditorInfo.TYPE_NULL)

                    if (inputType != EditorInfo.TYPE_NULL)
                        binding.textInputEditText.inputType = inputType
                }
                else -> doNothing()
            }
        }

        styledAttributes.recycle()
    }

    /**
     * Clears the field
     */
    private fun clearData() {
        binding.textInputEditText.setText("")
    }

    companion object {
        @JvmStatic
        @BindingAdapter("valueAttrChanged")
        fun setListener(view: CustomTextField, listener: InverseBindingListener?) {
            listener?.let {
                view.binding.textInputEditText.addTextChangedListener(object : TextWatcher {

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                        doNothing()
                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        doNothing()
                    }

                    // Updates the liveData provided
                    override fun afterTextChanged(s: Editable?) {
                        listener.onChange()

                        s?.let {
                            view.binding.clearTextImageView.isVisible = s.toString().isNotEmpty()
                        }
                    }
                })
            }
        }

        @JvmStatic
        @BindingAdapter("value")
        fun setValue(view: CustomTextField, value: String?) {
            if (value != view.binding.textInputEditText.text?.toString()) {
                view.binding.textInputEditText.setText(value)
            }
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "value")
        fun getValue(view: CustomTextField): String {
            return view.binding.textInputEditText.text.toString()
        }

        @JvmStatic
        @BindingAdapter("hint")
        fun setHint(view: CustomTextField, value: String?) {
            view.binding.textInputField.hint = value
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "hint")
        fun getHint(view: CustomTextField): String {
            return view.binding.textInputField.hint.toString()
        }

        @JvmStatic
        @BindingAdapter("showError")
        fun setShowError(view: CustomTextField, value: Boolean) {
            view.binding.errorTextView.isVisible = value
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "showError")
        fun getShowError(view: CustomTextField): Boolean = view.binding.errorTextView.isVisible

        @JvmStatic
        @BindingAdapter("errorMessage")
        fun setErrorMessage(view: CustomTextField, value: String?) {
            view.binding.errorTextView.text = value
        }

        @JvmStatic
        @InverseBindingAdapter(attribute = "errorMessage")
        fun getErrorMessage(view: CustomTextField): String = view.binding.errorTextView.text.toString()

        @JvmStatic
        @BindingAdapter("maxLength")
        fun setMaxLength(view: CustomTextField, value: Int) {
            view.binding.textInputEditText.filters = arrayOf(InputFilter.LengthFilter(value))
        }
    }
}