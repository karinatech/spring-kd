import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
@BeforeEach
public void beforeEach(){
    System.out.println("Before each here");
}
@AfterAll
public static void tearDown(){
    System.out.println("After all here ");
}
@AfterEach
public static void afterEachMeethod(){
    System.out.println("Here is afteer Eeach here ");
}
@BeforeAll
public static void beforeAll(){
    System.out.println("This is before all method ");
}
    @Test
    void add() {
     assertTrue(Calculator.operator.equals("add"));


    }
    @Test
    void case1() {
     int actual =Calculator.add(2,5);
     assertEquals(7,actual);
    }
    @Test
    void case2() {
        assertEquals(20,20);
    }
    @Test
    void case3() {
        assertArrayEquals(new int[]{1,2,3,4},new int[]{1,2,3,4});
    }
    @Test
    void case4() {
        String nullString =null;
        String notNullString="Kari";
        assertNotNull(notNullString);
        assertNull(nullString);
    }
    @Test
    void case5() {
        Calculator c1=new Calculator();
        Calculator c2=c1;
        Calculator c3=new Calculator();
        assertNotSame(c1,c3);
        assertSame(c1,c2);

    }

}