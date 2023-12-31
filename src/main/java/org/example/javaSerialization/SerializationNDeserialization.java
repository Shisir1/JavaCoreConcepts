package org.example.javaSerialization;

import java.io.*;

public class SerializationNDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Serialize
        Employee e = new Employee();
        e.setId(1);
        e.setName("Shisir Humagain");
        e.setSalary(5000);

        //new codeDecode.ser will be created in the given path
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/owner/Desktop/JavaLearning/core/src/main/java/org/example/javaSerialization/codeDecode.ser");

        //pass the fileoutputstream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        //write the object
        objectOutputStream.writeObject(e);

        objectOutputStream.close();
        fileOutputStream.close();

        //Deserialize

        //takes the streams from the file provided
        FileInputStream fileInputStream = new FileInputStream("/Users/owner/Desktop/JavaLearning/core/src/main/java/org/example/javaSerialization/codeDecode.ser");

        //takes object of fileInputStream
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);

        //typecast to the original object because reCreatedObject returns object
        Employee reCreatedObj = (Employee) inputStream.readObject();
        System.out.println(reCreatedObj.getId() + " : " + reCreatedObj.getName() + " : " + reCreatedObj.getSalary());
        inputStream.close();
        fileOutputStream.close();

    }
}
