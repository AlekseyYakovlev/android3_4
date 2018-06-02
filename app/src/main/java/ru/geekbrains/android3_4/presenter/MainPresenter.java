package ru.geekbrains.android3_4.presenter;

import android.annotation.SuppressLint;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import ru.geekbrains.android3_4.model.entity.Repo;
import ru.geekbrains.android3_4.model.repo.UsersRepo;
import ru.geekbrains.android3_4.view.MainView;
import timber.log.Timber;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    Scheduler mainThreadShceduler;
    UsersRepo usersRepo;

    public MainPresenter(Scheduler mainThreadScheduler) {
        this.mainThreadShceduler = mainThreadScheduler;
        usersRepo = new UsersRepo();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadData();
    }

    @SuppressLint("CheckResult")
    private void loadData() {
        usersRepo.getUser("AlekseyYakovlev")
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadShceduler)
                .subscribe(user -> {

                    //TODO: получить и отобразить список репозиториев пользователя

                    getViewState().setUsernameText(user.getName());
                    getViewState().loadImage(user.getAvatarUrl());
                    // getViewState().loadRepo(user.getGists());
                }, throwable -> {
                    Timber.e(throwable, "Failed to get user");
                });

        usersRepo.getRepo("AlekseyYakovlev")
                .subscribeOn(Schedulers.io())
                .observeOn(mainThreadShceduler)
                .subscribe(repos -> {

                    //TODO: получить и отобразить список репозиториев пользователя
                    //String name = repo.getName();
                    for (Repo repo : repos) {
                        getViewState().updateRepoTextView(repo.getName());
                    }

                    //Timber.d(name);

                }, throwable -> Timber.e(throwable, "Failed to get repo"));
    }

    private void getDataViaOkHttp() {
        Single<String> single = Single.fromCallable(() -> {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/users/AntonZarytski")
                    .build();
            return client.newCall(request).execute().body().string();
        });

        single.subscribeOn(Schedulers.io())
                .observeOn(mainThreadShceduler)
                .subscribe(s -> Timber.d(s));

    }
}
