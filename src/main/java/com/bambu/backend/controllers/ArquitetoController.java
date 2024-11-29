package com.bambu.backend.controllers;

import com.bambu.backend.dtos.ArquitetoDto;
import com.bambu.backend.models.ArquitetoModel;
import com.bambu.backend.repositories.ArquitetoRepository;
import com.bambu.backend.services.ArquitetoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/arquitetos")
public class ArquitetoController {

    @Autowired
    private ArquitetoService arquitetoService;

    @PostMapping
    public ResponseEntity<ArquitetoModel> criarArquiteto(@RequestBody ArquitetoDto arquitetoDto) {

        ArquitetoModel arquitetoSalvo = arquitetoService.createArquiteto(arquitetoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(arquitetoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArquitetoById(@PathVariable UUID id) {

        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoService.getArquitetoById(id);
        if (arquitetoModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquiteto not found!");
        }
        return ResponseEntity.ok(arquitetoModelOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<ArquitetoModel>> getAllArquitetos(){
        List<ArquitetoModel> allArquitetos = arquitetoService.getAllArquitetos();
        return ResponseEntity.ok(allArquitetos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ArquitetoModel>> getArquitetosByNome(@RequestParam String nome) {
        List<ArquitetoModel> arquitetos = arquitetoService.getArquitetosByNome(nome);
        if (arquitetos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(arquitetos);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArquitetoById(@PathVariable UUID id){
        if (arquitetoService.deleteArquitetoById(id)) {
            return ResponseEntity.ok("Arquiteto deleted successfully!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquiteto not found!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArquitetoById(@RequestBody ArquitetoDto arquitetoDto,
                                                    @PathVariable UUID id){
        Optional<ArquitetoModel> updatedArquiteto = arquitetoService.updateArquiteto(id, arquitetoDto);
        if (updatedArquiteto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquiteto not found!");
        }
        return ResponseEntity.ok(updatedArquiteto.get());
    }


}
