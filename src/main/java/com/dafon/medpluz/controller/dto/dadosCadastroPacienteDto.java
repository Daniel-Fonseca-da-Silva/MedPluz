package com.dafon.medpluz.controller.dto;

import com.dafon.medpluz.dto.DadosEnderecoDto;

public record dadosCadastroPacienteDto(
    String nome,
    String email,
    String telefone,
    String cpf,

    DadosEnderecoDto endereco
)
{
}
