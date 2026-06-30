package builder;

import model.ProdutoPerecivel;

import java.time.LocalDate;

import model.Categoria;
import model.Fornecedor;
import model.Produto;

public class ProdutoPerecivelBuilder implements ProdutoBuilder{

    private ProdutoPerecivel produto;

    @Override
    public void criarProduto() {
        produto = new ProdutoPerecivel();
    }

    @Override
    public void setCodigo(int codigo) {
        produto.setCodigo(codigo);
    }
    @Override
    public void setNome(String nome) {
        produto.setNome(nome);
    }

    @Override
    public void setCategoria(Categoria categoria) {
        produto.setCategoria(categoria);        
    }

    @Override
    public void setFornecedor(Fornecedor fornecedor) {
        produto.setFornecedor(fornecedor);
    }

    @Override
    public void setPreco(double preco) {
        produto.setPreco(preco);    
    }

    @Override
    public void setQuantidade(int quantidade) {
        produto.setQuantidade(quantidade);
    }

    @Override
    public void setEstoqueMinimo(int estoqueMinimo) {
        produto.setEstoqueMinimo(estoqueMinimo);
    }
    
     public void setDataValidade(LocalDate dataValidade) {
        produto.setDataValidade(dataValidade);
    }

    @Override
    public Produto getProduto() {
        return produto;
    }
}
