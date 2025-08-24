package com.app.dslist.service;

import com.app.dslist.dto.GameDTO;
import com.app.dslist.dto.GameListDTO;
import com.app.dslist.dto.GameMinDTO;
import com.app.dslist.entities.Game;
import com.app.dslist.entities.GameList;
import com.app.dslist.repositories.GameListRepository;
import com.app.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(entity -> new GameListDTO(entity)).toList();
    }
}
