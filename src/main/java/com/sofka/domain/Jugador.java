package com.sofka.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "jugador")
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;


    //(strategy = GenerationType.IDENTITY) esto es solo para campos autoincremento
    @Id
    @Column(name = "idj", nullable = false,length = 200)
    private String idj;



    @OneToMany(
            fetch = FetchType.LAZY,
            targetEntity = Numerosj.class,
            cascade = CascadeType.REMOVE,
            mappedBy = "jugador"
    )
    @JsonManagedReference
    private List<Numerosj> numerosj = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Bingo.class, optional = false)
    @JoinColumn(name = "idb")
    @JsonBackReference
    private Bingo bingo;

}
