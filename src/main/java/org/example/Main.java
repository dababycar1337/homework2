package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account reference = new Account(12345, 999, 10000.00, BankType.AUM);

        System.out.println("Добро пожаловать в банкомат!");
        System.out.print("Введите номер карты: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка доступа: неверный формат номера карты.");
            scanner.close();
            return;
        }
        int inputCard = scanner.nextInt();

        System.out.print("Введите пин-код: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка доступа: неверный формат пин-кода.");
            scanner.close();
            return;
        }
        int inputPin = scanner.nextInt();

        if (inputCard != reference.getCardNumber() || inputPin != reference.getPinCode()) {
            System.out.println("Ошибка доступа: неверный номер карты или пин-код.");
            scanner.close();
            return;
        }

        System.out.println("Авторизация успешна!");
        System.out.println(reference);

        CashMachine atm = new CashMachine();
        double currentBalance = reference.getBalance();

        System.out.print("Введите сумму для внесения: ");
        Double depositAmount = null;
        if (scanner.hasNextDouble()) {
            depositAmount = scanner.nextDouble();
        } else {
            scanner.next();
            System.out.println("Некорректная сумма. Внесение пропущено.");
        }

        currentBalance = atm.deposit(currentBalance, depositAmount);
        System.out.printf("Баланс после внесения: %.2f руб.%n", currentBalance);

        System.out.print("Введите сумму для снятия: ");
        Double withdrawAmount = null;
        if (scanner.hasNextDouble()) {
            withdrawAmount = scanner.nextDouble();
        } else {
            scanner.next();
            System.out.println("Некорректная сумма. Снятие пропущено.");
        }

        currentBalance = atm.withdraw(currentBalance, withdrawAmount, reference.getBankType());
        System.out.printf("Баланс после снятия: %.2f руб.%n", currentBalance);

        scanner.close();
    }
}