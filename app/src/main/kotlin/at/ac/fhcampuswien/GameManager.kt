package at.ac.fhcampuswien

import kotlin.system.exitProcess

object GameManager {

    private val gameLogic = GameLogic()

    fun start(): Unit {
        print("Welcome to the Number Guessing Game!\n" +
                "Guess a 4-digit number with unique digits.\n" +
                "Type 'exit' to leave game!\n")

        var won = false

        while (!won) {
            var guess: String?

            do {
                guess = getUserGuess()
                if (gameLogic.isValidGuess(guess)) break else print("Invalid number, try again.\n")
            } while (true)

            var result: GuessResult = gameLogic.evaluateGuess(guess!!)
            println(result)

            if (gameLogic.isWinningGuess(result)) { println("OMG YOU WON YAY!!"); won = true}
        }

        println("Want to play again? Type 'yes' or 'no': ")

        while (true) {
            val input = readlnOrNull()
            when (input) {
                "yes" -> {
                    gameLogic.targetNumber = GameLogic.generateRandomNumber(4)
                    start()
                }
                "no" -> exitProcess(0)
                else -> println("Invalid input, try again.\n")
            }
        }
    }

    private fun getUserGuess(): String? {
        print("ENTER YOUR GUESS: ")
        val input = readlnOrNull()
        if (input == "exit") exitProcess(0) else return input
    }
}
