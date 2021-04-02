package com.dezrill.npapilesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> towns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        towns=new ArrayList<>();
    }

    private void LoadCities() throws IOException, JSONException {
        OkHttpClient client=new OkHttpClient();

        Request request=new Request.Builder().url("https://api.novaposhta.ua/v2.0/json?apiKey=5427c06765bdcbd4da909b4c0bd86d5e&calledMethod=getSettlements&modelName=AddressGeneral")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("postman-token", "dd5903ae-7a7a-0a9b-1663-785505ab0e07")
                .build();


        Response response=client.newCall(request).execute();

        if (!response.isSuccessful()) throw new IOException("Error" + response);
        else {
            String responseData=response.body().string();
            JSONObject obj=new JSONObject(responseData);
            JSONArray jsonArray=obj.getJSONArray("data");
        }
    }

    private void LoadPVZs(String city) {

    }
}