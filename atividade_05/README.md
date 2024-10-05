# Sistema de Cadastro de Pessoas

Este projeto é uma continuação da [atividade 04](https://github.com/ClaudioAMF1/POO/tree/main/atividade_04) Ele  implementa um sistema de cadastro de pessoas que inclui clientes, clientes VIP, funcionários e gerentes. O sistema mantém os cadastros de maneira controlada, limitando a quantidade de funcionários e gerentes conforme as regras de negócio estabelecidas.

## Funcionalidades

- **Cadastro de Pessoas:**
  - Cadastro de clientes (comuns e VIP) sem limites de quantidade.
  - Cadastro de funcionários, limitado a no máximo 7 funcionários.
  - Cadastro de um gerente, limitado a 1 gerente por empresa.
  - O sistema utiliza uma exceção personalizada (`QuantidadeExcedidaException`) para controlar o limite de funcionários e gerente.

- **Impressão do Cadastro:**
  - Lista e imprime todos os dados das pessoas cadastradas, separando por clientes, funcionários e gerente.
  - Exibe o imposto sobre o salário de funcionários (5%) e do gerente (3%).
    
- **Exceções:**

  - Quando o limite de funcionários ou gerente for excedido, o sistema lança a exceção `QuantidadeExcedidaException` com uma mensagem indicando o tipo de vaga que excedeu a quantidade.
 
  - ## Diagramas de Classes
 
   ```plaintext
                        +---------------------+
                        |      Pessoa         |
                        |---------------------|
                        | nome : String       |
                        | nascimento : Data   |
                        | cpf : String        |
                        |---------------------|
                        | +imprimeDados()     |
                        +---------------------+
                                  |
                +-----------------+------------------+
                |                                    |
       +--------------------+               +------------------+
       | Cliente            |               | Funcionario      |
       |--------------------|               |------------------|
       | codigo : int       |               | salario : float  |
       |--------------------|               |------------------|
       | +imprimeDados()    |               | +calculaImposto()|
       +--------------------+               +------------------+
                |
       +-----------------------+
       | ClienteVip            |
       |-----------------------|
       | percentualDesconto :  |
       | double                |
       +-----------------------+

                        +------------------------+
                        |        Gerente         |
                        |------------------------|
                        | area : String          |
                        |------------------------|
                        | +calculaImposto()      |
                        +------------------------+
  ```


## Estrutura do Projeto

- **Pessoa.java**: Representa uma pessoa com nome, data de nascimento e CPF.
  
- **Cliente.java**: Representa um cliente comum, herda de `Pessoa` e adiciona o código do cliente.
  
- **ClienteVip.java**: Representa um cliente VIP, herda de `Cliente` e adiciona o atributo `percentualDesconto`.
  
- **Funcionario.java**: Herda de `Pessoa` e adiciona o salário, implementando o cálculo de imposto (5% do salário).
  
- **Gerente.java**: Herda de `Funcionario` e adiciona a área de atuação, implementando o cálculo de imposto (3% do salário).
  
- **Data.java**: Representa uma data com dia, mês e ano.
  
- **PessoaService.java**: Classe principal com as regras de negócio, como controle de limites e gerenciamento de registros.
  
- **QuantidadeExcedidaException.java**: Exceção personalizada para controlar os limites de funcionários e gerentes.
  
- **CadastroPessoas.java**: Classe que testa o código interativamente com o usuário, utilizando uma CLI (Interface de Linha de Comando) para permitir o cadastro de clientes, funcionários, gerente e listagem de pessoas cadastradas.
  
- **TestaCadastro.java**: Classe para testes **hardcoded**, simulando o cadastro de clientes, funcionários e gerente, e testando os limites do sistema de forma automatizada.


## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/ClaudioAMF1/POO/tree/main
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd atividade_05
   ```
3. Compile o projeto: (CLI)
   ```bash
   javac CadastroPessoas.java
   ```
   ou (hardcoded):
   ```bash
   javac TestaCadastro.java
   ```
4.  Execute o programa:(CLI)
    ```bash
    java CadastroPessoas
    ```
    ou (hardcoded):
    ```bash
    java TestaCadastro
    ```

## Exemplo de Uso

```plaintext
=== MENU DE CADASTRO ===
1. Cadastrar Cliente
2. Cadastrar Cliente VIP
3. Cadastrar Funcionario
4. Cadastrar Gerente
5. Listar todas as Pessoas Cadastradas
6. Sair
Escolha uma opção: 1

=== Cadastro de Cliente ===
Digite o nome do cliente: João Silva
Digite o CPF do cliente (11 dígitos): 12345678901
Digite o código do cliente: 101
Cliente cadastrado com sucesso!

[...]

=== Listagem de Pessoas Cadastradas ===
--- Clientes ---
Nome: João Silva, CPF: 12345678901, Nascimento: 10/5/1990, Código: 101

--- Funcionários ---
Nome: Funcionario 1, CPF: 11111111111, Salário: 2600.0
Imposto sobre o salário: 130.0

--- Gerente ---
Nome: Fernanda Lima, CPF: 55566677788, Área: TI, Salário: 5000.0
Imposto sobre o salário: 150.0
```

## Tratamento de Exceções
- Se tentar cadastrar mais de 7 funcionários ou mais de 1 gerente, o sistema lançará a exceção `QuantidadeExcedidaException` com uma mensagem específica.
- As exceções são tratadas de maneira a interromper o cadastro imediatamente quando o limite é excedido.

## Tecnologias Utilizadas

- Java 8+
- POO

------

Exercício desenvolvido para matéria de POO
