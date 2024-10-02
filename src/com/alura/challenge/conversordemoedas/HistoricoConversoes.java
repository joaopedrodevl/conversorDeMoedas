package com.alura.challenge.conversordemoedas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HistoricoConversoes {
    private final List<ExchangeAPIResult> historico;

    public HistoricoConversoes() {
        this.historico = new LinkedList<>();
    }

    public void verHistoricoDeConversoes() {
        if (this.historico.isEmpty()) {
            System.out.println("Nenhuma conversão resgistrada.");
            return;
        }

        for (ExchangeAPIResult result : historico) {
            System.out.printf("Moeda base: %s, Moeda alvo: %s, Valor atual da moeda: %.2f, Resultado da Conversão: %.2f%n",
                    result.baseCode(), result.targetCode(), result.conversionRate(), result.conversionResult());
        }
    }

    public void addAoHistorico(ExchangeAPIResult exchangeAPIResult) {
        this.historico.add(exchangeAPIResult);
    }

    public void salvaHistorioEmArquivoJson() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter("conversoes.json");
        fileWriter.write(gson.toJson(this.historico));
        fileWriter.close();
    }
}
