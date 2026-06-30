package model;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    
    private LocalDate dataValidade;

    public ProdutoPerecivel() {
        super();
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate data) {
        this.dataValidade = data;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Data de Validade: " + dataValidade);
    }
    
}
