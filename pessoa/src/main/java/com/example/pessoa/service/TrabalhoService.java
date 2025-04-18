package com.example.pessoa.service;

import com.example.pessoa.model.Trabalho;
import com.example.pessoa.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public Trabalho criarTrabalho(Trabalho trabalho) {return trabalhoRepository.save(trabalho);}

    public Trabalho getTrabalhoById(Long id) {return trabalhoRepository.findById(id).get();}

    public List<Trabalho> findAll() {return trabalhoRepository.findAll();}

    public void deletarTrabalho(Long id){trabalhoRepository.deleteById(id);}

    public Trabalho atualizarTrabalho(Long id,Trabalho trabalho){
        Trabalho t = trabalhoRepository.findById(id).get();
        trabalho.setEndereco(trabalho.getEndereco());
        return trabalhoRepository.save(t);
    }

}
