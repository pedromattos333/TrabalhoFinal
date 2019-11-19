package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.resources.RecupSenhaResource;

public class RecupSenhaControl {
    private Activity activity;
    private RecupSenhaResource recuperaSenha;
    private EditText email;

    public RecupSenhaControl(Activity activity){
        this.activity = activity;
        this.recuperaSenha = new RecupSenhaResource();

        this.email = activity.findViewById(R.id.edit_text_recuperacao);
    }

    public void recuperarAction(){
        String e = this.email.getText().toString();

        boolean r = recuperaSenha.RecpUsuario(e);

        if(r){
            Toast.makeText(activity, "Enviado com sucesso!", Toast.LENGTH_SHORT).show();
            this.activity.finish();
        } else {
            Toast.makeText(activity, "Falha ao enviar pedido de recuperação!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void voltarAction(){
        this.activity.finish();
    }
}
