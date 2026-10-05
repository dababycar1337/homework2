package org.example;

public interface WithdrawalOperations {

    double withdraw(double currentBalance, Double amount, BankType bankType);

    default double applyCommission(Double amount, BankType bankType) {
        if (amount == null || bankType == null) {
            return 0.0;
        }
        double commission = amount * bankType.getCommissionRate();
        return Math.round(commission * 100.0) / 100.0;
    }
}