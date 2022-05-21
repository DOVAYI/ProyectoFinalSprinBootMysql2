package com.sofka.dao;

import com.sofka.domain.Jugador;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface jugadorDao extends CrudRepository<Jugador,String> {
    //select jugador.idj from jugador INNER JOIN bingo ON jugador.idb=bingo.idb WHERE bingo.estado='iniciado';
    @Query("select j.idj from Jugador j INNER JOIN Bingo b ON j.bingo.idb=b.idb " +
            "WHERE b.estado=:status or b.estado=:status2")
    public List<String> getIdPlayer(@Param(value="status") String status,
                                    @Param(value="status2") String status2);
}
