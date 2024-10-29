/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bebet
 */
public class CommentModel {
    private int cmt_id;
    private int user_id;
    private int post_id;
    private String title;
    private String post_content;
    private String post_img;

    public CommentModel() {
    }

    public CommentModel(int cmt_id, int user_id, int post_id, String title, String post_content, String post_img) {
        this.cmt_id = cmt_id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.title = title;
        this.post_content = post_content;
        this.post_img = post_img;
    }

    public int getCmt_id() {
        return cmt_id;
    }

    public void setCmt_id(int cmt_id) {
        this.cmt_id = cmt_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    @Override
    public String toString() {
        return "CommentModel{" + "cmt_id=" + cmt_id + ", user_id=" + user_id + ", post_id=" + post_id + ", title=" + title + ", post_content=" + post_content + ", post_img=" + post_img + '}';
    }

    
}
