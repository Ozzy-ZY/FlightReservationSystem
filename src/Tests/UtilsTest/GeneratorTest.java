package Tests.UtilsTest;
import Utils.Generator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeneratorTest {

    @Test
    public void generateIDProducesNonNullValue() {
        String id = Generator.GenerateID();
        assertNotNull(id);
    }

    @Test
    public void generateIDProducesCorrectLength() {
        String id = Generator.GenerateID();
        assertEquals(16, id.length());
    }

    @Test
    public void generateIDProducesAlphanumericCharacters() {
        String id = Generator.GenerateID();
        assertTrue(id.matches("[A-Za-z0-9]+"));
    }

    @Test
    public void flightGenProducesCorrectFormat() {
        String flight = Generator.flightGen("NYC", "LA");
        assertTrue(flight.startsWith("Flight From NYC to LA at"));
    }


    @Test
    public void daysInMonthReturnsCorrectForNonLeapYear() {
        assertEquals(28, Generator.daysInMonth(1, 2023));
    }

    @Test
    public void daysInMonthReturnsCorrectForLeapYear() {
        assertEquals(29, Generator.daysInMonth(1, 2024));
    }

    @Test
    public void isLeapYearReturnsTrueForLeapYear() {
        assertTrue(Generator.isLeapYear(2024));
    }

    @Test
    public void isLeapYearReturnsFalseForNonLeapYear() {
        assertFalse(Generator.isLeapYear(2023));
    }
}
