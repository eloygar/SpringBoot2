package com.cebem.RickAndMorty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cebem.RickAndMorty.models.CharacterModel;
import com.cebem.RickAndMorty.utils.Utils;

@Service
public class RickAndMortyService {

    @Autowired
    RestTemplate restTemplate;

    public CharacterModel getCharacterRandom() {
        final int TOTAL_CHARACTERS = 826;
        int random = Utils.getRandomValue(825) + 1;
        String url = "https://rickandmortyapi.com/api/character/" + random;

     CharacterModel datos = restTemplate.getForObject(url, CharacterModel.class);
        return datos;

    }
}
