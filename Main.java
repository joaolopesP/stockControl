

import java.util.Scanner;

import service.EstoqueService;
import service.RelatorioService;
import util.Menu;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EstoqueService estoque = new EstoqueService();
        RelatorioService relatorio = new RelatorioService();

        Menu menu = new Menu(sc, estoque);

        int opcao = -1;

        do {

            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Entrada de Estoque");
            System.out.println("4 - Saída de Estoque");
            System.out.println("5 - Remover Produto");
            System.out.println("6 - Buscar Produto");
            System.out.println("7 - Listar Produtos com Estoque Baixo");
            System.out.println("8 - Valor Total do Estoque");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            try{
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    menu.cadastrarProduto();
                    break;

                case 2:
                    relatorio.listarProdutos(estoque.getProdutos());
                    break;

                case 3:
                    menu.entradaEstoque();
                    break;

                case 4:
                    menu.saidaEstoque();
                    break;

                case 5:
                    menu.removerProduto();
                    break;

                case 6:
                    menu.buscarProduto();
                    break;
                
                case 7:
                    relatorio.listarEstoqueBaixo(estoque.getProdutos());
                    break;
                
                case 8:
                    relatorio.valorTotalEstoque(estoque.getProdutos());
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
            }catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                sc.nextLine(); 
            }

        } while (opcao != 0);

        sc.close();
    }
}