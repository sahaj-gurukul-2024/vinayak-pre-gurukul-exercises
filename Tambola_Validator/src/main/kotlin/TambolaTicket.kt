package org.example

class TambolaTicket (
    val topRow: List<Int>,
    val middleRow: List<Int>,
    val bottomRow: List<Int>
){

    fun getElement(row: Int, element: Int): Any {
        return when(row) {
            0 -> topRow[element]
            1 -> middleRow[element]
            2 -> bottomRow[element]
            else -> throw Exception("Invalid Row Number, There are only 3.")
        }
    }
}