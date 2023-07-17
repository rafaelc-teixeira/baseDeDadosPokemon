package com.bd2.BaseDeDadosPokemon.dao;

import com.bd2.BaseDeDadosPokemon.model.PokemonDTO;

import java.util.Map;

public interface IPokemonDao {

    void savePokemon(PokemonDTO pokemon);
    PokemonDTO getOnePokemon(String name);
    void updatePokemon(PokemonDTO pokemon);
    Map<String, PokemonDTO> getAllPokemon();
    void deletePokemon(String name);
    void saveAllPokemon(Map<String, PokemonDTO> pokemonMap);

}
