import org.example.ClaimValidator
import org.example.TambolaTicket
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClaimValidatorTest{
    @Test
    fun `Validate the top row`(){
        val ticket = TambolaTicket(
            listOf(4,16,0,0,48,0,63,76,0),
            listOf(7,0,23,38,0,52,0,0,80),
            listOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumberSequence = mutableListOf(90, 4, 46, 63, 89, 16, 76, 48 )
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumberSequence,"Top Row")

        assertEquals("Accepted", result)
    }
    @Test
    fun `failing of the Top row claim not valid`(){
        val ticket = TambolaTicket(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val numberList = mutableListOf(90, 4, 46, 63, 89, 16, 76, 48, 12 )
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, numberList,"Top Row")

        assertEquals("Rejected", result)
    }

    @Test
    fun `check if bottom row wins`() {
        val ticket = TambolaTicket(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumberSequence = mutableListOf(9, 25, 46, 56, 89, 64, 76, 83)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumberSequence, "Bottom Row")

        assertEquals("Accepted", result)
    }

    @Test
    fun `check if bottom row losses`() {
        val ticket = TambolaTicket(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumbers = mutableListOf(9, 25, 83, 56, 89, 64, 76, 8)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumbers, "Bottom Row")

        assertEquals("Rejected", result)
    }

    @Test
    fun `check if early five wins`() {
        val ticket = TambolaTicket(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumbers = mutableListOf(4, 3, 9, 56, 64, 100, 80)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumbers, "Any Five")

        assertEquals("Accepted", result)
    }

    @Test
    fun `check if early five losses`() {
        val ticket = TambolaTicket(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumberSequence = mutableListOf(4, 3, 9, 56, 64, 100, 80, 77)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumberSequence, "Any Five")

        assertEquals("Rejected", result)
    }

    @Test
    fun `check if middle row wins`() {
        val ticket = TambolaTicket(
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83),
            mutableListOf(4,16,0,0,48,0,63,76,0),
        )
        val announcedNumberSequence = mutableListOf(9, 25, 46, 56, 89, 64, 76, 83)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumberSequence, "Middle Row")

        assertEquals("Accepted", result)
    }

    @Test
    fun `check if middle row losses`() {
        val ticket = TambolaTicket(
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumbers = mutableListOf(9, 25, 83, 56, 89, 64, 76, 8)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumbers, "Middle Row")

        assertEquals("Rejected", result)
    }

    @Test
    fun `check if full house wins`() {
        val ticket = TambolaTicket(
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumberSequence = mutableListOf(7,23,38,52,80,4,16,48,63,76,9,25,56,64,83)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumberSequence, "Full House")

        assertEquals("Accepted", result)
    }

    @Test
    fun `check if full house losses`() {
        val ticket = TambolaTicket(
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val announcedNumbers = mutableListOf(7,23,38,52,80,4,16,48,63,76,9,25,56,64,83,90)
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, announcedNumbers, "Full House")

        assertEquals("Rejected", result)
    }
}