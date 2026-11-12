package e1;

public enum Casa {
    Gryffindor("Gryffindor"),
    Hufflepuff("Hufflepuff"),
    Ravenclaw("Ravenclaw"),
    Slytherin("Slytherin");

    private final String nombreCasa;

    Casa(String nombreCasa) {
        this.nombreCasa = nombreCasa;
    }

    public String getNombreCasa() {
        return nombreCasa;
    }
}
