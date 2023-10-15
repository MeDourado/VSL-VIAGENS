package principal;

import principal.DAO.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;
        while(executando) {
            System.out.println("Bem vindo ao sistema  do VSL - VIAGENS");
            System.out.println("1. Cliente");
            System.out.println("2. Passagem");
            System.out.println("3. Voos");
            System.out.println("4. Destinos");
            System.out.println("5. Fale Conosco");
            System.out.println("6. Sair");

            String escolha = scanner.nextLine();


            switch (escolha) {
                case "1":
                    menuCliente();
                    break;
                case "2":
                    menuPassagem();
                    break;
                case "3":
                    menuVoos();
                    break;
                case "4":
                    menuDestinos();
                    break;
                case "5":
                    menuFaleConosco();
                    break;
                case "6":

                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
    }

    public static void menuCliente() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem vindo, Cliente!");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Deletar Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("5. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Opção: Adicionar Cliente");
                        Cliente cliente = new Cliente();
                        System.out.print("Nome:");
                        scanner.nextLine();
                        cliente.setNome(scanner.nextLine());
                        System.out.print("Email:");
                        cliente.setEmail(scanner.nextLine());
                        System.out.print("Senha:");
                        cliente.setSenha(scanner.nextLine());
                        System.out.print("Telefone:");
                        cliente.setTelefone(scanner.nextLine());
                        System.out.print("Cpf:");
                        cliente.setCpf(scanner.nextLine());
                        clienteDAO.cadastrarCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso");
                        break;
                    case 2:
                        System.out.println("Opção: Atualizar Cliente");
                        // clienteDAO.atualizarCliente();
                        break;
                    case 3:
                        System.out.println("Opção: Deletar Cliente");
                        // clienteDAO.deletarCliente();
                        break;
                    case 4:
                        System.out.println("Opção: Consultar Cliente");
                        // clienteDAO.consultarCliente();
                        break;
                    case 5:
                        clienteDAO.fecharConexao();
                        System.out.println("Saindo do menu Cliente...");
                        return; // Encerra o loop e a função
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você deve inserir um número válido.");
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
    }

    public static void menuPassagem() {
        PassagensDAO passagensDAO = new PassagensDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Area - Passagens!");
            System.out.println("1. Comprar Passagem");
            System.out.println("2. Cancelar Passagem");
            System.out.println("3. Consultar Passagem");
            System.out.println("4. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Opção: Comprar Passagem");
                        // clienteDAO.adicionarCliente();
                        break;
                    case 2:
                        System.out.println("Opção: Cancelar Passagem");
                        // clienteDAO.atualizarCliente();
                        break;
                    case 3:
                        System.out.println("Opção: Consultar Passagem");
                        // clienteDAO.consultarCliente();
                        break;
                    case 4:
                        System.out.println("Saindo da area de passagem...");
                        return; // Encerra o loop e a função
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você deve inserir um número válido.");
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
    }

    public static void menuVoos() {
        VoosDAO voosDAO = new VoosDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Area - Voos!");
            System.out.println("1. Consultar Voo");
            System.out.println("2. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Opção: Consultar Voo");
                        break;
                    case 2:
                        System.out.println("Saindo da area de voo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você deve inserir um número válido.");
                scanner.nextLine();
            }
        }
    }

    public static void menuFaleConosco() {
        FaleConoscoDAO faleConoscoDAO = new FaleConoscoDAO();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Area - Fale Conosco!");
            System.out.println("1. Enviar Mensagem");
            System.out.println("2. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Enviar Mensagem");
                        break;
                    case 2:
                        System.out.println("Saindo da area de fale conosco...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você deve inserir um número válido.");
                scanner.nextLine();
            }
        }

    }

    public static void menuDestinos() {
        DestinoDAO destinoDAO = new DestinoDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Area - Fale Conosco!");
            System.out.println("1. Adicionar Destino");
            System.out.println("2. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Adicionar Destino");
                        break;
                    case 2:
                        System.out.println("Saindo da area de destino...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Erro: Você deve inserir um número válido.");
                scanner.nextLine();
            }
        }

    }
}