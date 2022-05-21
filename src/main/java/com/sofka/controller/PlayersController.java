package com.sofka.controller;


import com.sofka.models.PlayersModel;
import com.sofka.service.ReturnPlayersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class PlayersController {

    @Autowired
    private ReturnPlayersService playersService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/players")
    public List<PlayersModel> loadPlayers() {
        List<PlayersModel> todoDataPlayers = null;
        todoDataPlayers = playersService.showDataPlayers();

        return todoDataPlayers;
    }

}
