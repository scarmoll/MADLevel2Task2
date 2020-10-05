package com.example.madlevel2task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val questions = arrayListOf<Question>()
    private val questionAdapter = QuestionAdapter(questions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        // Initialize the recycler view
        binding.rvQuestions.layoutManager = LinearLayoutManager(
            this@MainActivity, RecyclerView.VERTICAL, false
        )
        binding.rvQuestions.adapter = questionAdapter
        binding.rvQuestions.addItemDecoration(
            DividerItemDecoration(
                this@MainActivity,
                DividerItemDecoration.VERTICAL
            )
        )

        for (i in Question.QUESTIONS.indices) {
            questions.add(Question(Question.QUESTIONS[i].textValue, Question.QUESTIONS[i].answer))
        }

        createItemTouchHelper().attachToRecyclerView(binding.rvQuestions)
    }

    private fun createItemTouchHelper(): ItemTouchHelper {
        val callback = object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val selectedQuestion: Question = questions[position]

                if (direction == selectedQuestion.answer
                ) {
                    questions.removeAt(position)
                } else {
                    Snackbar.make(
                        binding.messageContainer,
                        "This question will not be removed",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                questionAdapter.notifyDataSetChanged()
            }

        }

        return ItemTouchHelper(callback)
    }
}