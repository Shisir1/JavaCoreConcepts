package org.example.core;

class A{

    public A(){
        super();
        System.out.println("in A");
    }

    public A(String name){
        super();
        System.out.println("in A string");
    }
}

class B extends AO {

    public B(){
        super();
        System.out.println("in B");
    }
    public B(String name){
        this();
        //super(name);
        System.out.println("in B string");
    }
}
public class Super {

    public static void main(String[] args) {
        A a = new A("Shisir");
        B b = new B("Shisir Humagain");

    }
}
