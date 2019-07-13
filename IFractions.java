package com.company;

public interface IFractions {

    //adds two fractions returns new one
    Fraction add(Fraction fraction);

    //subtracts two fractions returns new one
    Fraction subtract(Fraction fraction);

    //multiplies two fractions returns new one
    Fraction multiply(Fraction fraction);

    //divides two fractions returns new one
    Fraction divide(Fraction fraction);

    //returns new fraction with reciprocal values
    Fraction reciprocal();

    //compare fractions and return new one with the bigger fraction values
    Fraction compare(Fraction fraction);

    //compare if object fraction and passed fraction are equals
    boolean equal(Fraction fraction);

    //convert object fraction to string and return it
    String convertFractionToString();

    //finds GCD of two values
    int gcd(Integer integerOne, Integer integerTwo);
}