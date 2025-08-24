package com.app.dslist.service;

import com.app.dslist.dto.GameDTO;
import com.app.dslist.dto.GameMinDTO;
import com.app.dslist.entities.Game;
import com.app.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get(); // TO-DO futuro: tratar quando nao existir
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(entity -> new GameMinDTO(entity)).toList();
//        List<GameMinDTO> dtoList = new ArrayList<>(result.stream().map(GameMinDTO::new).toList());
//        dtoList.sort(Comparator.comparing(GameMinDTO::getYear).thenComparing(GameMinDTO::getTitle));
    }
}
