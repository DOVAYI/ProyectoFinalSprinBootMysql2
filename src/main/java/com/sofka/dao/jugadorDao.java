package com.sofka.dao;

import com.sofka.domain.Jugador;
import org.springframework.data.repository.CrudRepository;

public interface jugadorDao extends CrudRepository<Jugador,String> {
}
