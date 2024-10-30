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
    private String postTitle;
    private String postContent;
    private Date createdAt;
    private String postImg;

    public PostModel() {
    }

    public PostModel(int postId, String postTitle, String postContent, Date createdAt, String postImg) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.createdAt = createdAt;
        this.postImg = postImg;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    @Override
    public String toString() {
        return "PostModel{" + "postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", createdAt=" + createdAt + ", postImg=" + postImg + '}';
    }

}
