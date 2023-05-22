package com.cebem.RickAndMorty.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cebem.RickAndMorty.models.MemeModel;
import com.cebem.RickAndMorty.repositories.MemeRepository;

@Service
public class MemesServices {
    @Autowired
    MemeRepository memeRepository;

    public ArrayList<MemeModel> getAllMemes() {
        return (ArrayList<MemeModel>) memeRepository.findAll();

    }

    public MemeModel CreateMeme(MemeModel meme) {
        return memeRepository.save(meme);
    }

    public boolean deleteMeme(long id) {
        try {
            memeRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    
}
