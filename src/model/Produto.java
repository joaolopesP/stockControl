package model;

public abstract class Produto {
    
    private int codigo;
    private String nome;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private double preco;
    private int quantidade;
    private int estoqueMinimo;

    public Produto(){

    };
     public Produto(int codigo, String nome, Categoria categoria,Fornecedor fornecedor, double preco, int quantidade, int estoqueMinimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.preco = preco;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }
     public int getCodigo() {
         return codigo;
     }
     public void setCodigo(int codigo) {
         this.codigo = codigo;
     }
     public String getNome() {
         return nome;
     }
     public void setNome(String nome) {
         this.nome = nome;
     }
     public Categoria getCategoria() {
         return categoria;
     }
     public void setCategoria(Categoria categoria) {
         this.categoria = categoria;
     }
     public Fornecedor getFornecedor() {
         return fornecedor;
     }
     public void setFornecedor(Fornecedor fornecedor) {
         this.fornecedor = fornecedor;
     }
     public double getPreco() {
         return preco;
     }
     public void setPreco(double preco) {
         this.preco = preco;
     }
     public int getQuantidade() {
         return quantidade;
     }
     public void setQuantidade(int quantidade) {
         this.quantidade = quantidade;
     }
     public int getEstoqueMinimo() {
         return estoqueMinimo;
     }
     public void setEstoqueMinimo(int estoqueMinimo) {
         this.estoqueMinimo = estoqueMinimo;
     }

    public void exibirInformacoes() {

        System.out.println("---Exibindo Informações---");
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Fornecedor: " + fornecedor);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Estoque mínimo: " + estoqueMinimo);
    }
}
