package com.senac.pedro.gunregister.resources;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.senac.pedro.gunregister.config.ApiParams;
import com.senac.pedro.gunregister.model.Conta;
import com.senac.pedro.gunregister.view.ArmamentoActivity;

import cz.msebera.android.httpclient.Header;


public class LoginResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "login";
    private AsyncHttpClient client;
    private Conta usuario;
    private Activity activity;
    private AlertDialog alertDialog;

    public LoginResource(Activity activity){
        this.activity = activity;
        alertDialog = (new AlertDialog.Builder(activity)).create();
        alertDialog.setTitle("Aguarde");
        alertDialog.setMessage("Carregando");
        alertDialog.setCanceledOnTouchOutside(false);
    }

    public void verificaUsuario(String email, String senha){

        alertDialog.show();
        client = new AsyncHttpClient();
        // Inserir o header e testar na api
        client.get("http://192.168.0.12:8080/login" + "/" + email + "/" + senha, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {

                String resJSON = new String(bytes);

                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Conta.class);

                alertDialog.dismiss();
                if(usuario != null){
                    Intent it = new Intent(activity, ArmamentoActivity.class);
                    it.putExtra("user", usuario);
                    activity.startActivity(it);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                alertDialog.dismiss();
                Toast.makeText(activity, "Erro ao efetuar login", Toast.LENGTH_SHORT).show();
            }
        });

        //return usuario;
    }
}
