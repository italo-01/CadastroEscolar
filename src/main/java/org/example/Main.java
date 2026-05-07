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

        //Interação, Cadastro
        System.out.print("Digite o nome do aluno: ");
        aluno.setNome(sc.nextLine());

        System.out.print("Digite o ano de nascimento (AAAA-MM-DD): ");
        aluno.setDataNascimento(LocalDate.parse(sc.nextLine()));

        System.out.print("Digite a serie (Apenas o numero que a represente): ");
        aluno.setSerie(sc.nextLine());

        while (true) {
            System.out.print("Digite a turma > A, B, C ou D: ");
            aluno.setTurma(sc.nextLine().toUpperCase());
            if (aluno.getTurma().equals("A") || aluno.getTurma().equals("B") || aluno.getTurma().equals("C") || aluno.getTurma().equals("D")) {
                break;
            } else{
                System.out.println("Digite apenas: A, B, C ou D !! ");
            }

        }
        dados.salvar(aluno);

        //Visualização dos registros do banco de dados
        while(true) {
            System.out.println("Consultar Dados: 1 - sim  2 - não");
            String res = sc.nextLine();
            if(res.equals("1")){
                for (Aluno a : dados.dadosDao()) {
                    System.out.println("Nome " + a.getNome());
                    System.out.println("Idade " + a.getIdade());
                    System.out.println("Serie " + a.getSerie() + "° Ano");
                    System.out.println("Turma " + a.getTurma());
                    System.out.println("ID " + a.getId());
                }
            }else {
                break;
            }
        }
        //Atualizar registros
        while (true){
            System.out.println("Atualizar registro: 1 - sim  2 - não");
            String res = sc.nextLine();
            if (res.equals("1")) {
                System.out.println("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                aluno.setId(id);
                System.out.println("Atualizar nome: ");;
                String nome = sc.nextLine();
                aluno.setNome(nome);
                System.out.println("Atualizar turma: ");
                String turma = sc.nextLine();
                aluno.setTurma(turma);
                System.out.println("Atualizar serie: ");
                String serie = sc.nextLine();
                aluno.setSerie(serie);

                dados.update(aluno);
            } else{
                break;
            }
        }
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}