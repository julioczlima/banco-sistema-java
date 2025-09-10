package view;

import controller.MenuController;
import exceptions.InputInvalidoException;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    MenuController menuController = new MenuController();


    public Menu() {
    }

    public void listarMenuPrincipal() {
        ArrayList<String> opcoesMenuPrincipal = new ArrayList<>(
                Arrays.asList(
                        "Seção Clientes",
                        "Seção Contas",
                        "Sair"
                ));

        System.out.println("\n=== MENU ===");
        for (int i = 0; i < opcoesMenuPrincipal.size(); i++) {
            System.out.printf("%s - %s%n", (i + 1), opcoesMenuPrincipal.get(i));
        }
    }

    public void exibirMenuPrincipal() {

        int numero = 0;
        boolean executando = true;

        do {
            listarMenuPrincipal();
            try {
                numero = Integer.parseInt(menuController.usuarioInput("\nInforme um número: "));
            } catch (InputInvalidoException | NumberFormatException e) {
                System.out.println("O valor inserido é inválido: " + e.getMessage());
            }

            switch (numero) {
                case 1:
                    exibirMenuClientes();
                    break;

                case 2:
                    exibirMenuContas();
                    break;

                case 3:
                    System.out.println("\n-X- ENCERRANDO PROGRAMA -X-");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (executando);


    }

    public void listarMenuClientes() {
        ArrayList<String> opcoesMenuContas = new ArrayList<>(
                Arrays.asList(
                        "Cadastrar Cliente",
                        "Listar Clientes",
                        "Excluir Cliente",
                        "Editar Cliente",
                        "Sair"
                ));

        System.out.println("\n=== MENU ===");
        for (int i = 0; i < opcoesMenuContas.size(); i++) {
            System.out.printf("%s - %s%n", (i + 1), opcoesMenuContas.get(i));
        }
    }

    public void exibirMenuClientes() {

        int numero = 0;
        boolean executando = true;

        do {
            listarMenuClientes();
            try {
                numero = Integer.parseInt(menuController.usuarioInput("\nInforme um número: "));
            } catch (InputInvalidoException | NumberFormatException e) {
                System.out.println("O valor inserido é inválido: " + e.getMessage());
            }

            switch (numero) {
                case 1:
                    menuController.cadastrarCliente("CADASTRAR CLIENTE");
                    break;

                case 2:
                    menuController.listarClientes("LISTAR CLIENTES");
                    break;

                case 3:
                    System.out.println("Excluir Cliente ainda está em implementação.");
                    ;
                    break;

                case 4:
                    System.out.println("Editar Cliente ainda está em implementação.");
                    ;
                    break;

                case 5:
                    System.out.println("\n-=- RETORNANDO -=-");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (executando);


    }


    public void listarMenuContas() {
        ArrayList<String> opcoesMenuContas = new ArrayList<>(
                Arrays.asList(
                        "Abrir Conta",
                        "Listar Contas",
                        "Depositar",
                        "Sacar",
                        "Transferir",
                        "Sair"
                ));

        System.out.println("\n=== MENU ===");
        for (int i = 0; i < opcoesMenuContas.size(); i++) {
            System.out.printf("%s - %s%n", (i + 1), opcoesMenuContas.get(i));
        }
    }

    public void exibirMenuContas() {

        int numero = 0;
        boolean executando = true;

        do {
            listarMenuContas();
            try {
                numero = Integer.parseInt(menuController.usuarioInput("\nInforme um número: "));
            } catch (InputInvalidoException | NumberFormatException e) {
                System.out.println("O valor inserido é inválido: " + e.getMessage());
            }

            switch (numero) {
                case 1:
                    menuController.abrirConta("ABRIR CONTA");
                    break;

                case 2:
                    menuController.listarContas("LISTAR CONTAS");
                    break;

                case 3:
                    menuController.depositar("DEPOSITAR");
                    break;

                case 4:
                    menuController.sacar("SACAR");
                    break;

                case 5:
                    menuController.transferir("TRANSFERIR");
                    break;

                case 6:
                    System.out.println("\n-==- RETORNANDO -==-");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (executando);


    }


}
