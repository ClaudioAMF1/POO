# Gerenciador de Cidades - Sistema de Manipulação de Dados

## 📝 Descrição
Este projeto implementa um sistema de gerenciamento de cidades brasileiras utilizando diferentes estruturas de dados do Java Collections Framework. O sistema demonstra várias formas de organização e apresentação dos dados, incluindo agrupamento por UF, ordenação por capitais e ordenação alfabética.

## 🎯 Funcionalidades

O sistema implementa três estruturas diferentes de manipulação de dados:

1. **Estrutura 1: Agrupamento por UF**
   - Agrupa cidades por Unidade Federativa
   - Não permite repetição de UFs
   - Apresenta cidades em ordem alfabética dentro de cada UF

2. **Estrutura 2: Ordenação por Capitais**
   - Identifica cidades que são capitais
   - Apresenta primeiro as capitais, depois as demais cidades
   - Mantém ordenação alfabética dentro de cada categoria

3. **Estrutura 3: Ordenação Decrescente**
   - Apresenta todas as cidades em ordem alfabética decrescente
   - Mantém informação da UF para cada cidade

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Java Collections Framework
- IntelliJ IDEA (IDE recomendada)

## 📦 Estruturas de Dados Utilizadas

- `TreeMap`: Para garantir UFs únicas e ordenadas
- `TreeSet`: Para ordenação das cidades
- `ArrayList`: Para manipulação flexível de listas
- `Comparator`: Para implementar diferentes critérios de ordenação

## 🚀 Como Executar

1. **Pré-requisitos**
   - JDK 17 ou superior instalado
   - IntelliJ IDEA (ou outra IDE Java)

2. **Configuração do Projeto**
   ```bash
   # Clone o repositório ou crie um novo projeto
   # Importe as classes Cidade.java e ProgramaCidades.java
   ```

3. **Executando o Programa**
   - Abra o projeto no IntelliJ IDEA
   - Localize a classe `ProgramaCidades`
   - Execute o método `main`

## 📋 Estrutura do Projeto

```
src/
├── Cidade.java           # Classe modelo para cidades
└── ProgramaCidades.java  # Classe principal com implementações
```

## 📊 Exemplo de Saída

```
=== Estrutura 1: Cidades agrupadas por UF (ordem alfabética) ===
UF: GO
  Anápolis
  Goiânia
  ...

=== Estrutura 2: Cidades ordenadas por capital e nome ===
Belo Horizonte - MG (Capital)
Campo Grande - MS (Capital)
...

=== Estrutura 3: Cidades em ordem alfabética decrescente ===
Unaí - MG
Uberlândia - MG
...
```

## 📝 Notas

- O sistema utiliza boas práticas de programação orientada a objetos
- A implementação prioriza a clareza e manutenibilidade do código
- Todos os requisitos do exercício foram atendidos e validados

---
Desenvolvido para a disciplina de Programação Orientada a Objetos
