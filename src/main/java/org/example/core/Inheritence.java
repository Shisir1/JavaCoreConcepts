package org.example.core;

class Calc
{
    public int add(int n1, int n2){
        return n1+n2;
    }
    public int sub(int n1, int n2){
        return n1-n2;
    }

    public int multi(int i, int i1) {
        return i*i1;
    }

    public double div(double i, double i1) {
        return i/i1;
    }
}
public class Inheritence {

    public static void main(String[] args) {
        Calc calc = new Calc();
        int r1 = calc.add(5,7);
        int r2 = calc.sub(10,5);
        int r3 = calc.multi(10,5);
        double r4 = calc.div(5,10);

        System.out.println("Addition: "+r1 + "\nSubtraction: "+r2 + "\nMulti: " + r3 + "\nDivision: " + r4);
    }
}
