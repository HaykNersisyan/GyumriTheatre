package diploma.gyumri.theatre.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.squareup.picasso.Picasso;

import diploma.gyumri.theatre.R;
import diploma.gyumri.theatre.model.Event;
import diploma.gyumri.theatre.view.activities.ExpandableTextView;
import diploma.gyumri.theatre.view.presenter.listeners.YouTubePlayerStateChangeListener;

public class EventFragment extends Fragment {
    private YouTubePlayer YPlayer;
    private Event mEvent;
    private static final String YoutubeDeveloperKey = "AIzaSyDjeZH1klcMNqIHs5PTrw55bNJj5HkMXF8";
    private YouTubePlayerSupportFragment youTubePlayerFragment;
    private FrameLayout playerContainer;
    private ImageView image;
    private boolean notVideo;

    public EventFragment(Event event) {
        mEvent = event;
        this.notVideo = event.getVideoUrl() == null;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String yourText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Ut volutpat interdum interdum. Nulla laoreet lacus diam, vitae " +
                "sodales sapien commodo faucibus. Vestibulum et feugiat enim. Donec " +
                "semper mi et euismod tempor. Sed sodales eleifend mi id varius. Nam " +
                "et ornare enim, sit amet gravida sapien. Quisque gravida et enim vel " +
                "volutpat. Vivamus egestas ut felis a blandit. Vivamus fringilla " +
                "dignissim mollis. Maecenas imperdiet interdum hendrerit. Aliquam" +
                " dictum hendrerit ultrices. Ut vitae vestibulum dolor. Donec auctor ante" +
                " eget libero molestie porta. Nam tempor fringilla ultricies. Nam sem " +
                "lectus, feugiat eget ullamcorper vitae, ornare et sem. Fusce dapibus ipsum" +
                " sed laoreet suscipit. ";

        ExpandableTextView expandableTextView = (ExpandableTextView) view.findViewById(R.id.extDescription);
        expandableTextView.setText(yourText);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event, container, false);

        playerContainer = (FrameLayout) rootView.findViewById(R.id.playerContainer);
        image = (ImageView) rootView.findViewById(R.id.imgEventFragment);
        playerContainer.setVisibility(View.VISIBLE);
        youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();


        if (notVideo) {
            playerContainer.setVisibility(View.GONE);
            Picasso.with(getContext()).load(mEvent.getImgUrl()).into(image);

        } else {
            getChildFragmentManager().beginTransaction()
                    .add(R.id.playerContainer, youTubePlayerFragment).commit();
            youTubePlayerFragment.initialize(YoutubeDeveloperKey, new OnInitializedListener() {

                @Override
                public void onInitializationSuccess(Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
                    if (!b) {
                        YPlayer = youTubePlayer;
                        YPlayer.setFullscreen(false);
                        YPlayer.cueVideo(mEvent.getVideoUrl());
                        YPlayer.setShowFullscreenButton(false);
                        YPlayer.setPlayerStateChangeListener
                                (new YouTubePlayerStateChangeListener(getContext()
                                        , mEvent, image, playerContainer));
                        image.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onInitializationFailure(Provider arg0, YouTubeInitializationResult arg1) {

                }
            });
        }

        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        mUnbinder.unbind();
    }
}