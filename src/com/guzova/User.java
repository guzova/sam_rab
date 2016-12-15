package com.guzova;

public class User {
    private String surname;
    private String name;
    private int course;
    private int group;

    public User(String surname, String name, int course, int group) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + course + " " + group;
    }
}
