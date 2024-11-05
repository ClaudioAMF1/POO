# Sistema de Gestão de Estoque

Este projeto implementa um sistema simples de gestão de estoque em Java, utilizando conceitos de Programação Orientada a Objetos e testes unitários com JUnit.

## 📋 Descrição

O sistema consiste em duas classes principais:
- `Produto`: Representa um produto com nome e preço
- `Estoque`: Gerencia uma coleção de produtos com operações básicas de CRUD

## 🚀 Funcionalidades

### Classe Produto
- Criação de produto com nome e preço
- Comparação de produtos por nome
- Ordenação de produtos por preço
- Representação em String através do método toString

### Classe Estoque
- Adicionar produto
- Remover produto
- Buscar produto por nome
- Listar todos os produtos

## 🛠️ Tecnologias Utilizadas

- Java 17
- Maven
- JUnit Jupiter 5.8.2
- IntelliJ IDEA (recomendado)

## 📥 Instalação

1. Clone ou faça download do projeto
2. Abra o projeto no IntelliJ IDEA
3. Aguarde o Maven baixar as dependências
4. Execute os testes com o comando: `mvn test`

### Requisitos
- JDK 17 ou superior
- Maven 3.6 ou superior
- IDE (preferencialmente IntelliJ IDEA)

## ▶️ Como Executar os Testes

### Pelo IntelliJ IDEA:
1. Navegue até a pasta `src/test/java/br/com/minhaempresa`
2. Clique com botão direito em qualquer classe de teste
3. Selecione "Run 'NomeDaClasse'"

### Pelo Terminal:
```bash
mvn clean test
```

## 🧪 Testes Implementados

### EstoqueTest
* `testAdicionarProdutoComSucesso()`
* `testAdicionarProdutoDuplicado()`
* `testRemoverProdutoExistente()`
* `testRemoverProdutoInexistente()`
* `testBuscarProdutoExistente()`
* `testBuscarProdutoInexistente()`
* `testListarProdutosVazio()`
* `testListarProdutosMultiplos()`
* `testListarProdutosAposRemocao()`
* `testAdicionarVarioProdutos()`
* `testRemoverProdutoEAdicionar()`
* `testBuscarProdutoAposRemocao()`
* `testRemoverProdutoDeEstoqueVazio()`
* `testBuscarProdutoEmEstoqueVazio()`

### ProdutoTest
* `testConstrutorEGetters()`
* `testEquals()`
* `testHashCode()`
* `testCompareTo()`
* `testCompareToIguais()`
* `testEqualsNull()`
* `testEqualsDiferenteTipo()`
* `testProdutosDiferentesComMesmoNome()`
* `testProdutosMesmoPrecoComparable()`
* `testProdutoMaiorPrecoComparable()`
* `testProdutoMenorPrecoComparable()`
* `testProdutosIguaisHashCode()`
* `testToStringContemInformacoes()`

## 💡 Conceitos Demonstrados

- Encapsulamento
- Sobrescrita de métodos (equals, hashCode, compareTo, toString)
- Uso de coleções (HashSet)
- Testes unitários
- Uso de annotations do JUnit
- Assertions para validação de testes
- Preparação de ambiente de teste (@BeforeEach)

## 📁 Estrutura do Projeto

```
src/
├── main/java/br/com/minhaempresa/
│   ├── Estoque.java
│   └── Produto.java
└── test/java/br/com/minhaempresa/
    ├── EstoqueTest.java
    └── ProdutoTest.java
```

---
Desenvolvido para a disciplina de Programação Orientada a Objetos
