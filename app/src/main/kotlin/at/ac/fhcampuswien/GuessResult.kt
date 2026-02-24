package at.ac.fhcampuswien

// TODO write a data class that represents the result of a guess
data class GuessResult(private val correctDigits: Int, private val correctPositions: Int){
    override fun toString(): String = "$correctDigits:$correctPositions"
}

