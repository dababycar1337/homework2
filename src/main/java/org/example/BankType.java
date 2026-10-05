package org.example;

public enum BankType {
    NEO("Неокредит Банк", 0.01),
    AUM("Арум Финтех", 0.02),
    VTA("Вектор Альянс Банк", 0.00);

    public final String name;
    public final double commissionRate;

    BankType(String name, double commissionRate) {
        this.name = name;
        this.commissionRate = commissionRate;
    }

    public String getRussianName() {
        return name;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

}
