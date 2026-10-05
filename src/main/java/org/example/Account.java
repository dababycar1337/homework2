package org.example;

public class Account {

    public int cardNumber;
    public int pinCode;
    public double balance;
    public BankType bankType;

    public Account(int cardNumber, int pinCode, double balance, BankType bankType) {
        if (cardNumber < 10000 || cardNumber > 99999) {
            System.out.println("Ошибка: номер карты должен состоять из 5 цифр. Установлено 10000.");
            this.cardNumber = 10000;
        } else {
            this.cardNumber = cardNumber;
        }

        if (pinCode < 100 || pinCode > 999) {
            System.out.println("Ошибка: пин-код должен состоять из 3 цифр. Установлено 100.");
            this.pinCode = 100;
        } else {
            this.pinCode = pinCode;
        }

        if (balance < 0) {
            System.out.println("Ошибка: баланс не может быть отрицательным. Установлено 0.00.");
            this.balance = 0.0;
        } else {
            this.balance = Math.round(balance * 100.0) / 100.0;
        }

        this.bankType = (bankType == null) ? BankType.NEO : bankType;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public BankType getBankType() {
        return bankType;
    }

    @Override
    public String toString() {
        return String.format("%s Карта: %d, Баланс: %.2f руб.",
                bankType.getRussianName(), cardNumber, balance);
    }
}