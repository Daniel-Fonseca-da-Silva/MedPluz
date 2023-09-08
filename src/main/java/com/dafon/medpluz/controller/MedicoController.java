package com.dafon.medpluz.controller;

import com.dafon.medpluz.controller.dto.DadosCadastroMedicoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @PostMapping()
        public void cadastrar(@RequestBody DadosCadastroMedicoDto dados) {
        System.out.println(dados);

    }

}
