package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Objetos
        Scanner sc = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Connection con = Conexao.getConnection();
        AlunoDAO dados = new AlunoDAO(con);

        //Intereação
        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(sc.nextLine());

        System.out.print("Digite sua idade: ");
        aluno.setIdade(sc.nextInt());
        sc.nextLine();

        System.out.print("Digite sua serie: ");
        aluno.setSerie(sc.nextLine());

        System.out.print("Digite sua turma > A, B, C ou D: ");
        aluno.setTurma(sc.nextLine());

        dados.salvar(aluno);


        //Visualização dos registros do banco de dados
        for (Aluno a : dados.dadosDao()) {
            System.out.println("Nome " + a.getNome());
            System.out.println("Idade " + a.getIdade());
            System.out.println("Serie " + a.getSerie());
            System.out.println("Turma " + a.getTurma());
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}