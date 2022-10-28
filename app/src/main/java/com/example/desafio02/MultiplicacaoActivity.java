package com.example.desafio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MultiplicacaoActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_MULTIPLICACAO = 3;

    private EditText edNumber1Mul;
    private EditText edNumber2Mul;
    private String number2Mul;
    private String number1Mul;
    private float multiplication;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacao);
        setTitle("Multiplicação");

        this.edNumber1Mul = findViewById(R.id.editNumber1Multiplication);
        this.edNumber2Mul = findViewById(R.id.editNumber2Multiplication);

        Button clickButton = (Button) findViewById(R.id.button_Calculate_Multiplication);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                OperationMultiplication();
                Intent returnIntent = getIntent();
                returnIntent.putExtra("multiplicacao", multiplication);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

    }
    private void OperationMultiplication() {
        number1Mul = edNumber1Mul.getText().toString().trim();
        number2Mul = edNumber2Mul.getText().toString().trim();
        if(number1Mul.equals("") || number2Mul.trim().equals("")){
            Toast.makeText(getApplicationContext(), "È necessário digitar um valor!"
                    , Toast.LENGTH_SHORT).show();
        }else{
            multiplication = Float.parseFloat(number1Mul) * Float.parseFloat(number2Mul);
        }
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("numero 1", edNumber1Mul.getText().toString());
        outState.putString("numero 2", edNumber2Mul.getText().toString());

        Log.i("Salvando numero 1", edNumber1Mul.getText().toString());
        Log.i("Salvando numero 2", edNumber2Mul.getText().toString());

    }
}