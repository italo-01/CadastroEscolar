package org.example;

public class Aluno {
    //Atributos
    private int id;
    private String nome;
    private int idade;
    private String serie;
    private String turma;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        if (serie != null && !serie.contains("° Ano")) {
            this.serie = serie + "° Ano";
        } else{
            this.serie = serie;
        }
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma.substring(0,1).toUpperCase();
    }
}

