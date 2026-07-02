package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import builder.DiretorProduto;
import builder.ProdutoBuilder;
import builder.ProdutoEletronicoBuilder;
import builder.ProdutoPerecivelBuilder;
import model.Produto;
import service.EstoqueService;
import model.Categoria;
import model.Fornecedor;
import model.ProdutoEletronico;
import model.ProdutoPerecivel;

public class Menu {

    private Scanner sc;
    private EstoqueService estoque;

    public Menu(Scanner sc, EstoqueService estoque) {
        this.sc = sc;
        this.estoque = estoque;
    }

    public void cadastrarProduto() {

        System.out.println("\n=== TIPO DE PRODUTO ===");
        System.out.println("1 - Eletrônico");
        System.out.println("2 - Perecível");
        System.out.print("Escolha: ");
        int tipo = sc.nextInt();

        int codigo = lerCodigo();
        String nome = lerNome();
        String nomeCategoria = lerCategoria();
        Categoria categoria = new Categoria(1, nomeCategoria);
        String nomeFornecedor = lerNomeFornecedor();
        int idFornecedor = lerIdFornecedor();
        String telefoneFornecedor = lerTelefoneFornecedor();

        Fornecedor fornecedor = new Fornecedor(idFornecedor, nomeFornecedor, telefoneFornecedor);

        double preco = lerPreco();
        int quantidade = lerQuantidade();
        int estoqueMinimo = lerEstoqueMinimo();

        ProdutoBuilder builder;

        if (tipo == 1) {
            builder = new ProdutoEletronicoBuilder();
        } else {
            builder = new ProdutoPerecivelBuilder();
        }

        DiretorProduto diretor = new DiretorProduto(builder);

        Produto produto = diretor.construirProduto(
                codigo,
                nome,
                categoria,
                fornecedor,
                preco,
                quantidade,
                estoqueMinimo);

        if (produto instanceof ProdutoEletronico) {

            ProdutoEletronico eletronico = (ProdutoEletronico) produto;
            sc.nextLine();
            eletronico.setMarca(lerMarca());
            eletronico.setGarantiaMeses(lerGarantia());
        }

        if (produto instanceof ProdutoPerecivel) {
            ProdutoPerecivel perecivel = (ProdutoPerecivel) produto;
            sc.nextLine();
            perecivel.setDataValidade(lerDataValidade());
        }
        estoque.cadastrarProduto(produto);
    }

    public void entradaEstoque() {
        System.out.print("Código do produto: ");
        int codigo = sc.nextInt();
        System.out.print("Quantidade entrada: ");
        int qtd = sc.nextInt();
        estoque.entradaEstoque(codigo, qtd);
    }

    public void saidaEstoque() {
        System.out.print("Código do produto: ");
        int codigo = sc.nextInt();
        System.out.print("Quantidade saída: ");
        int qtd = sc.nextInt();
        estoque.saidaEstoque(codigo, qtd);
    }

    public void removerProduto() {
        System.out.print("Código do produto: ");
        int codigo = sc.nextInt();
        estoque.removerProduto(codigo);
    }

    public void buscarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = sc.nextInt();
        Produto produto = estoque.buscarProduto(codigo);
        if (produto != null) {
            System.out.println("\n===== PRODUTO ENCONTRADO =====");
            produto.exibirInformacoes();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private int lerCodigo() {
        int codigo;
        while (true) {
            try {
                System.out.print("Código: ");
                codigo = sc.nextInt();
                sc.nextLine();
                if (codigo <= 0) {
                    System.out.println("O código deve ser maior que zero.");
                    continue;
                }
                if (estoque.buscarProduto(codigo) != null) {
                    System.out.println("Já existe um produto cadastrado com esse código.");
                    continue;
                }
                return codigo;
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        }
    }

    private String lerNome() {
        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = sc.nextLine();
            if (!nome.isBlank()) {
                return nome;
            }
            System.out.println("O nome é obrigatório.");
        }
    }

    private double lerPreco() {
        double preco;
        while (true) {
            try {
                System.out.print("Preço: ");
                preco = sc.nextDouble();
                if (preco > 0) {
                    return preco;
                }
                System.out.println("Preço inválido.");
            } catch (InputMismatchException e) {

                System.out.println("Digite apenas números.");

                sc.nextLine();
            }
        }
    }

    private int lerQuantidade() {
        int quantidade;
        while (true) {
            try {
                System.out.print("Quantidade: ");
                quantidade = sc.nextInt();
                if (quantidade >= 0) {
                    return quantidade;
                }
                System.out.println("Quantidade inválida.");
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        }
    }

    private int lerEstoqueMinimo() {
        int estoque;
        while (true) {
            try {
                System.out.print("Estoque mínimo: ");
                estoque = sc.nextInt();
                if (estoque >= 0) {
                    return estoque;
                }
                System.out.println("Estoque mínimo inválido.");
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        }
    }

    private String lerCategoria() {
        String categoria;
        while (true) {
            System.out.print("Categoria: ");
            categoria = sc.nextLine();
            if (!categoria.isBlank()) {
                return categoria;
            }
            System.out.println("O nome da categoria é obrigatório.");
        }
    }

    private String lerNomeFornecedor() {
        String nomeFornecedor;
        while (true) {
            System.out.print("Fornecedor: ");
            nomeFornecedor = sc.nextLine();
            if (!nomeFornecedor.isBlank()) {
                return nomeFornecedor;
            }
            System.out.println("O nome do fornecedor é obrigatório.");
        }
    }

    private int lerIdFornecedor() {
        int idFornecedor;
        while (true) {
            System.out.print("ID do fornecedor: ");
            idFornecedor = sc.nextInt();
            if (idFornecedor > 0) {
                return idFornecedor;
            }
            System.out.println("O ID do fornecedor deve ser maior que zero.");
        }
    }

    private String lerTelefoneFornecedor() {
        sc.nextLine();
        String telefone;
        while (true) {
            System.out.print("Telefone do fornecedor: ");
            telefone = sc.nextLine();
            if (!telefone.isBlank()) {
                return telefone;
            }
            System.out.println("O telefone do fornecedor é obrigatório.");
        }
    }

    private LocalDate lerDataValidade() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Data de validade (dd/MM/yyyy): ");
                String data = sc.nextLine();

                return LocalDate.parse(data, formatter);
            } catch (Exception e) {
                System.out.println("Data inválida.");
            }
        }
    }

    private String lerMarca() {
        String marca;

        while (true) {
            System.out.print("Marca: ");
            marca = sc.nextLine();

            if (!marca.isBlank()) {
                return marca;
            }

            System.out.println("Informe a marca.");
        }
    }

    private int lerGarantia() {
        int garantia;

        while (true) {
            try {
                System.out.print("Garantia (meses): ");
                garantia = sc.nextInt();

                if (garantia >= 0) {
                    return garantia;
                }

                System.out.println("Garantia inválida.");
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        }
    }
}