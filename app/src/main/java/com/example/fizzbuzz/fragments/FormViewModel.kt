package com.example.fizzbuzz.fragments

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
}