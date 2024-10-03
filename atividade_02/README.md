# Controle de Bomba de Combustível ⛽

Este é um programa desenvolvido em Java utilizando princípios de orientação a objetos, que simula a operação de uma bomba de combustível. O sistema gerencia três tipos de combustível (Gasolina, Diesel e Etanol) e permite realizar operações de abastecimento, alteração de preços e quantidades, além de consultar o valor total abastecido.
## Funcionalidades 🛠️

- **Suporte para Múltiplos Combustíveis**: O sistema permite escolher entre Gasolina, Diesel e Etanol.
- **Abastecer por Valor**: O usuário informa um valor, e o sistema calcula a quantidade de litros a ser abastecida.
- **Abastecer por Litros**: O usuário informa uma quantidade de litros, e o sistema calcula o valor total a ser pago.
- **Alterar Preço por Litro**: O preço por litro de cada combustível pode ser ajustado.
- **Alterar Quantidade de Combustível**: O sistema permite modificar a quantidade de combustível disponível na bomba.
- **Consultar Total Abastecido**: O sistema exibe o valor total abastecido para cada tipo de combustível.
- **Opção de Sair**: O usuário pode encerrar o programa corretamente ao selecionar a opção "Sair".

## Estrutura do Projeto 📁

O projeto está organizado da seguinte maneira:

```plaintext
atividade_02/
│
├── TipoCombustivel.java
├── BombaCombustivel.java
└── PostoDeCombustivel.java 
```

- **TipoCombustivel.java**: Enumeração que define os tipos de combustível (Gasolina, Diesel, Etanol).
- **BombaCombustivel.java**: Gerencia as operações da bomba, como o valor por litro, a quantidade de combustível e o valor total abastecido para cada tipo de combustível.
- **PostoDeCombustivel.java**: Classe principal que oferece um menu interativo para o usuário escolher a operação desejada, como abastecimento, alteração de valores e consulta do total abastecido.

## Como Executar 🚀

### Clone o repositório para sua máquina local:
```bash
 https://github.com/ClaudioAMF1/POO
```

### Navegue até o diretório do projeto:
```bash
cd atividade_02
```

### Compilar o projeto:
```bash
javac atividade_02/*.java
```

### Executar o programa:

Após compilar, execute o programa principal com o comando:

```bash
java atividade_02.PostoDeCombustivel
```

**Interação**:
Siga as instruções no terminal para escolher a forma de abastecimento, alterar as configurações da bomba e visualizar o valor total abastecido.
  
## Requisitos 📝
- **Java**: Certifique-se de ter o JDK instalado (Java Development Kit) para compilar e executar o programa.

## Exemplo de Uso 💻

Ao iniciar o programa, o usuário será apresentado a um menu de opções:

Escolha uma opção:
1. Abastecer por valor
2. Abastecer por litros
3. Alterar valor do litro
4. Alterar quantidade de combustível na bomba
5. Ver valor total abastecido
6. Sair

O usuário pode então selecionar a opção desejada, seguida da escolha do tipo de combustível:

Escolha o tipo de combustível:
   1. Gasolina
   2. Diesel
   3. Etanol

Dependendo da operação escolhida, o sistema solicitará as entradas apropriadas (como valor a ser abastecido ou quantidade de litros) e exibirá os resultados.

**Saída Esperada**:

- Abastecimento por Valor:

        Abastecido: 20.00 litros de GASOLINA

- Abastecimento por Litros:

        Valor a pagar: R$ 120.00 por 20.00 litros de DIESEL

- Total Abastecido:

      Valor total abastecido de ETANOL: R$ 500.00
  
- Sair do Programa:

        Encerrando o programa...

Basta seguir as instruções e fornecer os valores conforme solicitado para realizar as operações desejadas.

##### Desenvolvido como parte de um exercício de programação orientada a objetos em Java.
