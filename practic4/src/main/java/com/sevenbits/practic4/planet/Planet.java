package com.sevenbits.practic4.planet;

import java.util.UUID;

public class Planet {
    private String name;
    private String id;

    public Planet(final String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Planet{" + "name='" + name + '\'' + '}';
    }
}