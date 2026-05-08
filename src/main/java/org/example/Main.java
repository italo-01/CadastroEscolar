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
        System.out.println("_".repeat(30));
        System.out.println("Sistema cadastro de alunos");
        System.out.println("-".repeat(30));
        while (true) {
            System.out.println("Selecione uma opção: \n" +
                    "1 - Cadastrar dados\n" +
                    "2 - Consultar dados\n" +
                    "3 - Editar dados\n" +
                    "4 - Deletar dados\n" +
                    "5 - Fecha ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
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
                        } else {
                            System.out.println("Digite apenas: A, B, C ou D !! ");
                        }
                    }
                    dados.salvar(aluno);
                    break;
                case 2:
                    //Visualização dos registros do banco de dados
                    for (Aluno a : dados.dadosDao()) {
                        System.out.println("Nome " + a.getNome());
                        System.out.println("Idade " + a.getIdade());
                        System.out.println("Serie " + a.getSerie() + "° Ano");
                        System.out.println("Turma " + a.getTurma());
                        System.out.println("ID " + a.getId());
                    }
                    break;

                case 3:
                    //Atualizar registros
                    System.out.println("Digite o ID do aluno: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    aluno.setId(id);

                    Aluno alunoAtual = dados.dadosDao().stream()
                            .filter(a -> a.getId() == id )
                            .findFirst()
                            .orElse(null);

                    if (alunoAtual == null ){
                        System.out.println("Aluno não encontrado");
                        break;
                    }
                    boolean atualizando = true;
                    while (atualizando) {
                        System.out.println("-".repeat(30));
                        System.out.println("Atualização de dados:\n" +
                                "Digite a opção que deseja Atualizar: \n" +
                                "1 - Nome\n" +
                                "2 - Turma\n" +
                                "3 - Serie\n" +
                                "4 - Terminar atualização");
                        System.out.println("-".repeat(30));
                        int novo = sc.nextInt();
                        sc.nextLine();

                        switch (novo) {
                            case 1:
                                System.out.println("Atualizar nome: \n" +
                                "Nome atual: " + alunoAtual.getNome());
                                String nome = sc.nextLine();
                                alunoAtual.setNome(nome);
                                System.out.println("Atualizado com sucesso!");
                                break;

                            case 2:
                                System.out.println("Atualizar turma: \n" +
                                "Turma atual ");
                                String turma = sc.nextLine();
                                alunoAtual.setTurma(turma);
                                System.out.println("Atualizado com sucesso!");
                                break;

                            case 3:
                                System.out.println("Atualizar serie: \n" +
                                 "Serie atual " + alunoAtual.getSerie() + "° Ano");
                                String serie = sc.nextLine();
                                alunoAtual.setSerie(serie);
                                System.out.println("Atualizado com sucesso!");
                                break;

                            case 4:
                                dados.update(alunoAtual);
                                //System.out.println("Atualizado com sucesso!");
                                atualizando = false;
                                break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do aluno que desejar deletar: ");
                    int ide = sc.nextInt();
                    sc.nextLine();

                    dados.delete(ide);
                    break;

                case 5:
                    try {
                        if (con != null) con.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Programa Finalizado.");
                return;
            }
        }
    }
}