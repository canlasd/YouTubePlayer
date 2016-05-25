package canlasd.example.com.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSingle;
    private Button btnStandAlone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnSingle = (Button) findViewById(R.id.btnPlaySingle);
        btnStandAlone = (Button) findViewById(R.id.btnStandAlone);

        btnSingle.setOnClickListener(this);
        btnStandAlone.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {
            case R.id.btnPlaySingle:
                intent = new Intent(MainActivity.this, YouTubeActivity.class);
                break;

            case R.id.btnStandAlone:
                intent = new Intent(MainActivity.this, StandAloneActivity.class);
                break;

            default:
        }

        if (intent != null) {
            startActivity(intent);
        }

    }
}
