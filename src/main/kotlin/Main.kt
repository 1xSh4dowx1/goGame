import model.core.Board
import model.core.Point
import model.core.Stone
import tui.askBoardSize
import tui.askInt
import tui.printBoard

fun main() {
    val size = askBoardSize()
    val board = Board(size)
    while (true) {
        val x = askInt(0..size, null)-1
        val y = askInt(0..size, null)-1
        val point = Point(x, y)
        board.set(point, Stone.BLACK)
        printBoard(board)
    }
}