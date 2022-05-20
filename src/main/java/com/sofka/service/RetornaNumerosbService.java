package com.sofka.service;

import com.sofka.dao.bingoDao;
import com.sofka.dao.numerosbDao;
import com.sofka.domain.Bingo;
import com.sofka.domain.Numerosb;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class RetornaNumerosbService {
    @Autowired
    private bingoDao bingodao;

    @Autowired
    private numerosbDao numerosbdao;

    private Numerosb numerosb;

    private Integer idBing;

    public void createNumberBingo(Integer number) {
        idBing = idBingo();
        Bingo bingo = bingodao.getBingo(idBing);
        if (bingo.getIdb() > 0 && bingo.getIdb() != null) {
            log.info("metodo createNumberBingo service RetornaNumerosbService " );
            numerosb = new Numerosb();
            numerosb.setNumeros(number);
            numerosb.setBingo(bingo);
            numerosbdao.save(numerosb);

        }

    }

    public List<Numerosb> loadNumberBingo(){
        idBing = idBingo();
        List<Numerosb> numerosb=null;
        numerosb=numerosbdao.numberRandomBingo(idBing);
        return numerosb;
    }

    private Integer idBingo() {
        Integer idbingo = 0;
        idbingo = bingodao.getIdBingo("iniciado");
        log.info("prueba numeros b service idbingo " + idbingo);

        return idbingo;
    }

    @Transactional(readOnly = true)
    public String getEstado2() {
        String status = null;
        status = bingodao.getEstadoJuego("iniciado");
        log.info("prueba numeros b service " + status);
        if (status == null) {
            status = "vacio";

        }

        return status;

    }
}
