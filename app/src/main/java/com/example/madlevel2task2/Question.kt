package com.example.madlevel2task2

data class Question(val textValue: String, val answer: Boolean) {
    companion object {
        val QUESTIONS_LIST: Array<String> = arrayOf(
            "A 'val' and 'var' are the same",
            "Mobile Application Development grants 12 ECTS",
            "A Unit in Kotlin corresponds to a void in Java",
            "In Kotlin 'when' replaces the 'switch' operator in Java"
        )

        val QUESTION_ANSWERS: Array<Boolean> = arrayOf(false, false, true, true)
    }
}