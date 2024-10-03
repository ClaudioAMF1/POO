# **Projeto de Alocação de Estudantes em Turmas (Ensalamento)** 👨🏼‍🎓

## **Descrição**

Este projeto foi desenvolvido em **Java** utilizando **Programação Orientada a Objetos (POO)**, e tem como objetivo alocar estudantes, professores e disciplinas em turmas, um processo chamado de "ensalamento". Cada turma é formada por:
- Um professor, que ministra uma disciplina específica.
- Alunos, que estão matriculados em cursos e disciplinas.
- Disciplinas, que pertencem a um curso específico.

O projeto reflete um cenário educacional em que alunos são matriculados em disciplinas, e essas disciplinas são ministradas por professores em diferentes turmas. O foco principal está na organização dessas relações, utilizando classes que modelam cada entidade do cenário.

## **Estrutura do Projeto** 

O projeto é organizado da seguinte forma, com cada classe representando um conceito chave no processo de ensalamento:

1. **Pessoa**:
   - Uma classe abstrata que serve como base para `Aluno` e `Professor`, compartilhando o atributo comum `nome`.

2. **Aluno**:
   - Extende `Pessoa` e contém a relação de agregação com a classe `Curso`, indicando o curso no qual o aluno está matriculado.

3. **Professor**:
   - Extende `Pessoa` e tem uma relação com `Disciplina`, indicando qual disciplina o professor ministra.

4. **Curso**:
   - Representa um curso da instituição, como "TI" ou "ADM". Contém uma lista de disciplinas associadas.

5. **Disciplina**:
   - Associada a um curso, representa uma matéria específica ministrada por um professor.

6. **Turma**:
   - Reúne um professor, uma disciplina e os alunos matriculados naquela disciplina. A turma organiza essas entidades e exibe suas informações.

7. **Ensalamento**:
   - A classe principal responsável por organizar o processo de criação e alocação dos alunos, professores e disciplinas em turmas. Contém o método `executarEnsalamento`, que organiza todas as operações.

## **Como Executar o Projeto** 👇🏼

### **Pré-requisitos**
- Java Development Kit (JDK) instalado (versão 8 ou superior).
- Um terminal ou ambiente de desenvolvimento como IntelliJ, Eclipse ou Visual Studio Code.

### **Passos para executar**

1. **Clone o repositório para sua máquina local:**
   ```bash
   git clone https://github.com/ClaudioAMF1/POO.git
    ```
   
2. **Navegue até o diretório do projeto:**
   ```bash
   cd trabalho_A1
   ```
   
3. **Compile o código fonte:** No terminal, execute o comando:
    ```bash
    javac trabalho_A1/*.java
    ```
    
4. **Execute o programa:** Após a compilação, execute o programa com o comando:
    ```bash
    java trabalho_A1.Main
    ```
    
5. **Saída esperada:** O programa irá exibir as turmas criadas com seus respectivos professores e alunos matriculados, organizados por disciplina e curso. A saída no console será semelhante a:
    ```bash
    Turma de POO do curso TI
    Professor: Mia
    Alunos matriculados:
     - Alfredo
     - Amélia
     - Bruno
     - Capitú
     - Debra
     
    Turma de Estrutura de Dados do curso TI
    Professor: Saulo
    Alunos matriculados:
     - Norberto
     - Wendel
     - Zoey
     
    Turma de BI do curso ADM
    Professor: Paula
    Alunos matriculados:
     - Ana
     - Bentinho
     - Joelmir
     - Maria
   ```

## **Estrutura de Pastas** 📁

O projeto segue a seguinte estrutura de diretórios:

  ```bash
    trabalho_A1/
    ├── Pessoa.java
    ├── Aluno.java
    ├── Professor.java
    ├── Curso.java
    ├── Disciplina.java
    ├── Turma.java
    ├── Ensalamento.java
    └── Main.java
  ```

## **Explicação das Classes**

### **Pessoa.java**:
- Uma classe abstrata que contém o atributo `nome`, que será compartilhado pelas classes `Aluno` e `Professor`.

### **Aluno.java**:
- Representa os alunos. Cada aluno é associado a um curso (`Curso`) e herda o atributo `nome` de `Pessoa`.

### **Professor.java**:
- Representa os professores. Cada professor ministra uma disciplina (`Disciplina`) e herda o atributo `nome` de `Pessoa`.

### **Curso.java**:
- Um curso da instituição de ensino que possui uma lista de disciplinas associadas.

### **Disciplina.java**:
- Representa uma matéria específica que é parte de um curso. Cada disciplina pertence a um curso.

### **Turma.java**:
- Reúne um professor, uma disciplina e os alunos matriculados naquela disciplina, formando uma turma.

### **Ensalamento.java**:
- Classe principal que organiza o processo de alocação de alunos em turmas. Cria os cursos, professores, alunos e turmas, e realiza a alocação de forma dinâmica.

### **Main.java**:
- Classe principal que contém o método `main`, responsável por iniciar o processo de ensalamento chamando `executarEnsalamento()` da classe `Ensalamento`.

---

Desenvolvido como parte de um exercício de programação orientada a objetos em Java.
