package org.example;
import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    //Atributos
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private String serie;
    private String turma;

    //Metodos
    public int getIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    // Metodos especiais
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null ) {
            this.nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();

        } else{
            this.nome = nome;
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
            this.serie = serie;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma.substring(0,1).toUpperCase();
    }
}

