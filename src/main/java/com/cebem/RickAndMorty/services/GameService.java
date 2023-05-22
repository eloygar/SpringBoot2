package com.cebem.RickAndMorty.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.RickAndMorty.models.GameModel;
import com.cebem.RickAndMorty.repositories.GameRepository;

@Service
public class GameService {
    @Autowired
    GameRepository GameRepository;

    public ArrayList<GameModel> getAllGames() {
        return (ArrayList<GameModel>) GameRepository.findAll();

    }

    public GameModel CreateGames(GameModel game) {
        return GameRepository.save(game);
    }

    public boolean deleteGames(long id) {
        try {
            GameRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
    
}
