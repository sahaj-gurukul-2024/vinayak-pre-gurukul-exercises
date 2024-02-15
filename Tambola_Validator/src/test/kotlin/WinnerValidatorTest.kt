import org.example.ClaimValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ClaimValidatorTest{
    @Test
    fun `Validate the top row`(){
        val ticket = mutableListOf(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val numberList = mutableListOf(90, 4, 46, 63, 89, 16, 76, 48 )
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, numberList,"Top Row")

        assertEquals("Accepted", result)
    }
    @Test
    fun `failing of the Top row claim not valid`(){
        val ticket = mutableListOf(
            mutableListOf(4,16,0,0,48,0,63,76,0),
            mutableListOf(7,0,23,38,0,52,0,0,80),
            mutableListOf(9,0,25,0,0,56,64,0,83)
        )
        val numberList = mutableListOf(90, 4, 46, 63, 89, 16, 76, 48, 12 )
        val validator = ClaimValidator()

        val result = validator.validateClaim(ticket, numberList,"Top Row")

        assertEquals("Rejected", result)
    }
}