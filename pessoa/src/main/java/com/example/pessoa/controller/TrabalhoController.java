package com.example.pessoa.controller;

import com.example.pessoa.model.Trabalho;
import com.example.pessoa.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping
    private ResponseEntity<List<Trabalho>> listarTrabalhos(){
        List<Trabalho> list = trabalhoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    private ResponseEntity<Trabalho> criarTrabalho(@RequestBody Trabalho trabalho){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
                .buildAndExpand(trabalho.getId()).toUri();
        Trabalho response = trabalhoService.criarTrabalho(trabalho);
        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletarTrabalho(@PathVariable Long id){
        trabalhoService.deletarTrabalho(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public Trabalho getTrabalhoById(@PathVariable Long id) {return trabalhoService.getTrabalhoById(id);}

    @PutMapping("/{id}")
    public ResponseEntity<Trabalho> atualizar(@PathVariable Long id, @RequestBody Trabalho trabalho){
        Trabalho response = trabalhoService.atualizarTrabalho(id, trabalho);
        return ResponseEntity.ok().body(response);
    }

}
