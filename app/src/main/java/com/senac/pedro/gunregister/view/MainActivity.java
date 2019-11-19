package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.MainControl;

public class MainActivity extends AppCompatActivity {
    private MainControl control;
    private EditText editLogin;
    private EditText editSenha;
    private Button   btEntrar;
    private Button   btEsqueci;
    private TextView Registrar;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control = new MainControl(this);
    }


    public void recuperarSenha(View view){
       control.recuperarAction();
    }

    public void cadastrar(View view){
        control.cadastrarAction();
    }

    public void entrar(View view){
        control.validarCampos();
        control.ValidaUsuario();
    }




}
