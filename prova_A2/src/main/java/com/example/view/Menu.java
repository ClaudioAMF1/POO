package com.example.view;

import com.example.exception.DatabaseException;
import com.example.exception.ValidationException;
import com.example.model.Post;
import com.example.model.Usuario;
import com.example.service.PostService;
import com.example.service.UsuarioService;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final UsuarioService usuarioService;
    private final PostService postService;
    private Usuario usuarioLogado;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.usuarioService = new UsuarioService();
        this.postService = new PostService(usuarioService);
    }

    public void iniciar() {
        while (true) {
            if (usuarioLogado == null) {
                menuInicial();
            } else {
                menuPrincipal();
            }
        }
    }

    private void menuInicial() {
        System.out.println("\n=== SISTEMA DE POSTS ===");
        System.out.println("1. Login");
        System.out.println("2. Cadastrar novo usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> fazerLogin();
                case 2 -> cadastrarUsuario();
                case 0 -> {
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void menuPrincipal() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("Bem-vindo, " + usuarioLogado.getNome());
        System.out.println("1. Criar novo post");
        System.out.println("2. Listar meus posts");
        System.out.println("3. Editar um post");
        System.out.println("4. Excluir um post");
        System.out.println("5. Editar meu perfil");
        System.out.println("6. Excluir minha conta");
        System.out.println("0. Logout");
        System.out.print("Escolha uma opção: ");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> criarPost();
                case 2 -> listarPosts();
                case 3 -> editarPost();
                case 4 -> excluirPost();
                case 5 -> editarPerfil();
                case 6 -> excluirConta();
                case 0 -> logout();
                default -> System.out.println("Opção inválida!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um número válido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void fazerLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        try {
            if (usuarioService.autenticar(email, senha)) {
                usuarioLogado = usuarioService.buscarPorEmail(email).get();
                System.out.println("Login realizado com sucesso!");
            } else {
                System.out.println("Email ou senha incorretos!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
        }
    }

    private void cadastrarUsuario() {
        try {
            Usuario novoUsuario = new Usuario();

            System.out.print("Email: ");
            novoUsuario.setEmail(scanner.nextLine());

            System.out.print("Senha: ");
            novoUsuario.setSenha(scanner.nextLine());

            System.out.print("Nome: ");
            novoUsuario.setNome(scanner.nextLine());

            System.out.println("Tipo de usuário:");
            System.out.println("1. ADMIN");
            System.out.println("2. EDITOR");
            System.out.println("3. LEITOR");
            System.out.print("Escolha uma opção: ");

            int tipoUsuario = Integer.parseInt(scanner.nextLine());
            switch (tipoUsuario) {
                case 1 -> novoUsuario.setTipoUsuario(Usuario.TipoUsuario.ADMIN);
                case 2 -> novoUsuario.setTipoUsuario(Usuario.TipoUsuario.EDITOR);
                case 3 -> novoUsuario.setTipoUsuario(Usuario.TipoUsuario.LEITOR);
                default -> throw new ValidationException("Tipo de usuário inválido");
            }

            usuarioService.cadastrar(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private void criarPost() {
        try {
            Post novoPost = new Post();

            System.out.print("Título: ");
            novoPost.setTitulo(scanner.nextLine());

            System.out.print("Conteúdo: ");
            novoPost.setConteudo(scanner.nextLine());

            novoPost.setEmailUsuario(usuarioLogado.getEmail());

            postService.cadastrar(novoPost);
            System.out.println("Post criado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao criar post: " + e.getMessage());
        }
    }

    private void listarPosts() {
        try {
            var posts = postService.listarPorUsuario(usuarioLogado.getEmail());
            if (posts.isEmpty()) {
                System.out.println("Você ainda não tem posts!");
                return;
            }

            System.out.println("\n=== SEUS POSTS ===");
            for (Post post : posts) {
                System.out.println("\nID: " + post.getId());
                System.out.println("Título: " + post.getTitulo());
                System.out.println("Conteúdo: " + post.getConteudo());
                System.out.println("Data: " + post.getDataPublicacao());
                System.out.println("-----------------");
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar posts: " + e.getMessage());
        }
    }

    private void editarPost() {
        try {
            listarPosts();

            System.out.print("\nDigite o ID do post que deseja editar: ");
            Long id = Long.parseLong(scanner.nextLine());

            var postOptional = postService.buscarPorId(id);
            if (postOptional.isEmpty()) {
                System.out.println("Post não encontrado!");
                return;
            }

            Post post = postOptional.get();
            if (!post.getEmailUsuario().equals(usuarioLogado.getEmail())) {
                System.out.println("Você não tem permissão para editar este post!");
                return;
            }

            System.out.print("Novo título (Enter para manter o atual): ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isEmpty()) {
                post.setTitulo(novoTitulo);
            }

            System.out.print("Novo conteúdo (Enter para manter o atual): ");
            String novoConteudo = scanner.nextLine();
            if (!novoConteudo.isEmpty()) {
                post.setConteudo(novoConteudo);
            }

            postService.atualizar(post);
            System.out.println("Post atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao editar post: " + e.getMessage());
        }
    }

    private void excluirPost() {
        try {
            listarPosts();

            System.out.print("\nDigite o ID do post que deseja excluir: ");
            Long id = Long.parseLong(scanner.nextLine());

            var postOptional = postService.buscarPorId(id);
            if (postOptional.isEmpty()) {
                System.out.println("Post não encontrado!");
                return;
            }

            Post post = postOptional.get();
            if (!post.getEmailUsuario().equals(usuarioLogado.getEmail())) {
                System.out.println("Você não tem permissão para excluir este post!");
                return;
            }

            System.out.print("Tem certeza que deseja excluir este post? (S/N): ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                postService.deletar(id);
                System.out.println("Post excluído com sucesso!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir post: " + e.getMessage());
        }
    }

    private void editarPerfil() {
        try {
            Usuario usuario = usuarioLogado;

            System.out.print("Nova senha (Enter para manter a atual): ");
            String novaSenha = scanner.nextLine();
            if (!novaSenha.isEmpty()) {
                usuario.setSenha(novaSenha);
            }

            System.out.print("Novo nome (Enter para manter o atual): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                usuario.setNome(novoNome);
            }

            usuarioService.atualizar(usuario);
            System.out.println("Perfil atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao editar perfil: " + e.getMessage());
        }
    }

    private void excluirConta() {
        try {
            System.out.print("Tem certeza que deseja excluir sua conta? Esta ação não pode ser desfeita! (S/N): ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                usuarioService.deletar(usuarioLogado.getEmail());
                System.out.println("Conta excluída com sucesso!");
                logout();
            }

        } catch (Exception e) {
            System.out.println("Erro ao excluir conta: " + e.getMessage());
        }
    }

    private void logout() {
        usuarioLogado = null;
        System.out.println("Logout realizado com sucesso!");
    }
}