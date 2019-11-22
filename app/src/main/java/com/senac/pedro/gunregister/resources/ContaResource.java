package com.senac.pedro.gunregister.resources;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.senac.pedro.gunregister.config.ApiParams;
import com.senac.pedro.gunregister.model.Conta;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;


public class ContaResource {

    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "usuario";
    private AsyncHttpClient client;
    private Conta usuario;
    private Activity activity;
    private AlertDialog dlgCarregando;

    public ContaResource(Activity activity){
        this.activity = activity;
        dlgCarregando = (new AlertDialog.Builder(activity)).create();
        dlgCarregando.setTitle("Aguarde");
        dlgCarregando.setMessage("Requisitando banco de dados...");
        dlgCarregando.setCanceledOnTouchOutside(false);
    }

    public void getUsuario(final ArrayAdapter<Conta> adapterCategoria){
        dlgCarregando.show();

        client = new AsyncHttpClient();
        client.get("http://192.168.0.12:8080/usuario", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);
                Conta usuario;
                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Conta.class);
                dlgCarregando.dismiss();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                dlgCarregando.dismiss();
            }
        });
    }

    public void cadastrarConta(Conta c){
        StringEntity entity=null;
        try {
            Gson g = new Gson();
            entity = new StringEntity(g.toJson(c));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        client = new AsyncHttpClient();
        client.post(activity.getApplicationContext(), "http://192.168.0.12:8080/usuario", entity, "application/json", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String resJSON = new String(bytes);

                Gson gson = new Gson();
                usuario = gson.fromJson(resJSON, Conta.class);
                //Toast.makeText(c, ""+usuario.getId(), Toast.LENGTH_SHORT).show();
                if(usuario != null){
                    Toast.makeText(activity, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    activity.finish();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Falha ao cadastrar usuario", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
