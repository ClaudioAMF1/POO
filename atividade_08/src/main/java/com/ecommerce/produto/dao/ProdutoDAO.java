package com.ecommerce.produto.dao;

import com.ecommerce.produto.model.Produto;
import java.sql.SQLException;
import java.util.List;

public interface ProdutoDAO {
    void inserir(Produto produto) throws SQLException;
    void atualizar(Produto produto) throws SQLException;
    void deletar(Integer id) throws SQLException;
    Produto buscarPorId(Integer id) throws SQLException;
    List<Produto> listarTodos() throws SQLException;
}