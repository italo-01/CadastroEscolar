package org.example;
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
        String sql = "INSERT INTO aluno (nome, data_nascimento, serie, turma) values (?, ?, ?, ?)";


        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setDate(2, java.sql.Date.valueOf(aluno.getDataNascimento()));
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
                alunosdad.setDataNascimento(rset.getDate("data_nascimento").toLocalDate());
                alunosdad.setSerie(rset.getString("serie"));
                alunosdad.setTurma(rset.getString("turma"));
                alunosdad.setId(rset.getInt("id"));

                alunos.add(alunosdad);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    return alunos;
    }
    public void update (Aluno aluno){
        String sql = "update aluno set nome = ?, turma = ?, serie = ? where id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getTurma());
            stmt.setString(3, aluno.getSerie());
            stmt.setInt(4,aluno.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        String sql = "delete from aluno where id = ?";

        try(PreparedStatement stmt = conexao.prepareStatement(sql)){
            stmt.setInt(1, id);;
            stmt.executeUpdate();
            System.out.println("Aluno deletado com sucesso!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

