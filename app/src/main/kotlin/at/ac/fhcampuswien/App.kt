package at.ac.fhcampuswien

fun main() {
    println("Hello Kotlin!")
    // Start the game
    // user GameManager.start()
    var Game = GameLogic()
    println(Game.targetNumber)
    println((Game.evaluateGuess("5439").toString()))


}