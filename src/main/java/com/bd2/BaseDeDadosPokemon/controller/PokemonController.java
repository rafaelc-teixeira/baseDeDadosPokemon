package com.bd2.BaseDeDadosPokemon.controller;

import com.bd2.BaseDeDadosPokemon.model.PokemonDTO;
import com.bd2.BaseDeDadosPokemon.repository.PokemonRepository;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.utils.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping("/createDatabase")
    public String createDatabase() {
        int totalPokemon = 10000;
        // Fetch the list of Pokémon names asynchronously
        CompletableFuture<NamedAPIResourceList> listFuture = CompletableFuture.supplyAsync(() ->
                Client.getPokemonList(totalPokemon, 0));

        // Wait for the list of Pokémon names to complete
        NamedAPIResourceList list = listFuture.join();

        // Fetch the Pokémon data in batches asynchronously
        List<CompletableFuture<PokemonDTO>> pokemonFutures = list.getResults().stream()
                .map(nar -> CompletableFuture.supplyAsync(() ->
                        new PokemonDTO(Client.getPokemonByName(nar.getName()))
                ))
                .collect(Collectors.toList());

        // Wait for all the Pokémon data to complete
        List<PokemonDTO> pokemonList = pokemonFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        for (PokemonDTO pokemon : pokemonList) {
            pokemonRepository.savePokemon(pokemon);
        }
        return "Pokemon database created!";
    }

    @GetMapping("/{name}")
    public PokemonDTO getPokemonByName(@PathVariable String name) {
        return pokemonRepository.getOnePokemon(name);
    }

    @GetMapping("/getAll")
    public Map<String, PokemonDTO> getAllPokemon() {
        return pokemonRepository.getAllPokemon();
    }

    @PutMapping("/")
    public PokemonDTO updatePokemon(@RequestBody PokemonDTO pokemonDTO) {
        pokemonRepository.updatePokemon(pokemonDTO);
        return pokemonRepository.getOnePokemon(pokemonDTO.getName());
    }

    @DeleteMapping("/")
    public void deletePokemon(@PathVariable String name) {
        pokemonRepository.deletePokemon(name);
    }
}