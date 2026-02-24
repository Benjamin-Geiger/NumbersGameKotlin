package at.ac.fhcampuswien

import at.ac.fhcampuswien.GuessResult

class GameLogic(val initialDigitsToGuess: Int = DEFAULT_DIGITS) {
    var digitsToGuess: Int = initialDigitsToGuess
        private set

    var targetNumber: List<Int> = generateRandomNumber(digitsToGuess)

    val evaluateGuess: (String) -> GuessResult = {
        userGuess ->

        var userInt: Int = userGuess.toInt()
        val userNumbers: MutableList<Int> = mutableListOf()

        for (i in 1..initialDigitsToGuess) {
            userNumbers.add(userInt % 10)
            userInt /= 10
        }

        var correctDigits: Int = 0
        var correctPositions: Int = 0

        for (i in 0..<initialDigitsToGuess) {
            if (userNumbers[i] in targetNumber) correctDigits++
            if (userNumbers[(initialDigitsToGuess - 1) - i] == targetNumber[i]) correctPositions++
        }

        GuessResult(correctDigits, correctPositions)
    }

    var isValidGuess: (String?) -> Boolean = { userGuess ->
        userGuess != null &&
        userGuess.length == digitsToGuess &&
        userGuess.all { char -> char in '1'..'9' } &&
        userGuess.toSet().size == digitsToGuess
    }
    
    fun isWinningGuess(res: GuessResult): Boolean = res.toString() == "$digitsToGuess:$digitsToGuess"

    companion object Numbers{
        val DEFAULT_DIGITS = 4

        fun generateRandomNumber(digits: Int): List<Int>{
            val numbers: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            numbers.shuffle()

            for(i in 1..(9 - digits)) {
                numbers.removeLast()
            }

            return numbers.toList()
        }
    }




}
