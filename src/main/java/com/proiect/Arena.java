package com.proiect;

import java.util.Random;

public class Arena {
    static Random random = new Random();
    
    static void batalieNeutrel(Antrenor antrenor, Pokemon pokemon, Pokemon neutrel) throws InterruptedException {

        // Retinem viata initial
        double regenNeutrel = neutrel.HP;
        double regenPokemon = pokemon.HP;

        System.out.println("Batalie cu " + neutrel.name + " :");

        // Folosim itemele
        pokemon.useItems();

        while(pokemon.HP > 0 && neutrel.HP > 0) {
            int nrRandom = random.nextInt(3);

            if(nrRandom == 0) { // atac normal

                System.out.println(pokemon.name + " atac normal / " + neutrel.name + " atac normal");

                pokemon.attack(neutrel);
                neutrel.attack(pokemon);
                
                System.out.println(neutrel.name + " " + neutrel.HP);
                System.out.println(pokemon.name + " " + pokemon.HP);

                Thread.sleep(500);

            } else if (nrRandom == 1 && pokemon.cooldownTime == 0) { // abilitate 1

                System.out.println(pokemon.name + " abilitate 1 / " + neutrel.name + " atac normal" + pokemon.cooldownTime);

                pokemon.abilitate1(neutrel);
                neutrel.attack(pokemon);
                
                System.out.println(neutrel.name + " " + neutrel.HP);
                System.out.println(pokemon.name + " " + pokemon.HP);
                
                Thread.sleep(500);

            } else if (nrRandom == 2 && pokemon.cooldownTime == 0) { // abilitate 2

                System.out.println(pokemon.name + " abilitate 2 / " + neutrel.name + " atac normal" + pokemon.cooldownTime);

                pokemon.abilitate2(neutrel);
                neutrel.attack(pokemon);
                
                System.out.println(neutrel.name + " " + neutrel.HP);
                System.out.println(pokemon.name + " " + pokemon.HP);
                
                Thread.sleep(500);
            }
        }

        if(pokemon.HP <= 0) { // Pokemon pierde 

            // Regeneram vietile pokemonilor
            neutrel.setHP(regenNeutrel);
            pokemon.setHP(regenPokemon);

            System.out.println(antrenor.numeAntrenor + " (" + 
            pokemon.name + ") pierde lupta.");
        }
        else if(pokemon.HP <= 0 && neutrel.HP <= 0) {  // Egalitate

            neutrel.setHP(regenNeutrel);
            pokemon.setHP(regenPokemon);

            System.out.println("Egalitate");
        }
        else { // Pokemon castiga
            System.out.println(antrenor.numeAntrenor + " (" + 
            pokemon.name + ") castiga lupta.");

            neutrel.setHP(regenNeutrel);
            pokemon.setHP(regenPokemon);

            //Actualizam atributele
            pokemon.HP++;
            pokemon.normalAttack++;
            pokemon.specialAttack++;
            pokemon.defense++;
            pokemon.specialDefense++;

            System.out.println("Atribute " + pokemon.name + " :HP " + pokemon.HP + " Normal Attack " + 
            pokemon.normalAttack + " Special Attack " + pokemon.specialAttack + " Defense " + pokemon.defense +
            " Special Defense " + pokemon.specialDefense);
        }

        Thread.sleep(1000);
    }

