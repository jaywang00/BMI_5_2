package com.example.abc.bmi_5_2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bmi extends AppCompatActivity implements View.OnClickListener {

    private EditText field_height;
    private EditText field_weight;
    private Button submit;
    private TextView result;
    private TextView suggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        setListeners();
    }

    private void findViews(){
        submit = findViewById(R.id.submit);
        field_height = findViewById(R.id.field_height);
        field_weight = findViewById(R.id.field_weight);
        result = findViewById(R.id.result);
        suggest = findViewById(R.id.suggest);



//        rootView = getLayoutInflater().inflate(R.layout.dial_keypad, null);
//        buton0 = rootView

    }

    private void setListeners(){
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DecimalFormat df = new DecimalFormat("0.00");

        double height = Double.parseDouble(field_height.getText().toString()) / 100;
        double weight = Double.parseDouble(field_weight.getText().toString());
        double BMI = weight / (height * height);

        result.setText("你的BMI值 = " + df.format(BMI));

        if (BMI > 25)
            suggest.setText(R.string.advice_heavy);
        else if (BMI < 20)
            suggest.setText(R.string.advice_light);
        else
            suggest.setText(R.string.advice_average);

        openOptionsDialog();
    }

    void openOptionsDialog(){
//        View rootview = getLayoutInflater().inflate(R.layout.d, null);
//        Button buttonAdd = rootview.findViewById(R.id.buttonAdd);
////add this for Listener
//        buttonAdd.setOnClickListener(dialogListener);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setView(rootview);
//
//
//        builder.show();

        final ProgressDialog progressDialog = ProgressDialog.show(Bmi.this,"Processing, please wait.....", "After finishing this process will be ended.");
            Thread thread = new Thread(){
                @Override
                public void run(){
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    progressDialog.dismiss();
                }

            };
            thread.start();
    }

    View.OnClickListener dialogListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("Click the SelfDefined Dialog");

        }
    };


}