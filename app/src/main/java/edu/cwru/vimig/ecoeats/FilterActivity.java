package edu.cwru.vimig.ecoeats;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import android.view.ViewAnimationUtils;
import android.graphics.Outline;


public class FilterActivity extends ActionBarActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {


    private ViewGroup buttonsContainer;
    private ViewGroup buttonsContainer2;
    private Button activeButton = null;
    private final int MAX_BUTTONS = 6;

    SeekBar distance_seek;
    SeekBar cost_seek;
    TextView distance_view;
    TextView cost_view;
    int value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        this.buttonsContainer = (ViewGroup) findViewById(R.id.buttonsContainer);
        this.buttonsContainer2 = (ViewGroup) findViewById(R.id.buttonsContainer2);
        distance_seek = (SeekBar) findViewById(R.id.seekBar);
        cost_seek = (SeekBar) findViewById(R.id.seekBar2);
        distance_view = (TextView) findViewById(R.id.distance_display);
        cost_view = (TextView) findViewById(R.id.cost_display);

        distance_seek.setOnSeekBarChangeListener(this);
        cost_seek.setOnSeekBarChangeListener(this);

        int buttonsSpacing = (int) getResources().getDimension(R.dimen.activity_horizontal_margin);
        int buttonSize = (int) getResources().getDimension(R.dimen.button_size);
        String[] names = {"Indian", "Mexican", "Italian", "American", "Chinese", "Other"};

        for (int i = 0; i < 3; i++) {
            Button button = (Button) getLayoutInflater().inflate(R.layout.circular_button_layout, buttonsContainer, false);
            button.setText(names[i]);
            button.setOnClickListener(this);
            if (i % 3 == 1) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                params.gravity = Gravity.LEFT;
                buttonsContainer.addView(button, params);
            } else if (i % 3 == 2) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                params.gravity = Gravity.CENTER;
                buttonsContainer.addView(button, params);
            } else if (i % 3 == 0) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                params.gravity = Gravity.RIGHT;
                buttonsContainer.addView(button, params);
            }
            button.setSelected(true);

            if (i != MAX_BUTTONS - 1) {
                buttonsContainer.addView(new Space(this), new ViewGroup.LayoutParams(buttonsSpacing, buttonSize));
            }
        }

            for (int j = 3; j < MAX_BUTTONS; j++) {
                Button button2 = (Button) getLayoutInflater().inflate(R.layout.circular_button_layout, buttonsContainer2, false);
                button2.setText(names[j]);
                button2.setOnClickListener(this);
                if (j % 3 == 1) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                    params.gravity = Gravity.LEFT;
                    buttonsContainer2.addView(button2, params);
                } else if (j % 3 == 2) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                    params.gravity = Gravity.CENTER;
                    buttonsContainer2.addView(button2, params);
                } else if (j % 3 == 0) {
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
                    params.gravity = Gravity.RIGHT;
                    buttonsContainer2.addView(button2, params);
                }

                button2.setSelected(true);

                //Add margin between buttons manually
                if (j != MAX_BUTTONS - 1) {
                    buttonsContainer2.addView(new Space(this), new ViewGroup.LayoutParams(buttonsSpacing, buttonSize));
                }
            }

        }

    private void selectButton(Button button) {
        if(button.isSelected()){
            button.setSelected(false);
        }
        else{
            button.setSelected(true);
        }
//
//        if (activeButton != null) {
//            //activeButton.setSelected(false);
//            activeButton = null;
//        }
//
//
//        activeButton = button;
//        button.setSelected(true);
    }

    @Override
    public void onClick(View view) {
        selectButton((Button) view);
    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)  {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
       if(seekBar.getId() == R.id.seekBar)
       {
           distance_view.setText(Integer.toString(progress));
       }
        else if(seekBar.getId() == R.id.seekBar2){
           cost_view.setText(Integer.toString(progress));
       }
    }
}
