package org.example;

public class CashMachine implements WithdrawalOperations, DepositOperations {

    @Override
    public double deposit(double currentBalance, Double amount) {
        if (amount == null || amount <= 0) {
            return currentBalance;
        }
        double newBalance = currentBalance + amount;
        return Math.round(newBalance * 100.0) / 100.0;
    }

    @Override
    public double withdraw(double currentBalance, Double amount, BankType bankType) {
        if (amount == null || amount <= 0) {
            return currentBalance;
        }

        double commission = applyCommission(amount, bankType);
        double total = amount + commission;
        total = Math.round(total * 100.0) / 100.0;

        if (total > currentBalance) {
            System.out.println("Недостаточно средств на счете. Требуется: "
                    + String.format("%.2f", total)
                    + " руб., доступно: "
                    + String.format("%.2f", currentBalance) + " руб.");
            return currentBalance;
        }

        double newBalance = currentBalance - total;
        return Math.round(newBalance * 100.0) / 100.0;
    }
}