package com.example.joane14.textstyler;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input;
    TextView indicator;
    CheckBox checkBold;
    CheckBox checkItalic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = (EditText) findViewById(R.id.txtInput);
        indicator = (TextView) findViewById(R.id.txtPreview);
        checkBold = (CheckBox) findViewById(R.id.ckBold);
        checkItalic = (CheckBox) findViewById(R.id.ckItalic);

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                indicator.setText(input.getText()+"");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    public void radioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.rbtnBlue: {
                indicator.setTextColor(Color.BLUE);
                break;
            }
            case R.id.rbtnGreen: {
                indicator.setTextColor(Color.GREEN);
                break;
            }
            case R.id.rbtnPink: {
                indicator.setTextColor(Color.parseColor("#FFC0CB"));
                break;
            }
            case R.id.rbtnRed: {
                indicator.setTextColor(Color.RED);
                break;
            }
        }
    }

    public void boldThis(View view){
//        checkBold.setOnClickListener(new View.OnClickListener() {

//            @Override
//            public void onClick(View v) {
                if(checkBold.isChecked() && checkItalic.isChecked()){
                    indicator.setTypeface(null, Typeface.BOLD_ITALIC);
                }else if(checkBold.isChecked()){
                    indicator.setTypeface(null, Typeface.BOLD);
                }
                else if(checkItalic.isChecked()){
                    indicator.setTypeface(null, Typeface.ITALIC);
                }
                else{
                    indicator.setTypeface(null, Typeface.NORMAL);
                }
//            }
//        });

    }

    public void italicThis(View view){
//        checkItalic.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
                if(checkItalic.isChecked()&&checkBold.isChecked()){
                    indicator.setTypeface(null, Typeface.BOLD_ITALIC);
                }else if(checkItalic.isChecked()){
                    indicator.setTypeface(null, Typeface.ITALIC);
                }else if(checkBold.isChecked()){
                    indicator.setTypeface(null, Typeface.BOLD);
                }
                else{
                    indicator.setTypeface(null, Typeface.NORMAL);
                }
//            }
//        });

    }

}
