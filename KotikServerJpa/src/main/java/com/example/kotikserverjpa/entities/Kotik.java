package com.example.kotikserverjpa.entities;
import com.example.kotikserverjpa.enumClass.Breed;
import com.example.kotikserverjpa.enumClass.Color;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kotiki")
public class Kotik {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "breed")
//    @Enumerated(EnumType.STRING)
    private Breed breed;
    @Column(name = "color")
//    @Enumerated(EnumType.STRING)
    private Color color;
//    @Column(name = "owner")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "owner")
//    private Owner owner;

    public Kotik(String name, LocalDate birthday, Breed breed, Color color){
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
//        this.owner = owner;
        /*this.id = id;*/
    }

    public Kotik() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

//    public Owner getOwner() {
//        return owner;
//    }

//    public void setOwner(Owner owner) {
//        this.owner = owner;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
