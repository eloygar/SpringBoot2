package com.cebem.RickAndMorty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.cebem.RickAndMorty.models.RespuestaJson;
import com.cebem.RickAndMorty.utils.Utils;

public class RickAndMortyService {

    @Autowired
    RestTemplate restTemplate;
    
    public RespuestaJson getCharacterRandom(){
        final int TOTAL_CHARACTERS = 826;
        int random = Utils.getRandomValue(825) + 1;
        String url = "https://rickandmortyapi.com/api/character/" + random;
    
        RespuestaJson respuestaJson=restTemplate.getForObject(url,RespuestaJson.class);
        return respuestaJson;

    }
}

