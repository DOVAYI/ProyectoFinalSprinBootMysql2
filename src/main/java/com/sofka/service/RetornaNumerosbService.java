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

            numerosb = new Numerosb();
            numerosb.setNumeros(number);
            numerosb.setBingo(bingo);
            numerosbdao.save(numerosb);

        }

    }
    @Transactional(readOnly = true)
    public List<Numerosb> loadNumberBingo() {
        List<Numerosb> numerosb = null;
        try {
            idBing = idBingo();
            numerosb = numerosbdao.numberRandomBingo(idBing);
        } catch (Exception e) {

        }

        return numerosb;
    }
    @Transactional(readOnly = true)
    private Integer idBingo() {
        Integer idbingo = 0;
        try {
            idbingo = bingodao.getIdBingo("iniciado");
        } catch (Exception e) {

        }

        return idbingo;
    }

    @Transactional(readOnly = true)
    public String getEstado2() {

        String status = null;
        status = bingodao.getEstadoJuego("iniciado","");

        if (status == null) {
            status = bingodao.getEstadoJuego("","finalizado");
            if(status==null){
                status = "vacio";
            }


        }

        return status;

    }
}
