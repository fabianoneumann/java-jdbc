package com.example.conexaocombanco.dao;



import com.example.conexaocombanco.factory.ConnectionFactory;
import com.example.conexaocombanco.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraProduto(Produto p) {
        String sql = "insert into produtos" +
                " (idProduto, nomeProduto, preco) " +
                "values (?,?,?)";

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
        String sql = "select * from produtos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet produtos = stmt.executeQuery();

            while (produtos.next()) {
                System.out.println(produtos.getInt("idProduto"));
                System.out.println(produtos.getString("nomeProduto"));
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
