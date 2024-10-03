# Atividade: Sistema de Cadastro de Pessoas🙋🏼‍♂️🙋🏼‍♀️

## Descrição

Este projeto implementa um **sistema de cadastro de pessoas** baseado em um diagrama de classes. O sistema permite o cadastro de três tipos de pessoas: `Cliente`, `Funcionario`, e `Gerente`. O cadastro é armazenado em um **array fixo**, e o sistema oferece funcionalidades para acessar, imprimir e remover registros de pessoas.

## Funcionalidades

1. **Cadastro de Pessoas**:
   - O sistema permite o cadastro de:
     - `Cliente`: Inclui nome, data de nascimento e código.
     - `Funcionario`: Inclui nome, data de nascimento e salário.
     - `Gerente`: Inclui nome, data de nascimento, salário e área de atuação.
   
2. **Impressão do Cadastro**:
   - O sistema imprime todas as pessoas cadastradas no formato correto, mostrando suas informações específicas.

3. **Acesso pelo Índice**:
   - O usuário pode acessar as informações de uma pessoa cadastrada fornecendo o índice no array.

4. **Remoção de Pessoas**:
   - O usuário pode remover uma pessoa do cadastro fornecendo o índice. O array é reordenado automaticamente.

5. **Tratamento de Exceções**:
   - Tratamento de exceções para evitar acessos inválidos ao array e entradas incorretas de dados.
   - O sistema lida com entradas inválidas do usuário (como caracteres em vez de números).

## Diagrama de Classes

O sistema foi desenvolvido com base no seguinte diagrama de classes:

![Screenshot 2024-10-03 101937](https://github.com/user-attachments/assets/fd088b73-f126-435d-86c9-673fff8a9311)


## Estrutura do Projeto

- `Data.java`: Representa a data de nascimento com os campos dia, mês e ano.
- `Pessoa.java`: Classe abstrata que serve como base para `Cliente`, `Funcionario`, e `Gerente`.
- `Cliente.java`: Herda de `Pessoa` e adiciona o atributo `codigo`.
- `Funcionario.java`: Herda de `Pessoa` e adiciona o atributo `salario`. Implementa o cálculo de imposto (3% do salário).
- `Gerente.java`: Herda de `Funcionario` e adiciona o atributo `area`. Implementa um cálculo de imposto diferenciado (5% do salário).
- `CadastroPessoas.java`: Gerencia o cadastro de pessoas, permitindo a inserção, impressão, acesso e remoção de registros.
- `TestaCadastro.java`: Classe principal com um menu interativo para executar as funcionalidades do sistema.

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/ClaudioAMF1/POO/tree/main/atividade_04
    ```
2. Compile o projeto utilizando o javac:
    ```bash
    javac *.java
    ```
3. Execute o programa:
    ```bash
    java TestaCadastro
    ```

## Exemplo de Uso

### Menu
Ao executar o programa, o seguinte menu será exibido:
```
Escolha uma opção:
1 - Cadastrar Cliente
2 - Cadastrar Funcionario
3 - Cadastrar Gerente
4 - Imprimir Cadastro
5 - Acessar pessoa por índice
6 - Remover pessoa por índice
7 - Sair
```

**Cadastro de um Ciente**
- Nome: João Silva
- Data de nascimento: 15/03/1985 (inserir dia, depois mês e por fim ano)
- Código: 101

**Impressão do Cadastro**
Após cadastrar, o sistema exebirá:
```
Cliente: João Silva, Código: 101, Nascimento: 15/3/1985
```

## Tratamento de Exceções
- Se o usuário tentar acessar ou remover uma pessoa com um índice inválido (fora do intervalo), o sistema exibirá uma mensagem de erro.
- Se o usuário tentar inserir um valor inválido (como texto em vez de número), o sistema solicitará uma nova entrada válida.

## Tecnologias Utilizadas
- Java: Linguagem de programação usada para implementar o sistema.
- Scanner: Usado para capturar a entrada do usuário.

  ---

  Atividade desenvolvida para a matéria de POO
