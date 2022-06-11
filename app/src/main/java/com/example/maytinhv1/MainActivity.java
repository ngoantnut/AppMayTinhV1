package com.example.maytinhv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private String input, output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt_out);
    }
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input = "";
                break;
            case "C":
                if(input.length()>0){
                    String newText =input.substring(0,input.length()-1);
                    input=newText;
                }
                break;
            case "=":
                output = input;
                break;
            case "x":
                input+="+";
                break;
            default:
                if(input==null ){
                    input="";
                }
                if(data.equals("+")||data.equals("-")||data.equals("/")){

                }
                input+=data;

        }
        textView.setText(input);
    }
}