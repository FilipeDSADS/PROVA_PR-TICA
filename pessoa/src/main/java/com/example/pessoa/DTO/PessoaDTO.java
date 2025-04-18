package com.example.pessoa.DTO;

import com.example.pessoa.model.Pessoa;

public class PessoaDTO {

    private Long id;
    private String nome;

    public Pessoa transformaParaObjeto(){
        return new Pessoa(null,nome);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
