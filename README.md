# CadastroEscolar
CadastroEscolar
Descrição
Sistema de cadastro de alunos desenvolvido em Java com conexão ao banco de dados MySQL.
Funcionalidades

Cadastrar alunos
Consultar alunos
Editar dados dos alunos
Deletar alunos

Tecnologias utilizadas

Java
MySQL
JDBC

Como executar

Clone o repositório
Configure a conexão com o banco de dados em Conexao.java
Execute o arquivo Main.java

Banco de dados
sqlCREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    serie VARCHAR(10) NOT NULL,
    turma VARCHAR(1) NOT NULL
);
Autor
Seu Italo costa ribeiro

