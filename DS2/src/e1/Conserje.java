package e1;

public class Conserje extends Personal {

    public Conserje(String nombre, String apellido, int edad, int horroDestruido, double nocturnidad) {
        super(nombre, apellido, edad,  horroDestruido);
        setRecompensa(65);
        setNocturnidad(nocturnidad);
    }

    @Override
    public double calcularSalario(){
        return 150 + 10*getNocturnidad();
    }

    @Override
    public double calcularRecompensa() {
        return getRecompensa()*getHorroDestruidos();
    }

    @Override
    public String StringRecompensa() {
        return getNombre() + " " + getApellido() + "(Conserje ," + getHorroDestruidos()
                + "horrcruxes): " + calcularRecompensa() + " galeones" + "\n";
    }

    @Override
    public String StringSalario() {
        return getNombre() + " " + getApellido() + "(Conserje): " + calcularSalario()
                + " galeones" + "\n";
    }
}
