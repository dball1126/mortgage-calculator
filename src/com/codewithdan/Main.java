package com.codewithdan;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static float MonthlyInterestRate(float annual_interest_rate){
        return annual_interest_rate / 12F;
    };

    public static short NumberOfPayments(byte period) {
        return (short) (period * 12);
    }

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        float annualInterest = -999_999;
        int principal = 0;
        byte years = 99;

        while (principal < 1000 || principal > 1_000_000) {

            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
        }

        while (annualInterest <= 0 || annualInterest > 30) {
            if (annualInterest != -999_999)
                System.out.println("Enter a value greater than 0 and less than or equal to 30");


            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
        }

        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        while (years < 1 || years > 30) {
            if (annualInterest != -999_999)
                System.out.println("Enter a value between 1 and 30");

            System.out.print("Period (Years): ");
            years = scanner.nextByte();
        }



        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal
                * (monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments)
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1)));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format((mortgage));
        System.out.print("Mortgage: " + mortgageFormatted);


    }
}
