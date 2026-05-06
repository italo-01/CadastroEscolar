package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Objetos
        Scanner sc = new Scanner(System.in);
        Aluno aluno = new Aluno();
        Connection con = Conexao.getConnection();
        AlunoDAO dados = new AlunoDAO(con);

        //Interação
        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(sc.nextLine());
        //Interação

        System.out.print("Digite seu ano de nascimento: ");
        aluno.setDataNascimento(LocalDate.parse(sc.nextLine()));
        sc.nextLine();

        System.out.print("Digite sua serie (Apenas o numero que a represente): ");
        aluno.setSerie(sc.nextLine());

        while (true) {
            System.out.print("Digite sua turma > A, B, C ou D: ");
            aluno.setTurma(sc.nextLine().toUpperCase());
            if (aluno.getTurma().equals("A") || aluno.getTurma().equals("B") || aluno.getTurma().equals("C") || aluno.getTurma().equals("D")) {
                break;
            } else{
                System.out.println("Digite apenas: A, B, C ou D !! ");
            }

        }
        dados.salvar(aluno);

        //Visualização dos registros do banco de dados
        for (Aluno a : dados.dadosDao()) {
            System.out.println("Nome " + a.getNome());
            System.out.println("Idade " + a.getIdade());
            System.out.println("Serie " + a.getSerie() + "° Ano");
            System.out.println("Turma " + a.getTurma());
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}