package Proga.task8;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Внесено: " + amount + ", баланс: " + balance);
        } else {
            System.out.println("Сумма должна быть положительной");
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств. Доступно: " + balance + ", запрошено: " + amount);
        }
        balance -= amount;
        System.out.println("Снято: " + amount + ", баланс: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class t3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(100);
            account.withdraw(900);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            account.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}