package com.bambu.backend.controllers;

import com.bambu.backend.models.EtapaModel;
import com.bambu.backend.models.ProjetoModel;
import com.bambu.backend.dtos.ProjetoDto;
import com.bambu.backend.repositories.EtapaRepository;
import com.bambu.backend.repositories.ProjetoRepository;
import com.bambu.backend.services.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProjetoController {

    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private EtapaRepository etapaRepository;
    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/projetos")
    public ResponseEntity<Object> criarProjeto(@RequestBody @Valid ProjetoDto projetoDto) {
        try {
            ProjetoModel projetoSalvo = projetoService.criarProjeto(projetoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }





    @GetMapping("/projetos")
    public ResponseEntity<List<ProjetoModel>> getAllProjects(){
        List<ProjetoModel> allProjetos = projetoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allProjetos);
    }


    @GetMapping("/projetos/{id}")
    public ResponseEntity<Object> getProjetoById(@PathVariable UUID id){
        Optional<ProjetoModel> projetoEncontrado = projetoRepository.findById(id);
        return projetoEncontrado.<ResponseEntity<Object>>map(projetoModel -> ResponseEntity.status(HttpStatus.OK).body(projetoModel)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado!"));
    }

    @DeleteMapping("/projetos/{id}")
    public ResponseEntity<String> deleteProjetoById(@PathVariable UUID id){
        Optional<ProjetoModel> produtoEncontrado = projetoRepository.findById(id);
        if(produtoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado!");
        }

        projetoRepository.delete(produtoEncontrado.get());
        return ResponseEntity.status(HttpStatus.OK).body("Projeto removido com sucesso!");
    }

    @PutMapping("/projetos/{id}")
    public ResponseEntity<Object> updateProjetoById(@PathVariable UUID id, @RequestBody ProjetoDto projetoDto){
        Optional<ProjetoModel> produtoEncontrado = projetoRepository.findById(id);
        if(produtoEncontrado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado!");
        }

        ProjetoModel projeto = produtoEncontrado.get();
        BeanUtils.copyProperties(projetoDto, projeto);
        return ResponseEntity.status(HttpStatus.OK).body(projetoRepository.save(projeto));
    }
}
