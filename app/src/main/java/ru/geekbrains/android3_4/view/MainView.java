package ru.geekbrains.android3_4.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

public interface MainView extends MvpView
{
    void setUsernameText(String username);
    void loadImage(String url);
    void updateRepoTextView(String repoName);
}
