package com.asrstudios.islamtoolkit.others

object StringUtils {
    fun validateParenthesisOrder(inputString: String): Boolean {
        if (inputString.startsWith(")") || inputString.endsWith("(")) {
            return false
        }
        if (inputString.count { it == '(' } == inputString.count { it == ')' }){
            val openingBracketsList = mutableListOf<Char>()
            for (bracket in inputString.toCharArray()){
                if(bracket == '('){
                    openingBracketsList.add(bracket)
                }else if(bracket == ')'){
                    if(openingBracketsList.isEmpty()){
                        return false
                    }else{
                        openingBracketsList.removeLast()
                    }
                }
            }
            return openingBracketsList.isEmpty()
        }else{
            return false
        }
    }

}