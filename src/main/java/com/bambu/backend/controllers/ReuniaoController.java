package com.bambu.backend.controllers;

import com.bambu.backend.dtos.ReuniaoDto;
import com.bambu.backend.models.ReuniaoModel;
import com.bambu.backend.repositories.ProjetoRepository;
import com.bambu.backend.repositories.ReuniaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ReuniaoController {

    @Autowired
    private ReuniaoRepository reuniaoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @GetMapping("/reunioes")
    public ResponseEntity<List<ReuniaoModel>> getAllReunioes() {
        List AllReuniaos = reuniaoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(AllReuniaos);
    }

    @GetMapping("/reunioes/{id}")
    public ResponseEntity<ReuniaoModel> getReuniaoById(@PathVariable UUID id) {
        Optional<ReuniaoModel> Reuniao = reuniaoRepository.findById(id);
        return Reuniao.map(reuniaoModel -> ResponseEntity.status(HttpStatus.OK).body(reuniaoModel)).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/reunioes/{id}")
    public ResponseEntity<String> deleteReuniaoById(@PathVariable UUID id) {
        Optional<ReuniaoModel> Reuniao = reuniaoRepository.findById(id);
        if (Reuniao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reunião não encontrada");
        }

        reuniaoRepository.delete(Reuniao.get());
        return ResponseEntity.status(HttpStatus.OK).body("Reuniao removida com sucessor");
    }

    @PutMapping
    public ResponseEntity<Object> updateReuniaoById(@PathVariable UUID id, @RequestBody ReuniaoDto reuniaoDto) {
        Optional<ReuniaoModel> Reuniao = reuniaoRepository.findById(id);
        if (Reuniao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Reuniao nao encontrado");
        }

        ReuniaoModel reuniao = Reuniao.get();
        BeanUtils.copyProperties(reuniaoDto, reuniao);
        return ResponseEntity.status(HttpStatus.OK).body(reuniaoRepository.save(reuniao));
    }
}
