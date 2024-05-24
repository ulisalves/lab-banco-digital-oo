import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao1, opcao2, tipoDeConta;
        boolean cond1 = true, cond2 = true;
        String nome;
        double valor;
        List<Cliente> clientes = new ArrayList<>();
        List<Conta> contas = new ArrayList<>();

    System.out.println("Bem vindo ao seu banco digital! Digite a Opção Desejada.");

        while (cond1) {

            System.out.println("|0| Sair - |1| Cadastrar cliente |2| Listar clientes");
            opcao1 = scanner.nextInt();

            switch (opcao1) {
                case 0 -> {
                    System.out.println("Obrigado pela preferência.");
                    cond1 = false;
                }

                case 1 -> {
                    System.out.println("Informe o nome do cliente.");
                    nome = scanner.next();
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);
                    clientes.add(cliente);

                    while (cond2){
                        System.out.println("Informe o tipo de conta: |1| CC |2| Poupança");
                        tipoDeConta = scanner.nextInt();
                        if (tipoDeConta == 1) {
                            Conta cc = new ContaCorrente(cliente);
                            contas.add(cc);
                            cond2 = false;
                       }
                        else if (tipoDeConta == 2) {
                                Conta poupanca = new ContaPoupanca(cliente);
                                contas.add(poupanca);
                                cond2 = false;
                                }
                            else {
                                System.out.println("Opção inválida.");
                            }
                    }
                    System.out.println("Informe opção desejada");
                    System.out.println("|1|-Cadastrar novo |2|-Depositar |3|-Listar |0|-Sair ");
                    opcao2 = scanner.nextInt();

                    switch (opcao2) {
                        case 0 -> {
                            cond1 = false;
                        }

                        case 1 -> {
                            System.out.println();
                        }

                        case 2 -> {
                            System.out.println("Informe o valor a transferir");
                            valor = scanner.nextDouble();
                            contas.getLast().depositar(valor);
                            contas.getLast().imprimirExtrato();
                            cond1 = false;

                        }

                        case 3 -> {
                            opcao1 = 2;
                        }

                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                }

                case 2 -> {
                    for (Cliente c: clientes) {
                        System.out.println("Cliente: "+c.getNome());
                    }
                cond1=false;
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

           // cc.depositar(100);
           // cc.transferir(100, poupanca);

           //cc.imprimirExtrato();
           // poupanca.imprimirExtrato();
    }
}
