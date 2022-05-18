package com.sofka.dao;

import com.sofka.domain.Bingo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface bingoDao extends CrudRepository<Bingo,Integer> {
    @Query("select b.estado from Bingo b  where b.estado=:estado ")
    public String getEstadoJuego(@Param("estado") String estado);

    @Query("select b.idb from Bingo b  where b.estado=:estado ")
    public Integer getIdBingo(@Param("estado") String estado);

    @Query("select b from Bingo b  where b.idb=:idb")
    public Bingo getBingo(@Param("idb") Integer idb);

    @Transactional
    @Modifying
    @Query("update Bingo b set b.estado=:newEstado where b.estado=:estado")
    public void updateStatus(@Param("newEstado") String newEstado,
                             @Param(value="estado") String estado);
}
