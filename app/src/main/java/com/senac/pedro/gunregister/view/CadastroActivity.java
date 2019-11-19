package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.CadastroControl;
import com.senac.pedro.gunregister.model.Conta;




public class CadastroActivity  extends Activity  {

    private CadastroControl cadastroControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R
                .layout.activity_cadastro);

        cadastroControl = new CadastroControl(this);


    }
    public void voltar(View view) {
        cadastroControl.voltarAction();
    }

    public void cadastrar(View view) {
        cadastroControl.cadastrarAction();
    }


}
