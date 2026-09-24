package e2;

public class Distance {
    /**
     * Given the layout of a class with available sites marked with an ’A’ and
     * invalid sites marked with a ’. ’, returns the resulting layout with the
     * sites occupied by the students marked with a ’#’ following two rules :
     * - Students occupy an empty seat if there are no other adjacent students .
     * - A student leaves a seat empty if he/ she has 4 or more adjacent students .
     * @param layout The initial layout .
     * @return The resulting layout .
     * @throws IllegalArgumentException if the initial layout is invalid (is null ,
     * is ragged , includes characters other than ’.’ or ’A ’)).
     */
    private static void validarLayout(char[][] layout) {
        int columnas;

        if (layout == null) {
            throw new IllegalArgumentException();
        }
        if (layout.length == 0) {
            throw new IllegalArgumentException();
        }

        columnas = layout[0].length;
        for (int i = 0; i < layout.length; i++) {
            if (layout[i] == null || layout[i].length != columnas) {
                throw new IllegalArgumentException();
            }
            for (int j = 0; j < layout[i].length; j++) {
                if (layout[i][j] != 'A' && layout[i][j] != '.') {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
    private static char [][] matrizAmpliada(char[][] layout) {
        int filas = layout.length;
        int columnas = layout[0].length;
        char [][] ampliada = new char[filas + 2][columnas + 2];

        for (int i = 0; i < ampliada.length; i++) {
            for (int j = 0; j < ampliada[i].length; j++) {
                ampliada[i][j] = '.';
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                ampliada[i+1][j+1] = layout[i][j];
            }
        }

        return ampliada;
    }
    private static char[][] matrizOriginal(char[][] layout) {
        int filas = layout.length;
        int columnas = layout[0].length;
        char[][] original = new char[filas - 2][columnas - 2];

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                original[i][j] = layout[i+1][j+1];
            }
        }

        return original;
    }
    private static char[][] copiarMatriz(char[][] matriz) {
        char[][] copia = new char[matriz.length][];

        for (int i = 0; i < matriz.length; i++) {
            copia[i] = matriz[i].clone();
        }

        return copia;
    }
    private static int countAdjacent(char[][] layout, int i, int j) {
        int count = 0;

        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {

                if (k == i && l == j) {
                    continue;
                }

                if (layout[k][l] == '#') {
                    count++;
                }
            }
        }

        return count;
    }

    public static char [][] seatingPeople ( char [][] layout ) {
        char [][] fLayout;
        boolean cambios;

        validarLayout(layout);

        layout = matrizAmpliada(layout);
        fLayout = copiarMatriz(layout);

        do {
            cambios = false;

            //SENTAMOS A LOS ALUMNOS
            for (int i = 1; i < layout.length - 1; i++) {
                for (int j = 1; j < layout[i].length - 1; j++) {
                    if (layout[i][j] == 'A') {
                        if (countAdjacent(layout, i, j) == 0) {
                            fLayout[i][j] = '#';
                            cambios = true;
                        }
                    }
                }
            }
            layout = copiarMatriz(fLayout);

            //LEVANTAMOS A LOS ALUMNOS
            for (int i = 1; i < layout.length - 1; i++) {
                for (int j = 1; j < layout[i].length - 1; j++) {
                    if (layout[i][j] == '#') {
                        if (countAdjacent(layout, i, j) >= 4) {
                            fLayout[i][j] = 'A';
                            cambios = true;
                        }
                    }
                }
            }
            layout = copiarMatriz(fLayout);
        }while (cambios);

        return matrizOriginal(layout);
    }
}
