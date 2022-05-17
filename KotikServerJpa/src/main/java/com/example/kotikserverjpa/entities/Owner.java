package com.example.kotikserverjpa.entities;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")

public class Owner {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private LocalDate birthday;
//    @OneToMany(mappedBy="owner", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Kotik> Kotiks;

    public Owner(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
//        Kotiks = new ArrayList<Kotik>();
    }

    public Owner() {
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

//    public List<Kotik> getKotiks() {
//        return Kotiks;
//    }

//    public void setKotiks(List<Kotik> kotiks) {
//        Kotiks = kotiks;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
