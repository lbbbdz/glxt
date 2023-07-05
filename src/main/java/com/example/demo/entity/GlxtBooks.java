package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class GlxtBooks implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String serialnumber;

    private String bookname;

    private String bookprice;

    private String author;

    private String press;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookprice() {
        return bookprice;
    }

    public void setBookprice(String bookprice) {
        this.bookprice = bookprice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Override
    public String toString() {
        return "Glxt_Books{" +
                "id='" + id + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookprice='" + bookprice + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }
}
