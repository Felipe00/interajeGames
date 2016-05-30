package br.com.interaje.interaje01;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        new AsyncTaskCoxinha().execute();
    }

    private class AsyncTaskCoxinha extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                cadastrarCoxinhas();
                listarCoxinhas();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("-->>", "deu erro: " + e.getMessage());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public void cadastrarCoxinhas() throws IOException, JSONException {
        Log.d("@@@", "-Cadastrando coxinha-");
        URL url = new URL("http://192.168.1.12:3000/coxinhas/setCoxinha");
        String jsonString;

        JSONObject coxinhaJ = new JSONObject();
        JSONObject object = new JSONObject();
        coxinhaJ.put("name", "coxinha de fogo");
        object.put("coxinha", coxinhaJ);

        jsonString = object.toString();

        // iniciando a conexão
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json");

        // Formatando para utf e fazendo o Encode dos dados
        OutputStream outputStream = new BufferedOutputStream(urlConnection.getOutputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"));
        writer.write(jsonString);
        writer.flush();
        writer.close();
        outputStream.close();

        InputStream inputStream;
        // Recebendo dados do web services
        if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
            inputStream = urlConnection.getInputStream();
        } else {
            inputStream = urlConnection.getErrorStream();
        }
        // Convertendo o InputStream
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp, response = "";
        while ((temp = bufferedReader.readLine()) != null) {
            response += temp;
        }

        // Sua resposta sai aqui!
        Log.d("-->>", !response.isEmpty() ? response : "nada");
        Log.d("@@@", "-Fim cadastro coxinha-");
    }

    public void listarCoxinhas() throws IOException, JSONException {
        Log.d("@@@", "-Listando coxinhas-");
        URL url = new URL("http://192.168.1.12:3000/coxinhas/setCoxinha");

        // Iniciando a conexão
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Content-Type", "application/json");


        InputStream inputStream;
        // Recebendo dados do web services
        if (urlConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
            inputStream = urlConnection.getInputStream();
        } else {
            inputStream = urlConnection.getErrorStream();
        }
        // Convertendo o InputStream
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp, response = "";
        while ((temp = bufferedReader.readLine()) != null) {
            response += temp;
        }

        // Sua resposta sai aqui!
        Log.d("-->>", !response.isEmpty() ? response : "nada");
        Log.d("@@@", "-Fim listagem de coxinhas-");
    }
}
