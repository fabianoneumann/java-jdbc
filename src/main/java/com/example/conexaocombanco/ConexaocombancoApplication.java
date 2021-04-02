package com.example.conexaocombanco;

import com.example.conexaocombanco.model.Produto;
import com.example.conexaocombanco.dao.ProdutoDAO;
import com.example.conexaocombanco.factory.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class ConexaocombancoApplication {

    public static void main(String[] args) throws SQLException {
//        SpringApplication.run(ConexaocombancoApplication.class, args);

        Produto p = new Produto(1, "Playstation", 700.0);

        ProdutoDAO pDAO = new ProdutoDAO();

        System.out.println("Lista de produtos original");
        pDAO.listaProdutos();

        System.out.println("Cadastrando produto...");
        pDAO.cadastraProduto(p);

        System.out.println("Produto Playstation Cadastrado com sucesso");

        System.out.println("Lista com Playstation inserido");
        pDAO.listaProdutos();

//        Connection c = new ConnectionFactory().getConnection();
//        System.out.println("Conectou!");
//        c.close();

    }

}
