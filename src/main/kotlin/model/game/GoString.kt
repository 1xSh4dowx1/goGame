package model.game

import model.core.Player
import model.core.Point

/**
 * Cada grupo de [color] conectado entre si cria uma GoString com [stones] e as suas [liberties]
 */
data class GoString(
    val color: Player,
    val stones: Set<Point>,     // usar Set porque não faz sentido ter duplicados
    val liberties: Set<Point>
) {
    /**
     * Devolve novo [GoString] com o [Point] removido das liberties
     */
    fun withoutLiberty(point: Point): GoString = TODO()

    /**
     * Devolve novo [GoString] com o [Point] adicionado às liberties
     */
    fun withLiberty(point: Point): GoString = TODO()

    /**
     * Funde este grupo com outro: une [GoString] e liberties
     *
     * Remove as posições ocupadas por [GoString] do resultado
     */
    fun mergedWith(other: GoString): GoString = TODO()

    // Se tiverem mais ideias de funções úteis é só sugerir
}
