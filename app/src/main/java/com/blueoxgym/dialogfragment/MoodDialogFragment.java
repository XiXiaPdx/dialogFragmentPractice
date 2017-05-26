package com.blueoxgym.dialogfragment;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by macbook on 5/26/17.
 */

public class MoodDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_mood_dialog, container, false);
        getDialog().setTitle("Simple Dialog");
        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);
        final RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.moodRadioGroup);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId= surveyRadioGroup.getCheckedRadioButtonId();
                final RadioButton selectedRadioButton = (RadioButton) rootView.findViewById
                        (selectedId);
                Log.d("testing", selectedRadioButton.getText().toString());
                Intent intent = new Intent (getActivity(), MainActivity.class);
                intent.putExtra("radio", selectedRadioButton.getText() );
                startActivity(intent);
                dismiss();
            }
        });
        return rootView;
    }
}
