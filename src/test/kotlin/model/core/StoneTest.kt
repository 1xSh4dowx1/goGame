package model.core

import kotlin.test.Test
import kotlin.test.assertEquals

class StoneTest {

    // Estes testes documentam os ordinals dos quais Board depende para serializar células.
    // Se alguém reordenar o enum, estes testes falham imediatamente.
    @Test
    fun `EMPTY has ordinal 0`() {
        assertEquals(0, Stone.EMPTY.ordinal)
    }

    @Test
    fun `BLACK has ordinal 1`() {
        assertEquals(1, Stone.BLACK.ordinal)
    }

    @Test
    fun `WHITE has ordinal 2`() {
        assertEquals(2, Stone.WHITE.ordinal)
    }

    @Test
    fun `entries contains exactly three values`() {
        assertEquals(3, Stone.entries.size)
    }
}
