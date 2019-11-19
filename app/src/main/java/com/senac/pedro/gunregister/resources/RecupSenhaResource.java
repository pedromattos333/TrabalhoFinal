package com.senac.pedro.gunregister.resources;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.senac.pedro.gunregister.config.ApiParams;

import cz.msebera.android.httpclient.Header;

public class RecupSenhaResource {
    private static final String BASE_URL = ApiParams.getURL();
    private static final String URL = "recover/";
    private AsyncHttpClient client;
    private boolean result;

    public boolean RecpUsuario(String email){
        client = new AsyncHttpClient();
        result = true;

        client.get(BASE_URL + URL + email, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                result = true;
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                result = false;
            }
        });

        return result;
    }
}

