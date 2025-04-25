import org.example.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testDepositAndWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance(), 0.01);
    }

    @Test
    void testInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(50);
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(100);
        });
    }
}
