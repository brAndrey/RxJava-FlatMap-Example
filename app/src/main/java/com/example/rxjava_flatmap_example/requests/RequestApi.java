package com.example.rxjava_flatmap_example.requests;

import com.example.rxjava_flatmap_example.models.Comment;
import com.example.rxjava_flatmap_example.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RequestApi {

    @GET("posts")
    Call<List<Post>> getData();

    @GET("posts")
    Observable<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComments(
            @Path("id") int id
    );


    @GET("posts/{id}")
    Observable<Post> getPost(
            @Path("id") int id
    );
}
