package com.sofka.dao;

import com.sofka.domain.Numerosb;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface numerosbDao extends CrudRepository<Numerosb,Integer> {
    @Query(value="select b from Numerosb b where b.bingo.idb=:idb")
    public List<Numerosb> numberRandomBingo(@Param("idb") Integer idb);
    //@Query(value="select n from Numerosj n where n.jugador.idj=:idj")
    //    public List<Numerosj> numerosRandomJugador(@Param("idj")String idj);
}
