package com.sofka.service;


import com.sofka.dao.bingoDao;
import com.sofka.dao.jugadorDao;
import com.sofka.dao.numerosjDao;
import com.sofka.domain.Bingo;
import com.sofka.domain.Jugador;
import com.sofka.domain.Numerosj;
import com.sofka.utility.GenerarNumerosAleatorios;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


@Slf4j
@Service
public class BingoService {

    @Autowired
    private bingoDao bingodao;
    @Autowired
    private jugadorDao jugadordao;

    @Autowired
    private numerosjDao numerosjdao;

    @Autowired
    private RetornaNumerosbService retornaNumerosbService;

    private Timer timer;

    private Timer timerNumberBingo;
    private Integer contador = 0;

    private Integer randomNum;

    private ArrayList<Integer> array = new ArrayList<>();




    @Transactional
    public Bingo crearBingo(String idJugador) {
        Bingo bingo = new Bingo();
        Bingo bingo2;
        bingo.setEstado("pendiente");
        bingo.setGanador("nn");
        bingo2 = bingodao.save(bingo);


        if (bingo2.getIdb() > 0 && bingo2.getIdb() != null) {
            crearJugador(idJugador, bingo2);
        }

        return bingo2;

    }



    @Transactional
    public Jugador crearJugador2(String idJugador) {
        Integer matrizNumerosJugador[][] = new Integer[5][5];
        GenerarNumerosAleatorios numerosAleatorios =
                new GenerarNumerosAleatorios();
        Integer idBingo = getIdBingo();
        Jugador jugador3 = new Jugador();
        Bingo bingo3 = bingodao.getBingo(idBingo);
        jugador3.setIdj(idJugador);
        jugador3.setBingo(bingo3);

        Jugador jugadores = jugadordao.save(jugador3);
        if (!(jugadores.getIdj().equals(" ")) && jugadores.getIdj() != null) {
            matrizNumerosJugador = numerosAleatorios.cargarO();
            crearNUmerosJugador(jugador3, matrizNumerosJugador);
        }

        return jugador3;
    }

    private Integer getIdBingo() {
        Integer idbingo = 0;
        idbingo = bingodao.getIdBingo("pendiente");

        return idbingo;
    }

    public Integer getIdBingoStatusIniciado() {
        Integer idBingo = 0;
        try {
            idBingo = bingodao.getIdBingo("iniciado");
        } catch (Exception e) {

        }
        return idBingo;
    }

    @Transactional
    public Jugador crearJugador(String idJugador, Bingo bingo) {
        GenerarNumerosAleatorios numerosAleatorios =
                new GenerarNumerosAleatorios();
        Integer matrizNumerosJugador[][] = new Integer[5][5];
        Jugador jugador2;
        Jugador jugador = new Jugador();
        jugador.setIdj(idJugador);
        jugador.setBingo(bingo);

        jugador2 = jugadordao.save(jugador);
        if (!(jugador2.getIdj().equals(" ")) && jugador2.getIdj() != null) {
            matrizNumerosJugador = numerosAleatorios.cargarO();
            crearNUmerosJugador(jugador2, matrizNumerosJugador);

        }
        updatStatus();


        return jugador2;
    }

    private void updatStatus() {
        timer = new Timer();
        timer.schedule(gameStartTimeout, 0, 60000);


    }

    TimerTask gameStartTimeout = new TimerTask() {
        @Override
        public void run() {
            contador++;

            if (contador == 3) {
                actualizarEstado();
                createNumberBingo();
                timer.cancel();

            }
        }
    };

    private void createNumberBingo() {
        timerNumberBingo = new Timer();
        timerNumberBingo.schedule(createNumberRandomBingo, 0, 15000);
        log.info("Bingo service metodo createNumberBingo");
    }

    TimerTask createNumberRandomBingo = new TimerTask() {
        @Override
        public void run() {
            log.info("Bingo service tarea createNumberRandom 1");
            String status = bingodao.getEstadoJuego("","iniciado");
            if (status.equals("iniciado")) {
                randomNum = (int) Math.floor((Math.random() * (75 - 1 + 1)) + 1);
                if (array.size() < 1) {
                    array.add(randomNum);
                    retornaNumerosbService.createNumberBingo(randomNum);
                } else {
                    while ((array.indexOf(randomNum) != -1)) {
                        randomNum = (int) Math.floor((Math.random() * (75 - 1 + 1)) + 1);
                    }
                    if (randomNum > 0) {
                        if ((array.indexOf(randomNum) == -1)) {
                            retornaNumerosbService.createNumberBingo(randomNum);
                            array.add(randomNum);


                        }
                    }
                }

            }else{
                timerNumberBingo.cancel();
            }
        }
    };

    public void actualizarEstado() {
        bingodao.updateStatus("iniciado", "pendiente");
    }

    public void updateStatusBingoFinal(String winner) {
        bingodao.updateStatus2(winner, "finalizado", "iniciado");
    }

    @Transactional
    public void crearNUmerosJugador(Jugador jugador,
                                    Integer matrizNumeros[][]) {


        for (int i = 0; i < 5; i++) {
            Numerosj numerosj = new Numerosj();
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    numerosj.setB(matrizNumeros[i][j]);
                } else if (j == 1) {
                    numerosj.setI(matrizNumeros[i][j]);
                } else if (j == 2) {
                    numerosj.setN(matrizNumeros[i][j]);
                } else if (j == 3) {
                    numerosj.setG(matrizNumeros[i][j]);
                } else if (j == 4) {
                    numerosj.setO(matrizNumeros[i][j]);
                }
            }
            numerosj.setJugador(jugador);
            numerosjdao.save(numerosj);


        }


    }

    @Transactional(readOnly = true)
    public String getEstado() {
        String status = null;
        status = bingodao.getEstadoJuego("pendiente","iniciado");
        log.info("prueba" + status);
        if (status == null) {
            status = "vacio";

        }

        return status;

    }

    @Transactional
    public Bingo getDataBingo() {
        Bingo dataBingo = null;
        Integer idBingo=0;
        try {
            idBingo=bingodao.getIdBingo2("finalizado");
            log.info("este es el idBingo: "+idBingo);
            dataBingo = bingodao.getBingo(idBingo);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return dataBingo;
    }


}
