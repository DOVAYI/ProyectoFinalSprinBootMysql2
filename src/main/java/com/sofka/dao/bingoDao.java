package com.sofka.dao;

import com.sofka.domain.Bingo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface bingoDao extends CrudRepository<Bingo, Integer> {
    @Query("select b.estado from Bingo b  where b.estado=:estado or b.estado=:estado2 ")
    public String getEstadoJuego(@Param("estado") String estado,
                                 @Param("estado2") String estado2);

    @Query("select b.idb from Bingo b  where b.estado=:estado ")
    public Integer getIdBingo(@Param(value = "estado") String estado);

    @Query("select b from Bingo b  where b.idb=:idb")
    public Bingo getBingo(@Param(value = "idb") Integer idb);

    @Query("select max(b2.idb) from Bingo b2 where b2.estado=:estado")
    public Integer getIdBingo2(@Param(value = "estado") String estado);

    @Transactional
    @Modifying
    @Query("update Bingo b set b.estado=:newEstado where b.estado=:estado")
    public void updateStatus(@Param("newEstado") String newEstado,
                             @Param(value = "estado") String estado);


    @Transactional
    @Modifying
    @Query("update Bingo b set b.ganador=:winner,b.estado=:estado where b.estado=:estado2")
    public void updateStatus2(@Param("winner") String winner,
                              @Param("estado") String estado,
                              @Param(value = "estado2") String estado2);
}
