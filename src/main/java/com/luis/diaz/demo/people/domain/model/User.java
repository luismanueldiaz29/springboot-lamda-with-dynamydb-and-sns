package com.luis.diaz.demo.people.domain.model;

public class User {
    private String id;
    private String name;
    private String identification;

    public User() {
    }

    public User(String id, String name, String identification) {
        this.id = id;
        this.name = name;
        this.identification = identification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
