package com.t4j.mobilenurse;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    private static final String    TAG                 = "Main::Activity";

    private MenuItem               mItemMain;
    private MenuItem               mItemDirectImage;
    private MenuItem               mItemSelectImage;
    private MenuItem               mItemSelectMode;

    public MainActivity() {
        Log.i(TAG, "Instantiated new " + this.getClass());
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "called onCreate");
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectModeActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton3 = (ImageButton)findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "called onCreateOptionsMenu");
        mItemMain = menu.add("Main");
        mItemDirectImage = menu.add("Direct Image");
        mItemSelectImage = menu.add("Select Image");
        mItemSelectMode = menu.add("Select Mode");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "called onOptionsItemSelected; selected item: " + item);
        if (item == mItemMain) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (item == mItemDirectImage) {
            Intent intent = new Intent(this, DirectImageActivity.class);
            startActivity(intent);
        } else if (item == mItemSelectImage) {
            Intent intent = new Intent(this, SelectImageActivity.class);
            startActivity(intent);
        } else if (item == mItemSelectMode) {
            Intent intent = new Intent(this, SelectModeActivity.class);
            startActivity(intent);
        }
        return true;
    }
    public void onClick(View v) {
        Intent intent = new Intent(this, SelectModeActivity.class);
        startActivity(intent);
    }

    private void setMinFaceSize(float faceSize) {
    }
}
