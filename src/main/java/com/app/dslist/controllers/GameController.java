package com.app.dslist.controllers;

import com.app.dslist.dto.GameDTO;
import com.app.dslist.dto.GameMinDTO;
import com.app.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        var result = gameService.findAll();
        return result;
    }
}
