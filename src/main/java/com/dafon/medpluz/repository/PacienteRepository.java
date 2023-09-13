package com.dafon.medpluz.repository;

import com.dafon.medpluz.model.Paciente;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);
}
