package canlasd.example.com.youtubeplayer;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener {

    private String GOOGLE_API_KEY = "AIzaSyCOCX2a1mULZKtgaSmZu_xLj5JePl9IwQE";
    private String YOUTUBE_VIDEO_ID = "eHevNn-AVQg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer youTubePlayer, boolean wasRestored) {

        Toast.makeText(this, "YouTube initialized successfully", Toast.LENGTH_LONG).show();
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if (!wasRestored) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener =
            new YouTubePlayer.PlaybackEventListener() {
                @Override
                public void onPlaying() {

                    Toast.makeText(YouTubeActivity.this, "Video is PLaying",
                            Toast.LENGTH_LONG).show();

                }

                @Override
                public void onPaused() {

                    Toast.makeText(YouTubeActivity.this, "Video is Paused",
                            Toast.LENGTH_LONG).show();


                }

                @Override
                public void onStopped() {

                }

                @Override
                public void onBuffering(boolean b) {

                }

                @Override
                public void onSeekTo(int i) {

                }
            };

    YouTubePlayer.PlayerStateChangeListener playerStateChangeListener
            = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

            Toast.makeText(YouTubeActivity.this, "Ad is showing",
                    Toast.LENGTH_LONG).show();


        }

        @Override
        public void onVideoStarted() {

            Toast.makeText(YouTubeActivity.this, "Video has Started",
                    Toast.LENGTH_LONG).show();


        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult youTubeInitializationResult) {

        Toast.makeText(this, "YouTube unsuccessful", Toast.LENGTH_LONG).show();

    }
}
