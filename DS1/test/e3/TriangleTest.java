import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void test_construction (){
        assertThrows (IllegalArgumentException.class , () -> new Triangle(0,0,0) );
        assertThrows(IllegalArgumentException.class, () -> new Triangle(90,90,0));
        Triangle t = new Triangle(45, 30,105);
        assertEquals(45,t.angle0());
        assertEquals(30,t.angle1());
        assertEquals(105,t.angle2());
    }

    @Test
    void test_condicions (){
        Triangle t = new Triangle(90,45,45);
        Triangle l = new Triangle (60,60,60);
        Triangle p = new Triangle(120,40,20);

        assertTrue(t.isRight());
        assertTrue(t.isIsosceles());
        assertFalse(t.isScalene());
        assertTrue(l.isEquilateral());
        assertFalse(l.isScalene());
        assertTrue(l.isAcute());
        assertTrue(l.isIsosceles());
        assertTrue(p.isObtuse());
        assertTrue(p.isScalene());
    }

    @Test
    void test_equality_and_hash (){
        Triangle p;
        Triangle t = new Triangle(90,45,45);
        Triangle l = new Triangle (60,60,60);
        Triangle k = new Triangle (90,45,45);
        Calculator calc = new Calculator();

        assertTrue(t.equals(t));
        assertFalse(t.equals(calc));
        assertTrue(t.equals(k));
        assertFalse(t.equals(l));

    }
}
