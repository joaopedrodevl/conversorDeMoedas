package com.alura.challenge.conversordemoedas;

public class Menu {
    public void apresentar() {
        System.out.println("================================================================================");
        System.out.println("Bem-Vindo ao Conversor de Moedas. Para continuar, digite umas das opções abaixo:");
        System.out.println("1- Dólar -> Real brasileiro");
        System.out.println("2- Real brasileiro -> Dólar");
        System.out.println("3- Euro -> Real brasileiro");
        System.out.println("4- Real brasileiro -> Euro");
        System.out.println("5- Peso argentino -> Real brasileiro");
        System.out.println("6- Real brasileiro -> Peso argentino");
        System.out.println("7- Ver histórico de conversões");
        System.out.println("8- Sair");
        System.out.println("================================================================================");
    }

    public void mostrarResultado(ExchangeAPIResult exchangeAPIResult, double valorInicial) {
        System.out.printf("Valor %.2f [%s] convertido para %.2f [%s]%n", valorInicial, exchangeAPIResult.baseCode(), exchangeAPIResult.conversionResult(), exchangeAPIResult.targetCode());
    }
}
