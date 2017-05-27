package com.example.sanourtomal.api;

/**
 * Created by Sanour Tomal on 4/7/2017.
 */

public class Model {
    private String id;
    private String updated_at,created_at;
    private String title,board,subject;

    public Model(String subject, String id, String updated_at,String created_at, String title, String board) {
        this.subject = subject;
        this.id = id;
        this.updated_at = updated_at;
        this.created_at = created_at;
        this.title = title;
        this.board = board;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
