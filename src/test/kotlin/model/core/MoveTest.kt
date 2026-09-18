package model.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertSame

class MoveTest {

    @Test
    fun `Play holds the given point`() {
        val point = Point(2, 3)
        val move = Move.Play(point)
        assertEquals(point, move.point)
    }

    @Test
    fun `Play with same point are equal`() {
        assertEquals(Move.Play(Point(1, 1)), Move.Play(Point(1, 1)))
    }

    @Test
    fun `Play with different points are not equal`() {
        assertNotEquals(Move.Play(Point(0, 0)), Move.Play(Point(0, 1)))
    }

    @Test
    fun `Pass and Resign are singletons and distinct`() {
        assertSame(Move.Pass, Move.Pass)
        assertSame(Move.Resign, Move.Resign)
        assertNotEquals<Move>(Move.Pass, Move.Resign)
    }


    @Test
    fun `sealed subtype is distinguishable via when`() {
        val moves: List<Move> = listOf(Move.Play(Point(0, 0)), Move.Pass, Move.Resign)
        val kinds = moves.map { move ->
            when (move) {
                is Move.Play    -> "play"
                is Move.Pass    -> "pass"
                is Move.Resign  -> "resign"
            }
        }
        assertEquals(listOf("play", "pass", "resign"), kinds)
    }
}
