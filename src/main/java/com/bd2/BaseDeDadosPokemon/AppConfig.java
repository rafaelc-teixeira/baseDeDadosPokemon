package com.bd2.BaseDeDadosPokemon;

import com.bd2.BaseDeDadosPokemon.model.PokemonDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class AppConfig {

    //Creating Connection with Redis
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    //Creating RedisTemplate for Entity 'Pokémon'
    @Bean
    public RedisTemplate<String, PokemonDTO> redisTemplate(){
        RedisTemplate<String, PokemonDTO> pokemonTemplate = new RedisTemplate<>();
        pokemonTemplate.setConnectionFactory(redisConnectionFactory());
        return pokemonTemplate;
    }
}