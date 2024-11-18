# Atividade 8 - CRUD de Produtos com JDBC

## Descrição da Atividade
Sistema desenvolvido em Java para cadastro e gerenciamento de produtos de e-commerce, utilizando JDBC para persistência de dados em MySQL. O projeto implementa operações CRUD completas, seguindo princípios de Orientação a Objetos.

## Tecnologias Utilizadas
- Java 17
- MySQL 8.0
- JDBC
- Maven
- IDE: IntelliJ IDEA

## Requisitos Implementados

### Atributos do Produto
- **Tipo**: Descrição curta para categorização (Ex: informática, limpeza, etc.)
- **Descrição**: Descrição textual detalhada do produto
- **Peso**: Valor em kg para cálculo de frete
- **Quantidade**: Quantidade disponível em estoque
- **Unidade de Medida**: Enum com valores:
    - METRO
    - METRO_QUADRADO
    - LITRO
    - KG

### Funcionalidades CRUD
- ✅ **Create**: Inserção de 5 produtos diferentes
- ✅ **Read**:
    - Listagem de todos os produtos
    - Visualização detalhada de produtos específicos
- ✅ **Update**: Alteração de dados de 2 produtos
- ✅ **Delete**: Remoção de 1 produto

## Implementação

### Estrutura do Projeto
```
src/main/java/com/ecommerce/produto/
├── config/
│   └── DatabaseConnection.java    // Gerencia conexão com banco
├── dao/
│   ├── ProdutoDAO.java           // Interface com métodos CRUD
│   └── ProdutoDAOImpl.java       // Implementação dos métodos
├── model/
│   ├── Produto.java              // Classe modelo do produto
│   └── UnidadeMedida.java        // Enum das unidades
└── Main.java                     // Classe principal/testes
```

### Configuração e Execução

1. **Banco de Dados**
```sql
CREATE DATABASE ecommerce;
USE ecommerce;

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    descricao TEXT NOT NULL,
    peso DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL,
    unidade_medida ENUM('METRO', 'METRO_QUADRADO', 'LITRO', 'KG') NOT NULL
);
```

2. **Dependências Maven**
```xml
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>
```

3. **Configuração do Banco**
- Abrir `DatabaseConnection.java`
- Atualizar credenciais:
```java
private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

4. **Executar o Projeto**
- Executar Main.java
- Verificar saída no console
- Conferir dados no banco

### Funcionalidades Demonstradas no Main

1. **Inserção de Produtos**
```java
Produto p1 = new Produto("Informática", "Notebook Dell", 2.5, 10, UnidadeMedida.KG);
produtoDAO.inserir(p1);
```

2. **Atualização**
```java
p1.setQuantidade(15);
produtoDAO.atualizar(p1);
```

3. **Consultas**
```java
// Lista todos
produtoDAO.listarTodos().forEach(System.out::println);

// Busca específica
System.out.println(produtoDAO.buscarPorId(1));
```

4. **Remoção**
```java
produtoDAO.deletar(5);
```

## Observações
- Dados inseridos via código (hard-coded) para facilitar testes
- Implementado tratamento básico de exceções SQL
- Utilizado padrão DAO para organização do código
- Conexão com banco implementada como Singleton

## Melhorias Possíveis
1. Implementação de testes unitários
2. Interface gráfica para usuário
3. Validações mais robustas
4. Tratamento de exceções mais específico
5. Implementação de logs

---
Desenvolvido para atividade de Programação Orientada a Objetos