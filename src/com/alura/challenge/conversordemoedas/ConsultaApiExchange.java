package com.alura.challenge.conversordemoedas;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiExchange {
    public ExchangeAPIResult consultar(String baseCode, String baseTarget, double valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/" + "pair/" + baseCode + "/" + baseTarget + "/" + valor))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

        return gson.fromJson(response.body(), ExchangeAPIResult.class);
    }
}
