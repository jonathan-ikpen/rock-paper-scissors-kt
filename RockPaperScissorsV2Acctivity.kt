package com.example.kotlinprojects

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class RockPaperScissorsV2Acctivity : AppCompatActivity() {
    private lateinit var playerScoreText: TextView
    private lateinit var computerScoreText: TextView
    private lateinit var playerChoiceText: TextView
    private lateinit var computerChoiceText: TextView
    private lateinit var resultText: TextView

    private var playerScore = 0
    private var computerScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock_paper_scissors_v2_acctivity)

        // Initialize views
        playerScoreText = findViewById(R.id.player_score)
        computerScoreText = findViewById(R.id.computer_score)
        playerChoiceText = findViewById(R.id.player_choice)
        computerChoiceText = findViewById(R.id.computer_choice)
        resultText = findViewById(R.id.game_result)

        val rockImage: ImageView = findViewById(R.id.rock_image)
        val paperImage: ImageView = findViewById(R.id.paper_image)
        val scissorsImage: ImageView = findViewById(R.id.scissors_image)

        // Set image click listeners
        rockImage.setOnClickListener { playGame("Rock") }
        paperImage.setOnClickListener { playGame("Paper") }
        scissorsImage.setOnClickListener { playGame("Scissors") }
    }

    @SuppressLint("SetTextI18n")
    private fun playGame(playerChoice: String) {
        val computerChoice = getComputerChoice()
        val result = determineWinner(playerChoice, computerChoice)

        // Update UI
        playerChoiceText.text = playerChoice
        computerChoiceText.text = computerChoice
        resultText.text = result

        // Update result text
        resultText.text = result

        // Update scores
        playerScoreText.text = playerScore.toString()
        computerScoreText.text = computerScore.toString()
    }

    private fun getComputerChoice(): String {
        val choices = listOf("Rock", "Paper", "Scissors")
        return choices[Random.nextInt(choices.size)]
    }

    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "It's a Tie!"
            (playerChoice == "Rock" && computerChoice == "Scissors") ||
                    (playerChoice == "Paper" && computerChoice == "Rock") ||
                    (playerChoice == "Scissors" && computerChoice == "Paper") -> {
                playerScore++
                "You Win!"
            }
            else -> {
                computerScore++
                "You Lose!"
            }
        }
    }
}