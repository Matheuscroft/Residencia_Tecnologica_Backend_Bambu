package com.bambu.backend.controllers;

import com.bambu.backend.dtos.AmbienteDto;
import com.bambu.backend.models.ProjetoModel;
import com.bambu.backend.services.AmbienteService;
import com.bambu.backend.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {

    @Autowired
    private AmbienteService ambienteService;

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<String> criarAmbientes(@RequestParam UUID projetoId, @RequestBody List<AmbienteDto> ambientes) {

        Optional<ProjetoModel> projetoOptional = projetoService.findById(projetoId);
        if (projetoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado.");
        }

        ProjetoModel projeto = projetoOptional.get();
        ambienteService.salvarAmbientes(ambientes, projeto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Ambientes criados com sucesso.");
    }

    @GetMapping("/by-projeto")
    public ResponseEntity<List<AmbienteDto>> getAmbientesByProjeto(@RequestParam UUID projetoId) {

        Optional<ProjetoModel> projetoOptional = projetoService.findById(projetoId);
        if (projetoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<AmbienteDto> ambientes = ambienteService.findAmbientesByProjetoId(projetoId);
        return ResponseEntity.ok(ambientes);
    }

}
