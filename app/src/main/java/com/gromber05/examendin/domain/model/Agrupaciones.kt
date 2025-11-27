package com.gromber05.examendin.domain.model

/*
    Se ha creado esta data class como elemento que recoge cada tipo de agrupación,
    contiene: Su nombre, su imagen correspondiente, y el tipo al que pertenece
*/

data class Agrupaciones(val name: String, val image: Int, val type: AgrupacionesTypes)
