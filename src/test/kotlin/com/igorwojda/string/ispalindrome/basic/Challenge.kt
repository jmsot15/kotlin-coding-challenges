package com.igorwojda.string.ispalindrome.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPalindrome(str: String): Boolean {
    var left = 0
    var right = str.lastIndex

    while (left < right) {
//        if (!str[left].isLetterOrDigit()) {
//            left += 1
//            continue
//        }
//        else if (!str[right].isLetterOrDigit()) {
//            right -= 1
//            continue
//        }
//        else {
            if (str[left] != str[right])
                return false
            left += 1
            right -= 1
//        }
    }

    return true
}

private class Test {

    @Test
    fun `'aba' is a palindrome`() {
        isPalindrome("aba") shouldBeEqualTo true
    }

    @Test
    fun `' aba' is not a palindrome`() {
        isPalindrome(" aba") shouldBeEqualTo false
    }

    @Test
    fun `'aba ' is not a palindrome`() {
        isPalindrome("aba ") shouldBeEqualTo false
    }

    @Test
    fun `'greetings' is not a palindrome`() {
        isPalindrome("greetings") shouldBeEqualTo false
    }

    @Test
    fun `'1000000001' a palindrome`() {
        isPalindrome("1000000001") shouldBeEqualTo true
    }

    @Test
    fun `'Fish hsif' is not a palindrome`() {
        isPalindrome("Fish hsif") shouldBeEqualTo false
    }

    @Test
    fun `'pennep' a palindrome`() {
        isPalindrome("pennep") shouldBeEqualTo true
    }
}
