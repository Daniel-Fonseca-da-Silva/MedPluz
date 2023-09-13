package com.dafon.medpluz.dto;

import com.dafon.medpluz.model.Paciente;

public record DadosListagemPacienteDto(Long id, String nome, String email, String cpf) {
    public DadosListagemPacienteDto(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}
