# Sistema de Cálculo de Impostos

Este projeto em Java é um sistema para calcular impostos e taxas em operações comerciais. Ele utiliza orientação a objetos para representar diferentes tipos de itens (produtos e serviços) e calcular os impostos aplicáveis a cada um.

## Funcionalidades

- Cálculo de ISS (7,3%) aplicado sobre serviços.
- Cálculo de ICMS (13,2%) aplicado sobre produtos e serviços.
- Cálculo de IPI (21,9%) aplicado sobre produtos.
- Interface simples para o usuário inserir dados via console.

## Como Executar

1. Compile todos os arquivos `.java`.
2. Execute o arquivo `Main.java` para iniciar o programa.
3. Insira os dados solicitados para calcular os impostos e ver o resultado detalhado.

## Estrutura do Projeto

- `Main.java`: Ponto de entrada do programa.
- `OperacaoComercial.java`: Responsável por calcular e detalhar a operação.
- `Item.java`: Classe base abstrata para `Produto` e `Servico`.
- `Produto.java`: Representa um produto.
- `Servico.java`: Representa um serviço.
- `Imposto.java`: Interface para os impostos.
- `ISS.java`: Implementa o cálculo do ISS.
- `ICMS.java`: Implementa o cálculo do ICMS.
- `IPI.java`: Implementa o cálculo do IPI.

## Exemplo de Execução

=== Bem-vindo ao Sistema de Cálculo de Impostos ===

Digite o nome do item:
Consultoria Financeira

Digite o tipo do item:
1 - Produto
2 - Serviço

Escolha: 2

Digite o valor base do item (em R$):

1500.00

==============================================

=== Detalhamento da Operação Comercial ===

Item: colsultoria
Valor Base: R$ 1500.00

--- Impostos Aplicados ---

  - ISS (7,3%): R$ 109.50
  - ICMS (13,2%): R$ 198.00

----------------------------

Valor Total com Impostos: R$ 1807.50

==============================================

 
