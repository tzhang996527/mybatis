package com.example.demomybatis.entity;

import java.io.Serializable;

public class Notification implements Serializable {
    private Integer id;

    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }
}