package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val tambolaBoard: MutableList<MutableList<Int>> = mutableListOf(
        mutableListOf(4,16,0,0,48,0,63,76,0),
        mutableListOf(7,0,23,38,0,52,0,0,80),
        mutableListOf(9,0,25,0,0,56,64,0,83)
    )
    val numberList:MutableList<Int> = mutableListOf(90, 4, 46, 63, 89, 16, 76, 48 )
    val validate=WinnerValidator()
    val result=validate.reciveTheInput(tambolaBoard, numberList,"Top Row")
}