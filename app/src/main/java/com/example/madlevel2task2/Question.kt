package com.example.madlevel2task2

import androidx.recyclerview.widget.ItemTouchHelper

data class Question(val textValue: String, val answer: Int) {
    companion object {
        val QUESTIONS: Array<Question> = arrayOf(
            Question(
                "A 'val' and 'var' are the same",
                ItemTouchHelper.LEFT
            ),
            Question(
                "Mobile Application Development grants 12 ECTS",
                ItemTouchHelper.LEFT
            ),
            Question(
                "A Unit in Kotlin corresponds to a void in Java",
                ItemTouchHelper.RIGHT
            ),
            Question(
                "In Kotlin 'when' replaces the 'switch' operator in Java",
                ItemTouchHelper.RIGHT
            )
        )
    }
}