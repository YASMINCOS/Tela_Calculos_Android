package com.example.desafio02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubtracaoActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_SUBTRACAO = 2;

    private EditText edNumber1Sub;
    private EditText edNumber2Sub;
    private String number2Sub;
    private String number1Sub;
    private float subtraction;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtracao);
        setTitle("Subtracao");

        this.edNumber1Sub = findViewById(R.id.editNumber1Subtraction);
        this.edNumber2Sub = findViewById(R.id.editNumber2Subtraction);

        Button clickButton = (Button) findViewById(R.id.button_Calculate_Subtraction);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OperationSubtracao();
                Intent returnIntent = getIntent();
                returnIntent.putExtra("subtracao", subtraction);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
    private void OperationSubtracao() {
        number1Sub = edNumber1Sub.getText().toString().trim();
        number2Sub = edNumber2Sub.getText().toString().trim();
        if(number1Sub.equals("") || number2Sub.trim().equals("")){
            Toast.makeText(getApplicationContext(), "È necessário digitar um valor!"
                    , Toast.LENGTH_SHORT).show();
        }else{
            subtraction = Float.parseFloat(number1Sub) - Float.parseFloat(number2Sub);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("numero 1", edNumber1Sub.getText().toString());
        outState.putString("numero 2", edNumber2Sub.getText().toString());

        Log.i("Salvando numero 1", edNumber1Sub.getText().toString());
        Log.i("Salvando numero 2", edNumber2Sub.getText().toString());

    }
}