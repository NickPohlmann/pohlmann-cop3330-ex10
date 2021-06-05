/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        double taxRate = 0.055;

        String item1PriceString = myApp.readInput("Enter the price of item 1: ");
        String item1QuantityString = myApp.readInput("Enter the quantity of item 1: ");
        String item2PriceString = myApp.readInput("Enter the price of item 2: ");
        String item2QuantityString = myApp.readInput("Enter the quantity of item 2: ");
        String item3PriceString = myApp.readInput("Enter the price of item 3: ");
        String item3QuantityString = myApp.readInput("Enter the quantity of item 3: ");
        float item1Price = myApp.convertInputToFloat(item1PriceString);
        int item1Quantity = myApp.convertInputToInt(item1QuantityString);
        float item2Price = myApp.convertInputToFloat(item2PriceString);
        int item2Quantity = myApp.convertInputToInt(item2QuantityString);
        float item3Price = myApp.convertInputToFloat(item3PriceString);
        int item3Quantity = myApp.convertInputToInt(item3QuantityString);
        float subtotal = myApp.computeSubtotal(item1Price, item2Price, item3Price, item1Quantity, item2Quantity, item3Quantity);
        double tax = myApp.computeTax(taxRate, subtotal);
        double total = myApp.computeTotal(tax, subtotal);
        String outputString = myApp.generateOutputString(subtotal, tax, total);
        myApp.printOutputString(outputString);
    }

    private void printOutputString(String outputString) { System.out.println(outputString); }

    private String generateOutputString(float subtotal, double tax, double total) {
        return String.format("Subtotal: %.2f \nTax: %.2f \nTotal: %.2f", subtotal, tax, total);
    }

    private String readInput(String str){
        System.out.println(str);
        String input = in.nextLine();
        return input;
    }

    private int convertInputToInt(String inputString) {
        int input = Integer.parseInt(inputString);
        return input;
    }

    private float convertInputToFloat(String inputString) {
        float input = Float.valueOf(inputString).floatValue();
        return input;
    }

    private float computeSubtotal(float item1Price, float item2Price, float item3Price, int item1Quantity, int item2Quantity, int item3Quantity) {
        float subtotal = (item1Price*item1Quantity) + (item2Price*item2Quantity) + (item3Price*item3Quantity);
        return subtotal;
    }

    private double computeTax(double taxRate, float subtotal) {
        double tax = taxRate * subtotal;
        return tax;
    }

    private double computeTotal(double tax, float subtotal) {
        double total = tax + subtotal;
        return total;
    }
}
