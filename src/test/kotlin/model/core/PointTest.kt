package model.core

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PointTest {

    @Test
    fun `toString returns correct format`() {
        assertEquals("(3,7)", Point(3, 7).toString())
        assertEquals("(0,0)", Point(0, 0).toString())
    }

    @Test
    fun `points with same coordinates are equal`() {
        assertEquals(Point(2, 5), Point(2, 5))
    }

    @Test
    fun `points with different coordinates are not equal`() {
        assertNotEquals(Point(1, 2), Point(2, 1))
        assertNotEquals(Point(0, 1), Point(0, 0))
    }

    @Test
    fun `copy produces independent point with changed values`() {
        val original = Point(3, 4)
        assertEquals(Point(9, 4), original.copy(x = 9))
        assertEquals(Point(3, 1), original.copy(y = 1))
    }
}
