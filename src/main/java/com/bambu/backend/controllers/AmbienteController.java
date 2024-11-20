package com.bambu.backend.controllers;

import com.bambu.backend.dtos.AmbienteDto;
import com.bambu.backend.models.AmbienteModel;
import com.bambu.backend.repositories.AmbienteRepository;
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
public class AmbienteController {

    @Autowired
    private AmbienteRepository ambienteRepository;
    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/projetos/ambientes")
    public ResponseEntity<Object> criarAmbiente(@RequestBody @Valid AmbienteDto ambienteDto) {
        try {
            AmbienteModel ambienteSalvo = projetoService.criarAmbiente(ambienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(ambienteSalvo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/projetos/ambientes")
    public ResponseEntity<List<AmbienteModel>> getAllAmbientes() {
        List<AmbienteModel> ambientes = ambienteRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ambientes);
    }

    @DeleteMapping("/projetos/ambientes/{id}")
    public ResponseEntity<Object> deleteAmbiente(@PathVariable UUID id) {
        Optional<AmbienteModel> ambiente = ambienteRepository.findById(id);
        if (ambiente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ambiente nao encontrado");
        }

        ambienteRepository.delete(ambiente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Ambiente deletado");
    }

    @PutMapping("/projetos/ambientes/{id}")
    public ResponseEntity<Object> updateAmbiente(@PathVariable UUID id, @RequestBody @Valid AmbienteDto ambienteDto) {
        Optional<AmbienteModel> ambiente = ambienteRepository.findById(id);
        if (ambiente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ambiente nao encontrado");
        }

        AmbienteModel ambienteSalvo = ambiente.get();
        BeanUtils.copyProperties(ambienteDto, ambienteSalvo);
        return ResponseEntity.status(HttpStatus.OK).body(ambienteSalvo);
    }
}
