package com.sam.foodmenudemoapp.questionone

import org.junit.Assert
import org.junit.Test

/**
 * Given a string str consisting of letters only and an integer n, the task is to replace every character of the given string by a character which is n times more than it. If the letter exceeds ‘z’, then start checking from ‘a’ in a cyclic manner.

Examples:
Input: str = “abc”, n = 2
Output: cde
a is moved by 2 times which results in character c
b is moved by 2 times which results in character d
c is moved by 2 times which results in character e

Input: str = “abc”, n= 28
Output: cde
a is moved 25 times, z is reached. Then the 26th character will be a, 27th b and 28th c.
b is moved 24 times, z is reached. 28-th is d.
c is moved 23 times, z is reached. 28-th is f.

Question:
a/ Write an algorithm to solve the above issue. Please consider the complexity of the algorithm.
b/ What is the disadvantage of using the ASCII value of the letters to solve this problem?
 */
class StringManipulationTest {


    /**
     * Answer:
     * Order of complexity is O(N)
     * The disadvantage of using ASCII value manipulation is that we need to handle separately for lower case and upper case letters.
     * Logic is as below
     */
    fun replaceString(stringValue: String, number:Int):String{
        val actualNumberForShift=number%26
        var index:Int=0;
        var chars = stringValue.toCharArray()
        while (index<stringValue.length){
            if(chars[index].isLowerCase()) {
                val character: Int = chars[index] - 'a'
                chars[index] = ('a'.toInt() + ((character + actualNumberForShift) % 26)).toChar()
            }else{
                val character: Int = chars[index] - 'A'
                chars[index] = ('A'.toInt() + ((character + actualNumberForShift) % 26)).toChar()
            }
            index++
        }
        val output= String(chars)
        println("output is $output")
        return output
    }
    @Test
    fun isReplaceStringCorrect() {

        Assert.assertEquals("cde", replaceString("abc",2))
        Assert.assertEquals("cde", replaceString("abc",28))
        Assert.assertEquals("abc", replaceString("abc",26))
        Assert.assertEquals("CDE", replaceString("ABC",2))
        Assert.assertEquals("CDE", replaceString("ABC",28))
        Assert.assertEquals("ABC", replaceString("ABC",26))
        Assert.assertEquals("CdE", replaceString("AbC",2))
        Assert.assertEquals("CdE", replaceString("AbC",28))
        Assert.assertEquals("AbC", replaceString("AbC",26))
        Assert.assertEquals("ade", replaceString("xab",3))
        Assert.assertEquals("ade", replaceString("xab",29))
        Assert.assertEquals("xab", replaceString("xab",26))

    }
}