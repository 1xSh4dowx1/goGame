package tui

import model.core.Board

/**
 * Simple TUI UTILS
 */
fun askYesNo(prompt: String): Boolean {
    print("$prompt (y/n): ")
    return readln().trim().lowercase() == "y"
}

fun askInt(range: IntRange, prompt: String?): Int {
    while (true) {
        if (prompt != null) {
            print(prompt)
        }
        val input = readln().trim().toIntOrNull()
        if (input != null && input in range) return input
        println("Invalid. Try again.")
    }
}

/**
 * How to interact with the user
 */
fun askSize(): Int {
    while (true) {
        print("Choose board size ${Board.VALID_SIZES}: ")
        val input = readln().trim().toIntOrNull()
        if (input != null && input in Board.VALID_SIZES) return input
        println("Invalid size. Try again.")
    }
}

fun askBoardSize(): Int =
    if (askYesNo("Test mode?"))
        askInt(Board.TEST_VALUE..Board.VALID_SIZES.max(), "Choose size (${Board.TEST_VALUE}..${Board.VALID_SIZES.max()}): ")
    else
        askSize()
