package view;

import controller.MenuController;
import exceptions.ClienteInvalidoException;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    MenuController menuController = new MenuController();

    ArrayList<String> opcoesMenu = new ArrayList<>(
            Arrays.asList(
                    "Criar Cliente",
                    "Listar Clientes",
                    "Criar Conta",
                    "Listar Contas",
                    "Sair"
            ));

    public Menu() {
    }

    public void exibirMenu() {
        int numero;
        boolean executando = true;

        do {
            listarMenu();
            numero = Integer.parseInt(menuController.usuarioInput("\nInforme um número: "));

            switch (numero) {
                case 1:
                    try {
                        menuController.criarCliente();
                    } catch (Exception e) {
                        throw new ClienteInvalidoException("Não foi possível cadastrar o cliente.");
                    }
                    break;

                case 2:
                    menuController.listarClientes();
                    break;

                case 3:
                    menuController.criarConta();
                    break;

                case 4:
                    menuController.listarContas();
                    break;

                case 5:
                    System.out.println("\n-=X=- ENCERRANDO O PROGRAMA -=X=-");
                    executando = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        } while (executando);


    }

    public void listarMenu() {
        System.out.println("\n=== MENU ===");
        for (int i = 0; i < opcoesMenu.size(); i++) {
            System.out.printf("%s - %s%n", (i + 1), opcoesMenu.get(i));
        }
    }




}
