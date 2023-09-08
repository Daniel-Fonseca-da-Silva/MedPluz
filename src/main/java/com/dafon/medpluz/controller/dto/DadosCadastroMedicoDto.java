package com.dafon.medpluz.controller.dto;

import com.dafon.medpluz.controller.enums.Especialidade;

public record DadosCadastroMedicoDto(String nome, String email, String crm, Especialidade especialdiade, DadosEnderecoDto endereco) {
}
