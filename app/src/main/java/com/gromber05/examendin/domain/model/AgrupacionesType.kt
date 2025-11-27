package com.gromber05.examendin.domain.model

/*
    He creado esta enum class para tener una mayor escalabilidad de tipos de agrupaciones
*/
enum class AgrupacionesTypes {
    CHIRIGOTA, COMPARSA, CORO, CUARTETO, ROMANCEROS, PREGONEROS;

    override fun toString(): String {
        return super.toString()
    }
}