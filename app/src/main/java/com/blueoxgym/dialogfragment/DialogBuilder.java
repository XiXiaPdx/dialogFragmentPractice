package com.blueoxgym.dialogfragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DialogBuilder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_builder);
        FragmentManager fm = getFragmentManager();
        BuilderFragment builderFragment = new BuilderFragment();
        builderFragment.show(fm, "builder Fragment");
        Intent receive = getIntent();
        String radio = receive.getStringExtra("radio");
//        Log.d("radio value", radio.toString());
    }
}
