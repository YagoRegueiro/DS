package e1;

abstract class Integrante {
    private String nombre;
    private String apellido;
    private int edad;
    private int horroDestruidos;
    private int recompensa;

    public Integrante(String nombre, String apellido, int edad, int horroDestruidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horroDestruidos =  horroDestruidos;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getHorroDestruidos() {
        return horroDestruidos;
    }
    public void setHorroDestruidos(int horroDestruidos) {
        this.horroDestruidos = horroDestruidos;
    }
    public int getRecompensa() {
        return recompensa;
    }
    void setRecompensa(int recompensa) {
        this.recompensa = recompensa;
    }

    public abstract double calcularRecompensa();
    public abstract String StringRecompensa();
}
