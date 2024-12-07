# Sistema de Usuários e Posts

## 📝 Descrição
Sistema de gerenciamento de usuários e posts desenvolvido em Java, utilizando JDBC e banco de dados H2. O sistema permite o cadastro de usuários, autenticação e gerenciamento de posts.

## 🚀 Funcionalidades

### Usuários
- Cadastro de novos usuários
- Autenticação (login/logout)
- Edição de perfil
- Exclusão de conta
- Tipos de usuário: ADMIN, EDITOR, LEITOR

### Posts
- Criação de posts
- Listagem de posts por usuário
- Edição de posts
- Exclusão de posts

## 🛠️ Tecnologias Utilizadas
- Java 17
- Maven
- JDBC
- Banco de dados H2
- JUnit 5 (para testes)

## 📋 Pré-requisitos
- JDK 17 ou superior
- Maven 3.6 ou superior
- Git (opcional)

## 🔧 Configuração do Ambiente

### Instalação
1. Clone o repositório (ou baixe o ZIP):
```bash
git clone https://github.com/ClaudioAMF1/POO.git
```

2. Navegue até a pasta do projeto:
```bash
cd prova_A2
```

3. Compile o projeto:
```bash
mvn clean package
```

### Configuração do Banco de Dados
O sistema utiliza H2 Database em modo arquivo. As configurações estão em `src/main/resources/application.properties`:

```properties
db.url=jdbc:h2:~/postsdb;DB_CLOSE_DELAY=-1
db.user=sa
db.password=
```

## 🚀 Executando o Sistema

### Via IDE (IntelliJ IDEA)
1. Abra o projeto na IDE
2. Localize a classe `Main.java`
3. Execute o método `main`

### Via Terminal
```bash
java -jar target/SistemaUsuariosPosts-1.0-SNAPSHOT.jar
```

## 📖 Guia de Uso

### Menu Principal
O sistema apresenta dois menus principais:

#### Menu Inicial (usuário não autenticado)
1. Login
2. Cadastrar novo usuário
0. Sair

#### Menu Principal (usuário autenticado)
1. Criar novo post
2. Listar meus posts
3. Editar um post
4. Excluir um post
5. Editar meu perfil
6. Excluir minha conta
0. Logout

### Exemplo de Uso
1. Cadastre um novo usuário
2. Faça login com as credenciais cadastradas
3. Crie um novo post
4. Liste seus posts
5. Edite ou exclua posts conforme necessário

## 🧪 Testando o Sistema

### Teste Manual
1. **Cadastro de Usuário**
   - Email válido (com @)
   - Senha com mínimo de 6 caracteres
   - Nome não pode ser vazio
   - Tipo de usuário válido (1-ADMIN, 2-EDITOR, 3-LEITOR)

2. **Login**
   - Teste com credenciais corretas
   - Teste com credenciais incorretas

3. **Gestão de Posts**
   - Crie posts com diferentes títulos e conteúdos
   - Edite posts existentes
   - Exclua posts
   - Verifique a listagem após cada operação

4. **Gestão de Perfil**
   - Altere senha
   - Altere nome
   - Teste login com nova senha

### Casos de Teste Importantes
1. **Validações de Usuário**
   - Email inválido
   - Senha curta
   - Email duplicado
   - Campos vazios

2. **Validações de Post**
   - Título vazio
   - Conteúdo vazio
   - IDs inexistentes

## ⚠️ Tratamento de Erros
O sistema inclui tratamento para:
- Erros de banco de dados
- Validações de dados
- Permissões de usuário
- Entradas inválidas

## 🔍 Estrutura do Projeto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           ├── dao/
│   │           ├── exception/
│   │           ├── model/
│   │           ├── service/
│   │           ├── util/
│   │           ├── view/
│   │           └── Main.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## 🐛 Problemas Conhecidos e Soluções

### Erro de Conexão com Banco
- Verifique se o arquivo application.properties está correto
- Certifique-se que a pasta do banco H2 tem permissão de escrita
- Verifique se não há outras instâncias do banco rodando

### Erro de Compilação
- Execute `mvn clean install`
- Verifique se todas as dependências foram baixadas
- Confira a versão do Java no seu ambiente

### Problemas de Codificação (Caracteres Especiais)
- Configure o encoding do projeto para UTF-8
- No IntelliJ: File -> Settings -> Editor -> File Encodings
