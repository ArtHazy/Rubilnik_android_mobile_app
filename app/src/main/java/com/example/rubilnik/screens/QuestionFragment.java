package com.example.rubilnik.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.rubilnik.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class QuestionFragment extends Fragment {
    String text;
    JSONArray choices;
    public QuestionFragment(String text, JSONArray choices){
        this.text=text;
        this.choices=choices;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.question_fragment, container, false);
        Button choiceButton = rootView.findViewById(R.id.btnChoice1);
        ArrayList<Button> choiceButtons = new ArrayList<>();
        LinearLayout buttonsLayout = rootView.findViewById(R.id.buttonsLayout);
        buttonsLayout.removeAllViews();
        TextView questionTextView = rootView.findViewById(R.id.txtQuestion);

        questionTextView.setText(text);

        for (int i=0; i<choices.length(); i++){
            JSONObject choice;
            String text ="";
            try { choice = choices.getJSONObject(i); text = choice.getString("text");} catch (JSONException e) {Log.d("my", e.getClass().getSimpleName() + ": " + e.getMessage());}
            if (text.length()>0) { // if choice exists
                choiceButton.setText(text);
                choiceButtons.add(choiceButton);
            }
        }


        return rootView;
    }
}
