package org.example;

import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*Create - Criar
 *Read - Bucar
 *Update - Atualizar
 *Delete - Deletar
 */

public class AlunoDAO {
    //Atributos
    private Connection conexao;

    //Construtor
    public AlunoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    //Metodos
    public void salvar(Aluno aluno){
        String sql = "INSERT INTO aluno (nome, idade, serie, turma) values (?, ?, ?, ?)";


        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getSerie());
            stmt.setString(4, aluno.getTurma());

            stmt.executeUpdate();
            System.out.println("Dados Salvo com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Aluno> dadosDao(){

        String sql = "Select * from aluno";

        List<Aluno> alunos = new ArrayList<>();

        ResultSet rset = null;
        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {

            rset = stmt.executeQuery();

            while(rset.next()){
                Aluno alunosdad = new Aluno();

                alunosdad.setNome(rset.getString("nome"));
                alunosdad.setIdade(rset.getInt("idade"));
                alunosdad.setSerie(rset.getString("serie"));
                alunosdad.setTurma(rset.getString("turma"));

                alunos.add(alunosdad);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return alunos;
    }

}

