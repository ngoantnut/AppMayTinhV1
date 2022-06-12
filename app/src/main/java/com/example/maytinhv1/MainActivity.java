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
                Solve();
                output = input;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            default:
                if(input==null ){
                    input="";
                }
                if(data.equals("+")||data.equals("-")||data.equals("/")){
                    Solve();
                }
                input+=data;

        }
        textView.setText(input);
    }

    public void Solve(){
        if(input.split("\\*").length==2){
            String number[] =input.split("\\*");
            try {
                double nhan= Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = nhan+ " ";
            }
            catch (Exception e){

            }
        }

        if(input.split("\\+").length==2){
            String number[] =input.split("\\+");
            try {
                double cong= Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input = cong+ " ";
            }
            catch (Exception e){

            }
        }

        if(input.split("\\-").length==2){
            String number[] =input.split("\\-");
            try {
                double tru= Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = tru+ " ";
            }
            catch (Exception e){

            }
        }

        if(input.split("\\/").length==2){
            String number[] =input.split("\\/");
            try {
                double chia= Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = chia+ " ";
            }
            catch (Exception e){

            }
        }
        if(input.split("\\^").length==2){
            String number[] =input.split("\\^");
            try {
                double mu= Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input = mu+ " ";
            }
            catch (Exception e){

            }
        }


        String n[]= input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                input= n[0];
            }
        }
    }
}