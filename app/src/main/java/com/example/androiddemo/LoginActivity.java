package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser, txtPassword;
    Button btnLogin;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = LoginActivity.this;

        //Botões
        btnLogin = findViewById(R.id.btnLogin);

        // Campos de edição
        txtPassword = findViewById(R.id.txtPassword);
        txtUser = findViewById(R.id.txtUser);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String userCorreto = "gui";
                    String senhaCorreta = "iug";

                    String usuario = txtUser.getText().toString();
                    String senha = txtPassword.getText().toString();

                    txtUser.requestFocus();

                    if (usuario.equals(userCorreto) && (senha.equals(senhaCorreta))) {
                        exibirToast("Logado com sucesso!");
                        esconderTeclado();

                        Intent tela = new Intent(context, LoginSegundaTelaActivity.class);
                        startActivity(tela);
                        //finish(); // Fecha as que estão atrás, ou seja, não fica uma casacata de telas

                    } else {
                        exibirToast("Usuário ou senha incorretos");
                        esconderTeclado();
                    }


                } catch (Exception ex) {

                }
            }
        });
    }

    private void esconderTeclado(){
        try{
            //cria um objeto do teclado do emulador/celular
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
            //método que esconde o teclado da tela
            imm.hideSoftInputFromWindow(btnLogin.getWindowToken(), 0);

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