package model.core

/**
 * Forma de Representar uma peça
 *
 * Se usarmos Stone.ordinal, vai atribuir valores binários
 */
enum class Stone {
    EMPTY, // ordinal 0
    BLACK, // ordinal 1
    WHITE  // ordinal 2
}

/**
 * Há outra forma de fazer isto
 *
 * Caso alguém mude a ordem do enum
 * O ordinal vai dar erros
 * Funções com when não alteram
 * Discutir qual implementação usar
 */


fun Stone.toInt() = when (this) {
    Stone.EMPTY -> 0b00
    Stone.WHITE -> 0b01
    Stone.BLACK -> 0b10
}

fun Int.toStone() = when (this) {
    0b01 -> Stone.WHITE
    0b10 -> Stone.BLACK
    else -> Stone.EMPTY
}