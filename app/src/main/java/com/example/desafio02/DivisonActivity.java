package com.example.desafio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DivisonActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_DIVISAO =4;

    private EditText edNumber1Div;
    private EditText edNumber2Div;
    private String number2Div;
    private String number1Div;
    private float division;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        setTitle("Divisao");

        this.edNumber1Div = findViewById(R.id.editNumber1Division);
        this.edNumber2Div = findViewById(R.id.editNumber2Division);

        Button clickButton = (Button) findViewById(R.id.button_Calculate_Division);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OperationDivision();
                Intent returnIntent = getIntent();
                returnIntent.putExtra("divisao", division);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
    private void OperationDivision() {
        number1Div = edNumber1Div.getText().toString().trim();
        number2Div = edNumber2Div.getText().toString().trim();
        if(number1Div.equals("") || number2Div.trim().equals("")){
            Toast.makeText(getApplicationContext(), "È necessário digitar um valor!"
                    , Toast.LENGTH_SHORT).show();
        }else{
            division = Float.parseFloat(number1Div) / Float.parseFloat(number2Div);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("numero 1", edNumber1Div.getText().toString());
        outState.putString("numero 2", edNumber2Div.getText().toString());

        Log.i("Salvando numero 1", edNumber1Div.getText().toString());
        Log.i("Salvando numero 2", edNumber2Div.getText().toString());

    }
}