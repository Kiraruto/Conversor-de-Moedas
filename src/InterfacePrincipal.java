import br.com.alura.Challenge.ApiKeyPackge.ApiKey;

import java.io.IOException;
import java.util.Scanner;

public class InterfacePrincipal extends ApiKey {


    public static void main(String[] args) throws IOException, InterruptedException {

        ApiKey apikey = new ApiKey(); //    Nova Instância da classe ApiKey

        Double add; //  Salvando fora do Do

        Scanner scanner = new Scanner(System.in); // Nova Instância da classe Scanner

        String moneyName; //    Salvando fora do Do o número que eu escolho da minha tábela

        do {

            System.out.println("""
                    *******************************************************
                    
                    Seja Bem-Vindo/a ao Conversor de Moedas =]
                    
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real Brasileiro
                    4) Real Brasileiro =>> Dólar
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) Dólar =>> dirham
                    8) dirham =>> Dólar
                    9) Sair
                    
                    Escolha uma opção válida:
                    *******************************************************
                    """);

            moneyName = scanner.next();

            if (moneyName.equals("9")) {
                System.out.println("Obrigado por usar nosso sistema Saindo.... ");
                break;
            } //    Dizendo que se sair 9 é para finalizar aqui mesmo

            System.out.println("Qual o valaor que você quer converter");

            long moneyValue = scanner.nextLong(); //    Salvando a quantidade que eu quero converter

            switch (moneyName) {
                case "1":
                    apikey.httpRequest("USD", "ARS"); //    Utilizando o Método httpRequest
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue; //   Fazendo a conta que eu preciso para fazer o câmbio
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[ARS]"); // Mostrando o Resultado
                    break;
                case "2":
                    apikey.httpRequest("ARS", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[ARS] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "3":
                    apikey.httpRequest("USD", "BRL");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[BRL]");
                    break;
                case "4":
                    apikey.httpRequest("BRL", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[BRL] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "5":
                    apikey.httpRequest("USD", "COP");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[COP]");
                    break;
                case "6":
                    apikey.httpRequest("COP", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[COP] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "7":
                    apikey.httpRequest("USD", "AED");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[AED]");
                    break;
                case "8":
                    apikey.httpRequest("AED", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[AED] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                default:
                    System.out.println("Digite uma opção valida: 1 ao 9"); //   Default case
                    break;
            }
        } while (true);


    }}
