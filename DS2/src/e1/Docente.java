package e1;

public class Docente extends Personal {
    Materia materia;

    public Docente(String nombre, String apellido, int edad, int horroDestruidos, Materia materia){
        super(nombre, apellido, edad, horroDestruidos);
        this.materia = materia;
        setRecompensa(50);
    }

    @Override
    public double calcularSalario(){
        return materia.getSalario();
    }

    @Override
    public double calcularRecompensa() {
        if(materia.equals(Materia.Defensa)){
            return 0.75*(getRecompensa()*getHorroDestruidos());
        }

        return getRecompensa()*getHorroDestruidos();
    }

    @Override
    public String StringRecompensa() {
        return getNombre() + " " + getApellido() + "(Docente de " + materia.getNombreMateria()
                + " ," + getHorroDestruidos() + "horrcruxes): " + calcularRecompensa() + " galeones" +
                "\n";
    }

    @Override
    public String StringSalario() {
        return getNombre() + " " + getApellido() + "(Docente de " + materia.getNombreMateria()
                + "): " + calcularSalario() + " galeones" + "\n";
    }
}
