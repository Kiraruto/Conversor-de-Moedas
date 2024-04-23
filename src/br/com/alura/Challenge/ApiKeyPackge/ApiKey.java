package br.com.alura.Challenge.ApiKeyPackge;

import br.com.alura.Challenge.ModeloDoJson.ModeloDoJsonCoin;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiKey {

    private ModeloDoJsonCoin jsonCoin;


    public ModeloDoJsonCoin getJsonCoin() {
        return jsonCoin;
    }


  public void httpRequest(String baseCurrency,  String targetCurrency) throws IOException, InterruptedException {

        var key = "40267db8ad477275b6dc16fd";
        String url = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + baseCurrency + "/" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
      HttpResponse<String> response = client
              .send(request, HttpResponse.BodyHandlers.ofString());

      try {
            System.out.println("Response: " + response.body());

            Gson gson = new Gson();

            String json = response.body();
            jsonCoin = gson.fromJson(json, ModeloDoJsonCoin.class);
          System.out.println(jsonCoin);
        } catch  (IllegalArgumentException e) {
          throw  new RuntimeException();}
}}