package com.example.kotikiadministrator.wrapper;//package com.example.kotikserverjpa.wrapper;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserWrapper {
    private Integer id;
    private String login;
    private String password;
    private String role;
    private String owner;

    public UserWrapper(Integer id, String login, String password, String role, String owner) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.owner = owner;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
