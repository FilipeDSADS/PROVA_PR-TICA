package com.example.pessoa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Trabalho")
public class Trabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String endereco;

    public Trabalho(Object o, String endereco){
    }

    public Trabalho(Long id, String nome, String endereco) {
        this.id = id;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
