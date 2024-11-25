package com.bambu.backend.repositories;

import com.bambu.backend.models.AmbienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AmbienteRepository extends JpaRepository<AmbienteModel, UUID> {

    void deleteByProjetoId(UUID projetoId);

    List<AmbienteModel> findByProjetoId(UUID projetoId);
}
