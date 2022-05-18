package com.sofka.dao;

import com.sofka.domain.Numerosj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface numerosjDao extends CrudRepository<Numerosj,Integer> {
    @Query(value="select n from Numerosj n where n.jugador.idj=:idj")
    public List<Numerosj> numerosRandomJugador(@Param("idj")String idj);



}
