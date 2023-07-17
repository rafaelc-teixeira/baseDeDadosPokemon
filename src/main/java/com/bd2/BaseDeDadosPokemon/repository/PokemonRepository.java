package com.bd2.BaseDeDadosPokemon.repository;

import com.bd2.BaseDeDadosPokemon.dao.IPokemonDao;
import com.bd2.BaseDeDadosPokemon.model.PokemonDTO;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PokemonRepository implements IPokemonDao {

    private final String hashReference = "Pokemon";

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, PokemonDTO> hashOperations;
    @Override
    public void savePokemon(PokemonDTO pokemon) {
        hashOperations.putIfAbsent(hashReference, pokemon.getName(), pokemon);
    }

    @Override
    public PokemonDTO getOnePokemon(String name) {
        return hashOperations.get(hashReference, name);
    }

    @Override
    public void updatePokemon(PokemonDTO pokemon) {
        hashOperations.put(hashReference, pokemon.getName(), pokemon);
    }

    @Override
    public Map<String, PokemonDTO> getAllPokemon() {
        return hashOperations.entries(hashReference);
    }

    @Override
    public void deletePokemon(String name) {
        hashOperations.delete(hashReference, name);
    }

    @Override
    public void saveAllPokemon(Map<String, PokemonDTO> pokemonMap) {
        hashOperations.putAll(hashReference, pokemonMap);
    }


}
