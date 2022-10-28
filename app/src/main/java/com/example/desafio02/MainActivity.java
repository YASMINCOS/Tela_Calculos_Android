package com.example.desafio02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int REQUEST_CODE_SOMA = 1;
    private static final int REQUEST_CODE_SUBTRACAO = 2;
    private static final int REQUEST_CODE_MULTIPLICACAO = 3;
    private static final int REQUEST_CODE_DIVISAO = 4;


    float returnResult;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.result = (TextView) findViewById(R.id.editResultado);

        Button clickBSum = (Button) findViewById(R.id.button_NextScreen_Sum);
        clickBSum.setOnClickListener(this);
        Button clickBSub = (Button) findViewById(R.id.button_NextScreen_Subtraction);
        clickBSub.setOnClickListener(this);
        Button clickBMul = (Button) findViewById(R.id.button_NextScreen_Multiplication);
        clickBMul.setOnClickListener(this);
        Button clickBDiv = (Button) findViewById(R.id.button_NextScreen_Division);
        clickBDiv.setOnClickListener(this);



        setTitle("Cálculo");

        if (savedInstanceState != null) {
            returnResult = savedInstanceState.getFloat("soma");
            result.setText("Soma " + returnResult);

            returnResult = savedInstanceState.getFloat("subtracao");
            result.setText("Subtracao " + returnResult);

            returnResult = savedInstanceState.getFloat("multiplicacao");
            result.setText("Multiplicacao " + returnResult);


            returnResult = savedInstanceState.getFloat("divisao");
            result.setText("Divisao " + returnResult);


        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putFloat("soma", returnResult);
        Log.i("Soma", String.valueOf(returnResult));
        super.onSaveInstanceState(outState);

        outState.putFloat("subtracao", returnResult);
        Log.i("Subtracao", String.valueOf(returnResult));
        super.onSaveInstanceState(outState);

        outState.putFloat("multiplicacao", returnResult);
        Log.i("multiplicacao", String.valueOf(returnResult));
        super.onSaveInstanceState(outState);

        outState.putFloat("modulo", returnResult);
        Log.i("modulo", String.valueOf(returnResult));
        super.onSaveInstanceState(outState);

        outState.putFloat("divisao", returnResult);
        Log.i("divisao", String.valueOf(returnResult));
        super.onSaveInstanceState(outState);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode== REQUEST_CODE_SOMA) {

            if (resultCode == RESULT_OK) {
                returnResult = data.getFloatExtra("soma", 0);
                result.setText("Soma " + returnResult);
            }
        }
        else if (requestCode == REQUEST_CODE_SUBTRACAO){
            if (resultCode == RESULT_OK) {
                returnResult = data.getFloatExtra("subtracao", 0);
                result.setText("Subtracao " + returnResult);
            }
        }
        else if (requestCode == REQUEST_CODE_MULTIPLICACAO){
            if (resultCode == RESULT_OK) {
                returnResult = data.getFloatExtra("multiplicacao", 0);
                result.setText("Multiplicacao " + returnResult);
            }
        }

        else if (requestCode == REQUEST_CODE_DIVISAO){
            if (resultCode == RESULT_OK) {
                returnResult = data.getFloatExtra("divisao", 0);
                result.setText("Divisao " + returnResult);
            }
        }

        }


    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
    switch (view.getId()) {
        case R.id.button_NextScreen_Sum:
            Intent intent = new Intent(this, SomaActivity.class);
            startActivityForResult(intent, REQUEST_CODE_SOMA);
            break;

        case R.id.button_NextScreen_Subtraction:
            Intent intentSub = new Intent(this, SubtracaoActivity.class);
            startActivityForResult(intentSub, REQUEST_CODE_SUBTRACAO);
            break;

        case R.id.button_NextScreen_Multiplication:
            Intent intentMult = new Intent(this, MultiplicacaoActivity.class);
            startActivityForResult(intentMult, REQUEST_CODE_MULTIPLICACAO);
            break;


        case R.id.button_NextScreen_Division:
            Intent intentDiv = new Intent(this, DivisonActivity.class);
            startActivityForResult(intentDiv, REQUEST_CODE_DIVISAO);
            break;


        default:
            throw new IllegalStateException("Unexpected value: " + view.getId());
    }
}

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}