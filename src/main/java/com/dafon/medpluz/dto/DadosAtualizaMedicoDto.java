package com.dafon.medpluz.dto;

import com.dafon.medpluz.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosAtualizaMedicoDto(

        @NotNull
        Long id,

        String nome,

        @Email
        String email,

        String telefone,

        @Pattern(regexp = "\\d{4,6}")
        String crm,

        Especialidade especialidade,

        @Valid
        DadosEnderecoDto endereco) {

}
