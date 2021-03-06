package com.example.postgresdemo.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Entity

@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Person {

    public Person(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;


    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Address address;

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
