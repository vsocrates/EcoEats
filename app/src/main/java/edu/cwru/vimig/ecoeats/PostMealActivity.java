package edu.cwru.vimig.ecoeats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * Created by JESSIE on 6/21/15.
 */
public class PostMealActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postmeal);
    }

    public void onSubmit(View v) {
        Toast.makeText(getApplicationContext(), "Your meal is successfully posted!",
                Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(), MyProfileActivity.class);
        startActivity(i);
    }
}
