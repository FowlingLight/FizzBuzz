package com.example.fizzbuzz.models

import androidx.databinding.ObservableField

data class FizzBuzzConfigsModel(
    var firstNumber: ObservableField<String> = ObservableField<String>(),
    var secondNumber: ObservableField<String> = ObservableField<String>(),
    var firstWord: ObservableField<String> = ObservableField<String>(),
    var secondWord: ObservableField<String> = ObservableField<String>(),
    var limit: ObservableField<String> = ObservableField<String>(),
)