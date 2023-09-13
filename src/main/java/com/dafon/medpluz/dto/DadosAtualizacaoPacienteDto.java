package com.dafon.medpluz.dto;

import jakarta.validation.Valid;

public record DadosAtualizacaoPacienteDto(
        Long id,
        String nome,
        String telefone,
        @Valid
        DadosEnderecoDto endereco) {

}
