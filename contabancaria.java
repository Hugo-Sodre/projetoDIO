import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variáveis para armazenar as informações da conta
        String titular = "";
        int numeroConta = 0;
        double saldo = 0.0;

        // Flag para verificar se a conta foi criada
        boolean contaCriada = false;

        int opcao;
        
        do {
            // Exibe o menu de opções
            System.out.println("\nMenu de opções:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar Saldo");
            System.out.println("5 - Exibir Dados da Conta");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Criar conta bancária
                    if (!contaCriada) {
                        scanner.nextLine(); // Limpar o buffer de entrada
                        System.out.print("Digite o nome do titular da conta: ");
                        titular = scanner.nextLine();
                        System.out.print("Digite o número da conta: ");
                        numeroConta = scanner.nextInt();
                        saldo = 0.0; // Inicializa o saldo com 0

                        contaCriada = true;
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("A conta já foi criada.");
                    }
                    break;

                case 2:
                    // Realizar depósito
                    if (contaCriada) {
                        System.out.print("Digite o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        if (valorDeposito > 0) {
                            saldo += valorDeposito;
                            System.out.println("Depósito de R$ " + valorDeposito + " realizado com sucesso.");
                        } else {
                            System.out.println("Valor inválido para depósito.");
                        }
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro.");
                    }
                    break;

                case 3:
                    // Realizar saque
                    if (contaCriada) {
                        System.out.print("Digite o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        if (valorSaque > 0 && valorSaque <= saldo) {
                            saldo -= valorSaque;
                            System.out.println("Saque de R$ " + valorSaque + " realizado com sucesso.");
                        } else if (valorSaque > saldo) {
                            System.out.println("Saldo insuficiente para saque.");
                        } else {
                            System.out.println("Valor inválido para saque.");
                        }
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro.");
                    }
                    break;

                case 4:
                    // Consultar saldo
                    if (contaCriada) {
                        System.out.println("Saldo atual da conta: R$ " + saldo);
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro.");
                    }
                    break;

                case 5:
                    // Exibir dados da conta
                    if (contaCriada) {
                        System.out.println("Dados da Conta:");
                        System.out.println("Titular: " + titular);
                        System.out.println("Número da Conta: " + numeroConta);
                        System.out.println("Saldo Atual: R$ " + saldo);
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
