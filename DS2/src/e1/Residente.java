package e1;

abstract class Residente extends Integrante{
    private Casa casa;

    public Residente(String nombre, String apellido, int edad, int horroDestruidos, Casa casa){
        super(nombre, apellido, edad, horroDestruidos);
        this.casa = casa;
    }

    public Casa getCasa() {
        return casa;
    }
}
