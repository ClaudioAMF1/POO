package br.com.minhaempresa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {

    @Test
    void testConstrutorEGetters() {
        Produto produto = new Produto("Notebook", 3500.0);
        assertEquals("Notebook", produto.getNome());
        assertEquals(3500.0, produto.getPreco());
    }

    @Test
    void testEquals() {
        Produto produto1 = new Produto("Notebook", 3500.0);
        Produto produto2 = new Produto("Notebook", 4000.0);
        Produto produto3 = new Produto("Smartphone", 2000.0);

        // Produtos com mesmo nome devem ser considerados iguais
        assertEquals(produto1, produto2);
        // Produtos com nomes diferentes não devem ser iguais
        assertNotEquals(produto1, produto3);
    }

    @Test
    void testHashCode() {
        Produto produto1 = new Produto("Notebook", 3500.0);
        Produto produto2 = new Produto("Notebook", 4000.0);

        // HashCode deve ser igual para produtos com mesmo nome
        assertEquals(produto1.hashCode(), produto2.hashCode());
    }

    @Test
    void testCompareTo() {
        Produto produtoMaiorPreco = new Produto("Notebook", 3500.0);
        Produto produtoMenorPreco = new Produto("Smartphone", 2000.0);

        // Produto com preço maior deve vir depois
        assertTrue(produtoMaiorPreco.compareTo(produtoMenorPreco) > 0);
        // Produto com preço menor deve vir antes
        assertTrue(produtoMenorPreco.compareTo(produtoMaiorPreco) < 0);
    }

    @Test
    void testCompareToIguais() {
        Produto produto1 = new Produto("Notebook", 3500.0);
        Produto produto2 = new Produto("Smartphone", 3500.0);

        // Produtos com mesmo preço devem ser considerados iguais na comparação
        assertEquals(0, produto1.compareTo(produto2));
    }

    @Test
    void testEqualsNull() {
        Produto produto = new Produto("Notebook", 3500.0);
        assertNotEquals(null, produto);
    }

    @Test
    void testEqualsDiferenteTipo() {
        Produto produto = new Produto("Notebook", 3500.0);
        assertNotEquals(produto, new Object());
    }
}
