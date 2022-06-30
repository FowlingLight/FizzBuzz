package com.example.fizzbuzz.viewmodels

import androidx.lifecycle.*

class FormViewModel : ViewModel() {
    var _firstNumber = MutableLiveData<String>()
    var _secondNumber = MutableLiveData<String>()
    var _firstWord = MutableLiveData<String>()
    var _secondWord = MutableLiveData<String>()
    var _limit = MutableLiveData<String>()
    var _showErrors = MutableLiveData<Boolean>()

    val getFirstNumber: LiveData<String> = _firstNumber
    val getSecondNumber: LiveData<String> = _secondNumber
    val getFirstWord: LiveData<String> = _firstWord
    val getSecondWord: LiveData<String> = _secondWord
    val getLimit: LiveData<String> = _limit

    /**
     * Checks if every field of the form has been filled and with valid data
     */
    fun checkValidForm(): Boolean {
        if ((_firstNumber.value?.toInt() ?: 0) == 0) return false
        if ((_secondNumber.value?.toInt() ?: 0) == 0) return false
        if (_firstWord.value?.isEmpty() != false) return false
        if (_secondWord.value?.isEmpty() != false) return false
        if ((_limit.value?.toInt() ?: 0) == 0) return false

        return true
    }

    /**
     * Shows error messages where needed
     */
    fun displayErrors() {
        _showErrors.postValue(true)
    }
}