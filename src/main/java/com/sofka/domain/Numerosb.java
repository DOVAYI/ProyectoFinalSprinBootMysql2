package com.sofka.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "numerosb")

public class Numerosb implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnb", nullable = false)
    private Integer idnb;

    @Column(name = "numeros")
    private Integer numeros;


    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bingo.class, optional = false)
    @JoinColumn(name = "idb", nullable = false)
    @JsonBackReference
    private Bingo bingo;
}
