package builder;

import model.Categoria;
import model.Fornecedor;
import model.Produto;
import model.ProdutoEletronico;

public class ProdutoEletronicoBuilder implements ProdutoBuilder{
    
    private ProdutoEletronico produtoEletronico;

    @Override
    public void criarProduto() {
        produtoEletronico = new ProdutoEletronico();
    }

    @Override
    public void setCodigo(int codigo) {
        produtoEletronico.setCodigo(codigo);
    }

    @Override
    public void setNome(String nome) {
        produtoEletronico.setNome(nome);
    }

    @Override
    public void setCategoria(Categoria categoria) {
        produtoEletronico.setCategoria(categoria);
    }

    @Override
    public void setFornecedor(Fornecedor fornecedor) {
        produtoEletronico.setFornecedor(fornecedor);
    }

    @Override
    public void setPreco(double preco) {
        produtoEletronico.setPreco(preco);
    }

    @Override
    public void setQuantidade(int quantidade) {
        produtoEletronico.setQuantidade(quantidade);
    }

    @Override
    public void setEstoqueMinimo(int estoqueMinimo) {
        produtoEletronico.setEstoqueMinimo(estoqueMinimo);
    }

    public void setMarca(String marca) {
        produtoEletronico.setMarca(marca);
    }

    public void setGarantiaMeses(int garantiaMeses) {
        produtoEletronico.setGarantiaMeses(garantiaMeses);
    }

    @Override
    public Produto getProduto() {
        return produtoEletronico;
    }
}