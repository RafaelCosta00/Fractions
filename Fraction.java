package com.company;

public class Fraction implements IFractions {
    private int numerator;
    private int denominator;
    private int tempNegativeDeno;
    private int tempNegativeNum;
    private int gcd;
    private int tempSwap;
    private int tempNum;
    private int tempDeno;
    private Fraction tempFraction;

    public Fraction(Fraction fraction){
        this.numerator = fraction.getNumerator();
        this.denominator = fraction.getDenominator();
    }

    public Fraction(int numerator, int denominator) {
        if(denominator == 0){
            System.out.println("Invalid denominator. Denominator set to One.");
            this.denominator = 1;
            this.numerator = numerator;
        }else {
            //if either one are negative converts to positives and assign to instance variables
            if(numerator < 0 && denominator < 0){
                convertNegativeDenominator(numerator, denominator);
            //switch negative sign form the denominator to numerator and assign new value to instance variables
            }else if(numerator > 0 && denominator < 0){
                convertNegativeDenominator(numerator, denominator);
            }else{
            //assign smallest values for fraction
            gcd = gcd(numerator, denominator);
            this.numerator = numerator/gcd;
            this.denominator = denominator/gcd;
            }
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    @Override
    public int gcd(Integer integerOne, Integer integerTwo) {
        int result;
        if (integerOne % integerTwo == 0)
            result = integerTwo;
        else
            result = gcd(integerTwo, integerOne % integerTwo);
        //converts negative gcd to positive
        if(result < 0){
            result = result - (2 * result);
        }
        return result;
    }

    @Override
    public Fraction add(Fraction fraction) {
        if(this.denominator == fraction.getDenominator()){
            tempFraction = new Fraction((fraction.getNumerator() + this.numerator), this.denominator);
            return tempFraction;
        }else{
            tempNum = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
            tempDeno = this.denominator * fraction.denominator;
            tempFraction = new Fraction(tempNum, tempDeno);
            return tempFraction;
        }
    }

    @Override
    public Fraction subtract(Fraction fraction) {
        if(this.denominator == fraction.getDenominator()){
            tempFraction = new Fraction((this.numerator - fraction.getNumerator()), this.denominator);
            return tempFraction;
        }else{
            tempNum = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
            tempDeno = this.denominator * fraction.denominator;
            tempFraction = new Fraction(tempNum, tempDeno);
            return tempFraction;
        }
    }

    @Override
    public Fraction multiply(Fraction fraction) {
        //multiply fractions and return new fraction with lowest values
        tempFraction = new Fraction(fraction.getNumerator() * this.numerator, fraction.getDenominator() * this.denominator);
        return tempFraction;
    }

    @Override
    public Fraction divide(Fraction fraction) {
        //multiply by the inverse of the second fraction and return new fraction with lowest values
        tempFraction = new Fraction( fraction.getDenominator() * this.numerator, fraction.getNumerator() * this.denominator);
        return tempFraction;
    }

    @Override
    public Fraction reciprocal() {
        tempSwap = this.numerator;
        tempNum = this.denominator;
        tempDeno = tempSwap;
        tempFraction = new Fraction(tempNum, tempDeno);
        return tempFraction;
    }

    @Override
    public Fraction compare(Fraction fraction) {
        if((fraction.getNumerator()/fraction.getDenominator()) > (this.numerator/this.denominator)){
            tempFraction = new Fraction(fraction.getNumerator(), fraction.getDenominator());
            return fraction;
        }else if((fraction.getNumerator()/fraction.getDenominator()) < (this.numerator/this.denominator)){
            tempFraction = new Fraction(this.numerator, this.denominator);
            return tempFraction;
        }
        //equals
        System.out.println("Equal fractions.");
        tempFraction = new Fraction(this.numerator, this.denominator);
        return fraction;
    }

    @Override
    public boolean equal(Fraction fraction) {
        if(fraction.getNumerator() == this.numerator && fraction.getDenominator() == this.denominator)
            return true;
        return false;
    }

    @Override
    public String convertFractionToString() {
        return (this.numerator + "/" + this.denominator);
    }


    private void convertNegativeDenominator(int numerator, int denominator) {
        gcd = gcd(numerator, denominator);
        //converts denominator to positive
        tempNegativeDeno = denominator;
        tempNegativeDeno = tempNegativeDeno - (2*tempNegativeDeno);
        //assigns positive denominator
        this.denominator = tempNegativeDeno / gcd;
        //converts numerator to negative
        tempNegativeNum = numerator;
        tempNegativeNum = tempNegativeNum - (2*tempNegativeNum);
        //assign negative denominator
        this.numerator = tempNegativeNum / gcd;
    }
}
