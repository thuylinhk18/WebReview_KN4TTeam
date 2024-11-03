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

    private int postId;
    private boolean isFavorite;
    private int userId;
    private String postTitle;
    private String postContent;
    private String postImg;
    private String author;
    private String tempContent;

    public PostModel() {
    }

    public PostModel(int postId, int userId, String postTitle, String postContent, String postImg) {
        this.postId = postId;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImg = postImg;
    }

    public PostModel(int postId, boolean isFavorite, int userId, String postTitle, String postContent, String postImg) {
        this.postId = postId;
        this.isFavorite = isFavorite;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImg = postImg;
    }

    public PostModel(int postId, boolean isFavorite, int userId, String postTitle, String postContent, String postImg, String author) {
        this.postId = postId;
        this.isFavorite = isFavorite;
        this.userId = userId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.postImg = postImg;
        this.author = author;
    }

    public String getTempContent() {
        return this.postContent != null && this.postContent.length() > 30? this.postContent.substring(0,30)+"...":this.postContent+"...";
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    @Override
    public String toString() {
        return "PostModel{" + "postId=" + postId + ", isFavorite=" + isFavorite + ", userId=" + userId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postImg=" + postImg + '}';
    }

    

   

}
