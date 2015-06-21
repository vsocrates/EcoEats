package edu.cwru.vimig.ecoeats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by ETHAN on 6/20/15.
 */
public class DetailActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrolldetail);
    }


    public void changeToProfile(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
