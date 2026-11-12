package e1;

public class Estudiante extends Residente {

    public Estudiante(String nombre, String apellido, int edad, int horroDestruidos, Casa casa) {
        super(nombre, apellido, edad, horroDestruidos, casa);
        setRecompensa(90);
    }

    @Override
    public double calcularRecompensa() {
        if(getCasa().equals(Casa.Slytherin)){
            return 2*(getHorroDestruidos()*getRecompensa());
        }

        return getHorroDestruidos()*getRecompensa();
    }

    @Override
    public String StringRecompensa() {
        return getNombre() + " " + getApellido() + "(Estudiante de " + getCasa().getNombreCasa()
                + " ," + getHorroDestruidos() + "horrocruxes): " + calcularRecompensa() + " galeones" +
                "\n";
    }

}
