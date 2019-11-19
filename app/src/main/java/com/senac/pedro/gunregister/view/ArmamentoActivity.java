package com.senac.pedro.gunregister.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.control.ArmamentoControl;

public class ArmamentoActivity extends Activity {
    private ArmamentoControl control;
    private Button btSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armamento);

        btSair = findViewById(R.id.btSair);
        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmamentoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        loadData();

        control = new ArmamentoControl(this);

    }

    private void loadData(){
        Intent intent = getIntent();
        String login = intent.getStringExtra("login");
    }

    public void chamaTelaCadArma(View v){
        control.chamaTelaCadArmaAction();
    }

    public void chamaTelaPesqArma(View v){
        control.chamaTelaPesqArmaAction();
    }

    public void voltar(View v){
        control.voltarAction();
    }
}