package org.example.ch2.ex2.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String name = "Ella";
    private final Parrot parrot;

    // @Autowired         со Spring 4.3, если класс состоит только из одного конструктора, аннотацию @Autowired можно пропустить.
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }
}
