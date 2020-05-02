package com.example.test;

import java.io.Serializable;
import java.util.Random;

public class DataClass implements Serializable {
//    private Random mRandom = new Random();
//    private String mField1;
//    private String mField2;
    private String id;
    private String name;
    private int    age;
    private String location;

    DataClass() {
        name = "";
        age = 0;
        location = "";
    }

    DataClass(String id, String name, int age, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.location = location;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getLocation() {
        return location;
    }

    void setLocation(String location) {
        this.location = location;
    }
}
