package model.core

/**
 * Representação simples de jogador
 */
enum class Player {
    BLACK,
    WHITE;

    fun opponent(): Player = if (this == BLACK) WHITE else BLACK

    fun toStone(): Stone = if (this == BLACK) Stone.BLACK else Stone.WHITE
}
