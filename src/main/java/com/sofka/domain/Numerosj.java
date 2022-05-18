package com.sofka.domain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Data
@Entity
@Table(name = "numerosj")

public class Numerosj implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnj", nullable = false)
    private Integer idnj;

    @Column(name = "b")
    private Integer b;

    @Column(name = "i")
    private Integer i;

    @Column(name = "n")
    private Integer n;

    @Column(name = "g")
    private Integer g;

    @Column(name = "o")
    private Integer o;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Jugador.class, optional = false)
    @JoinColumn(name = "idj", nullable = false)
    @JsonBackReference

    private Jugador jugador;


}
