import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {
    CheckingAccount ch = new CheckingAccount();
    @BeforeEach
    void setUp() {
        System.out.println("Before each here ");
        ch.setInfo(120000,1234567L,"Kari");
    }

    @Test
    void deposit() {

        assertEquals(121000,ch.deposit(1000));
    }

    @Test
    void withdraw() {
        assertEquals(110000,ch.withdraw(10000));
    }
    @Test
    void purchase() {
        assertEquals(110000,ch.purchase("shoes",10000));

    }
    @Test
    public void withdraw_branch(){
        assertThrows(IllegalArgumentException.class,()-> {
            ch.withdraw_branch(700,false);
        });
    }

}