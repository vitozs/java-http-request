package br.com.httpRequest.HttpUrlConnection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//Pega apenas os campos passados dentro da classe
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cep {
    public final String cep;
    public final String localidade;
    public final String bairro;

    public Cep(@JsonProperty("cep") String cep, @JsonProperty("localidade") String localidade, @JsonProperty("bairro") String bairro) {
        this.cep = cep;
        this.localidade = localidade;
        this.bairro = bairro;
    }
}
