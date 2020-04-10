package com.example.demo.Model;

import javax.persistence.*;


@Entity
@Table(name="fruitposts")
public class FruitPost {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private int id;
private String date;
private String title;
private String body;

   public int getId(){
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

    public FruitPost() {
    }

    public FruitPost(String date, String title, String body) {
        this.date = date;
        this.title = title;
        this.body = body;
    }
}
