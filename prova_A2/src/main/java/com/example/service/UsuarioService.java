package com.example.service;

import com.example.dao.UsuarioDAO;
import com.example.exception.ValidationException;
import com.example.model.Usuario;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.usuarioDAO.criarTabela();
    }

    public void cadastrar(Usuario usuario) {
        validarUsuario(usuario);
        if (usuarioDAO.buscarPorId(usuario.getEmail()).isPresent()) {
            throw new ValidationException("Email já cadastrado");
        }
        usuarioDAO.inserir(usuario);
    }

    public void atualizar(Usuario usuario) {
        validarUsuario(usuario);
        if (usuarioDAO.buscarPorId(usuario.getEmail()).isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        usuarioDAO.atualizar(usuario);
    }

    public void deletar(String email) {
        if (usuarioDAO.buscarPorId(email).isEmpty()) {
            throw new ValidationException("Usuário não encontrado");
        }
        usuarioDAO.deletar(email);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioDAO.buscarPorId(email);
    }

    public List<Usuario> listarTodos() {
        return usuarioDAO.listarTodos();
    }

    public boolean autenticar(String email, String senha) {
        return usuarioDAO.autenticar(email, senha);
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email é obrigatório");
        }
        if (!usuario.getEmail().contains("@")) {
            throw new ValidationException("Email inválido");
        }
        if (usuario.getSenha() == null || usuario.getSenha().length() < 6) {
            throw new ValidationException("Senha deve ter pelo menos 6 caracteres");
        }
        if (usuario.getNome() == null || usuario.getNome().trim().isEmpty()) {
            throw new ValidationException("Nome é obrigatório");
        }
        if (usuario.getTipoUsuario() == null) {
            throw new ValidationException("Tipo de usuário é obrigatório");
        }
    }
}