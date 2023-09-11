package com.dafon.medpluz.repository;

import com.dafon.medpluz.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
