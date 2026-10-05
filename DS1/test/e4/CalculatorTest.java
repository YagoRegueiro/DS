import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void Paso_de_operandos_sin_operador (){
        Calculator calculator = new Calculator();
        float[] array = {23,3};
        assertThrows (IllegalArgumentException.class , () -> calculator.addOperation("", array) );
    }

    @Test
    void Paso_de_operador_sin_operandos(){
        Calculator calculator = new Calculator();
        String operador = "+";
        float[] array = {};
        assertThrows (IllegalArgumentException.class , () -> calculator.addOperation(operador,array) );
    }
    @Test//Asumo que esto es una condición donde ha de dar error
    void Paso_de_operador_con_un_numero_par_de_operandos(){
        Calculator calculator = new Calculator();
        String operador = "+-";
        float[] array = {2,3,4,5};
        assertThrows (IllegalArgumentException.class , () -> calculator.addOperation(operador,array) );
    }

    @Test
    void Paso_de_mas_operadores_que_operandos (){
        Calculator calculator = new Calculator();
        String operador = "+-*/";
        float[] array = {2,3};
        assertThrows (IllegalArgumentException.class , () -> calculator.addOperation(operador,array) );
    }

    @Test
    void Comprobaciones_aritmeticas(){
        Calculator calculator = new Calculator();
        String operador = "+-*/++**";
        float[] array = {2,3,-5,6,7,8,-9,-10,11};//2+3-(-5)*6/7+8+(-9)*(-10)*11 -> 2 + 3 - (-4.285714) +8 + 990
        //conjunto de suma 2+3-4.285714286+8+990
        calculator.addOperation(operador,array);
        assertEquals(1007.285714286,calculator.resultado_final, 0.0001);
        assertEquals("[*]-5.0_6.0[/]7.0[*]-9.0_-10.0[*]11.0[+]2.0_3.0[-]-4.285714[+]8.0[+]990.0", calculator.toString());


        float[] array2 = {-9,-8,-7,-6};
        String operador2 = "***";
        calculator.addOperation(operador2,array2);
        assertEquals(3024,calculator.resultado_final, 0.0001);
        assertEquals("[*]-9.0_-8.0[*]-7.0[*]-6.0[+]0.0_3024.0", calculator.toString());

        float[] array3 = {-9,-8,-7,6};
        String operador3 = "**+";
        calculator.addOperation(operador3,array3);
        assertEquals(-498,calculator.resultado_final, 0.0001);
        assertEquals("[*]-9.0_-8.0[*]-7.0[+]-504.0_6.0",calculator.toString());

        //


    }
    //TODO: Preguntar al profesor de teóricas si consideramos las otras funciones publicas
    //TODO: Pese a que claramente no estén diseñadas para ser llamadas fuera de la función




}
