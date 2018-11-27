package com.sevenbits.practic4;

import com.sevenbits.practic4.planet.Planet;
import com.sevenbits.practic4.storage.FixedStorage;
import com.sevenbits.practic4.storage.IFixedStorage;
import com.sevenbits.practic4.storage.IUniqueStorage;
import com.sevenbits.practic4.storage.UniqueStorage;

public class Main {

    public static void main(String[] args) {
        IUniqueStorage<Planet> unique = new UniqueStorage<Planet>();
        IFixedStorage<Planet> fixed = new FixedStorage<Planet>(7);

        Planet mercury = new Planet("Mercury");
        Planet venus = new Planet("Venus");
        Planet earth = new Planet("Earth");
        Planet mars = new Planet("Mars");
        Planet jupiter = new Planet("Jupiter");
        Planet saturn = new Planet("Saturn");
        Planet uranus = new Planet("Uranus");
        Planet[] planets = new Planet[] {mercury, venus, earth, mars, jupiter, saturn, uranus};

        for(Planet planet : planets) {
            unique.add(planet);
            fixed.add(planet.getId(), planet);
        }


        System.out.println("Planets in UniqueStorage");
        for (Planet planet : (Iterable<Planet>) unique) {
            System.out.println("   " + planet.getName());
        }


        System.out.println("Planets in FixedStorage");
        for (Planet planet : planets) {
            if (fixed.contains(planet)) {
                System.out.println("   " + planet.getName());
            }
        }


        fixed.remove(earth.getId());

        System.out.println("Planets in FixedStorage after deleting Earth");
        for (Planet planet : planets) {
            if (fixed.contains(planet)) {
                System.out.println("   " + planet.getName());
            }
        }


        fixed.add(saturn.getId(), saturn);
        fixed.add("djd", saturn);
        fixed.add("djd", saturn);
        System.out.println("Planets in FixedStorage after adding Saturn again");
        for (Planet planet : planets) {
            if (fixed.contains(planet)) {
                System.out.println("   " + planet.getName());
            }
        }
    }
}
