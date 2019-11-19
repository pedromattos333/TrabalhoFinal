package com.senac.pedro.gunregister.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


import com.j256.ormlite.dao.Dao;
import com.senac.pedro.gunregister.R;
import com.senac.pedro.gunregister.view.RecupActivity;
import com.senac.pedro.gunregister.dao.ContaDao;
import com.senac.pedro.gunregister.dao.ORMLiteHelper;
import com.senac.pedro.gunregister.model.Conta;
import com.senac.pedro.gunregister.resources.LoginResource;
import com.senac.pedro.gunregister.view.CadastroActivity;

import java.sql.SQLException;

public class MainControl {

    private Dao<Conta, Integer> contaDao;
    private Activity activity;
    private EditText editLogin;
    private EditText editSenha;
    private ContaDao contaOrmDao;
    private ORMLiteHelper helper;
    private LoginResource loginResource;
    private Conta conta;

    public MainControl(Activity activity) {
        this.activity = activity;
        this.loginResource = new LoginResource(this.activity);
        this.helper = new ORMLiteHelper(activity);
        this.contaOrmDao = new ContaDao(this.helper);

        this.editLogin = activity.findViewById(R.id.editLogin);
        this.editSenha = activity.findViewById(R.id.editSenha);

        try{
            contaDao = contaOrmDao.getCadastroDao();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    public void cadastrarAction(){
        Intent it = new Intent(activity, CadastroActivity.class);
        activity.startActivity(it);
    }

    public boolean validarCampos() {
        if (editLogin.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_logar, Toast.LENGTH_LONG).show();
            editLogin.requestFocus();
            return false;
        } else if (editSenha.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.erro_senha, Toast.LENGTH_LONG).show();
            editSenha.requestFocus();

            return false;
        }
        return false;
    }

    public void ValidaUsuario(){
        conta = null;

        String e = editLogin.getText().toString();
        String s = editSenha.getText().toString();

        loginResource.verificaUsuario(e,s);
    }




    public void recuperarAction(){
        Intent it = new Intent(activity, RecupActivity.class);
        activity.startActivity(it);
    }


    public void voltarAction() {
        activity.finish();
    }


}
