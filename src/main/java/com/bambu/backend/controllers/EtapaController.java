package com.bambu.backend.controllers;

import com.bambu.backend.models.EtapaModel;
import com.bambu.backend.repositories.EtapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}
