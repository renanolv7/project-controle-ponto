package com.estudos.api_controle_ponto.repositories;

import com.estudos.api_controle_ponto.models.ControlePontoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface ControlePontoRepository extends JpaRepository<ControlePontoEntity, Long> {
    Optional<ControlePontoEntity> findByMatriculaAndDataAtual(String matricula, LocalDate data);
}
