package com.dafon.medpluz.controller;

import com.dafon.medpluz.controller.dto.DadosCadastroMedicoDto;
import com.dafon.medpluz.controller.dto.DadosListagemMedicoDto;
import com.dafon.medpluz.model.Endereco;
import com.dafon.medpluz.model.Medico;
import com.dafon.medpluz.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping()
    @Transactional()
        public void cadastrar(@RequestBody @Valid DadosCadastroMedicoDto dados) {

        repository.save(new Medico(dados));
    }

    @GetMapping()
    public Page<DadosListagemMedicoDto> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedicoDto::new);
    }

}
