package com.example.fizzbuzz.utils

/**
 * Generates a fizzbuzz list with a limit and a start index
 */
fun getFizzBuzzList(
    firstNumber: Int,
    secondNumber: Int,
    firstWord: String,
    secondWord: String,
    limit: Int,
    startIndex: Int
): List<String> {
    val list = mutableListOf<String>()

    if (firstNumber < 1 || secondNumber < 1)
        return list

    val result = StringBuilder()
    for (i in startIndex + 1..limit) {
        result.clear()

        if (i % firstNumber == 0)
            result.append(firstWord)
        if (i % secondNumber == 0)
            result.append(secondWord)
        if (result.isEmpty())
            result.append(i)

        list.add(result.toString())
    }

    return list
}