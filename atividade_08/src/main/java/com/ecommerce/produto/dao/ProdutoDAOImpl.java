package com.ecommerce.produto.dao;

import com.ecommerce.produto.config.DatabaseConnection;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.model.UnidadeMedida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (tipo, descricao, peso, quantidade, unidade_medida) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidadeMedida().name());

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                produto.setId(generatedKeys.getInt(1));
            }
        }
    }

    @Override
    public void atualizar(Produto produto) throws SQLException {
        String sql = "UPDATE produtos SET tipo = ?, descricao = ?, peso = ?, quantidade = ?, unidade_medida = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidadeMedida().name());
            stmt.setInt(6, produto.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deletar(Integer id) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public Produto buscarPorId(Integer id) throws SQLException {
        String sql = "SELECT * FROM produtos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        UnidadeMedida.valueOf(rs.getString("unidade_medida"))
                );
            }
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                produtos.add(new Produto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        UnidadeMedida.valueOf(rs.getString("unidade_medida"))
                ));
            }
        }
        return produtos;
    }
}