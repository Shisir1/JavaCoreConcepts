package org.example.core;
class AO {

    public AO(){
        System.out.println("Object Created");
    }
    public void show(){
        System.out.println("in A show");
    }
}
public class AnnonymousObject{
    public static void main(String[] args) {

        //Annonymous Object
        new AO();
        new AO().show();
    }
}
