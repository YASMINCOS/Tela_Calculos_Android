package com.example.desafio02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SomaActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_SOMA = 1;

    private EditText edNumber1;
    private EditText edNumber2;
    private String number2;
    private String number1;
    private float sum;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma);
        setTitle("Soma");

        this.edNumber1 = findViewById(R.id.editNumber1Sum);
        this.edNumber2 = findViewById(R.id.editNumber2Sum);

        Button clickButton = (Button) findViewById(R.id.button_Calculate_Sum);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OperationSum();
                Intent returnIntent = getIntent();
                returnIntent.putExtra("soma", sum);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
    private void OperationSum() {
        number1 = edNumber1.getText().toString().trim();
        number2 = edNumber2.getText().toString().trim();
        if(number1.equals("") || number2.trim().equals("")){
          Toast.makeText(getApplicationContext(), "È necessário digitar um valor!"
                    , Toast.LENGTH_SHORT).show();
        }else{
            sum = Float.parseFloat(number1) + Float.parseFloat(number2);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
 
        outState.putString("numero 1", edNumber1.getText().toString());
        outState.putString("numero 2", edNumber2.getText().toString());

        Log.i("Salvando numero 1", edNumber1.getText().toString());
        Log.i("Salvando numero 2", edNumber2.getText().toString());

    }

}