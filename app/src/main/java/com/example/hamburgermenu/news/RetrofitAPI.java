package com.example.hamburgermenu.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {
    @GET
    Call<NewsModal> getAllNews(@Url String url);

    @GET
    Call<NewsModal>getNewsByCategory(@Url String url);

    //A modal (also called a modal window or lightbox) is a web page element that displays in front of and
    // deactivates all other page content.
    // To return to the main content, the user must engage with the modal by completing an action or by closing it
}
