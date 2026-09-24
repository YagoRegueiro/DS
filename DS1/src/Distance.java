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
    public static char [][] seatingPeople ( char [][] layout ) {
        int i, j, k, l, count;
        char [][] finalLayout = new char[layout.length][];

        //SENTAMOS A LOS ALUMNOS
        //Comprobamos las esquinas
        if((layout[0][0] == 'A') && (layout[0][1] != '#') && (layout[1][0] != '#') && (layout[1][1] != '#'))
            finalLayout[0][0] = '#';
        else
            finalLayout[0][0] = layout[0][0];
        if((layout[layout.length-1][0] == 'A') && (layout[layout.length-1][1] != '#') &&
                    (layout[layout.length-2][0] != '#') && (layout[layout.length-2][1] != '#'))
            finalLayout[layout.length-1][0] = '#';
        else
            finalLayout[layout.length-1][0] = layout[layout.length-1][0];
        if((layout[0][layout.length-1] == 'A') && (layout[0][layout.length-2] != '#') &&
                    (layout[1][layout.length-2] != '#') && (layout[1][layout.length-1] != '#'))
            finalLayout[0][layout.length-1] = '#';
        else
            finalLayout[0][layout.length-1] = layout[0][layout.length-1];
        if((layout[layout.length-1][layout.length-1] == 'A') && (layout[layout.length-1][layout.length-2] != '#') && (layout[layout.length-2][layout.length-2] != '#') &&
                        (layout[layout.length-2][layout.length-1] != '#'))
            finalLayout[layout.length-1][layout.length-1] = '#';
        else
            finalLayout[layout.length-1][layout.length-1] = layout[layout.length-1][layout.length-1];


        //Comprobamos la primera fila
        for ( i = 1; i < layout.length-1; i++ ) {
            if(layout[i][0] == 'A') {
                if((layout[i-1][0] != '#') && (layout[i+1][0] != '#') && (layout[i-1][1] != '#') &&
                                (layout[i][1] != '#') && (layout[i+1][1] != '#')) {
                    finalLayout[i][0] = '#';
                }
                else {
                    finalLayout[i][0] = layout[i][0];
                }
            }
            else
                finalLayout[i][0] = layout[i][0];

        }
        //Comprobamos la ultima fila
        for ( i = 1; i < layout.length-1; i++ ) {
            if(layout[i][layout.length-1] == 'A') {
                if((layout[i-1][layout.length-1] != '#') && (layout[i+1][layout.length-1] != '#') && (layout[i-1][layout.length-2] != '#')
                        && (layout[i][layout.length-2] != '#') && (layout[i+1][layout.length-2] != '#')) {
                    finalLayout[i][layout.length] = '#';
                }
                else {
                    finalLayout[i][layout.length-1] = layout[i][layout.length-1];
                }
            }
            else
                finalLayout[i][layout.length-1] = layout[i][layout.length-1];

        }
        //Comprobamos la primera columna
        for ( j = 1; j < layout[0].length-1; j++ ) {
            if(layout[0][j] == 'A') {
                if((layout[0][j-1] != '#') && (layout[0][j+1] != '#') && (layout[1][j-1] != '#') &&
                        (layout[1][j] != '#') && (layout[1][j+1] != '#')) {
                    finalLayout[0][j] = '#';
                }
                else {
                    finalLayout[0][j] = layout[0][j];
                }
            }
            else
                finalLayout[0][j] = layout[0][j];

        }
        //Comprobamos la ultima columna
        for ( j = 1; j < layout[0].length-1; j++ ) {
            if(layout[layout.length-1][j] == 'A') {
                if((layout[layout.length-1][j-1] != '#') && (layout[layout.length-1][j+1] != '#') && (layout[layout.length-2][j-1] != '#')
                        && (layout[layout.length-2][j] != '#') && (layout[layout.length-2][j+1] != '#')) {
                    finalLayout[layout.length-1][j] = '#';
                }
                else {
                    finalLayout[layout.length-1][j] = layout[layout.length-1][j];
                }
            }
            else
                finalLayout[layout.length-1][j] = layout[layout.length-1][j];

        }

        //Comprobamos el resto de la matriz
        for ( i = 1; i < layout.length-1; i++ ) {
            for ( j = 1; j < layout[i].length-1; j++ ) {
                if ( layout[i][j] == 'A' ) {
                    if ( (layout[i-1][j-1] != '#') && (layout[i-1][j] != '#') && (layout[i-1][j+1] != '#') &&
                                    (layout[i][j-1] != '#') && (layout[i][j+1] != '#') && (layout[i+1][j-1] != '#') &&
                                                (layout[i+1][j] != '#') &&(layout[i+1][j+1] != '#')) {
                        finalLayout[i][j] = '#';
                    }
                    else
                        finalLayout[i][j] = layout[i][j];
                }
                else
                    finalLayout[i][j] = layout[i][j];
            }
        }

        layout = finalLayout.clone();

        //LEVANTAMOS A LOS ALUMNOS
        //Comprobamos la primera fila
        for ( i = 1; i < layout.length-1; i++ ) {
            if (layout[i][0] == '#') {
                count = 0;
                for (k = i - 1; k <= i + 1; k++) {
                    for (l = 0; l <= 1; l++) {
                        if ((k == i) && (l == 0))
                            continue;
                        else if (layout[k][l] == '#')
                            count++;
                    }
                }
                if (count >= 4)
                    finalLayout[i][0] = 'A';
            }
        }
        //Comprobamos la ultima fila
        for ( i = 1; i < layout.length-1; i++ ) {
            if (layout[i][layout.length-1] == '#') {
                count = 0;
                for (k = i - 1; k <= i + 1; k++) {
                    for (l = layout.length - 2; l <= layout.length - 1; l++) {
                        if ((k == i) && (l == layout.length - 1))
                            continue;
                        else if (layout[k][l] == '#')
                            count++;
                    }
                }
                if (count >= 4)
                    finalLayout[i][layout.length - 1] = 'A';
            }
        }
        //Comprobamos la primera columna
        for ( j = 1; j < layout[0].length-1; j++ ) {
            if (layout[0][j] == '#') {
                count = 0;
                for (k = 0; k <= 1; k++) {
                    for (l = j - 1; l <= j + 1; l++) {
                        if ((k == 0) && (l == j))
                            continue;
                        else if (layout[k][l] == '#')
                            count++;
                    }
                }
                if (count >= 4)
                    finalLayout[0][j] = 'A';
            }
        }
        //Comprobamos la ultima columna
        for ( j = 1; j < layout[0].length-1; j++ ) {
            if (layout[layout.length - 1][j] == '#') {
                count = 0;
                for (k = layout.length - 2; k <= layout.length - 1; k++) {
                    for (l = j - 1; l <= j + 1; l++) {
                        if ((k == layout.length - 1) && (l == j))
                            continue;
                        else if (layout[k][l] == '#')
                            count++;
                    }
                }
                if (count >= 4)
                    finalLayout[layout.length - 1][j] = 'A';
            }
        }

        //Comprobamos el resto de la matriz
        for ( i = 1; i < layout.length-1; i++ ) {
            for ( j = 1; j < layout[i].length-1; j++ ) {
                if ( layout[i][j] == '#' ) {
                    count = 0;
                    for (k = i-1; k <= i+1; k++) {
                        for (l = j - 1; l <= j + 1; l++) {
                            if ((k == i) && (l == j))
                                continue;
                            else if (layout[k][l] == '#')
                                count++;
                        }
                    }
                    if (count >= 4)
                        finalLayout[layout.length - 1][j] = 'A';
                }
            }
        }
        return finalLayout;
    }
}
