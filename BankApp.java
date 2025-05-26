//<================================== OOPS Concepts in Java ==================================>
// This code demonstrates the four main OOP concepts in Java: Encapsulation, Inheritance, Polymorphism, and Abstraction.

//<============================= Data Abstraction =============================>

abstract class BankAccount {
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);

    public void showBalance() {
        System.out.println(accountHolder + "'s current balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to Savings Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Savings Account");
        } else {
            System.out.println("Insufficient balance in Savings Account.");
        }
    }
}

//<============================= Inheritance =============================>
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " to Checking Account");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from Checking Account");
        } else {
            System.out.println("Overdraft limit exceeded in Checking Account.");
        }
    }
}

//<============================= Polymorphism =============================>
class FixedDepositAccount extends BankAccount {
    private double interestRate;

    public FixedDepositAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Cannot deposit in a Fixed Deposit Account.");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from a Fixed Deposit Account.");
    }

    public void calculateInterest() {
        double interest = balance * interestRate / 100;
        System.out.println("Interest earned: $" + interest);
    }
}

//<============================= Encapsulation =============================>
class AccountHolder {
    private String name;
    private String address;

    public AccountHolder(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

//<============================= Main Class =============================>
public class BankApp {
    public static void main(String[] args) {
        // Demonstrating encapsulation
        AccountHolder holder = new AccountHolder("Alice", "123 Main Street");
        System.out.println("Account Holder: " + holder.getName() + ", Address: " + holder.getAddress());

        // Demonstrating abstraction and polymorphism
        BankAccount savings = new SavingsAccount(holder.getName(), 1000);
        BankAccount checking = new CheckingAccount("Bob", 500, 200);
        BankAccount fixed = new FixedDepositAccount("Charlie", 2000, 5);

        savings.deposit(200);
        savings.withdraw(300);
        savings.showBalance();

        checking.deposit(100);
        checking.withdraw(700);
        checking.showBalance();

        fixed.deposit(100);  // should show not allowed
        fixed.withdraw(50);  // should show not allowed
        ((FixedDepositAccount) fixed).calculateInterest();  // calling subclass-specific method
    }
}
