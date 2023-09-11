package com.dafon.medpluz.controller.dto;

import com.dafon.medpluz.controller.enums.Especialidade;
import com.dafon.medpluz.model.Medico;

public record DadosListagemMedicoDto (String nome, String email, String crm, Especialidade especialidade)
{
    public DadosListagemMedicoDto(Medico medico) {
            this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}


