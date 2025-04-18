package com.example.pessoa.service;

import com.example.pessoa.model.Pessoa;
import com.example.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {return pessoaRepository.save(pessoa);}

    public Pessoa getPessoaById(Long id) {return pessoaRepository.findById(id).get();}

    public List<Pessoa> findAll() {return pessoaRepository.findAll();}

    public void deletarPessoa(Long id){pessoaRepository.deleteById(id);}

    public Pessoa atualizarPessoa(Long id,Pessoa pessoa){
        Pessoa p = pessoaRepository.findById(id).get();
        pessoa.setNome(pessoa.getNome());
        pessoa.setCpf((pessoa.getCpf()));
        return pessoaRepository.save(p);
    }

}
