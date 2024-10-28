package br.com.minhaempresa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {
    private Estoque estoque;
    private Produto produto1;
    private Produto produto2;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
        produto1 = new Produto("Notebook", 3500.0);
        produto2 = new Produto("Smartphone", 2000.0);
    }

    @Test
    void testAdicionarProdutoComSucesso() {
        assertTrue(estoque.adicionarProduto(produto1));
        assertEquals(1, estoque.listarProdutos().size());
    }

    @Test
    void testAdicionarProdutoDuplicado() {
        estoque.adicionarProduto(produto1);
        Produto produtoDuplicado = new Produto("Notebook", 4000.0);
        assertFalse(estoque.adicionarProduto(produtoDuplicado));
        assertEquals(1, estoque.listarProdutos().size());
    }

    @Test
    void testRemoverProdutoExistente() {
        estoque.adicionarProduto(produto1);
        assertTrue(estoque.removerProduto("Notebook"));
        assertEquals(0, estoque.listarProdutos().size());
    }

    @Test
    void testRemoverProdutoInexistente() {
        estoque.adicionarProduto(produto1);
        assertFalse(estoque.removerProduto("Produto Inexistente"));
        assertEquals(1, estoque.listarProdutos().size());
    }

    @Test
    void testBuscarProdutoExistente() {
        estoque.adicionarProduto(produto1);
        Produto encontrado = estoque.buscarProduto("Notebook");
        assertNotNull(encontrado);
        assertEquals("Notebook", encontrado.getNome());
    }

    @Test
    void testBuscarProdutoInexistente() {
        estoque.adicionarProduto(produto1);
        Produto encontrado = estoque.buscarProduto("Produto Inexistente");
        assertNull(encontrado);
    }

    @Test
    void testListarProdutosVazio() {
        assertTrue(estoque.listarProdutos().isEmpty());
    }

    @Test
    void testListarProdutosMultiplos() {
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        assertEquals(2, estoque.listarProdutos().size());
    }
}