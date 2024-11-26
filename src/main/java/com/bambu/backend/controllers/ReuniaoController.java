package com.bambu.backend.controllers;

import com.bambu.backend.dtos.ReuniaoDto;
import com.bambu.backend.models.EtapaModel;
import com.bambu.backend.models.ReuniaoModel;
import com.bambu.backend.repositories.EtapaRepository;
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

    @Autowired
    private EtapaRepository etapaRepository;

    @PostMapping("/reunioes")
    public ResponseEntity<Object> createReuniao(@RequestBody ReuniaoDto reuniaoDto,
                                                @RequestParam UUID etapaId) {
        if (reuniaoDto.nomeReuniao() == null || reuniaoDto.nomeReuniao().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo 'nomeReuniao' é obrigatório");
        }

        if (reuniaoDto.dataReuniao() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo 'dataReuniao' é obrigatório");
        }

        Optional<EtapaModel> etapa = etapaRepository.findById(etapaId);
        if (etapa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A etapa especificada não foi encontrada");
        }

        ReuniaoModel novaReuniao = new ReuniaoModel();
        BeanUtils.copyProperties(reuniaoDto, novaReuniao);
        novaReuniao.setId(UUID.randomUUID());
        novaReuniao.setEtapa(etapa.get());

        ReuniaoModel reuniaoSalva = reuniaoRepository.save(novaReuniao);
        return ResponseEntity.status(HttpStatus.CREATED).body(reuniaoSalva);
    }


    @GetMapping("/reunioes")
    public ResponseEntity<List<ReuniaoModel>> getAllReunioes() {
        List AllReunioes = reuniaoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(AllReunioes);
    }

    @GetMapping("/reunioes/{etapaId}")
    public ResponseEntity<List<ReuniaoModel>> getReunioesByEtapaId(@PathVariable UUID etapaId) {
        List<ReuniaoModel> reunioes = reuniaoRepository.findByEtapaId(etapaId);
        if (reunioes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(reunioes);
        }
        return ResponseEntity.status(HttpStatus.OK).body(reunioes);
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

    @PutMapping("/reunioes/{id}")
    public ResponseEntity<ReuniaoModel> atualizarReuniao(@PathVariable UUID id, @RequestBody ReuniaoDto reuniaoDto) {
        Optional<ReuniaoModel> reuniaoOptional = reuniaoRepository.findById(id);
        if (reuniaoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        ReuniaoModel reuniao = reuniaoOptional.get();
        // Atualizar os campos
        reuniao.setNomeReuniao(reuniaoDto.nomeReuniao());
        reuniao.setDataReuniao(reuniaoDto.dataReuniao());
        reuniao.setLocal(reuniaoDto.local());
        reuniao.setApontamentos(reuniaoDto.apontamentos());

        // Não altere o ID
        reuniaoRepository.save(reuniao);

        return ResponseEntity.ok(reuniao);
    }


}
