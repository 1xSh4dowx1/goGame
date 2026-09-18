package tui

import model.core.Board
import model.core.Player
import model.core.Point
import model.core.Stone

/**
 * Função temporária para ver o board
 */
fun printBoard(board: Board) {
    print("  ")
    repeat(board.size) { x -> print(" ${'A' + x}") }
    println()

    for (y in 0 until board.size) {
        print("${y + 1}".padStart(2))
        for (x in 0 until board.size) {
            val symbol = when (board.get(Point(x, y))) {
                Stone.EMPTY -> "+"
                Stone.BLACK -> "B"
                Stone.WHITE -> "W"
            }
            print(" $symbol")
        }
        println()
    }
}

const val BLACK_SYMBOL = 'B'
const val WHITE_SYMBOL = 'W'
const val EMPTY_SYMBOL = '+'

private fun Player.symbol(): Char {
    TODO()
}

fun turnShow(){
    TODO()
}

fun gameShow(){
    TODO()
}
fun scoreShow(){
    TODO()
}
