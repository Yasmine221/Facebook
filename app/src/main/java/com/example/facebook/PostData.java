package com.example.facebook;

public class PostData {

    private int userImage;
    private int postImage;
    private String userName;
    private String postText;

    public PostData(int userImage, int postImage, String userName, String postText) {
        this.userImage = userImage;
        this.postImage = postImage;
        this.userName = userName;
        this.postText = postText;
    }

    public int getUserImage() {
        return userImage;
    }

    public int getPostImage() {
        return postImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostText() {
        return postText;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public void setPostImage(int postImage) {
        this.postImage = postImage;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}
