package com.bambu.backend.services;

import com.bambu.backend.dtos.ArquitetoDto;
import com.bambu.backend.models.ArquitetoModel;
import com.bambu.backend.repositories.ArquitetoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArquitetoService {

    @Autowired
    private ArquitetoRepository arquitetoRepository;

    public ArquitetoModel createArquiteto(ArquitetoDto arquitetoDto) {
        ArquitetoModel arquitetoModel = new ArquitetoModel();
        BeanUtils.copyProperties(arquitetoDto, arquitetoModel);
        return arquitetoRepository.save(arquitetoModel);
    }

    public Optional<ArquitetoModel> getArquitetoById(UUID id) {
        return arquitetoRepository.findById(id);
    }

    public List<ArquitetoModel> getAllArquitetos() {
        return arquitetoRepository.findAll();
    }

    public boolean deleteArquitetoById(UUID id) {
        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoRepository.findById(id);
        if (arquitetoModelOptional.isPresent()) {
            arquitetoRepository.delete(arquitetoModelOptional.get());
            return true;
        }
        return false;
    }

    public Optional<ArquitetoModel> updateArquiteto(UUID id, ArquitetoDto arquitetoDto) {
        Optional<ArquitetoModel> arquitetoModelOptional = arquitetoRepository.findById(id);
        if (arquitetoModelOptional.isPresent()) {
            ArquitetoModel arquiteto = arquitetoModelOptional.get();
            BeanUtils.copyProperties(arquitetoDto, arquiteto);
            return Optional.of(arquitetoRepository.save(arquiteto));
        }
        return Optional.empty();
    }

    public List<ArquitetoModel> getArquitetosByNome(String nome) {
        return arquitetoRepository.findByNomeContainingIgnoreCase(nome);
    }

}
