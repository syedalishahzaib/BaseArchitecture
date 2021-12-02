package com.asrstudios.testingsample

import com.asrstudios.islamtoolkit.others.StringUtils
import com.google.common.truth.Truth.assertThat
import org.junit.Test


class StringUtilsTest{

    @Test
    fun `string have closing parenthesis before opening return false`(){
        assertThat(StringUtils.validateParenthesisOrder("abcde)(fgh")).isFalse()
    }

    @Test
    fun `string have opening parenthesis on end return false`(){
        assertThat(StringUtils.validateParenthesisOrder("abcde()fgh(def")).isFalse()
    }

    @Test
    fun `string have equal parenthesis but missing order return false`(){
        assertThat(StringUtils.validateParenthesisOrder("abcde()())(fgh")).isFalse()
    }

    @Test
    fun `string have parenthesis in order return true`(){
        assertThat(StringUtils.validateParenthesisOrder("abcde((()sdfs)sss)fgh")).isTrue()
    }

}