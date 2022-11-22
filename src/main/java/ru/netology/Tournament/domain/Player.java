package ru.netology.Tournament.domain;

public class Player {
    // поля id, name, strength
    protected String name;
    protected int strength;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Player(String name, int strength) {
        this.name = name;
        this.strength = strength;

    }
}
