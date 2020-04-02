package com.example.demo.Model;

import javax.persistence.*;


@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String date;
    private String title;
    //we need to change the way H2 handles our body field. We can do this using annotations. Above body add the
    // following annotations: @Column(name = "body", columnDefinition="TEXT"). Here, we're defining a custom name for
    // our SQL column and defining it. We want to use "TEXT" because the "TEXT" definition has an indefinite limit for
    // an amount of characters. This is perfect for our blog!
    @Column(name = "body",columnDefinition="TEXT")
    private String body;


    public Post(String date, String title, String body) {
        this.date = date;
        this.title = title;
        this.body = body;
    }
    public Post() {
    }


    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }




}
