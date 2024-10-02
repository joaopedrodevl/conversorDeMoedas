import com.alura.challenge.conversordemoedas.ConsultaApiExchange;
import com.alura.challenge.conversordemoedas.ExchangeAPIResult;
import com.alura.challenge.conversordemoedas.HistoricoConversoes;
import com.alura.challenge.conversordemoedas.Menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HistoricoConversoes historico = new HistoricoConversoes();
        ConsultaApiExchange consultaApiExchange = new ConsultaApiExchange();
        Menu menu = new Menu();
        int op;
        ExchangeAPIResult exchangeAPIResult;
        double valor = 1;

        while (true) {
            menu.apresentar();
            System.out.print("Digite sua escolha: ");
            try {
                op = scanner.nextInt();

                if (op < 1 || op > 8) {
                    System.out.println("Opção inválida. Por favor, digite um número entre 1 e 8.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa a entrada inválida
                continue;
            }

            if (op == 8) break;

            try {
                if (op < 7) {
                    System.out.println("Digite o valor que deseja converter:");
                    valor = scanner.nextDouble();
                }

                while (valor <= 0) {
                    System.out.println("Valor inválido. Por favor, digite um valor maior que 0:");
                    valor = scanner.nextDouble();
                }

                switch (op) {
                    case 1:
                        exchangeAPIResult = consultaApiExchange.consultar("USD", "BRL", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 2:
                        exchangeAPIResult = consultaApiExchange.consultar("BRL", "USD", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 3:
                        exchangeAPIResult = consultaApiExchange.consultar("EUR", "BRL", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 4:
                        exchangeAPIResult = consultaApiExchange.consultar("BRL", "EUR", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 5:
                        exchangeAPIResult = consultaApiExchange.consultar("ARS", "BRL", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 6:
                        exchangeAPIResult = consultaApiExchange.consultar("BRL", "ARS", valor);
                        historico.addAoHistorico(exchangeAPIResult);
                        menu.mostrarResultado(exchangeAPIResult, valor);
                        break;
                    case 7:
                        historico.verHistoricoDeConversoes();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.next(); // Limpa a entrada inválida
            }
        }
        historico.salvaHistorioEmArquivoJson();
        System.out.println("Fim do programa!");
    }
}