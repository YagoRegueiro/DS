package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCountTest {

    // countWords
    @Test
    void testCountWords() {
        assertEquals(3, StringCount.countWords("Hola que tal"));
    }
    @Test
    void testCountWordsMultiplesEspacios() {
        assertEquals(3, StringCount.countWords("Hola    que   tal"));
    }
    @Test
    void testCountWordsEspaciosExtremos() {
        assertEquals(3, StringCount.countWords("   Hola que tal   "));
    }
    @Test
    void testCountWordsStringVacio() {
        assertEquals(0, StringCount.countWords(""));
    }
    @Test
    void testCountWordsSoloEspacios() {
        assertEquals(0, StringCount.countWords("     "));
    }
    @Test
    void testCountWordsNull() {
        assertEquals(0, StringCount.countWords(null));
    }

    // countChar
    @Test
    void testCountChar() {
        assertEquals(3, StringCount.countChar("banana", 'a'));
    }
    @Test
    void testCountCharNoEncontrado() {
        assertEquals(0, StringCount.countChar("banana", 'z'));
    }
    @Test
    void testCountCharMayusculas() {
        assertEquals(3, StringCount.countChar("Banana A", 'a'));
        assertEquals(1, StringCount.countChar("Banana A", 'A'));
    }
    @Test
    void testCountCharAcentos() {
        assertEquals(1, StringCount.countChar("canción", 'ó'));
        assertEquals(0, StringCount.countChar("canción", 'o'));
    }
    @Test
    void testCountCharNull() {
        assertEquals(0, StringCount.countChar(null, 'a'));
    }

    // countCharIgnoringCase
    @Test
    void testCountCharIgnoringCase() {
        assertEquals(3, StringCount.countCharIgnoringCase("BanAna", 'a'));
    }

    @Test
    void testCountCharIgnoringCaseMayusculas() {
        assertEquals(3, StringCount.countCharIgnoringCase("BanAna", 'A'));
    }

    @Test
    void testCountCharIgnoringCaseNoEncontrado() {
        assertEquals(0, StringCount.countCharIgnoringCase("Banana", 'z'));
    }

    @Test
    void testCountCharIgnoringCaseAcentos() {
        assertEquals(1, StringCount.countCharIgnoringCase("canción", 'ó'));
        assertEquals(0, StringCount.countCharIgnoringCase("canción", 'o'));
    }

    @Test
    void testCountCharIgnoringCaseNull() {
        assertEquals(0, StringCount.countCharIgnoringCase(null, 'a'));
    }

    // isPasswordSafe
    @Test
    void testisPasswordSafe() {
        assertTrue(StringCount.isPasswordSafe("Hola123?"));
    }
    @Test
    void testisPasswordSafeMenos8() {
        assertFalse(StringCount.isPasswordSafe("Hola12?"));
    }
    @Test
    void testisPasswordSafeSinMayusculas() {
        assertFalse(StringCount.isPasswordSafe("hola123?"));
    }
    @Test
    void testisPasswordSafeSinMinusculas() {
        assertFalse(StringCount.isPasswordSafe("HOLA123?"));
    }
    @Test
    void testisPasswordSafeSinDigitos() {
        assertFalse(StringCount.isPasswordSafe("HolaMundo?"));
    }
    @Test
    void testisPasswordSafeSinCaracteresEspeciales() {
        assertFalse(StringCount.isPasswordSafe("Hola1234"));
    }
    @Test
    void testisPasswordSafeInterrogacion() {
        assertTrue(StringCount.isPasswordSafe("Hola123?"));
    }
    @Test
    void testisPasswordSafeArroba() {
        assertTrue(StringCount.isPasswordSafe("Hola123@"));
    }
    @Test
    void testisPasswordSafeHash() {
        assertTrue(StringCount.isPasswordSafe("Hola123#"));
    }
    @Test
    void testisPasswordSafeDollar() {
        assertTrue(StringCount.isPasswordSafe("Hola123$"));
    }
    @Test
    void testisPasswordSafePunto() {
        assertTrue(StringCount.isPasswordSafe("Hola123."));
    }
    @Test
    void testisPasswordSafeComa() {
        assertTrue(StringCount.isPasswordSafe("Hola123,"));
    }
}
