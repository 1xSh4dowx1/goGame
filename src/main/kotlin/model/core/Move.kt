package model.core

/**
 * Representação simples de um [Move]
 *
 * Singletons para moves restritos
 */
sealed class Move{
    // O que fazer com moves inválidos?
    data class Play(val point: Point): Move()
    object Pass     : Move()
    object Resign   : Move()
}
