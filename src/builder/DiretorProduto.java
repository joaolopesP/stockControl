package builder;

import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class DiretorProduto {

    private ProdutoBuilder builder;

    public DiretorProduto(ProdutoBuilder builder) {
        this.builder = builder;
    }

    public Produto construirProduto(int codigo, String nome, Categoria categoria, Fornecedor fornecedor, double preco, int quantidade, int estoqueMinimo) {
        builder.criarProduto();
        builder.setCodigo(codigo);
        builder.setNome(nome);
        builder.setCategoria(categoria);
        builder.setFornecedor(fornecedor);
        builder.setPreco(preco);
        builder.setQuantidade(quantidade);
        builder.setEstoqueMinimo(estoqueMinimo);
        

        return builder.getProduto();
    }
}