package com.senac.pedro.gunregister.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.ArmamentoControl;
import com.senac.pedro.gunregister.control.PesqArmaControl;


public class PesqArmaActivity extends AppCompatActivity {
    private PesqArmaControl control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesq_arma);

        control = new PesqArmaControl(this);


    }
    public void voltar(View v){
        control.voltarAction();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }






}
