import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcCommissionVKPayOutOfLimitAtTime() {
        val amountOfTransaction = 20_000
        val amountOfPreviousTransaction = 0
        val typeOfCard = "VK Pay"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(-1, result)
    }

    @Test
    fun calcCommissionVKPayOutOfMonthLimit() {
        val amountOfTransaction = 12_000
        val amountOfPreviousTransaction = 100_000
        val typeOfCard = "VK Pay"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(-1, result)
    }

    @Test
    fun calcCommissionVKPayInLimit() {
        val amountOfTransaction = 12_000
        val amountOfPreviousTransaction = 0
        val typeOfCard = "VK Pay"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(0, result)
    }

    @Test
    fun calcCommissionOutOfLimit() {
        val amountOfTransaction = 200_000
        val amountOfPreviousTransaction = 0
        val typeOfCard = "Visa"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(-2, result)
    }

    @Test
    fun calcCommissionOutOfMonthLimit() {
        val amountOfTransaction = 20_000
        val amountOfPreviousTransaction = 700_000
        val typeOfCard = "Visa"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(-2, result)
    }

    @Test
    fun calcCommissionMaestroMasterOutOfMonthLimit() {
        val amountOfTransaction = 20_000
        val amountOfPreviousTransaction = 60_000
        val typeOfCard = "Maestro"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(140, result)
    }

    @Test
    fun calcCommissionMaestroMasterInMonthLimit() {
        val amountOfTransaction = 20_000
        val amountOfPreviousTransaction = 20_000
        val typeOfCard = "Mastercard"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(0, result)
    }

    @Test
    fun calcCommissionVisaMIRMoreMinComm() {
        val amountOfTransaction = 100_000
        val amountOfPreviousTransaction = 0
        val typeOfCard = "Visa"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(750, result)
    }

    @Test
    fun calcCommissionVisaMIRLessMinComm() {
        val amountOfTransaction = 200
        val amountOfPreviousTransaction = 0
        val typeOfCard = "МИР"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(35, result)
    }

    @Test
    fun calcCommissionNameCardError() {
        val amountOfTransaction = 200
        val amountOfPreviousTransaction = 0
        val typeOfCard = "MIR"

        val result = calcCommission(amountOfTransaction, typeOfCard, amountOfPreviousTransaction)

        assertEquals(-3, result)
    }
}