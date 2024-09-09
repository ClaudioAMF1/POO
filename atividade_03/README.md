# Controle de Estacionamento 🅿️

Este é um programa desenvolvido em **Java** utilizando princípios de **orientação a objetos**, que simula o controle de bilhetagem de um edifício de estacionamento. O sistema gerencia diferentes tipos de veículos (motocicletas, carros de passeio, caminhonetes e furgões), permitindo classificar os veículos, verificar se podem estacionar e calcular o valor a ser cobrado por hora.

## Funcionalidades 🛠️

- **Classificação Automática de Veículos**:
  - Suporta motocicletas, carros de passeio (hatchback, sedan, SUV), caminhonetes e furgões.
  
- **Verificação de Aceitação**:
  - O sistema verifica se o veículo pode estacionar com base no peso, volume e regras específicas.

- **Cálculo de Tarifas**:
  - O valor por hora de estacionamento é calculado automaticamente com base nas características do veículo.

- **Simples Interação com o Usuário**:
  - O sistema pergunta ao usuário sobre o tipo e peso do veículo e exibe o valor por hora e se o veículo pode estacionar.

## Estrutura do Projeto 📁

O projeto está organizado da seguinte maneira:

``` bash
atividade_03/
├── Veiculo.java
├── Motocicleta.java
├── CarroDePasseio.java
├── Caminhonete.java
├── Furgao.java
└── GaragemEstacionamento.java
```

- **Veiculo.java**: Classe abstrata que serve como base para todos os veículos.
- **Motocicleta.java**: Gerencia a verificação e tarifação de motocicletas.
- **CarroDePasseio.java**: Classe para carros de passeio (hatchback, sedan, SUV).
- **Caminhonete.java**: Gerencia as caminhonetes, tanto carregadas quanto não carregadas.
- **Furgao.java**: Gerencia furgões, verificando peso e volume.
- **GaragemEstacionamento.java**: Classe principal que oferece um menu interativo para o usuário inserir os dados do veículo e obter as informações.

## Como Executar 🚀

### Compilar o projeto:

Navegue até a pasta onde estão os arquivos `.java` e compile os arquivos utilizando o seguinte comando:

```bash
javac *.java
```

### Executar o programa:

Após compilar, execute o programa principal com o comando:

```bash
java GaragemEstacionamento
```

## Requisitos 📝

- **Java**:  Certifique-se de ter o JDK (Java Development Kit) instalado para compilar e executar o programa.

## Exemplo de Uso 💻

Ao iniciar o programa, o usuário será perguntado sobre o tipo de veículo e suas carecterísticas, como o peso ou volume. O sistema classificará o veículo e retornará o valor por hora e se o veículo pode ou não estacionar.

### Exemplo de Saída:

```scss
Deseja informar um novo veículo? (sim/nao)
sim
Informe o tipo de veículo (motocicleta, carro de passeio, caminhonete, furgao):
motocicleta
Informe o peso da motocicleta (kg):
150
O valor por hora para estacionar esta Motocicleta é R$ 4,00
```

Basta seguir as instruções para informar os dados dos veículos e o sistema calculará as tarifas de estacionamento e verificará a aceitação.

-------
Desenvolvido como parte de um exercício de programação orientada a objetos em Java.
