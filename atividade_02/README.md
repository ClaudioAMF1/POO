# Controle de Bomba de Combustível ⛽

Este é um programa desenvolvido em Java utilizando princípios de orientação a objetos, que simula a operação de uma bomba de combustível. O programa permite realizar abastecimentos por valor ou por quantidade de litros, alterar configurações da bomba, e visualizar o valor total já abastecido.

## Funcionalidades 🛠️

- **Abastecer por Valor**: Informa o valor a ser abastecido e calcula a quantidade de litros.
- **Abastecer por Litro**: Informa a quantidade de litros a ser abastecida e calcula o valor total.
- **Alterar Valor do Litro**: Permite alterar o valor cobrado por litro de combustível.
- **Alterar Tipo de Combustível**: Permite alterar o tipo de combustível da bomba.
- **Alterar Quantidade de Combustível na Bomba**: Permite ajustar a quantidade de combustível disponível na bomba.
- **Ver Valor Total Abastecido**: Mostra o valor total já abastecido na bomba.

## Estrutura do Projeto 📁

O projeto está organizado da seguinte maneira:

```plaintext
atividade_02/
│
├── BombaCombustivel.java
└── PostoDeCombustivel.java
```

- **BombaCombustivel**: Contém a classe `BombaCombustivel`, que gerencia as operações da bomba.
- **PostoDeCombustivel**: Contém a classe principal `PostoDeCombustivel`, que interage com o usuário e controla a bomba.

## Como Executar 🚀

1. **Compilar o projeto**:
   - Navegue até a pasta `atividade_02` e compile os arquivos `.java`:
  
     ```bash
     javac atividade_02/*.java
     ```
2. **Executar o programa**:
    - Execute o programa utilizando o comando:

      ```bash 
      java atividade_02.PostoDeCombustivel
      ```

3. **Interação**:
    - Siga as instruções no terminal para escolher a forma de abastecimento, alterar as configurações da bomba e visualizar o valor total abastecido.
  
## Requisitos 📝
- **Java**: Certifique-se de ter o JDK instalado (Java Development Kit) para compilar e executar o programa.

## Exemplo de Uso 💻

Ao iniciar o programa, o usuário será apresentado a um menu de opções:

Escolha uma opção:
1. Abastecer por valor
2. Abastecer por litros
3. Alterar valor do litro
4. Alterar tipo de combustível
5. Alterar quantidade de combustível na bomba
6. Ver valor total abastecido
7. Sair

Basta seguir as instruções e fornecer os valores conforme solicitado para realizar as operações desejadas.

##### Desenvolvido como parte de um exercício de programação orientada a objetos em Java.
