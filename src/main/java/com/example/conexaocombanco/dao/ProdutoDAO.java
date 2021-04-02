package com.example.conexaocombanco.dao;

import com.example.conexaocombanco.factory.ConnectionFactory;
import com.example.conexaocombanco.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {
    private Connection connection;

    //Método construtor utilizado para obter a conexão
    // com o banco de dados por meio da fábrica de conexões
    // e para criar a tabela produtos, caso não exista, para
    // que possa ser manipulada com CRUD
    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
        this.criaTabelaProduto();
    }

    //Método utilizado para criar a tabela, caso não exista
    public void criaTabelaProduto() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                        "idProduto INT PRIMARY KEY AUTO_INCREMENT," +
                        "nome VARCHAR(50) NOT NULL," +
                        "preco DECIMAL(10,2)" +
                     ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela Produto criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastraProduto(Produto p) {
        String sql = "INSERT INTO produtos" +
                " (idProduto, nome, preco) " +
                "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, p.getIdProduto());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPreco());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listaProdutos() {
        String sql = "SELECT * FROM produtos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet produtos = stmt.executeQuery();

            while (produtos.next()) {
                System.out.println(produtos.getInt("idProduto"));
                System.out.println(produtos.getString("nome"));
                System.out.println(produtos.getDouble("preco"));
                System.out.println("---------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarProduto(Produto p) {

    }

    public void deletarProduto(Produto p) {

    }
}
