package com.sofka.controller;

import com.sofka.domain.Jugador;
import com.sofka.domain.Numerosb;
import com.sofka.domain.Numerosj;
import com.sofka.service.BingoService;
import com.sofka.service.RetornaNumerosbService;
import com.sofka.service.RetornaNumerosjService;
import com.sofka.utility.Restructurar;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.sofka.domain.Bingo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BingoController {
    @Autowired
    private BingoService bingoService;

    @Autowired
    private RetornaNumerosjService retornanumeroService;

    @Autowired
    private RetornaNumerosbService retornaNumerosbService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/numerosbingo")
    public List<Numerosb> loadBingoNumber() {
        List<Numerosb> numberBingo = null;
        numberBingo = retornaNumerosbService.loadNumberBingo();

        return numberBingo;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/buscarjuego")
    public String getEstado() {
        String estado = bingoService.getEstado();
        log.info("prueba" + estado);

        return estado;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/buscarjuego2")
    public String getEstado2() {
        String estado = retornaNumerosbService.getEstado2();
        log.info("prueba 2 " + estado);

        return estado;
    }


    @Transactional(readOnly = true)
    public List<Numerosj> cargarNUmerosJugador(String idjugador) {
        return retornanumeroService.getListNumerosJugador(idjugador);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/crearbingo")
    public List<Numerosj> create(@RequestBody String idJugador) {
        List<Numerosj> numerosj = null;
        log.info("prueba" + idJugador);
        String newIdjugador = Restructurar.restructurar(idJugador);
        log.info("prueba2" + newIdjugador);
        Bingo bingo = bingoService.crearBingo(newIdjugador);
        if (bingo.getIdb() > 0 && bingo.getIdb() != null) {
            numerosj = cargarNUmerosJugador(newIdjugador);
        }
        return numerosj;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/crearjugador")
    public List<Numerosj> createGamers(@RequestBody String idJugador) {
        List<Numerosj> numerosj = null;
        log.info("prueba" + idJugador);
        String newIdjugador = Restructurar.restructurar(idJugador);
        log.info("prueba2" + newIdjugador);
        Jugador jugad = bingoService.crearJugador2(newIdjugador);
        if (!(jugad.getIdj().equals(" ")) && jugad.getIdj() != null) {
            numerosj = cargarNUmerosJugador(newIdjugador);
        }
        return numerosj;
    }


}
