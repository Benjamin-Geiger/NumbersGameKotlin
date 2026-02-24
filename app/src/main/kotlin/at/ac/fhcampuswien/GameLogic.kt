package at.ac.fhcampuswien

import at.ac.fhcampuswien.GuessResult

class GameLogic(val initialDigitsToGuess: Int = DEFAULT_DIGITS) {
    var digitsToGuess: Int = initialDigitsToGuess
        private set

    val targetNumber: List<Int> = generateRandomNumber(digitsToGuess)


    companion object Numbers{
        val DEFAULT_DIGITS = 4

        fun generateRandomNumber(digits: Int): List<Int>{
            val numbers: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
            numbers.shuffle()

            for(i in 1..(9 - digits)){
                numbers.removeLast()
            }

            return numbers.toList()
        }


    }


}
