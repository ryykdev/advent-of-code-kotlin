import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Test {

    // 1. Test case for moving within bounds
    @Test
    fun `test movement within bounds`() {
        val lock = Lock()
        var newPosition = lock.dial(10)

        // Assert (Verification)
        assertEquals(60, newPosition, "Position should be 60 (50 + 10)")
    }

    // 2. Test case for exceeding the capacity
    @Test
    fun `test movement exceeding capacity`() {
        // Arrange
        val lock = Lock()

        // Act
        val newPosition = lock.dial(55)

        // Assert
        assertEquals(5, newPosition, "Position should be clamped at 99 (capacity)")
    }

    // 3. Test case for moving below zero
    @Test
    fun `test movement below zero`() {
        // Arrange
        val lock = Lock()

        // Act
        val newPosition = lock.dial(-55)

        // Assert
        assertEquals(95, newPosition, "Position should be clamped at 0")
    }

    @Test
    fun `test parse_to_list_int`() {
        val input = "L68\n" +
                "L30\n" +
                "R48\n" +
                "L5\n" +
                "R60\n" +
                "L55\n" +
                "L1\n" +
                "L99\n" +
                "R14\n" +
                "L82"
        val clean_input = input.trim().lines()

        val list = parse_to_list_int(clean_input)
        val listShould: List<Int> = listOf(-68, -30, 48, -5, 60, -55, -1, -99, 14, -82)
        assertEquals(listShould, list)
    }
}