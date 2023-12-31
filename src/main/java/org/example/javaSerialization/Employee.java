package org.example.javaSerialization;

import java.io.Serial;
import java.io.Serializable;

public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;
    private int id;
    private String name;

    //this field won't work because its transient, static also won't work
    private transient int Salary;

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
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
}
