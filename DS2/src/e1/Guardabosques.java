package e1;

public class Guardabosques extends Personal {

    public Guardabosques(String nombre, String apellido, int edad, int horroDestruido, double nocturnidad) {
        super(nombre, apellido, edad,  horroDestruido);
        setRecompensa(75);
        setNocturnidad(nocturnidad);
    }

    @Override
    public double calcularSalario(){
        return 170 + 10*getNocturnidad();
    }

    @Override
    public double calcularRecompensa() {
        return getRecompensa()*getHorroDestruidos();
    }

    @Override
    public String StringRecompensa() {
        return getNombre() + " " + getApellido() + "(Guardabosques ," + getHorroDestruidos()
                + "horrcruxes): " + getRecompensa() + " galeones" + "\n";
    }

    @Override
    public String StringSalario() {
        return getNombre() + " " + getApellido() + "(Guardabosques): " + calcularSalario()
                + " galeones" + "\n";
    }
}
