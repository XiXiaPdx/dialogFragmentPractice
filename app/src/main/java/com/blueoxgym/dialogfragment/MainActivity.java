package com.blueoxgym.dialogfragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.openDialog) Button openDialog;
    @Bind(R.id.nextActivity) Button nextActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        openDialog.setOnClickListener(this);
        nextActivity.setOnClickListener(this);
    }
    @Override
    public void onClick (View v) {
        if (v == openDialog){
            FragmentManager fm = getFragmentManager();
            MoodDialogFragment moodDialogFragment = new MoodDialogFragment();
            moodDialogFragment.show(fm, "Sample Fragment");
        }
        if (v == nextActivity){
            Intent receive = getIntent();
            String radio = receive.getStringExtra("radio");
            Log.d("radio value", radio.toString());
            Intent intent =  new Intent(MainActivity.this, DialogBuilder.class);
            startActivity(intent);
        }
    }
}
