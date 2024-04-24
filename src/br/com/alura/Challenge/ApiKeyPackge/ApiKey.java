package br.com.alura.Challenge.ApiKeyPackge;

import br.com.alura.Challenge.ModeloDoJson.ModeloDoJsonCoin;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiKey {

    private ModeloDoJsonCoin jsonCoin; //   Ele é o que eu puxo no InterfacePrincipal usando o Método get

    public ModeloDoJsonCoin getJsonCoin() {
        return jsonCoin;
    }

//      O método httpRequest ele faz a requisição na api e puxando somente o conversion_rate
//      É com o conversion_rate que eu consigo faz a conta da taxa de câmbio

  public void httpRequest(String baseCurrency,  String targetCurrency) throws IOException, InterruptedException {

        var key = "40267db8ad477275b6dc16fd"; // A chave da minha API
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseCurrency + "/" + targetCurrency; //   A URL da API

      try {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString()); //    O método http

            Gson gson = new Gson();

            String json = response.body();
            jsonCoin = gson.fromJson(json, ModeloDoJsonCoin.class); //  Transformando o objeto java em json

        } catch  (IllegalArgumentException e) {
          throw  new RuntimeException();}
}}