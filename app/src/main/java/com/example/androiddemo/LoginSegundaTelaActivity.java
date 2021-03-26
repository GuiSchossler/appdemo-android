package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class LoginSegundaTelaActivity extends AppCompatActivity {

    Button btnMsg, btnTela3;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_segunda_tela);

        context = LoginSegundaTelaActivity.this;

        btnTela3 = findViewById(R.id.btnTela3);
        btnMsg = findViewById(R.id.btnMsg);

        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            exibirToast("Ainda não há nada por aqui, eu acho!");

            }
        });

        btnTela3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent tela =new Intent(context, LoginTerceiraTelaActivity.class);
                startActivity(tela);

            }
        });

    }

    private void exibirToast(String texto) {
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {

        }
    }
}