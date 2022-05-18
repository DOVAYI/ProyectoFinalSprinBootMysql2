package com.sofka.service;

import com.sofka.dao.numerosjDao;
import com.sofka.domain.Numerosj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RetornaNumerosjService {
    @Autowired
    private numerosjDao numerosjdao;

    @Transactional(readOnly = true)
    public List<Numerosj> getListNumerosJugador(String idjugador) {

        return numerosjdao.numerosRandomJugador(idjugador);
    }
}
