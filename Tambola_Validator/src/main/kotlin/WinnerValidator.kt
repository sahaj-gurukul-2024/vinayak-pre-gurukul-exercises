package org.example

class WinnerValidator(){
    val rows=3
    val column=9
    val topRow:MutableList<Int> = mutableListOf()
    val BottomRow:MutableList<Int> = mutableListOf()
    val anyFive:MutableList<Int> = mutableListOf()
    //val twoDArray: MutableList<MutableList<Int>> = MutableList(rows) { MutableList(column) { 0 } }

    fun validateOneByOne(ticket: MutableList<MutableList<Int>>, numberAnounced:Int){
        for(i in 0 until rows){
            for (j in 0 until rows) {
                if(ticket[i][j]==numberAnounced){
                    if(i==0){
                        topRow.add(numberAnounced)
                    }
                    else if(i==2){
                        BottomRow.add(numberAnounced)
                    }
                    else{
                        anyFive.add(numberAnounced)
                    }
                }
            }
    }
    fun reciveTheInput(ticket:MutableList<MutableList<Int>>,numberSequence:MutableList<Int>){

        }
    }
}