    static void duelAntrenori(Antrenor antrenor1, Antrenor antrenor2, Pokemon pokemon1, Pokemon pokemon2) throws InterruptedException {

        // Retinem viata initial
        double regenPokemon1 = pokemon1.HP;
        double regenPokemon2 = pokemon2.HP;

        // Folosim itemele
        pokemon1.useItems();
        pokemon2.useItems();

        while(pokemon1.HP > 0 && pokemon2.HP > 0) {
            int nrRandom = random.nextInt(3);

            if(nrRandom == 0) { // atac normal

                switch(Arena.alegeAtac(pokemon2)) {
                    case 0:
                    System.out.println(pokemon1.name + " atac normal / " + pokemon2.name + " atac normal");
                    pokemon1.attack(pokemon2);
                    pokemon2.attack(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 1:
                    System.out.println(pokemon1.name + " atac normal / " + pokemon2.name + " abilitate1");
                    pokemon1.attack(pokemon2);
                    pokemon2.abilitate1(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 2:
                    System.out.println(pokemon1.name + " atac normal / " + pokemon2.name + " abilitate2");
                    pokemon1.attack(pokemon2);
                    pokemon2.abilitate2(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                }


            } else if (nrRandom == 1 && pokemon1.cooldownTime == 0) { // abilitate 1

                switch(Arena.alegeAtac(pokemon2)) {
                    case 0:
                    System.out.println(pokemon1.name + " abilitate1 / " + pokemon2.name + " atac normal");
                    pokemon1.abilitate1(pokemon2);
                    pokemon2.attack(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 1:
                    System.out.println(pokemon1.name + " abilitate1 / " + pokemon2.name + " abilitate1");
                    pokemon1.abilitate1(pokemon2);
                    pokemon2.abilitate1(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 2:
                    System.out.println(pokemon1.name + " abilitate1 / " + pokemon2.name + " abilitate2");
                    pokemon1.abilitate1(pokemon2);
                    pokemon2.abilitate2(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                }

            } else if (nrRandom == 2 && pokemon1.cooldownTime == 0) { // abilitate 2

                switch(Arena.alegeAtac(pokemon2)) {
                    case 0:
                    System.out.println(pokemon1.name + " abilitate2 / " + pokemon2.name + " atac normal");
                    pokemon1.abilitate2(pokemon2);
                    pokemon2.attack(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 1:
                    System.out.println(pokemon1.name + " abilitate2 / " + pokemon2.name + " abilitate1");
                    pokemon1.abilitate2(pokemon2);
                    pokemon2.abilitate1(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                    case 2:
                    System.out.println(pokemon1.name + " abilitate2 / " + pokemon2.name + " abilitate2");
                    pokemon1.abilitate2(pokemon2);
                    pokemon2.abilitate2(pokemon1);
                    System.out.println(pokemon1.name + " " + pokemon1.HP);
                    System.out.println(pokemon2.name + " " + pokemon2.HP);
                    Thread.sleep(500);
                    break;
                }
            }
        }
        
    

        if(pokemon1.HP <= 0) { // Pokemonul1 pierde 

            // Regeneram vietile pokemonilor
            pokemon1.setHP(regenPokemon1);
            pokemon2.setHP(regenPokemon2);

            //Actualizam atributele
            pokemon2.HP++;
            pokemon2.normalAttack++;
            pokemon2.specialAttack++;
            pokemon2.defense++;
            pokemon2.specialDefense++;

            System.out.println(antrenor2.numeAntrenor + " (" + 
            pokemon2.name + ") castiga lupta.");
        }
        else if(pokemon1.HP <= 0 && pokemon2.HP <= 0) {  // Egalitate

            pokemon1.setHP(regenPokemon1);
            pokemon2.setHP(regenPokemon2);

            System.out.println("Egalitate");
        }
        else { // Pokemonul2 pierde
            System.out.println(antrenor1.numeAntrenor + " (" + 
            pokemon1.name + ") castiga lupta.");

            pokemon1.setHP(regenPokemon1);
            pokemon2.setHP(regenPokemon2);

            //Actualizam atributele
            pokemon1.HP++;
            pokemon1.normalAttack++;
            pokemon1.specialAttack++;
            pokemon1.defense++;
            pokemon1.specialDefense++;

            System.out.println("Atribute " + pokemon1.name + " :HP " + pokemon1.HP + " Normal Attack " + 
            pokemon1.normalAttack + " Special Attack " + pokemon1.specialAttack + " Defense " + pokemon1.defense +
            " Special Defense " + pokemon1.specialDefense);
        }

        Thread.sleep(1000);
    }

    static int alegeAtac(Pokemon pokemon) {
        int nrRandom = random.nextInt(3);

        if(nrRandom == 1 && pokemon.cooldownTime == 0)
        return 1;
        else if (nrRandom == 2 && pokemon.cooldownTime == 0)
        return 2;
        else 
        return 0;
    }
}
