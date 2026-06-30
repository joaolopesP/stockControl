package model;

public class ProdutoEletronico extends Produto{

    private String marca;
    private int garantiaMeses;

    public ProdutoEletronico() {
        super();
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void exibirInformacoes(){
        super.exibirInformacoes();
        System.out.println("Marca: " + marca);
        System.out.println("Garantia (meses): " + garantiaMeses);
    }
}