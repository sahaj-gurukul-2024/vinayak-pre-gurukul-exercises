package org.example

class ClaimValidator {
    private val ticketRows = 3
    private val ticketColumns = 9
    private var topRowMatches = mutableListOf<Int>()
    private var middleRowMatches = mutableListOf<Int>()
    private var bottomRowMatches = mutableListOf<Int>()
    private var status = "Rejected"

    private fun validateOneByOne(ticket: TambolaTicket, announcedNumber: Int) {
        for (i in 0 until ticketRows) {
            for (j in 0 until ticketColumns) {
                val ticketValue = ticket.getElement(i, j)
                if (ticketValue == announcedNumber) {
                    when (i) {
                        0 -> {
                            topRowMatches.add(announcedNumber)
                        }
                        1 -> {
                            middleRowMatches.add(announcedNumber)
                        }
                        2 -> {
                            bottomRowMatches.add(announcedNumber)
                        }
                    }
                }
            }
        }
    }

    fun validateClaim(ticket: TambolaTicket, announcedNumberSequence: MutableList<Int>, claim: String): String {
        for (announcedNumber in announcedNumberSequence) {
            validateOneByOne(ticket, announcedNumber)
        }

        val lastAnnouncedNumber = announcedNumberSequence.last()

        if(anyRowMatchContains(lastAnnouncedNumber)){
            if (isTopRowMatchValid(claim) || isMiddleRowMatchValid(claim) || isBottomRowMatchValid(claim) || isAnyFiveMatchValid(claim) || isFullHouseMatchValid(claim)) {
                status = "Accepted"
                return status
            }
        }

        return status
    }

    private fun isFullHouseMatchValid(claim: String) =
        (bottomRowMatches.size + topRowMatches.size + middleRowMatches.size == 15 && claim == "Full House")

    private fun isAnyFiveMatchValid(claim: String) =
        (bottomRowMatches.size + topRowMatches.size + middleRowMatches.size == 5 && claim == "Any Five")

    private fun isBottomRowMatchValid(claim: String) = (bottomRowMatches.size == 5 && claim == "Bottom Row")

    private fun isMiddleRowMatchValid(claim: String) = (middleRowMatches.size == 5 && claim == "Middle Row")

    private fun isTopRowMatchValid(claim: String) = (topRowMatches.size == 5 && claim == "Top Row")

    private fun anyRowMatchContains(lastAnnouncedNumber: Int) =
        topRowMatches.contains(lastAnnouncedNumber) || bottomRowMatches.contains(lastAnnouncedNumber) || middleRowMatches.contains(
            lastAnnouncedNumber
        )
}
