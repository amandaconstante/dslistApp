package com.app.dslist.controllers;

import com.app.dslist.dto.GameListDTO;
import com.app.dslist.service.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        var result = gameListService.findAll();
        return result;
    }
}
