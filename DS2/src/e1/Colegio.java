package e1;

import java.util.ArrayList;

public class Colegio {
    private ArrayList<Integrante> integrantes;

    public Colegio() {
        integrantes = new ArrayList<>();
    }
    public Colegio(ArrayList<Integrante> integrantes) {
        this.integrantes = integrantes;
    }

    public ArrayList<Integrante> getIntegrantes() {
        return integrantes;
    }
    public void addIntegrante(Integrante integrantes) {
        this.integrantes.add(integrantes);
    }

    public String imprimirRecompensas() {
        StringBuilder recompensas = new StringBuilder();
        double recompensasTotal = 0;

        for (Integrante integrante : integrantes) {
            recompensas.append(integrante.StringRecompensa());
            recompensasTotal += integrante.calcularRecompensa();
        }

        recompensas.append("La recompensa total del Colegio Hogwarts es de " +
                recompensasTotal + "galeones");
        return recompensas.toString();
    }

    public String imprimirSalarios() {
        StringBuilder salarios = new StringBuilder();
        double salariosTotal = 0;

        for (Integrante integrante : integrantes) {
            if(integrante instanceof Personal) {
                salarios.append(((Personal) integrante).StringSalario());
                salariosTotal += ((Personal) integrante).calcularSalario();
            }
        }

        salarios.append("El gasto de Hogwarts en personal es de " + salariosTotal + "galeones");
        return salarios.toString();
    }
}
