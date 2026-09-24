public class StringCount {
    /**
     * Counts the number of words in a given String .
     * Words are groups of characters separated by one or more spaces .
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */
    public static int countWords ( String text ) {
        /*int count = 0;
        if (text.charAt(0) == ' '){
            text = text.substring(1);
        }
        for(int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) == ' ') && (text.charAt(i - 1) != ' ')) {
                count++;
            }
        }
        return count;*/
        String[] palabras = text.trim().split("\\s+");
        return palabras.length;
    }
    /**
     * Counts the number of times the given character appears in the String .
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countChar ( String text , char c) {
        int count = 0;

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == c) {
            count++;
            }
        }
        return count;
    }
    /**
     * Counts the number of times the given character appears in the String .
     * The case is ignored so an ’a’ is equal to an ’A ’.
     * Accented characters are considered different characters .
     * @param text String with the characters
     * @param c the character to be found
     * @return Number of times the character appears in the String or zero if null
     */
    public static int countCharIgnoringCase ( String text , char c ) {
        int count = 0;

        for(int i = 0; i < text.length(); i++) {
            if(Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(c)) {
                count++;
            }
        }
        return count;
    }
    /**
     * Checks if a password is safe according to the following rules :
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these : ’? ’, ’@ ’, ’#’, ’$ ’, ’.’ and ’,’
     * @param password The password , we assume it is not null .
     * @return true if the password is safe , false otherwise
     */
    public static boolean alMenos8Caracteres(String password) {
        if(password.length() < 8)
            return false;
        return true;
    }
    public static boolean tieneMayuscula(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean tieneMinuscula(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean tieneDigito(String password) {
        return password.matches(".*\\d.*");
    }
    public static boolean tieneCaracterEspecial(String password) {
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case '?':
                    return true;
                case '@':
                    return true;
                case '#':
                    return true;
                case '$':
                    return true;
                case '.':
                    return true;
                case ',':
                    return true;
            }
        }
        return false;
    }

    public static boolean isPasswordSafe ( String password ) {
        return alMenos8Caracteres(password) && tieneMayuscula(password) && tieneMinuscula(password)
                                                            && tieneDigito(password) && tieneCaracterEspecial(password);
    }
}
