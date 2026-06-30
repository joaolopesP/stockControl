package builder;

import model.Categoria;
import model.Fornecedor;
import model.Produto;

public interface ProdutoBuilder {

    void criarProduto();

    void setCodigo(int codigo);

    void setNome(String nome);

    void setCategoria(Categoria categoria);

    void setFornecedor(Fornecedor fornecedor);

    void setPreco(double preco);

    void setQuantidade(int quantidade);

    void setEstoqueMinimo(int estoqueMinimo);

    


    Produto getProduto();
}