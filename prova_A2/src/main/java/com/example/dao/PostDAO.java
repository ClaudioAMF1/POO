package com.example.dao;

import com.example.exception.DatabaseException;
import com.example.model.Post;
import com.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDAO implements GenericDAO<Post, Long> {

    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS posts (
                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                titulo VARCHAR(255) NOT NULL,
                conteudo TEXT NOT NULL,
                data_publicacao TIMESTAMP NOT NULL,
                email_usuario VARCHAR(255) NOT NULL,
                FOREIGN KEY (email_usuario) REFERENCES usuarios(email)
                ON DELETE CASCADE
            )
        """;

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao criar tabela de posts", e);
        }
    }

    @Override
    public void inserir(Post post) {
        String sql = "INSERT INTO posts (titulo, conteudo, data_publicacao, email_usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, post.getTitulo());
            stmt.setString(2, post.getConteudo());
            stmt.setTimestamp(3, Timestamp.valueOf(post.getDataPublicacao()));
            stmt.setString(4, post.getEmailUsuario());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                post.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao inserir post", e);
        }
    }

    @Override
    public Optional<Post> buscarPorId(Long id) {
        String sql = "SELECT * FROM posts WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("id"));
                post.setTitulo(rs.getString("titulo"));
                post.setConteudo(rs.getString("conteudo"));
                post.setDataPublicacao(rs.getTimestamp("data_publicacao").toLocalDateTime());
                post.setEmailUsuario(rs.getString("email_usuario"));
                return Optional.of(post);
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao buscar post", e);
        }
    }

    public List<Post> listarPorUsuario(String emailUsuario) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE email_usuario = ? ORDER BY data_publicacao DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emailUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("id"));
                post.setTitulo(rs.getString("titulo"));
                post.setConteudo(rs.getString("conteudo"));
                post.setDataPublicacao(rs.getTimestamp("data_publicacao").toLocalDateTime());
                post.setEmailUsuario(rs.getString("email_usuario"));
                posts.add(post);
            }

            return posts;
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar posts do usuário", e);
        }
    }

    @Override
    public List<Post> listarTodos() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY data_publicacao DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getLong("id"));
                post.setTitulo(rs.getString("titulo"));
                post.setConteudo(rs.getString("conteudo"));
                post.setDataPublicacao(rs.getTimestamp("data_publicacao").toLocalDateTime());
                post.setEmailUsuario(rs.getString("email_usuario"));
                posts.add(post);
            }

            return posts;
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao listar posts", e);
        }
    }

    @Override
    public void atualizar(Post post) {
        String sql = "UPDATE posts SET titulo = ?, conteudo = ? WHERE id = ? AND email_usuario = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, post.getTitulo());
            stmt.setString(2, post.getConteudo());
            stmt.setLong(3, post.getId());
            stmt.setString(4, post.getEmailUsuario());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new DatabaseException("Post não encontrado ou usuário não autorizado");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao atualizar post", e);
        }
    }

    @Override
    public void deletar(Long id) {
        String sql = "DELETE FROM posts WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Erro ao deletar post", e);
        }
    }
}