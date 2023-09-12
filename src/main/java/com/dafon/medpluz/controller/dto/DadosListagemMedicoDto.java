package com.dafon.medpluz.controller.dto;

import com.dafon.medpluz.controller.enums.Especialidade;
import com.dafon.medpluz.model.Medico;

public record DadosListagemMedicoDto (Long id, String nome, String telefone, String email, String crm, Especialidade especialidade)
{
    public DadosListagemMedicoDto(Medico medico) {
            this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}


