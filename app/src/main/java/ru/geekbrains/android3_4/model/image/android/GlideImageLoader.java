package ru.geekbrains.android3_4.model.image.android;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import ru.geekbrains.android3_4.model.image.IImageLoader;

public class GlideImageLoader implements IImageLoader<ImageView>
{
    @Override
    public void loadInto(String url, ImageView container)
    {
        GlideApp.with(container.getContext()).asBitmap().load(url).listener(new RequestListener<Bitmap>()
        {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource)
            {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource)
            {
                return false;
            }
        }).into(container);
    }
}
