package diploma.gyumri.theatre.view.presenter.listeners;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubePlayer;
import com.squareup.picasso.Picasso;

import diploma.gyumri.theatre.model.Event;

/**
 * Created by Hayk on 29.07.2017.
 */

public class YouTubePlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {
    private Context context;
    private Event event;
    private ImageView imageView;
    private FrameLayout frameLayout;

    public YouTubePlayerStateChangeListener(Context context, Event event, ImageView imageView, FrameLayout frameLayout) {
        this.context = context;
        this.event = event;
        this.imageView = imageView;
        this.frameLayout = frameLayout;
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onLoaded(String s) {

    }

    @Override
    public void onAdStarted() {

    }

    @Override
    public void onVideoStarted() {

    }

    @Override
    public void onVideoEnded() {

    }

    @Override
    public void onError(YouTubePlayer.ErrorReason errorReason) {
        frameLayout.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        Picasso.with(context).load(event.getImgUrl()).into(imageView);
    }
}
