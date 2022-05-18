package com.sofka.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "bingo")
public class Bingo implements Serializable {

    private static final long serialVersionUID = 1L;

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idb", nullable = false,length = 200)
    private Integer idb;

    @Column(name = "estado")
    private String estado;

    @Column(name = "ganador")
    private String ganador;

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Numerosb.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "bingo"
    )
    @JsonManagedReference
    private List<Numerosb> numerosb = new ArrayList<>();

    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Jugador.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "bingo"
    )
    @JsonManagedReference
    private List<Jugador> jugador = new ArrayList<>();
}
