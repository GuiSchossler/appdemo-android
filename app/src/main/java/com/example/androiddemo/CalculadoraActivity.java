package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {

    Button btnSomar, btnSubtrair, btnMultiplicar, btnDividir, btnLimpa;
    TextView lblResultado;
    EditText txtNum1, txtNum2;
    Context context; //quase sempre usar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        //preenche o contexto da tela
        context = CalculadoraActivity.this;

        //declaração dos botões
        btnSomar = findViewById(R.id.btnSoma_calculadora);
        btnSubtrair = findViewById(R.id.btnSubtrai_calculadora);
        btnMultiplicar = findViewById(R.id.btnMultiplica_calculadora);
        btnDividir = findViewById(R.id.btnDivide_calculadora);
        btnLimpa = findViewById(R.id.btnLimpa_calculadora);

        //declaração dos campos de edição
        txtNum1 =findViewById(R.id.txtNumero1_calculadora);
        txtNum2 =findViewById(R.id.txtNumero2_calculadora);


        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double num1 = Double.parseDouble(txtNum1.getText().toString());
                    double num2 = Double.parseDouble(txtNum2.getText().toString());

                    double resultado = num1 + num2;

                    txtNum1.requestFocus();

                    exibirToast("RESULTADO = " + resultado);
                    esconderTeclado();
                } catch (Exception ex) {

                }
            }
        });

        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double num1 = Double.parseDouble(txtNum1.getText().toString());
                    double num2 = Double.parseDouble(txtNum2.getText().toString());

                    double resultado = num1 - num2;

                    exibirToast("RESULTADO = " + resultado);
                    esconderTeclado();
                } catch (Exception ex) {

                }
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double num1 = Double.parseDouble(txtNum1.getText().toString());
                    double num2 = Double.parseDouble(txtNum2.getText().toString());

                    double resultado = num1 * num2;

                    exibirToast("RESULTADO = " + resultado);
                    esconderTeclado();
                } catch (Exception ex) {

                }
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double num1 = Double.parseDouble(txtNum1.getText().toString());
                    double num2 = Double.parseDouble(txtNum2.getText().toString());

                    if (num2>0) {
                        double resultado = num1 / num2;
                        exibirToast("RESULTADO = " + resultado);
                        txtNum1.requestFocus();
                        esconderTeclado();
                    }else {
                        exibirToast("A divisão não pode ser realizada!");
                    }

                } catch (Exception ex) {

                }
            }
        });

        btnLimpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNum1.setText("");
                txtNum2.setText("");
                esconderTeclado();
            }

        });
    }

    private void esconderTeclado(){
        try{
            //cria um objeto do teclado do emulador/celular
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            //método que esconde o teclado da tela
            imm.hideSoftInputFromWindow(btnSomar.getWindowToken(), 0);

        }catch (Exception ex){

        }
    }

    private void exibirToast(String texto) {
        try {
            Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
        } catch (Exception ex) {

        }
    }
}


