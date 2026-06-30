# 📦 StockControl

Sistema de controle de estoque desenvolvido em **Java** como Projeto Integrador, aplicando os principais conceitos de **Programação Orientada a Objetos (POO)** e o padrão de projeto **Builder**.

## 📖 Sobre o projeto

O StockControl é um sistema de gerenciamento de estoque que permite cadastrar produtos, controlar entradas e saídas de mercadorias e consultar informações dos produtos cadastrados.

O projeto foi desenvolvido com foco na aplicação de conceitos fundamentais da orientação a objetos, organização em camadas e utilização de padrões de projeto.

---

## ✨ Funcionalidades

* ✅ Cadastro de produtos eletrônicos
* ✅ Cadastro de produtos perecíveis
* ✅ Entrada de estoque
* ✅ Saída de estoque
* ✅ Busca de produtos por código
* ✅ Remoção de produtos
* ✅ Validação dos dados informados pelo usuário

---

## 🛠️ Tecnologias utilizadas

* Java
* Programação Orientada a Objetos (POO)
* Builder Pattern
* Eclipse IDE

---

## 📂 Estrutura do projeto

```text
src
├── builder
│   ├── DiretorProduto.java
│   ├── ProdutoBuilder.java
│   ├── ProdutoEletronicoBuilder.java
│   └── ProdutoPerecivelBuilder.java
│
├── model
│   ├── Produto.java
│   ├── ProdutoEletronico.java
│   ├── ProdutoPerecivel.java
│   ├── Categoria.java
│   └── Fornecedor.java
│
├── service
│   └── EstoqueService.java
│
└── util
    └── Menu.java
```

---

## 🧱 Conceitos aplicados

Durante o desenvolvimento foram utilizados diversos conceitos da Programação Orientada a Objetos:

* Encapsulamento
* Herança
* Polimorfismo
* Abstração

Também foi aplicado o padrão de projeto **Builder**, responsável por organizar o processo de construção dos objetos `Produto`.

---

## 🚀 Fluxo do sistema

```text
Usuário

↓

Menu

↓

Escolha do tipo de produto

↓

Builder

↓

DiretorProduto

↓

Produto

↓

EstoqueService

↓

Estoque (ArrayList)
```

---

## ▶️ Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/StockControl.git
```

2. Abra o projeto no Eclipse.

3. Execute a classe que contém o método `main()`.

---

## 📚 Objetivo acadêmico

Este projeto foi desenvolvido para fins acadêmicos, com o objetivo de praticar:

* Programação Orientada a Objetos
* Organização de código em pacotes
* Padrões de Projeto (Builder)
* Estruturação de aplicações Java

---

## 👨‍💻 Autor

**Arthur Lemos**

Projeto desenvolvido como atividade do Projeto Integrador.
