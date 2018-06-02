package ru.geekbrains.android3_4.model.entity;

import com.google.gson.annotations.Expose;

import java.util.List;


public class Repo {
    @Expose
    String avatarUrl;
    @Expose
    String name;



    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getName() {
        return name;
    }




}
