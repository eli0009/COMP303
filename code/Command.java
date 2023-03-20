package code;

public class Command {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100);
        System.out.println(account);

        BankCommand deposit = new BankDepositCommand(account, 200);
        deposit.call();
        System.out.println(account);

        BankCommand withdraw = new BankWithdrawCommand(account, 150);
        withdraw.call();
        System.out.println(account);

        withdraw.undo();
        System.out.println(account);

        deposit.undo();
        System.out.println(account);
    }
}

interface BankCommand {
    void call();

    void undo();
}

class BankDepositCommand implements BankCommand {
    private BankAccount account;
    private int amount;
    private boolean success;

    public BankDepositCommand(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void call() {
        success = account.deposit(amount);
    }

    @Override
    public void undo() {
        if (success)
            account.withdraw(amount);
    }
}

class BankWithdrawCommand implements BankCommand {
    private BankAccount account;
    private int amount;
    private boolean success;

    public BankWithdrawCommand(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void call() {
        success = account.withdraw(amount);
    }

    @Override
    public void undo() {
        if (success)
            account.deposit(amount);
    }
}

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }

    @Override
    public String toString() {
        return "{" +
                " balance='" + balance + "'" +
                "}";
    }
}