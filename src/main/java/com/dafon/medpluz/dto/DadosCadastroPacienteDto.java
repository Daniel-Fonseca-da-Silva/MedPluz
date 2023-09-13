package com.dafon.medpluz.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosCadastroPacienteDto(

    @NotBlank
    String nome,
    @NotBlank
    @Email
    String email,
    @NotBlank
    String telefone,
    @NotBlank
    @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
    String cpf,
    @NotNull
    @Valid
    DadosEnderecoDto endereco
) {

}

