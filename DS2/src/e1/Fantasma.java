package e1;

public class Fantasma extends Residente {

    public Fantasma(String nombre, String apellido, int edad, int horroDestruidos, Casa casa) {
        super(nombre, apellido, edad, horroDestruidos, casa);
        setRecompensa(80);
    }

    @Override
    public double calcularRecompensa() {
        return getRecompensa()*getHorroDestruidos();
    }

    @Override
    public String StringRecompensa() {
        return getNombre() + " " + getApellido() + "(Fantasma de " + getCasa().getNombreCasa()
                + " ," + getHorroDestruidos() + "horrocruxes): " + calcularRecompensa() + " galeones" +
                "\n";
    }
}
