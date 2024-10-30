/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author bebet
 */
public class PostModel {
    private int post_id;
    private String title;
    private String post_content;
    private Date created_at;
    private String post_img;

    public PostModel() {
    }

    public PostModel(int post_id, String title, String post_content, Date created_at, String post_img) {
        this.post_id = post_id;
        this.title = title;
        this.post_content = post_content;
        this.created_at = created_at;
        this.post_img = post_img;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    @Override
    public String toString() {
        return "PostModel{" + "post_id=" + post_id + ", title=" + title + ", post_content=" + post_content + ", created_at=" + created_at + ", post_img=" + post_img + '}';
    }
    
    
           
}
