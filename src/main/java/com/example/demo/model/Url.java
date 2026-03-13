package com.example.demo.model;

import jakarta.persistence.*;

@Entity // Avisa ao Spring que esta classe vai virar uma tabela no banco de dados
public class Url {

    @Id // Define que este campo é a Chave Primária (ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID (1, 2, 3...) automaticamente
    private Long id;

    private String urlOriginal; // Onde salvaremos o link longo (ex: google.com)
    
    private String codigoCurto; // Onde salvaremos o apelido (ex: 907eee)

    // Os Getters e Setters permitem que o Spring leia e escreva dados nestes campos
    public String getUrlOriginal() { return urlOriginal; }
    public void setUrlOriginal(String urlOriginal) { this.urlOriginal = urlOriginal; }
    
    public String getCodigoCurto() { return codigoCurto; }
    public void setCodigoCurto(String codigoCurto) { this.codigoCurto = codigoCurto; }
}