package org.example

class WinnerValidator() {
    var rows = 3
    var column = 9
    var topRow: MutableList<Int> = mutableListOf()
    var BottomRow: MutableList<Int> = mutableListOf()
    var anyFive: MutableList<Int> = mutableListOf()
    var Status: String = "Rejected"
    //val twoDArray: MutableList<MutableList<Int>> = MutableList(rows) { MutableList(column) { 0 } }

    fun validateOneByOne(ticket: MutableList<MutableList<Int>>, numberAnounced: Int) {
        for (i in 0 until rows) {
            for (j in 0 until column) {
                val ticketval=ticket[i][j]
                if (ticketval == numberAnounced) {
                    if (i == 0) {
                        topRow.add(numberAnounced)
                    } else if (i == 2) {
                        BottomRow.add(numberAnounced)
                    } else {
                        anyFive.add(numberAnounced)
                    }
                }
            }
        }
    }

    fun reciveTheInput(ticket: MutableList<MutableList<Int>>, numberSequence: MutableList<Int>, claim: String): String {
        for (i in 0 until numberSequence.size) {
            validateOneByOne(ticket, numberSequence[i])

        }
        val lastEntryInPut=numberSequence[numberSequence.size-1]
        if(topRow.contains(lastEntryInPut)||BottomRow.contains(lastEntryInPut)||anyFive.contains(lastEntryInPut)){
            if ((topRow.size == 5 && claim == "Top Row") || (BottomRow.size == 5 && claim == "Bottom Row") || (anyFive.size == 5 || claim == "Any Five")) {
                Status = "Accepted"
                return Status
            }
        }
        return Status
    }
}
