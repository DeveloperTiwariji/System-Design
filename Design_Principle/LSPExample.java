//<=======================LSP Liskov Substitution Principle========================>
//<=======================Subclass should be substitutabel for their Base class===================>


interface DepositOnlyAccount {
    void deposit(double amount);
}

interface WithdrawableAccount extends DepositOnlyAccount {
    void withdraw(double amount);
}

class SavingsAccount implements WithdrawableAccount {
    private double balance;

    public SavingsAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class CurrentAccount implements WithdrawableAccount {
    private double balance;

    public CurrentAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class FixedDepositAccount implements DepositOnlyAccount {
    private double balance;

    public FixedDepositAccount() {
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class LSPExample {
    public static void main(String[] args) {
        WithdrawableAccount savingsAccount = new SavingsAccount();
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        System.out.println("Savings Account Balance: " + ((SavingsAccount) savingsAccount).getBalance());

        WithdrawableAccount currentAccount = new CurrentAccount();
        currentAccount.deposit(2000);
        currentAccount.withdraw(1000);
        System.out.println("Current Account Balance: " + ((CurrentAccount) currentAccount).getBalance());

        DepositOnlyAccount fixedDepositAccount = new FixedDepositAccount();
        fixedDepositAccount.deposit(5000);
        System.out.println("Fixed Deposit Account Balance: " + ((FixedDepositAccount) fixedDepositAccount).getBalance());
    }
}