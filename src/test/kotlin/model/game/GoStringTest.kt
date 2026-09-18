package model.game

import model.core.Player
import model.core.Point
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class GoStringTest {

    private val black = Player.BLACK

    private val group = GoString(
        color = black,
        stones = setOf(Point(22), Point(23)),
        liberties = setOf(Point(12), Point(32), Point(21), Point(13), Point(33), Point(24))
    )

    @Test
    fun `withoutLiberty removes the point from liberties`() {
        assertFalse(Point(12) in group.withoutLiberty(Point(12)).liberties)
    }

    @Test
    fun `withoutLiberty keeps remaining liberties intact`() {
        assertEquals(group.liberties - Point(12), group.withoutLiberty(Point(12)).liberties)
    }

    @Test
    fun `withoutLiberty does not change stones`() {
        assertEquals(group.stones, group.withoutLiberty(Point(12)).stones)
    }

    @Test
    fun `withoutLiberty on absent point leaves liberties unchanged`() {
        assertEquals(group.liberties, group.withoutLiberty(Point(99)).liberties)
    }

    @Test
    fun `withLiberty adds the point to liberties`() {
        assertTrue(Point(12) in group.withoutLiberty(Point(12)).withLiberty(Point(12)).liberties)
    }

    @Test
    fun `withLiberty does not change stones`() {
        assertEquals(group.stones, group.withLiberty(Point(99)).stones)
    }

    @Test
    fun `mergedWith combines stones from both groups`() {
        val other = GoString(black, setOf(Point(24)), setOf(Point(25), Point(14), Point(34)))
        assertEquals(setOf(Point(22), Point(23), Point(24)), group.mergedWith(other).stones)
    }

    @Test
    fun `mergedWith removes occupied positions from liberties`() {
        // Point(24) era liberty de group, mas passa a ser pedra após merge
        val other = GoString(black, setOf(Point(24)), setOf(Point(25), Point(14), Point(34)))
        assertFalse(Point(24) in group.mergedWith(other).liberties)
    }

    @Test
    fun `mergedWith unions liberties from both groups`() {
        val other = GoString(black, setOf(Point(24)), setOf(Point(25), Point(14), Point(34)))
        assertTrue(Point(25) in group.mergedWith(other).liberties)
    }

    @Test
    fun `mergedWith preserves color`() {
        val other = GoString(black, setOf(Point(24)), setOf(Point(25)))
        assertEquals(black, group.mergedWith(other).color)
    }
}
