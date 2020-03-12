package com.microservices.springsecurityjpa.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rol_id;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String rol_name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
