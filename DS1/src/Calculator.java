import java.util.*;

public class Calculator {
    //Para las operaciones - Es declarado como static debido a que se operan en un enum pero idealmente no serian static
    //Idealmente seria propio del objeto no de la clase, ya que de esta manera no podemos tener varios objetos de la misma
    //Clase trabajando a la vez
    public float acumulador_0;
    public float acumulador_1;

    //Aquí guardaremos los bloques de multiplicaciones y divisiones
    //Para ser procesados antes de las sumas y las restas
    ArrayList<bloque_operadores> muldiv;

    //En este bloque guardaremos las operaciones a hacer una vez procesadas
    //Las multiplicaciones y divisiones
    bloque_operadores sumres;

    //Resultados de la operación actual y el resultado final
    float resultado_ciclo;
    float resultado_final;

    //Lógica para definir si estamos trabajando con un bloque de multiplicaciones o divisiones
    boolean en_ciclo;

    //La lista de resultados de los bloques
    ArrayList<resultado_bloques> resB;

    //Booleano que define si estamos trabajando con 2 o 1 operandos
    public boolean condicion_operandos;// Ocurre lo mismo que con los acumuladores

    //String temporal para el enum
    public String stringValue;

    //Caracter para identificar la operación
    public Character car_op;

    //String permanente para toString()
    public StringBuilder stringtot;

    //booleano para que la función toString() sepa si guardar el string o devolverlo todo
    public boolean condicion_string;



    class bloque_operadores {
        //Aquí es donde se definen los bloques de multiplicaciones y divisiones
        int p_init;
        int p_fin;
        Queue<Character> st_inst;
        Queue<Float> st_dat; //Sólo utilizada para sumres

    }

    class resultado_bloques {
        //Aquí es donde se definen los resultados de los bloques de multiplicaciones y divisiones
        int p_init;
        int p_fin;
        Float resultado;
    }

    public Calculator() {
        acumulador_0 = 0;
        acumulador_1 = 0;
        resultado_final = 0;
        resultado_ciclo = 0;
        muldiv = new ArrayList<>();
        sumres = new bloque_operadores();
        sumres.st_dat = new LinkedList<>();
        sumres.st_inst = new LinkedList<>();
        resB = new ArrayList<>();
        en_ciclo = false;
        condicion_operandos = true;
        condicion_string = false;
        stringValue = "";
        car_op = ' ';
        stringtot = new StringBuilder();
    }
    public void cleanOperations() {
        muldiv.clear();
        sumres.st_inst.clear();
        sumres.st_dat.clear();
        sumres.p_init = 0;
        sumres.p_fin = 0;
        resB.clear();
        acumulador_0 = 0;
        acumulador_1 = 0;
        resultado_ciclo = 0;
        en_ciclo = false;
        condicion_operandos = true;
        condicion_string = false;
        stringValue = "";
        car_op = ' ';

    }

    private void procesado_de_bloques(String operation, float... values) {
        //PASO 1: PROCESADO DE BLOQUES
        //Lo que hemos mandado es preliminalmente válido o no

        if (operation.isEmpty() || (operation.length() != values.length - 1)) {//Sabemos que va a haber n + 1 valores para n operandos
            throw new IllegalArgumentException();
        }


        //Si lo es creamos los grupos de multiplicaciones y divisiones porque tienen mayor prioridad
        //Aritmética - también comprobamos si nos mandaron algun operando ilegal
        for (int i = 0; i < operation.length(); i++) {
            car_op = operation.charAt(i);
            String patata = Operador.valueOf("sabop").saber_operador(car_op);
            int condicion = Operador.valueOf(patata).tipo_de_prioridad();

            if (condicion == 1) {

                if (!en_ciclo) {
                    //Hemos entrado en un nuevo bloque de multiplicaciones o divisiones
                    en_ciclo = true;
                    muldiv.add(new bloque_operadores());

                    muldiv.getLast().p_fin = -1;
                    muldiv.getLast().p_init = i;

                    muldiv.getLast().st_inst = new LinkedList<>();

                    muldiv.getLast().st_inst.offer(operation.charAt(i));
                } else {
                    //Seguimos en el bloque de multiplicaciones y divisiones pero no es el primer elemento
                    muldiv.getLast().p_fin = i;
                    muldiv.getLast().st_inst.offer(operation.charAt(i));
                }

            } else if (condicion == 0) {
                if (en_ciclo) {
                    //Acabamos el bloque de multiplicaciones y divisiones
                    //No necesitamos hacer nada más ya que haremos este paso otra vez con los resultados de los
                    //Bloques computados
                    en_ciclo = false;
                }
            } else {
                //Necesariamente es una operación ilegal
                throw new IllegalArgumentException();
            }
        }
    }

