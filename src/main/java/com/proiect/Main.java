package com.proiect;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Main 
{
    public static void main( String[] args ) throws InterruptedException
    {
        
        Gson gson = new Gson();
        Random random = new Random();
        List<Pokemon> pokemoni = new ArrayList<Pokemon>();

        // Initializare
        try {
            FileReader input1 = new FileReader("resources/Pokemoni.json");
        
            Type lista = new TypeToken<ArrayList<Pokemon>>(){}.getType();
            pokemoni = gson.fromJson(input1, lista); 

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initializam cei doi inamici boti
        Pokemon neutrel1 = pokemoni.get(0);
        Pokemon neutrel2 = pokemoni.get(1);

        File folder = new File("tests/");
        String[] listafisiere = folder.list();

        //Parcurgem folderul cu fisiere de test
        for(String numefisier : listafisiere) {
            
        // Cautam doar fisierele cu formatul .json
        if(numefisier.endsWith(".json"))
        try (FileReader input = new FileReader("tests/" + numefisier);) {

            Antrenor antrenor[] = gson.fromJson(input, Antrenor[].class);

            int victoriiAntrenor1 = 0;
            int victoriiAntrenor2 = 0;

            System.out.println("Antrenorii " + antrenor[0].numeAntrenor
            + " si " + antrenor[1].numeAntrenor + " intra in arena.");

            for(int i=0; i<antrenor[0].listaPokemoni.size(); i++) {

                boolean esteBatalie = false;
                
                while(esteBatalie == false) {
                int nrRandom = random.nextInt(3);

                if(nrRandom == 0) { //Neutrel1

                    Arena.batalieNeutrel(antrenor[0], antrenor[0].listaPokemoni.get(i), neutrel1);
                    Arena.batalieNeutrel(antrenor[1], antrenor[1].listaPokemoni.get(i), neutrel1);

                } else if(nrRandom == 1) { //Neutrel2

                    Arena.batalieNeutrel(antrenor[0], antrenor[0].listaPokemoni.get(i), neutrel2);
                    Arena.batalieNeutrel(antrenor[1], antrenor[1].listaPokemoni.get(i), neutrel2);

                } else if (nrRandom == 2) { //Intre antrenori
                    esteBatalie = true;
                    System.out.println("Duel intre antrenori:");
                    Arena.duelAntrenori(antrenor[0], antrenor[1], 
                    antrenor[0].listaPokemoni.get(i), 
                    antrenor[1].listaPokemoni.get(i));
                }
                }
            }

            // Batalia finala
            // Alegem cel mai bun pokemon 
            antrenor[0].calculPokemon();
            antrenor[1].calculPokemon();

            System.out.println("Ultima batalie.");
            System.out.println("Cei mai buni pokemoni:");
            System.out.println(antrenor[0].pokemonFinal.name);
            System.out.println(antrenor[1].pokemonFinal.name);

            boolean esteBatalie = false;
            while(esteBatalie == false) {
                int nrRandom = random.nextInt(3);

                if(nrRandom == 0) { //Neutrel1

                    Arena.batalieNeutrel(antrenor[0], antrenor[0].pokemonFinal, neutrel1);
                    Arena.batalieNeutrel(antrenor[1], antrenor[1].pokemonFinal, neutrel1);

                } else if(nrRandom == 1) { //Neutrel2

                    Arena.batalieNeutrel(antrenor[0], antrenor[0].pokemonFinal, neutrel2);
                    Arena.batalieNeutrel(antrenor[1], antrenor[1].pokemonFinal, neutrel2);

                } else if (nrRandom == 2) { //Intre antrenori
                    esteBatalie = true;
                    System.out.println("Duel intre antrenori:");
                    Arena.duelAntrenori(antrenor[0], antrenor[1], 
                    antrenor[0].pokemonFinal, 
                    antrenor[1].pokemonFinal);
                }
            }

            // Calculam castigatorul
            if(victoriiAntrenor1 > victoriiAntrenor2)
            System.out.println(antrenor[0].numeAntrenor + " a castigat aventura!");
            else if(victoriiAntrenor1 < victoriiAntrenor2)
            System.out.println(antrenor[1].numeAntrenor + " a castigat aventura!");
            else
            System.out.println("Egalitate!");

        } catch (IOException e) {
            e.printStackTrace();
        }

        }

    }
}
