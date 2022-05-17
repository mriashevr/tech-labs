package com.example.kotikiadministrator.entities;
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
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Kotik> Kotiks;
//    @OneToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private Users user;


    public Owner(String name, LocalDate birthday ) {
        this.name = name;
        this.birthday = birthday;
        Kotiks = new ArrayList<Kotik>();
//        this.user = user;
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

    public List<Kotik> getKotiks() {
        return Kotiks;
    }

    public void setKotiks(List<Kotik> kotiks) {
        Kotiks = kotiks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//    public Users getUser() {
//        return user;
//    }
//
//    public void setUser(Users user) {
//        this.user = user;
//    }
}
