package com.dafon.medpluz.controller;

import com.dafon.medpluz.controller.dto.dadosCadastroPacienteDto;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @PostMapping()
    @Transactional()
    public void cadastrar(@RequestBody dadosCadastroPacienteDto dados) {
        System.out.println("Dados recebidos: " + dados);
    }

}
