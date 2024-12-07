package com.example.service;

import com.example.dao.PostDAO;
import com.example.exception.ValidationException;
import com.example.model.Post;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostDAO postDAO;
    private final UsuarioService usuarioService;

    public PostService(UsuarioService usuarioService) {
        this.postDAO = new PostDAO();
        this.usuarioService = usuarioService;
        this.postDAO.criarTabela();
    }

    public void cadastrar(Post post) {
        validarPost(post);
        if (usuarioService.buscarPorEmail(post.getEmailUsuario()).isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        postDAO.inserir(post);
    }

    public void atualizar(Post post) {
        validarPost(post);
        if (postDAO.buscarPorId(post.getId()).isEmpty()) {
            throw new ValidationException("Post não encontrado");
        }
        postDAO.atualizar(post);
    }

    public void deletar(Long id) {
        if (postDAO.buscarPorId(id).isEmpty()) {
            throw new ValidationException("Post não encontrado");
        }
        postDAO.deletar(id);
    }

    public Optional<Post> buscarPorId(Long id) {
        return postDAO.buscarPorId(id);
    }

    public List<Post> listarPorUsuario(String emailUsuario) {
        if (usuarioService.buscarPorEmail(emailUsuario).isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        return postDAO.listarPorUsuario(emailUsuario);
    }

    private void validarPost(Post post) {
        if (post.getTitulo() == null || post.getTitulo().trim().isEmpty()) {
            throw new ValidationException("Título é obrigatório");
        }
        if (post.getTitulo().length() > 255) {
            throw new ValidationException("Título deve ter no máximo 255 caracteres");
        }
        if (post.getConteudo() == null || post.getConteudo().trim().isEmpty()) {
            throw new ValidationException("Conteúdo é obrigatório");
        }
        if (post.getEmailUsuario() == null || post.getEmailUsuario().trim().isEmpty()) {
            throw new ValidationException("Email do usuário é obrigatório");
        }
    }
}