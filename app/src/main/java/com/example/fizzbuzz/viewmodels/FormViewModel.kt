package com.example.fizzbuzz.viewmodels

import androidx.lifecycle.*
import com.example.fizzbuzz.models.FizzBuzzConfigsModel

class FormViewModel : ViewModel() {
    val data = FizzBuzzConfigsModel()

    private var _firstNumberError = MutableLiveData<Boolean>()
    val firstNumberError: LiveData<Boolean> = _firstNumberError

    private var _secondNumberError = MutableLiveData<Boolean>()
    val secondNumberError: LiveData<Boolean> = _secondNumberError

    private var _firstWordError = MutableLiveData<Boolean>()
    val firstWordError: LiveData<Boolean> = _firstWordError

    private var _secondWordError = MutableLiveData<Boolean>()
    val secondWordError: LiveData<Boolean> = _secondWordError

    private var _limitError = MutableLiveData<Boolean>()
    val limitError: LiveData<Boolean> = _limitError

    /**
     * Checks if every field of the form has been filled and with valid data
     */
    fun checkValidForm(): Boolean {
        var result = true

        resetErrors()

        data.apply {
            if ((firstNumber.get()?.toInt() ?: 0) < 1) {
                _firstNumberError.postValue(true)
                result = false
            }
            if ((secondNumber.get()?.toInt() ?: 0) < 1) {
                _secondNumberError.postValue(true)
                result = false
            }
            if (firstWord.get()?.isEmpty() != false) {
                _firstWordError.postValue(true)
                result = false
            }
            if (secondWord.get()?.isEmpty() != false) {
                _secondWordError.postValue(true)
                result = false
            }
            if ((limit.get()?.toInt() ?: 0) < 1) {
                _limitError.postValue(true)
                result = false
            }
        }

        return result
    }

    /**
     * Removes all the error flags
     */
    private fun resetErrors() {
        _firstNumberError.postValue(false)
        _secondNumberError.postValue(false)
        _firstWordError.postValue(false)
        _secondWordError.postValue(false)
        _limitError.postValue(false)
    }
}