package com.microservices.springsecurityjpa.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int use_id;
    @Column(name="use_username", nullable=false)
    @NotEmpty()
    private String userName;
    @Column(nullable=false)
    @NotEmpty()
    @Size(min=4)
    private String use_password;
    @Column(nullable=false)
    @NotEmpty()
    private boolean use_active;
    @ManyToMany(cascade=CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns={@JoinColumn(name="uro_use_id", referencedColumnName="use_id")},
            inverseJoinColumns={@JoinColumn(name="uro_rol_id", referencedColumnName="rol_id")})
    private List<Rol> roles;

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUse_password() {
        return use_password;
    }

    public void setUse_password(String use_password) {
        this.use_password = use_password;
    }

    public boolean isUse_active() {
        return use_active;
    }

    public void setUse_active(boolean use_active) {
        this.use_active = use_active;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
