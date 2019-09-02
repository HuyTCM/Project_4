package com.huytcm.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    private String username;
    private String password;
    private List<Post> posts;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public boolean checkLogin(String username, String password) {
        return username.equals(this.username) && password.equals(this.password);
    }

    @Override
    public String toString() {
        return this.username;
    }
}
