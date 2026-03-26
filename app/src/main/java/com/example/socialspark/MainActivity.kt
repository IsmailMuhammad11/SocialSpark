package com.example.socialspark

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare UI components
    private lateinit var etTimeOfDay: EditText
    private lateinit var btnSuggest: Button
    private lateinit var btnReset: Button
    private lateinit var tvSuggestion: TextView

    // Tag for Logcat
    private val TAG = "SocialSparkApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Link Kotlin variables to XML views
        etTimeOfDay = findViewById(R.id.etTimeOfDay)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)
        tvSuggestion = findViewById(R.id.tvSuggestion)

        Log.d(TAG, "App started successfully")

        // Suggestion button click
        btnSuggest.setOnClickListener {
            val userInput = etTimeOfDay.text.toString().trim()

            Log.d(TAG, "User entered: $userInput")

            if (userInput.isEmpty()) {
                tvSuggestion.text = "Please enter a time of day such as Morning, Afternoon, or Dinner."
                Log.e(TAG, "Input was empty")
            } else {
                val suggestion = getSparkSuggestion(userInput)
                tvSuggestion.text = suggestion
                Log.d(TAG, "Suggestion displayed: $suggestion")
            }
        }

        // Reset button click
        btnReset.setOnClickListener {
            etTimeOfDay.text.clear()
            tvSuggestion.text = "Your social spark will appear here."
            Log.d(TAG, "Screen reset by user")
        }
    }

    /**
     * This function checks the user's input and returns
     * a social suggestion based on the time of day.
     * if statements are used as required in the assignment.
     */
    private fun getSparkSuggestion(timeOfDay: String): String {
        val input = timeOfDay.lowercase()

        if (input == "morning") {
            return "Good morning spark: Send a cheerful 'Good morning' text to a family member."
        }

        if (input == "mid-morning" || input == "mid morning") {
            return "Connection spark: Reach out to a colleague with a quick 'Thank you.'"
        }

        if (input == "afternoon") {
            return "Fun spark: Share a funny meme or interesting link with a friend."
        }

        if (input == "afternoon snack time" || input == "snack time") {
            return "Caring spark: Send a quick 'Thinking of you' message to someone."
        }

        if (input == "dinner") {
            return "Catch-up spark: Call a friend or relative for a 5-minute catch-up."
        }

        if (input == "after dinner" || input == "night" || input == "evening") {
            return "Kindness spark: Leave a thoughtful comment on a friend's post."
        }

        Log.w(TAG, "Invalid input entered: $timeOfDay")
        return "Invalid input. Please type Morning, Mid-morning, Afternoon, Snack Time, Dinner, After Dinner, Evening, or Night."
    }
}