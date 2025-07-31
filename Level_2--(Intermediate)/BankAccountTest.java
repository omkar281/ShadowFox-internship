import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest {
    
    // Bank Account class
    public static class BankAccount {
        private String accountNumber;
        private double balance;
        
        // Constructor
        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }
        
        // Deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }
        
        // Withdraw money from the account
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }
        
        // Get the current balance
        public double getBalance() {
            return balance;
        }
    }

    // Test deposit functionality
    @Test
    public void testDeposit() {
        // Create a BankAccount object with initial balance of 100
        BankAccount account = new BankAccount("123", 100);
        
        // Deposit 50 into the account
        account.deposit(50);
        
        // Assert that the balance is now 150
        assertEquals(150, account.getBalance(), 0);
    }
    
    // Test withdrawal functionality
    @Test
    public void testWithdraw() {
        // Create a BankAccount object with initial balance of 100
        BankAccount account = new BankAccount("123", 100);
        
        // Withdraw 50 from the account
        account.withdraw(50);
        
        // Assert that the balance is now 50
        assertEquals(50, account.getBalance(), 0);
    }
    
    // Test withdrawal exceeding balance
    @Test
    public void testWithdrawExceedBalance() {
        // Create a BankAccount object with initial balance of 100
        BankAccount account = new BankAccount("123", 100);
        
        // Withdraw 200 from the account
        account.withdraw(200);
        
        // Assert that the balance remains unchanged (100)
        assertEquals(100, account.getBalance(), 0);
    }
    
    // Main function
    public static void main(String[] args) {
        // Create a BankAccount object with initial balance of 100
        BankAccount account = new BankAccount("123", 100);
        
        // Print initial balance
        System.out.println("Initial balance: " + account.getBalance());
        
        // Deposit 50 into the account
        account.deposit(50);
        System.out.println("After deposit, balance: " + account.getBalance());
        
        // Withdraw 30 from the account
        account.withdraw(30);
        System.out.println("After withdrawal, balance: " + account.getBalance());
        
        // Attempt to withdraw 200 from the account
        account.withdraw(200);
        System.out.println("After withdrawal exceeding balance, balance: " + account.getBalance());
    }
}
