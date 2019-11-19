package com.senac.pedro.gunregister.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.RecupSenhaControl;

public class RecupActivity extends AppCompatActivity {

    private RecupSenhaControl recupSenhaControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recup);
        this.recupSenhaControl = new RecupSenhaControl(this);
    }
    public void voltar(View view) {
        recupSenhaControl.voltarAction();
    }

    public void recuperar(View view) {
        recupSenhaControl.recuperarAction();
    }
}
