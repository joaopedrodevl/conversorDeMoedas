package com.alura.challenge.conversordemoedas;

public record ExchangeAPIResult(double conversionRate, double conversionResult, String baseCode, String targetCode) {
}
