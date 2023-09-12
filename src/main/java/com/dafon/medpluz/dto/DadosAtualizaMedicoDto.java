package com.dafon.medpluz.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaMedicoDto(
        @NotNull
        Long id,

        String nome,
        String telefone,
        DadosEnderecoDto endereco) {

}
