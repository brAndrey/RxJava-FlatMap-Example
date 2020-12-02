package com.example.rxjava_flatmap_example.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


//http://developer.alexanderklimov.ru/android/theory/parcelable.php

// implements Parcelable - нужен для передачи экземпляра класса через
// intent.putExtra(Constants.POST,post);

public class Post implements Parcelable {
    @SerializedName("userId")
    @Expose()
    private int userId;

    @SerializedName("id")
    @Expose()
    private int id;

    @SerializedName("title")
    @Expose()
    private String title;

    @SerializedName("body")
    @Expose()
    private String body;

    private List<Comment> comments;

    public Post(int userId, int id, String title, String body, List<Comment> comments) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.comments = comments;
    }

    protected Post(Parcel in) {
        // implements Parcelable
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {

        // implements Parcelable

        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
    @Override
    // implements Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        // implements Parcelable
        parcel.writeInt(userId);
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(body);
    }
}
