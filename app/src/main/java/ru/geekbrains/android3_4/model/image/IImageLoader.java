package ru.geekbrains.android3_4.model.image;

public interface IImageLoader<T>
{
    void loadInto(String url, T container);
}
