package com.dafon.medpluz.controller;

import com.dafon.medpluz.dto.*;
import com.dafon.medpluz.model.Paciente;
import com.dafon.medpluz.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping()
    @Transactional()
    public void cadastrar(@RequestBody @Valid DadosCadastroPacienteDto dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacienteDto> listar(@PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacienteDto::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacienteDto dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
