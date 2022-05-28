package com.sofka.service;

import com.sofka.dao.jugadorDao;
import com.sofka.models.PlayersModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ReturnPlayersService {
    @Autowired
    private jugadorDao jugadordao;

    private List<PlayersModel> todoPlayers = new ArrayList<>();

    private List<String> loadIdPlayers() {
        List<String> idPlayers = null;
        try {
            idPlayers = jugadordao.getIdPlayer("pendiente", "iniciado");
        } catch (Exception e) {
            log.info(e.getMessage());
        }


        return idPlayers;
    }

    public List<PlayersModel> showDataPlayers() {
        List<PlayersModel> dataUserMongo = loadDatasPlayers();
        List<String> idPlayersInSql = loadIdPlayers();
        for (int i = 0; i < idPlayersInSql.size(); i++) {
            int j = 0;
            while (j < dataUserMongo.size()) {
                if (idPlayersInSql.get(i).equals(dataUserMongo.get(j).get_id())) {
                    todoPlayers.add(dataUserMongo.get(j));
                    j = dataUserMongo.size() - 1;
                }
                j++;
            }
        }

        return todoPlayers;
    }

    private List<PlayersModel> loadDatasPlayers() {
        PlayersModel[] playersModel = null;

            RestTemplate restTemplate = new RestTemplate();
            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            restTemplate = restTemplateBuilder.build();

            playersModel = restTemplate.getForObject(
                    "http://localhost:4001/players", PlayersModel[].class);


            log.info("prueba1 " + playersModel[0].get_id());
            log.info("prueba2 " + playersModel[1].get_id());




        return Arrays.asList(playersModel);
    }
}
