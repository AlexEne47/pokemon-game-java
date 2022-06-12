package com.proiect;

public class Item {
    String name;
    double HP;
    double attack;
    double specialAttack;
    double defense;
    double specialDefense;

    @Override
    public String toString() {
        return this.name + " " + this.HP + " " + this.attack + " " + this.specialAttack + " " + this.defense + " " + this.specialDefense;
    }
}
