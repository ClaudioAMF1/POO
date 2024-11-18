package com.ecommerce.produto;

import com.ecommerce.produto.dao.ProdutoDAO;
import com.ecommerce.produto.dao.ProdutoDAOImpl;
import com.ecommerce.produto.model.Produto;
import com.ecommerce.produto.model.UnidadeMedida;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            ProdutoDAO produtoDAO = new ProdutoDAOImpl();

            // Inserindo produtos
            System.out.println("Inserindo produtos...");

            Produto p1 = new Produto("Informática", "Notebook Dell", 2.5, 10, UnidadeMedida.KG);
            Produto p2 = new Produto("Limpeza", "Detergente", 1.0, 50, UnidadeMedida.LITRO);
            Produto p3 = new Produto("Casa & Decoração", "Tapete", 3.0, 5, UnidadeMedida.METRO_QUADRADO);
            Produto p4 = new Produto("Informática", "Mouse sem fio", 0.2, 20, UnidadeMedida.KG);
            Produto p5 = new Produto("Casa & Decoração", "Cortina", 0.5, 8, UnidadeMedida.METRO);

            produtoDAO.inserir(p1);
            produtoDAO.inserir(p2);
            produtoDAO.inserir(p3);
            produtoDAO.inserir(p4);
            produtoDAO.inserir(p5);

            System.out.println("Produtos inseridos com sucesso!");

            // Listando todos os produtos
            System.out.println("\nProdutos cadastrados:");
            produtoDAO.listarTodos().forEach(System.out::println);

            // Atualizando produtos
            System.out.println("\nAtualizando produtos...");
            p1.setQuantidade(15);
            p2.setQuantidade(60);
            produtoDAO.atualizar(p1);
            produtoDAO.atualizar(p2);

            // Mostrando produtos específicos
            System.out.println("\nDetalhes do produto 1:");
            System.out.println(produtoDAO.buscarPorId(p1.getId()));
            System.out.println("\nDetalhes do produto 2:");
            System.out.println(produtoDAO.buscarPorId(p2.getId()));

            // Deletando produto
            System.out.println("\nDeletando produto 5...");
            produtoDAO.deletar(p5.getId());

            // Lista final
            System.out.println("\nLista final de produtos:");
            produtoDAO.listarTodos().forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println("Erro ao executar operações no banco de dados:");
            e.printStackTrace();
        }
    }
}