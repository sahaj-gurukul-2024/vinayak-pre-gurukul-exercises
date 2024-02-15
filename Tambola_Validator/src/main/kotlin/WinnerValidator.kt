package org.example

class WinnerValidator() {
    val rows = 3
    val column = 9
    var topRow = mutableListOf<Int>()
    var bottomRow = mutableListOf<Int>()
    var firstFive = mutableListOf<Int>()
    var status = "Rejected"

    fun validateOneByOne(ticket: MutableList<MutableList<Int>>, announcedNumber: Int) {
        for (i in 0 until rows) {
            for (j in 0 until column) {
                val ticketValue = ticket[i][j]
                if (ticketValue == announcedNumber) {
                    if (i == 0) {
                        topRow.add(announcedNumber)
                    } else if (i == 2) {
                        bottomRow.add(announcedNumber)
                    } else {
                        firstFive.add(announcedNumber)
                    }
                }
            }
        }
    }

    fun reciveTheInput(ticket: MutableList<MutableList<Int>>, announcedNumberSequence: MutableList<Int>, claim: String): String {
        for (i in 0 until announcedNumberSequence.size) {
            validateOneByOne(ticket, announcedNumberSequence[i])
        }

        val lastAnnouncedNumber = announcedNumberSequence[announcedNumberSequence.size-1]

        if(topRow.contains(lastAnnouncedNumber)||bottomRow.contains(lastAnnouncedNumber)||firstFive.contains(lastAnnouncedNumber)){
            if ((topRow.size == 5 && claim == "Top Row") || (bottomRow.size == 5 && claim == "Bottom Row") || (firstFive.size == 5 || claim == "Any Five")) {
                status = "Accepted"
                return status
            }
        }

        return status
    }
}
