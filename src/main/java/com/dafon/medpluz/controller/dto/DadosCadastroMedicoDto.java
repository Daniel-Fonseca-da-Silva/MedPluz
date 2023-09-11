package com.dafon.medpluz.controller.dto;

import com.dafon.medpluz.controller.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroMedicoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEnderecoDto endereco) {
}
