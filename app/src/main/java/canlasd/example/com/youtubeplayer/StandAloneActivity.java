package canlasd.example.com.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class StandAloneActivity extends AppCompatActivity implements View.OnClickListener {

    private String GOOGLE_API_KEY = "AIzaSyCOCX2a1mULZKtgaSmZu_xLj5JePl9IwQE";
    private String YOUTUBE_VIDEO_ID = "eHevNn-AVQg";
    private String YOUTUBE_PLAYLIST = "PLhRy0N4DxIyBXzUGKzUSdZ1qVDoP7-HHJ";
    private Button btnPlayVideo;
    private Button btnPlayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnPlayList = (Button) findViewById(R.id.btnPlayerList);
        btnPlayVideo = (Button) findViewById(R.id.btnPlayer);

        btnPlayList.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);

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
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.btnPlayer:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY,
                        YOUTUBE_VIDEO_ID);
                break;

            case R.id.btnPlayerList:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY,
                        YOUTUBE_PLAYLIST);
                break;

            default:
        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}
