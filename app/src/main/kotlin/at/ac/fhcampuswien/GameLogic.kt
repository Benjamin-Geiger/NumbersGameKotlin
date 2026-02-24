package at.ac.fhcampuswien

import at.ac.fhcampuswien.GuessResult

class GameLogic(val initialDigitsToGuess: Int = DEFAULT_DIGITS) {
    var digitsToGuess: Int = initialDigitsToGuess
        private set

    val targetNumber: List<Int> = generateRandomNumber(DEFAULT_DIGITS)


    companion object Numbers{
        val DEFAULT_DIGITS = 4

        fun generateRandomNumber(digits: Int): List<Int>{
            val numbers: MutableList<Int> = mutableListOf()
            for(i in 1..9){
                numbers.add(i)
            }
            val numbersShuffled: List<Int> = numbers.shuffled()

            val numbersLocked: MutableList<Int> = mutableListOf()

            for(i in 1..digits){
                numbersLocked.add(numbersShuffled[i])
            }
            return numbersLocked

        }
    }
}
