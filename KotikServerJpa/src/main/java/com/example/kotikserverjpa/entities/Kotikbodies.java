package com.example.kotikserverjpa.entities;


import javax.persistence.*;

@Entity
@Table(name = "kotikbodies")

public class Kotikbodies {
    @Column(name = "id_general")
    private Integer id_general;
    @Column(name = "id_friend")
    private Integer id_friend;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Kotikbodies(Kotik mainKotik, Kotik friendKotik){
        this.id_general = mainKotik.getId();
        this.id_friend = mainKotik.getId();

    }

    public Kotikbodies() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getId_general() {
        return id_general;
    }

    public void setId_general(Integer id_general) {
        this.id_general = id_general;
    }

    public Integer getId_friend() {
        return id_friend;
    }

    public void setId_friend(Integer id_friend) {
        this.id_friend = id_friend;
    }
}
