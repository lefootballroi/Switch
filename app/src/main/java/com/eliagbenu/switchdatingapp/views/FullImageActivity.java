package com.eliagbenu.switchdatingapp.views;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.eliagbenu.switchdatingapp.R;
import com.eliagbenu.switchdatingapp.adapter.ImageAdapter;

public class FullImageActivity extends ActionBarActivity {
    Button buttonPass, buttonLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        int position = i.getExtras().getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        likeClick();
        passClick();
    }

    public void likeClick() {
        buttonLike = (Button) findViewById(R.id.buttonLike);

        buttonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent moreDetailsIntent = new Intent(getApplicationContext(), MoreDetails.class);
                startActivity(moreDetailsIntent);

            }
        });
    }

    public void passClick() {
        buttonPass = (Button) findViewById(R.id.buttonPass);

        buttonPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //if all is well go to profile
                Intent candidatesIntent = new Intent(getApplicationContext(),Candidates.class);
                startActivity(candidatesIntent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_full_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
