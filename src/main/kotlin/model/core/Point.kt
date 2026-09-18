package model.core

/**
 * Representação de uma coordenada do tabuleiro
 */
data class Point(val x: Int, val y: Int) {
    override fun toString(): String = "($x,$y)"

    /**
     * Função auxiliar para calcular as [model.game.GoString]
     */
    fun isNear(p1: Point, p2: Point): Boolean = p1.x == p2.x || p1.y == p2.y

    /*
     Nesta situação só deve existir o GoString das Stones B
     0  1   2   3   4
     1  B   B
     2  B
     3
     4              W
     5          W
     */

}
