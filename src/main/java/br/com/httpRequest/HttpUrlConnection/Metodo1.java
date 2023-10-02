package br.com.httpRequest.HttpUrlConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Metodo1 {
    public static void getConn() throws IOException {

        try{
            //Url da api
            URL url = new URL("https://viacep.com.br/ws/01001000/json/");

            //Abre a conexao com a url
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //Retorna status da conexao
            //System.out.println(conn.getResponseCode());

            conn.setRequestProperty("accept", "application/json");

            //Faz o request
            InputStream resposta = conn.getInputStream();

            ObjectMapper mapper = new ObjectMapper();

            //"Converte" a resposta em um objeto
            Cep cep = mapper.readValue(resposta, Cep.class);

            System.out.println(cep.cep);
        }catch (Exception e){
            System.err.println(e);
        }


    }
}
