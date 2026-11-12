package e1;

public enum Materia {
    Historia(200, "Historia"),
    Transformaciones(400, "Transformaciones"),
    Defensa(500, "Defensa"),
    Herbologia(250, "Herbologia"),
    Pociones(350, "Pociones");

    private final int salario;
    private final String nombreMateria;

    Materia(int salario, String nombreMateria) {
        this.salario = salario;
        this.nombreMateria = nombreMateria;
    }
    public int getSalario() {
        return salario;
    }
    public String getNombreMateria() {
        return nombreMateria;
    }
}
