package com.dafon.medpluz.controller;

import com.dafon.medpluz.dto.*;
import com.dafon.medpluz.model.Medico;
import com.dafon.medpluz.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping()
    @Transactional()
        public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicoDto dados, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriBuilder.path("/api/v1/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedicoDto(medico));
    }

    @GetMapping()
    public ResponseEntity<Page<DadosListagemMedicoDto>> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedicoDto::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping()
    @Transactional()
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizaMedicoDto dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoMedicoDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional()
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedicoDto(medico));
    }

}
