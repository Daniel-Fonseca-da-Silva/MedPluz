package com.dafon.medpluz.dto;

import com.dafon.medpluz.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroMedicoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEnderecoDto endereco) {
}
