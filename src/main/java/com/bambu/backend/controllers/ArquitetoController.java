package com.bambu.backend.controllers;

import com.bambu.backend.dtos.ArquitetoDto;
import com.bambu.backend.models.ArquitetoModel;
import com.bambu.backend.repositories.ArquitetoRepository;
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
    private ArquitetoRepository arquitetoRepository;

    @PostMapping
    public ResponseEntity<ArquitetoModel> criarArquiteto(@RequestBody ArquitetoDto arquitetoDto) {

        ArquitetoModel arquitetoModel = new ArquitetoModel();
        BeanUtils.copyProperties(arquitetoDto, arquitetoModel);
        ArquitetoModel arquitetoSalvo = arquitetoRepository.save(arquitetoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(arquitetoSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getArquitetoById(@PathVariable UUID id) {

        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoRepository.findById(id);

        if(arquitetoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquiteto not found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(arquitetoModelOptional.get());
    }

    @GetMapping
    public ResponseEntity<List<ArquitetoModel>> getAllArquitetos(){
        List<ArquitetoModel> allProducts = arquitetoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allProducts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArquitetoById(@PathVariable UUID id){
        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoRepository.findById(id);
        if(arquitetoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }
        arquitetoRepository.delete(arquitetoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateArquitetoById(@RequestBody ArquitetoDto arquitetoDto,
                                                    @PathVariable UUID id){
        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoRepository.findById(id);
        if(arquitetoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found!");
        }

        ArquitetoModel arquiteto = arquitetoModelOptional.get();
        BeanUtils.copyProperties(arquitetoDto, arquiteto);
        return ResponseEntity.status(HttpStatus.OK).body(arquitetoRepository.save(arquiteto));
    }


}
