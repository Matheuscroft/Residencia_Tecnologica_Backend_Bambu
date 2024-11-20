package com.bambu.backend.repositories;

import com.bambu.backend.models.AmbienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AmbienteRepository extends JpaRepository<AmbienteModel, UUID> {
    List<AmbienteModel> findByNomeAmbienteContaining(String nomeAmbiente);

    List<AmbienteModel> findByNomeAmbiente(String nomeAmbiente);

    Optional<AmbienteModel> findById(UUID id);
}