    private void guardar_estado (String temporal){
        switch (temporal){
            case "suma":
                if (condicion_operandos) {
                    stringValue = "[+]" + acumulador_0 + "_" + acumulador_1;
                } else {
                    stringValue = "[+]" + acumulador_1;
                }
                condicion_string = true;
                stringtot.append(stringValue);
                condicion_string = false;
                break;
            case "resta":
                if (condicion_operandos) {
                    stringValue = "[-]" + acumulador_0 + "_" + acumulador_1;
                } else {
                    stringValue = "[-]" + acumulador_1;
                }
                condicion_string = true;
                stringtot.append(stringValue);
                condicion_string = false;
                break;
            case "multiplicacion":
                if (condicion_operandos) {
                    stringValue = "[*]" + acumulador_0 + "_" + acumulador_1;
                } else {
                    stringValue = "[*]" + acumulador_1;
                }
                condicion_string = true;
                stringtot.append(stringValue);
                condicion_string = false;
                break;
            case "division":
                if (condicion_operandos) {
                    stringValue = "[/]" + acumulador_0 + "_" + acumulador_1;
                } else {
                    stringValue = "[/]" + acumulador_1;
                }
                condicion_string = true;
                stringtot.append(stringValue);
                condicion_string = false;
                break;
        }
    }


    private void computo_de_bloques(float... values) {
        //PASO 2: CÓMPUTO DE BLOQUES
        if (muldiv.isEmpty()) {
            return; // Son todo sumas o restas no hemos de operar nada
        }

        int pos_temp; // La posición que observamos en el array values
        bloque_operadores bloque; // valor temporal para sacar bloques
        Character operacion_temp;

        for (int i = 0; i < muldiv.size(); i++) {
            //Recorremos todos los elementos de la lista y llamamos al enum para obtener el resultado
            bloque = muldiv.get(i);

            pos_temp = bloque.p_init;
            for (; pos_temp <= bloque.p_fin; pos_temp++) {
                operacion_temp = bloque.st_inst.remove();
                if (pos_temp == bloque.p_init) {
                    //Si es el primer elemento cogemos dos valores
                    acumulador_0 = values[pos_temp];
                    condicion_operandos = true;
                } else {
                    //Si no el primer valor es el resultado anterior
                    acumulador_0 = resultado_ciclo;
                    condicion_operandos = false;
                }
                acumulador_1 = values[pos_temp + 1];
                car_op = operacion_temp;
                String temporal = Operador.valueOf("sabop").saber_operador(car_op);
                resultado_ciclo = Operador.valueOf(temporal).executeOperations(acumulador_0, acumulador_1);
                guardar_estado(temporal);

            }
            //Guardamos el valor del ciclo
            resB.add(new resultado_bloques());

            resB.getLast().p_fin = bloque.p_fin;
            resB.getLast().p_init = bloque.p_init;
            resB.getLast().resultado = resultado_ciclo;

            resultado_ciclo = 0;

        }
    }

