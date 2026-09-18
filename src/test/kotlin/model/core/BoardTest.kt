package model.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BoardTest {

    @Test
    fun `valid sizes are accepted`() {
        Board.VALID_SIZES.forEach { Board(it) }
    }

    @Test
    fun `test range sizes are accepted`() {
        (Board.TEST_VALUE..Board.VALID_SIZES.max()).forEach { Board(it) }
    }

    @Test
    fun `invalid size throws`() {
        assertFailsWith<IllegalArgumentException> { Board(0) }
        assertFailsWith<IllegalArgumentException> { Board(Board.VALID_SIZES.max() + 1) }
    }

    @Test
    fun `new board is all empty`() {
        val board = testBoard()
        for (x in 0 until Board.TEST_VALUE)
            for (y in 0 until Board.TEST_VALUE)
                assertEquals(Stone.EMPTY, board.get(Point(x, y)))
    }

    @Test
    fun `set and get stone`() {
        val board = testBoard().withStones(Point(1, 2) plays Stone.BLACK)
        assertEquals(Stone.BLACK, board.get(Point(1, 2)))
    }

    @Test
    fun `set overwrites stone`() {
        val board = testBoard().withStones(
            Point(0, 0) plays Stone.BLACK,
            Point(0, 0) plays Stone.WHITE
        )
        assertEquals(Stone.WHITE, board.get(Point(0, 0)))
    }

    @Test
    fun `out of bounds throws`() {
        val board = testBoard()
        assertFailsWith<IllegalArgumentException> { board.get(Point(-1, 0)) }
        assertFailsWith<IllegalArgumentException> { board.get(Point(Board.TEST_VALUE, 0)) }
        assertFailsWith<IllegalArgumentException> { board.set(Point(0, -1), Stone.BLACK) }
        assertFailsWith<IllegalArgumentException> { board.set(Point(0, Board.TEST_VALUE), Stone.BLACK) }
    }
}
