package service;

import java.util.ArrayList;
import model.Produto;

public class RelatorioService {

    public void listarProdutos(ArrayList<Produto> produtos) {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("\n===== RELATÓRIO DE PRODUTOS =====");
        for (Produto produto : produtos) {
            produto.exibirInformacoes();
            System.out.println();
        }
    }

    public void listarEstoqueBaixo(ArrayList<Produto> produtos) {

        System.out.println("\n===== PRODUTOS COM ESTOQUE BAIXO =====");
        for (Produto produto : produtos) {
            if (produto.getQuantidade() <= produto.getEstoqueMinimo()) {
                produto.exibirInformacoes();
                System.out.println();
            }
        }
    }

    public void valorTotalEstoque(ArrayList<Produto> produtos) {

        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        System.out.printf("Valor total do estoque: R$ %.2f%n", total);
    }
}
