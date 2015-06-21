package edu.cwru.vimig.ecoeats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by JESSIE on 6/20/15.
 */
public class MyProfileActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myprofile);
    }

    public void onPostMeal(View v) {
        Intent i = new Intent(getApplicationContext(), PostMealActivity.class);
        startActivity(i);
    }

}
