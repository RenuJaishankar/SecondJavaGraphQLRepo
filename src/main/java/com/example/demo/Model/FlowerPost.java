package com.example.demo.Model;


import javax.persistence.*;

@Entity
@Table(name="flowerposts")
public class FlowerPost {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name="imageUrl",columnDefinition = "TEXT")
private String imageUrl;
private String date;
private String title;
private String body;


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public FlowerPost(String date, String title, String body, String imageUrl) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
    }

    public FlowerPost() {
    }

    public int getId(){
        return id;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
