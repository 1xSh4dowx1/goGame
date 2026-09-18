package model.core

import kotlin.test.Test
import kotlin.test.assertEquals

class PlayerTest {

    @Test
    fun `opponent of BLACK is WHITE`() {
        assertEquals(Player.WHITE, Player.BLACK.opponent())
    }

    @Test
    fun `opponent of WHITE is BLACK`() {
        assertEquals(Player.BLACK, Player.WHITE.opponent())
    }
}
