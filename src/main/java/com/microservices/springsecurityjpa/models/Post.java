package com.microservices.springsecurityjpa.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pos_id;

    @Column(nullable = false)
    @NotEmpty
    private String pos_title;

    @Column(nullable = false)
    @NotEmpty
    private String pos_text;

    @Column(nullable = false)
    @NotEmpty
    @Temporal(TemporalType.DATE)
    private Date pos_date;

    @ManyToOne
    private User user;

    public Post(int pos_id, @NotEmpty String pos_title, @NotEmpty String pos_text, @NotEmpty Date pos_date, User user) {
        this.pos_id = pos_id;
        this.pos_title = pos_title;
        this.pos_text = pos_text;
        this.pos_date = pos_date;
        this.user = user;
    }

    public Post() {
    }

    public int getPos_id() {
        return pos_id;
    }

    public void setPos_id(int pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_title() {
        return pos_title;
    }

    public void setPos_title(String pos_title) {
        this.pos_title = pos_title;
    }

    public String getPos_text() {
        return pos_text;
    }

    public void setPos_text(String pos_text) {
        this.pos_text = pos_text;
    }

    public Date getPos_date() {
        return pos_date;
    }

    public void setPos_date(Date pos_date) {
        this.pos_date = pos_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
