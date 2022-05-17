package com.example.kotikiadministrator.entities;

import com.example.kotikiadministrator.wrapper.UserWrapper;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    //    @Column(name = "owner")
    @OneToOne
    @JoinColumn(name = "owner")
    private Owner owner;


    public Users(String login, String password, Role role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Users() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public UserWrapper UserWrapper() {
        return new UserWrapper(id,login,password,role.toString(), owner.toString());
    }

}
