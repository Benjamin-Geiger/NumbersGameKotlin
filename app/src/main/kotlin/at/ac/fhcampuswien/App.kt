package at.ac.fhcampuswien

fun main() {
    println("Hello Kotlin!")
    // Start the game
    // user GameManager.start()
    var Game = GameLogic
    val num = Game.generateRandomNumber(4)
    println(num)
}