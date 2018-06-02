package ru.geekbrains.android3_4.model.entity;

import com.google.gson.annotations.Expose;



public class User {
    @Expose
    String avatarUrl;
    @Expose
    String login;
    @Expose
    String name;



    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }



}
