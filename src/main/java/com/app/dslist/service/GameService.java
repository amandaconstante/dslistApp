package com.app.dslist.service;

import com.app.dslist.dto.GameDTO;
import com.app.dslist.entities.Game;
import com.app.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll() {
        var result = gameRepository.findAll();
        List<GameDTO> dto = result.stream().map(entity -> new GameDTO(entity)).toList();
        return dto;
    }
}
