package org.example

class ClaimValidator {
    private val rows = 3
    private val column = 9
    private var topRow = mutableListOf<Int>()
    private var bottomRow = mutableListOf<Int>()
    private var firstFive = mutableListOf<Int>()
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
                        2 -> {
                            bottomRow.add(announcedNumber)
                        }
                        else -> {
                            firstFive.add(announcedNumber)
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

        if(topRow.contains(lastAnnouncedNumber)||bottomRow.contains(lastAnnouncedNumber)||firstFive.contains(lastAnnouncedNumber)){
            if ((topRow.size == 5 && claim == "Top Row") || (bottomRow.size == 5 && claim == "Bottom Row") || (firstFive.size == 5 || claim == "Any Five")) {
                status = "Accepted"
                return status
            }
        }

        return status
    }
}
