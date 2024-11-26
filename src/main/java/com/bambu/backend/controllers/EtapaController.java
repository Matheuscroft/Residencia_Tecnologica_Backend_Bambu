package com.bambu.backend.controllers;

import com.bambu.backend.dtos.EtapaDto;
import com.bambu.backend.models.EtapaModel;
import com.bambu.backend.repositories.EtapaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/etapas")
public class EtapaController {

    @Autowired
    private EtapaRepository etapaRepository;

    @GetMapping("/{projetoId}")
    public ResponseEntity<List<EtapaModel>> getEtapasByProjetoId(@PathVariable UUID projetoId) {
        List<EtapaModel> etapas = etapaRepository.findByProjetoId(projetoId);
        if (etapas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(etapas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtapaModel> atualizarEtapa(@PathVariable UUID id, @RequestBody EtapaDto etapaDto) {
        Optional<EtapaModel> etapaOptional = etapaRepository.findById(id);
        if (etapaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EtapaModel etapa = etapaOptional.get();

        BeanUtils.copyProperties(etapaDto, etapa, "id", "projeto", "reunioes");

        etapaRepository.save(etapa);

        return ResponseEntity.ok(etapa);
    }
}
