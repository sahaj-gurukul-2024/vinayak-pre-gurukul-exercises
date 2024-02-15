package org.example

class ClaimValidator {
    private val rows = 3
    private val column = 9
    private var topRow = mutableListOf<Int>()
    private var middleRow = mutableListOf<Int>()
    private var bottomRow = mutableListOf<Int>()
    private var status = "Rejected"

    private fun validateOneByOne(ticket: MutableList<MutableList<Int>>, announcedNumber: Int) {
        for (i in 0 until rows) {
            for (j in 0 until column) {
                val ticketValue = ticket[i][j]
                if (ticketValue == announcedNumber) {
                    when (i) {
                        0 -> {
                            topRow.add(announcedNumber)
                        }
                        1 -> {
                            middleRow.add(announcedNumber)
                        }
                        2 -> {
                            bottomRow.add(announcedNumber)
                        }
                    }
                }
            }
        }
    }

    fun validateClaim(ticket: MutableList<MutableList<Int>>, announcedNumberSequence: MutableList<Int>, claim: String): String {
        for (announcedNumber in announcedNumberSequence) {
            validateOneByOne(ticket, announcedNumber)
        }

        val lastAnnouncedNumber = announcedNumberSequence.last()

        if(topRow.contains(lastAnnouncedNumber)||bottomRow.contains(lastAnnouncedNumber)||middleRow.contains(lastAnnouncedNumber)){
            if ((topRow.size == 5 && claim == "Top Row") || (middleRow.size == 5 && claim == "Middle Row") || (bottomRow.size == 5 && claim == "Bottom Row") || (bottomRow.size + topRow.size + middleRow.size == 5 && claim == "Any Five") || (bottomRow.size + topRow.size + middleRow.size == 15 && claim == "Full House")) {
                status = "Accepted"
                return status
            }
        }

        return status
    }
}