    private void procesado_de_resultado(String operation, float... values) {
        //Da la lista de sumas y restas con los resultados de los bloques de multiplicación y división
        resultado_bloques bloque = resB.removeFirst();
        sumres.p_init = 0;
        sumres.p_fin = operation.length();

        if (bloque == null) {
            //no hay multiplicaciones o divisiones
            bloque = new resultado_bloques();
            bloque.p_init = operation.length() + 1; // Como no hay simplemente apuntamos al extremo + 1
        }

        for (int i = 0; i < operation.length(); i++) {
            if (bloque.p_init == 0) {
                //Caso especial la multiplicacion o division era la primera operación
                if (bloque.p_fin == operation.length()-1) {
                    //Otro caso especial -> SÓLO habia multiplicaciones y divisiones
                    sumres.p_fin = 1;
                    sumres.st_inst.offer('+');
                    sumres.st_dat.offer((float) 0);
                    sumres.st_dat.offer(bloque.resultado);
                    i = operation.length();
                } else {
                    i = bloque.p_fin + 1;
                    sumres.st_inst.offer(operation.charAt(i));
                    sumres.st_dat.offer(bloque.resultado);
                    sumres.st_dat.offer(values[i + 1]);
                    int patata = 0;
                }
                int patata = operation.length();
                if (i < operation.length() && !resB.isEmpty()){
                    bloque = resB.removeFirst();
                }
                else{
                    bloque = new resultado_bloques();
                    bloque.p_init = operation.length() +1;
                }
                //En ambos casos cogemos un nuevo bloque
            } else if (i == 0) {
                //En este caso introducimos dos valores normales -> primer operador + o -
                sumres.st_inst.offer(operation.charAt(i));
                sumres.st_dat.offer(values[i]);
                sumres.st_dat.offer(values[i + 1]);
            }
            else {
                //caso general
                if (i + 1 != bloque.p_init) {
                    //Caso habitual - No hay bloques
                    sumres.st_inst.offer(operation.charAt(i));
                    sumres.st_dat.offer(values[i + 1]);
                } else {
                    //Si que hay bloques
                    sumres.st_inst.offer(operation.charAt(i));
                    sumres.st_dat.offer(bloque.resultado);
                    i = bloque.p_fin;
                    if (resB.isEmpty()) {
                        //Por si los bloques de multiplicaciones o divisiones no llegan al final
                        bloque = new resultado_bloques();
                        bloque.p_init = values.length + 1;
                    } else {
                        bloque = resB.removeFirst();
                    }
                }
            }
        }
        int patata = 0;
    }

    private void computo_de_final() {
        Character operacion_temp;
        int patata = 0;
        for (int i = 0; !sumres.st_inst.isEmpty(); i++) {
            operacion_temp = sumres.st_inst.remove();
            if (i == 0) {
                acumulador_0 = sumres.st_dat.remove();
                condicion_operandos = true;
            } else {
                acumulador_0 = resultado_final;
                condicion_operandos = false;
            }
            acumulador_1 = sumres.st_dat.remove();

            car_op = operacion_temp;
            String temporal = Operador.valueOf("sabop").saber_operador(car_op);
            resultado_ciclo = Operador.valueOf(temporal).executeOperations(acumulador_0, acumulador_1);
            guardar_estado(temporal);
            resultado_final = resultado_ciclo;
        }
        patata = 0;
    }

    public void addOperation(String operation, float... values) {
        stringtot.setLength(0);

        procesado_de_bloques(operation, values);
        //Crea una lista de clase bloque_operadores que la utilizaremos para procesar las multiplicaciones y divisiones
        //Antes que las sumas y restas
        //También lanza los errores necesarios si se pasa un argumento o combinación de valores y argumentos ilegales

        computo_de_bloques(values);
        //Computamos el resultado de los bloques y guardamos el resultado (junto a su posición) en la lista de resultados
        //de bloques

        procesado_de_resultado(operation, values);
        //Crea una lista de clase bloque_operadores que utilizaremos para procesar sumas y restas - substituye las
        //multiplicaciones y divisiones por su resultado

        computo_de_final();
        //computamos las sumas y las restas para obtener el resultado final

        cleanOperations();
    }

    public float executeOperations() { /* ... */
        return 0;
    }


    @Override
    public String toString() { /* ... */
            System.out.print(stringtot);
            return stringtot.toString();
    }
}
