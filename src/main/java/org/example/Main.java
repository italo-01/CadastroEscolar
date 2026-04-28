package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

    Aluno aluno = new Aluno();
    Connection con = Conexao.getConnection();
    AlunoDAO dados = new AlunoDAO(con);

    aluno.setNome("João");
    aluno.setIdade(18);
    aluno.setSerie("2º ano");
    aluno.setTurma("A");

    dados.salvar(aluno);
    }
}