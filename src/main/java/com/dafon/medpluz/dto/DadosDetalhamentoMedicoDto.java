package com.dafon.medpluz.dto;

import com.dafon.medpluz.enums.Especialidade;
import com.dafon.medpluz.model.Endereco;
import com.dafon.medpluz.model.Medico;

public record DadosDetalhamentoMedicoDto(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedicoDto(Medico medico) {
           this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),
                   medico.getEspecialidade(), medico.getEndereco());
    }

}
