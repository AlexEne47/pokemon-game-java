package com.proiect;

import java.util.*;

public class Pokemon {
    String name;
    double HP;
    double normalAttack;
    double specialAttack;
    double defense;
    double specialDefense;

    double cooldownTime = 0;
    boolean isStunned = false;
    boolean dodge = false;

    Ability1 ability1 = new Ability1();
    Ability2 ability2 = new Ability2();

    List<Item> items = new ArrayList<Item>();

    class Ability1 {
        double damage;
        boolean stun;
        boolean dodge;
        double cooldown;

        @Override
        public String toString() {
            return this.damage + " " + this.stun + " " + this.dodge + " " + this.cooldown;
        }
    }

    class Ability2 {
        double damage;
        boolean stun;
        boolean dodge;
        double cooldown;

        @Override
        public String toString() {
            return this.damage + " " + this.stun + " " + this.dodge + " " + this.cooldown;
        }
    }

    void setNume(String nume) {
        this.name = nume;
    }

    void setHP(double HP) {
        this.HP = HP;
    }

    void setAttack(double attack) {
        this.normalAttack = attack;
    }

    void setDefense(double defense) {
        this.defense = defense;
    }

    void setSpecialDefence(double specialDefence) {
        this.specialDefense = specialDefence;
    }

    void useItems() {
        for(Item item : items) {
            this.HP += item.HP;
            this.normalAttack += item.attack;
            this.specialAttack += item.specialAttack;
            this.defense += item.defense;
            this.specialDefense += item.specialDefense;
        }
    }

    void attack(Pokemon pokemon) {
        if(this.isStunned == true)
        this.isStunned = false;
        else {
        if(pokemon.dodge == true)
        pokemon.dodge = false;
        else
        if(this.normalAttack != 0) { // Atac normal 
            if(pokemon.defense < this.normalAttack + this.specialAttack)
            pokemon.HP -= (this.normalAttack + this.specialAttack) - pokemon.defense;
        } else { // Atac special
            if(pokemon.specialDefense < this.normalAttack + this.specialAttack)
            pokemon.HP -= (this.normalAttack + this.specialAttack) - pokemon.specialDefense;
        }
        }

        if(this.cooldownTime != 0)
        this.cooldownTime--;
    }

    void abilitate1(Pokemon pokemon) {
        if(this.isStunned == true)
        this.isStunned = false;
        else {
        this.cooldownTime = this.ability1.cooldown;
        this.dodge = this.ability1.dodge;

        if(pokemon.dodge == true)
        pokemon.dodge = false;
        else {
        pokemon.HP -= this.ability1.damage;
        pokemon.isStunned = this.ability1.stun;
        }
        }
    }

    void abilitate2(Pokemon pokemon) {
        if(this.isStunned == true)
        this.isStunned = false;
        else {
        this.cooldownTime = this.ability2.cooldown;
        this.dodge = this.ability2.dodge;

        if(pokemon.dodge == true)
        pokemon.dodge = false;
        else {
        pokemon.HP -= this.ability2.damage;
        pokemon.isStunned = this.ability2.stun;
        }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.HP + " " + this.normalAttack + " " + this.specialAttack + " " +
        this.defense + " " + this.specialDefense + " " + this.items.toString();
    }

}
