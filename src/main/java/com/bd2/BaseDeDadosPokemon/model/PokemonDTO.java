package com.bd2.BaseDeDadosPokemon.model;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import lombok.Data;

import java.io.Serializable;

@Data
public class PokemonDTO implements Serializable {

    private int id;
    private int base_experience;
    private int height;
    private int order;
    private int weight;
    private String name;
    private String official_artwork;

    public PokemonDTO(Pokemon pokemon) {
        this.setId(pokemon.getId());
        this.setBase_experience(pokemon.getBaseExperience());
        this.setHeight(pokemon.getHeight());
        this.setOrder(pokemon.getOrder());
        this.setWeight(pokemon.getWeight());
        this.setName(pokemon.getName());
        this.setOfficial_artwork(pokemon.getSprites().getFrontDefault());
    }

    public PokemonDTO() {

    }



}
