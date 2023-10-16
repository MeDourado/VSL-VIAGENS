package principal;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import principal.DAO.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
                        System.out.print("ID do Cliente para atualização: ");
                        int clienteIdAtualizar = scanner.nextInt();
                        Cliente clienteAtualizar = clienteDAO.consultarCliente(clienteIdAtualizar);
                        if(clienteAtualizar != null) {
                            System.out.print("Novo Nome do Cliente: ");
                            scanner.nextLine();
                            clienteAtualizar.setNome(scanner.nextLine());
                            System.out.print("Novo Email do Cliente: ");
                            clienteAtualizar.setEmail(scanner.nextLine());
                            System.out.print("Nova Senha do Cliente: ");
                            clienteAtualizar.setSenha(scanner.nextLine());
                            System.out.print("Novo Telefone do Cliente: ");
                            clienteAtualizar.setTelefone(scanner.nextLine());
                            System.out.print("Novo Cpf do Cliente: ");
                            clienteAtualizar.setCpf(scanner.nextLine());
                            clienteDAO.atualizarCliente(clienteAtualizar);
                            System.out.println("Cliente atualizado com sucesso");
                        }else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;
                    case 3:
                        System.out.println("Opção: Deletar Cliente");
                        System.out.print("ID do Cliente para Deletar: ");
                        int idExcluir = scanner.nextInt();
                        Cliente clienteExcluir = clienteDAO.consultarCliente(idExcluir);
                        if(clienteExcluir != null) {
                            clienteDAO.excluirCliente(idExcluir);
                            System.out.println("Cliente excluido com sucesso");
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }

                        break;
                    case 4:
                        System.out.println("Opção: Consultar Cliente");
                        System.out.print("ID do Cliente para consulta: ");
                        int id = scanner.nextInt();
                        Cliente clienteBuscar = clienteDAO.consultarCliente(id);
                        if(clienteBuscar != null) {
                            System.out.println("Id: " + clienteBuscar.getClienteID() + " , Nome: " + clienteBuscar.getNome() + " , Email: " + clienteBuscar.getEmail() + " , Cpf: " + clienteBuscar.getCpf());
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
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
                        System.out.println("Saindo da area de passagem..");
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
            System.out.println("1. Cadastrar Voo");
            System.out.println("2. Consultar Voo");
            System.out.println("3. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Opção: Cadastrar Voo");
                        Voos voos = new Voos();
                        System.out.print("Piloto:");
                        scanner.nextLine();
                        voos.setPiloto(scanner.nextLine());
                        System.out.print("Data do Voo de ida (dd/mm/yyyy): ");
                        String data_ida = scanner.next();
                        System.out.print("Data do Voo de volta (dd/mm/yyyy): ");
                        String data_volta = scanner.next();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                        try {
                            Date data_ida_voo = sdf.parse(data_ida);
                            Date data_volta_voo = sdf.parse(data_volta);
                            voos.setData_ida(data_ida_voo);
                            voos.setData_volta(data_volta_voo);
                            voosDAO.adicionarVoos(voos);
                            System.out.println("Voo cadastrado com sucesso.");
                        } catch (ParseException e) {
                            System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
                        }
                        break;


                    case 2:
                        System.out.println("Opção: Consultar Voo");
                        System.out.print("Informe o ID do voo a ser consultado: ");
                        int idVoo = scanner.nextInt();
                        Voos vooConsultado = voosDAO.consultarVoos(idVoo);

                        if (vooConsultado != null) {
                            System.out.println("Detalhes do voo:");
                            System.out.println("ID: " + idVoo);
                            System.out.println("Piloto: " + vooConsultado.getPiloto());
                            System.out.println("Data de Ida: " + vooConsultado.getData_ida());
                            System.out.println("Data de Volta: " + vooConsultado.getData_volta());
                        } else {
                            System.out.println("Voo não encontrado.");
                        }

                        break;

                    case 3:
                        voosDAO.fecharConexao();
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
            System.out.println("2. Lista de Destinos");
            System.out.println("3. Sair");

            try {
                System.out.print("Escolha uma opção: ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("Opção - Adicionar Destino");
                        Destino destino = new Destino();
                        scanner.nextLine();
                        System.out.print("Nome do Destino:");
                        destino.setNomeDestino(scanner.nextLine());
                        destinoDAO.adicionarDestino(destino);
                        System.out.println("Destino cadastrado com sucesso");
                        break;
                    case 2:
                        List<Destino> destinos = destinoDAO.listarDestinos();
                        System.out.println("Lista de Destinos");
                        for(Destino d : destinos) {
                            System.out.println("Destino: " + d.getNomeDestino());
                        }
                        break;
                    case 3:
                        destinoDAO.fecharConexao();
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