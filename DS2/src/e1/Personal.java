package e1;

abstract class Personal extends Integrante {
    private double nocturnidad;

    public Personal(String nombre, String apellido, int edad, int horroDestruidos) {
        super(nombre, apellido, edad, horroDestruidos);
    }

    public void setNocturnidad(double nocturnidad) {
        this.nocturnidad = nocturnidad;
    }
    public double getNocturnidad() {
        return nocturnidad;
    }

    public abstract double calcularSalario();
    public abstract String StringSalario();
}
