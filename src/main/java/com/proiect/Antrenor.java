package com.proiect;

import java.util.ArrayList;
import java.util.List;

public class Antrenor {
    String numeAntrenor;
    String varsta;

    List<Pokemon> listaPokemoni = new ArrayList<Pokemon>();

    Pokemon pokemonFinal;

    Antrenor() {
    }

    void setNumeAntrenor(String numeAntrenor) {
        this.numeAntrenor = numeAntrenor;
    }

    void setVarsta(String varsta) {
        this.varsta = varsta;
    }

    void setListaPokemoni(ArrayList<Pokemon> listaPokemoni) {
        this.listaPokemoni = listaPokemoni;
    }

    void alegePokemon(String numePokemon) {
        for(Pokemon pokemon : listaPokemoni)
        if(pokemon.name.equals(numePokemon))
        pokemonFinal = pokemon;
    }

    void calculPokemon() {
        int sumaAtribute = 0;

        for(Pokemon pokemon : this.listaPokemoni) {
            int sumaCurenta = 0;
            
            sumaCurenta += pokemon.HP;
            sumaCurenta += pokemon.normalAttack;
            sumaCurenta += pokemon.specialAttack;
            sumaCurenta += pokemon.defense;
            sumaCurenta += pokemon.specialDefense;

            if(sumaCurenta > sumaAtribute) {
                sumaAtribute = sumaCurenta;
                this.pokemonFinal = pokemon;
            }
        }
    }

    @Override
    public String toString() {
        return this.numeAntrenor + " " + this.varsta + " " + listaPokemoni.toString();
    }
}
