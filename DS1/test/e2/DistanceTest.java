package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    @Test
    void testLayoutNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(null)
        );
    }
    @Test
    void testLayoutVacio() {
        char[][] layout = {};

        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }
    @Test
    void testLayoutRagged() {
        char[][] layout = {
                {'A', '.'},
                {'A'},
                {'.', 'A'}
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }
    @Test
    void testLayoutFilaNull() {
        char[][] layout = {
                {'A', '.'},
                null,
                {'.', 'A'}
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }
    @Test
    void testCaracterInvalido() {
        char[][] layout = {
                {'A', '.'},
                {'.', 'X'}
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }
    @Test
    void testCaracterInvalidoHash() {
        char[][] layout = {
                {'A', '#'},
                {'.', 'A'}
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }
    @Test
    void testCaracterInvalidoEspacio() {
        char[][] layout = {
                {'A', ' '},
                {'.', 'A'}
        };
        assertThrows(
                IllegalArgumentException.class,
                () -> Distance.seatingPeople(layout)
        );
    }

    @Test
    void testSeOcupanSitiosVacios() {
        char[][] layout = {
                {'A', '.', 'A'},
                {'.', '.', '.'},
                {'A', '.', 'A'}
        };
        char[][] esperado = {
                {'#', '.', '#'},
                {'.', '.', '.'},
                {'#', '.', '#'}
        };

        assertArrayEquals(esperado, Distance.seatingPeople(layout));
    }
    @Test
    void testSeLevantanEstudiantes() {
        char[][] layout = {
                {'A', 'A', 'A'},
                {'A', 'A', 'A'},
                {'A', 'A', 'A'}
        };
        char[][] esperado = {
                {'#', 'A', '#'},
                {'A', 'A', 'A'},
                {'#', 'A', '#'}
        };

        assertArrayEquals(esperado, Distance.seatingPeople(layout));
    }
}
