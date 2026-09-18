package model.core

/** Cria um Point a partir de um número de dois dígitos:
 *
 *  Point(23) → Point(2,3) */
fun Point(n: Int) = Point(n / 10, n % 10)

fun testBoard(size: Int = Board.TEST_VALUE) = Board(size)

fun Board.withStones(vararg plays: Pair<Point, Stone>): Board {
    plays.forEach { (point, stone) -> set(point, stone) }
    return this
}

/**
 * Infix fun é uma função que não precisa de () ou . para ser chamada.
 *
 * Exemplo infix fun Int.soma(outro: Int) : Int
 *
 * val soma = 10 soma 3 → 13
 */
infix fun Point.plays(stone: Stone) = Pair(this, stone)
