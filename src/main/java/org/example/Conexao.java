package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "");

            System.out.println("Banco Conectado com sucesso");

            return conexao;

        } catch (ClassNotFoundException e) {
            System.out.println("Drive não encontrado");
            return null;

        } catch (SQLException e) {
            System.out.println("Erro na conexão com o banco de dados " + e.getMessage());
            return null;
        }
    }
}
