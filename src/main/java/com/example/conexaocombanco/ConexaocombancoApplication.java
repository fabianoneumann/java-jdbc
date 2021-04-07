package com.example.conexaocombanco;

import com.example.conexaocombanco.model.Produto;
import com.example.conexaocombanco.dao.ProdutoDAO;
import com.example.conexaocombanco.factory.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class ConexaocombancoApplication {
    public static void main(String[] args) throws SQLException {

        Produto produto = new Produto(6, "Produto OK", 15.0);
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Código: " + produto.getIdProduto());
        System.out.println("Preço: " + produto.getPreco());

//        produto.setPreco(30.0);
//        System.out.println("Preço alterado: " + produto.getPreco());
        
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/uniamerica", "root", "");

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.criaTabelaProduto();
        produtoDAO.cadastraProduto(produto);
        produtoDAO.listaProdutos();

        Produto produto2 = new Produto(4, "Produto Legal", 55.0);
        produtoDAO.cadastraProduto(produto2);
        produtoDAO.listaProdutos();

//        SpringApplication.run(ConexaocombancoApplication.class, args);

//        Produto p = new Produto(2, "notebook", 800.0);
//
//        ProdutoDAO pDAO = new ProdutoDAO();
//
//        System.out.println("Lista de produtos original");
//        pDAO.listaProdutos();
//
//        System.out.println("Cadastrando produto...");
//        pDAO.cadastraProduto(p);
//
//        System.out.println("Produto Playstation Cadastrado com sucesso");
//
//        System.out.println("Lista com Playstation inserido");
//        pDAO.listaProdutos();

//        Connection c = new ConnectionFactory().getConnection();
//        System.out.println("Conectou!");
//        c.close();

    }

}
