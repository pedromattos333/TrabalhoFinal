package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.model.Conta;
import com.senac.pedro.gunregister.resources.ContaResource;

public class CadastroControl {
    private Activity activity;
    private ContaResource contaResource;
    private Conta conta;

    private EditText et_nome;
    private EditText et_email;
    private EditText et_senha;

    public CadastroControl(Activity activity) {
        this.activity = activity;
        this.contaResource = new ContaResource(this.activity);
        this.et_nome = activity.findViewById(R.id.et_nome);
        this.et_email = activity.findViewById(R.id.et_email);
        this.et_senha = activity.findViewById(R.id.et_senha);
    }

    public void cadastrarAction() {
        Conta usuario = new Conta();

        if (et_nome.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_nome, Toast.LENGTH_LONG).show();
            et_nome.requestFocus();
            return;
        } else if (et_email.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_email, Toast.LENGTH_LONG).show();
            et_email.requestFocus();
            return;

        } else if    (et_senha.getText().toString().trim().isEmpty()) {
                Toast.makeText(activity, R.string.erro_senha, Toast.LENGTH_LONG).show();
                et_senha.requestFocus();
                return;

            }

            try {
           contaResource.cadastrarConta(usuario);
        } catch (Exception e) {
            Toast.makeText(activity, "Falha ao cadastrar usuario", Toast.LENGTH_SHORT).show();
            return;
        }

        }

         public void voltarAction(){
             this.activity.finish();

        }
    }
