package model.core

/**
 * Simple definition of [Board].
 *
 * - It contains the pieces used in the board in a IntArray.
 * - It uses validated sizes defined previously.
 * - It validates every [Point] used inside the [Board].
 */
data class Board(val size: Int) {

    companion object {
        const val TEST_VALUE = 4
        val VALID_SIZES = listOf(9, 13, 19)
    }

    /**
     * Forma de validar o size do [Board]
     */
    init {
        require(size in VALID_SIZES || size in TEST_VALUE..VALID_SIZES.max()) { "size must be in VALID_SIZES" }
    }

    val cells = IntArray(size * size)

    /**
     * Função para colocar uma [Stone] num [Point] do [Board]
     */
    fun set(point: Point, stone: Stone) {
        requireValid(point)
        // cells[point.y * size + point.x] = stone.ordinal
        cells[point.y * size + point.x] = stone.toInt()
    }

    /**
     * Função para ver uma [Stone] num [Point] do [Board]
     */
    fun get(point: Point): Stone {
        requireValid(point)
        // return Stone.entries[cells[point.y * size + point.x]]
        return cells[point.y * size + point.x].toStone()
    }

    /**
     * Função auxiliar para validar um [Point] dentro dos bounds do [Board]
     */
    private fun requireValid(point: Point) {
        require(point.x in 0 until size && point.y in 0 until size) { "Point out of bounds" }
    }
}

