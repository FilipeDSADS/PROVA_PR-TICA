package com.example.pessoa.DTO;

import com.example.pessoa.model.Trabalho;

public class TrabalhoDTO {

    private Long id;
    private String endereco;

    public Trabalho transformaParaOObjeto(){
        return new Trabalho(null,endereco);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return endereco;
    }

    public void setNome(String nome) {
        this.endereco = endereco;
    }

}
