package com.app.dslist.service;

import com.app.dslist.dto.GameDTO;
import com.app.dslist.entities.Game;
import com.app.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameDTO> dtoList = result.stream().map(entity -> new GameDTO(entity)).toList();
//        List<GameDTO> dtoList = new ArrayList<>(result.stream().map(GameDTO::new).toList());
//        dtoList.sort(Comparator.comparing(GameDTO::getYear).thenComparing(GameDTO::getTitle));
        return dtoList;
    }
}
