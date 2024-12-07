package com.example.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    void inserir(T entity);
    Optional<T> buscarPorId(ID id);
    List<T> listarTodos();
    void atualizar(T entity);
    void deletar(ID id);
}