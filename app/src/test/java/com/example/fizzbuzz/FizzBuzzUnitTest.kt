package com.example.fizzbuzz

import com.example.fizzbuzz.utils.getFizzBuzzList
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FizzBuzzUnitTest {
    @Test
    fun nominalFizzBuzzListTest() {
        val goodList = listOf(
            "1",
            "2",
            "fizz",
            "4",
            "buzz",
            "fizz",
            "7",
            "8",
            "fizz",
            "buzz",
            "11",
            "fizz",
            "13",
            "14",
            "fizzbuzz",
            "16"
        )
        assertEquals(getFizzBuzzList(3, 5, "fizz", "buzz", 16, 0), goodList)
    }

    @Test
    fun smallestFizzBuzzListTest() {
        val goodList = listOf("1")
        assertEquals(getFizzBuzzList(3, 5, "fizz", "buzz", 1, 0), goodList)
    }

    @Test
    fun invalidLimitFizzBuzzListTest() {
        val goodList = listOf<String>()
        assertEquals(getFizzBuzzList(3, 5, "fizz", "buzz", -1, 0), goodList)
    }

    @Test
    fun invalidFirstNumberFizzBuzzListTest() {
        val goodList = listOf<String>()
        assertEquals(getFizzBuzzList(-1, 5, "fizz", "buzz", 16, 0), goodList)
    }

    @Test
    fun invalidSecondNumberFizzBuzzListTest() {
        val goodList = listOf<String>()
        assertEquals(getFizzBuzzList(3, 0, "fizz", "buzz", 16, 0), goodList)
    }
}