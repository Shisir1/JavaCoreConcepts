package org.example.javaSerialization;

import java.io.*;

public class ExternalizationPOJO implements Externalizable {

    @Serial
    private static final long serialVersionUID = 2L;
    private int id;
    private String name;

    //this field won't work because its transient, static also won't work
    private transient double Salary;

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //Only write that are present here
        out.writeInt(id);
        out.writeBytes(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //reads only fields that are present here
        id = in.readInt();
        name = in.readLine();
    }
}
