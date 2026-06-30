package service;

import model.Produto;
import java.util.ArrayList;

public class EstoqueService {

    private ArrayList<Produto> produtos;

    public EstoqueService() {
        produtos = new ArrayList<>();
    }

    public boolean cadastrarProduto(Produto produto) {
        if (buscarProduto(produto.getCodigo()) != null) {
            System.out.println("Produto com código " + produto.getCodigo() + " já existe.");
            return false;
        }

        produtos.add(produto);
        System.out.println("PRODUTO CADASTRADO COM SUCESSO!");
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Código: " + produto.getCodigo());
        return true;
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto produto : produtos) {
            produto.exibirInformacoes();
            System.out.println();
        }
    }

    public Produto buscarProduto(int codigo) {

        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public void entradaEstoque(int codigo, int quantidade) {
        Produto produto = buscarProduto(codigo);

        while(quantidade <= 0) {
            System.out.println("Quantidade inválida! Digite um valor maior que zero.");
            return;
        }

        if (produto != null) {
            produto.setQuantidade(produto.getQuantidade() + quantidade);
            System.out.println("\n==================================");
            System.out.println("ENTRADA DE ESTOQUE REALIZADA");
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Quantidade atual: " + produto.getQuantidade());
            System.out.println("==================================");

        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void saidaEstoque(int codigo, int quantidade) {
        while(quantidade <= 0) {
            System.out.println("Quantidade inválida! Digite um valor maior que zero.");
            return;
        }
        Produto produto = buscarProduto(codigo);


        if (produto != null) {

            if (produto.getQuantidade() >= quantidade) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                System.out.println("\n==================================");
                System.out.println("SAÍDA DE ESTOQUE REALIZADA");
                System.out.println("Produto: " + produto.getNome());
                System.out.println("Quantidade atual: " + produto.getQuantidade());
                System.out.println("==================================");
            } else {
                System.out.println("Estoque insuficiente.");
            }

        }else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void removerProduto(int codigo) {

        Produto produto = buscarProduto(codigo);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto" + produto.getNome()+" id:" + produto.getCodigo() + " removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
