package br.com.httpRequest.HttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Metodo2 {

    public static void getConn(){

        //Cria um client para fazer os requests
        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder(
                URI.create("https://viacep.com.br/ws/01001000/json/")).header("accept", "application/json").build();

        //var resposta = client.send(request, HttpResponse.BodyHandler.);


    }

}
