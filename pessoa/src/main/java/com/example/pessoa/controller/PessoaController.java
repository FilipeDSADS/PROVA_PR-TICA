package com.example.pessoa.controller;

import com.example.pessoa.model.Pessoa;
import com.example.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    private ResponseEntity<List<Pessoa>> listarPessoas(){
        List<Pessoa> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    private ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(pessoa.getId()).toUri();
        Pessoa response = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Pessoa getPessoaById(@PathVariable Long id) {return pessoaService.getPessoaById(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa response = pessoaService.atualizarPessoa(id, pessoa);
        return ResponseEntity.ok().body(response);
    }


}