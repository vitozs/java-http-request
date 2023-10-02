package br.com.httpRequest.HttpUrlConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ApplicationTest {



    public static void getCep(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Digite o seu cep: ");
            int cep = scanner.nextInt();

            //Adiciona o cep na url para requisitar na api
            URL url = new URL("https://viacep.com.br/ws/"+ cep +"/json/");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("accept", "application/json");

            if(conn.getResponseCode() == 400){
                throw new RuntimeException("Erro ao encontrar seu cep");
            }

            InputStream resposta = conn.getInputStream();

            ObjectMapper mapper = new ObjectMapper();

            Cep cepObject = mapper.readValue(resposta, Cep.class);

            System.out.println("Cep: " + cepObject.cep);
            System.out.println("Localidade: " + cepObject.localidade);
            System.out.println("Bairro: " + cepObject.bairro);



        }catch (InputMismatchException e){
            System.err.println("Apenas numeros inteiros!");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
