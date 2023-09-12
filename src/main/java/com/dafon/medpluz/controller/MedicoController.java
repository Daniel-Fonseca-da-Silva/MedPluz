package com.dafon.medpluz.controller;

import com.dafon.medpluz.dto.*;
import com.dafon.medpluz.model.Medico;
import com.dafon.medpluz.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


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
    public Page<DadosListagemMedicoDto> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoDto::new);
    }

    @PutMapping()
    @Transactional()
    public void atualizar(@RequestBody @Valid DadosAtualizaMedicoDto dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional()
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
