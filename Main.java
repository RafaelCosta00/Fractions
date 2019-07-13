package com.company;

/*
CCSF Class 111B
Student Rafael Ferreira Costa
Created on 07/118/2018

Project Interface
 */


public class Main {

    public static void main(String[] args) {
        System.out.println();

        //zero denominator -> converts to 1 automatically
        Fraction fraction0 = new Fraction(1,0);
        System.out.println("Fraction 0 input(1/0): " + fraction0.convertFractionToString());

        //reduce fraction
        Fraction fraction1 = new Fraction(9, 75);
        System.out.println("Fraction 1 input(9/75): " + fraction1.convertFractionToString());

        //negative denominator fraction
        Fraction fraction2 = new Fraction(-33, 11);
        System.out.println("Fraction 2 input(-33/11): " + fraction2.convertFractionToString());

        //negative denominator fraction -> converts to negative numerator
        Fraction fraction3 = new Fraction(16, -4);
        System.out.println("Fraction 3 input(16/-4): " + fraction3.convertFractionToString());

        //denominator and numerator negative -> converts to positive fraction
        Fraction fraction4 = new Fraction(-3, -33);
        System.out.println("Fraction 4 input(-3/-33): " + fraction4.convertFractionToString());

        //add two fraction
        Fraction fraction5 = new Fraction(fraction0.add(fraction4));
        System.out.println("Fraction 5 (adds fractions 4 to 0): " + fraction5.convertFractionToString());

        //subtract two fractions
        Fraction fraction6 = new Fraction(fraction2.subtract(fraction3));
        System.out.println("Fraction 6 (subtracts fractions 3 from 2): " + fraction6.convertFractionToString());

        //multiply two fractions
        Fraction fraction7 = new Fraction(fraction4.multiply(fraction5));
        System.out.println("Fraction 7 (multiply fractions 4 and 5): " + fraction7.convertFractionToString());

        //divides two fractions
        Fraction fraction8 = new Fraction(fraction7.divide(fraction3));
        System.out.println("Fraction 8 (divide fractions 7 by 3): " + fraction8.convertFractionToString());

        //reciprocal fraction
        Fraction fraction9 = new Fraction(fraction2.reciprocal());
        System.out.println("Fraction 9 (return reciprocal of fraction 2): " + fraction9.convertFractionToString());

        //compare two fractions
        Fraction fraction10 = new Fraction(fraction3.compare(fraction4));
        System.out.println("Fraction 10 (compare fraction 3 to 4 returns bigger): " + fraction10.convertFractionToString());

        //compares if two fractions are equals
        System.out.println("Is fraction 9 equal to fraction 2? " + fraction9.equal(fraction2));
        System.out.println("Is fraction 0  equal to fraction 6? " + fraction0.equal(fraction6));

        //finds GCD
        int gcd = fraction0.gcd(2,4);
        System.out.println("The GCD of 2 and 4 is: " + gcd);



    }
}
