package br.com.senai.api.controller;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.EntregaModel;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.EntregaInput;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;
    private PessoaAssembler pessoaAssembler;

    @GetMapping
    public List<PessoaModel> listar(Pessoa pessoa){
    return pessoaService.listar(pessoa);
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<PessoaModel> listarPorNome(@PathVariable String pessoaNome, Pessoa pessoa){
        return pessoaService.listarPorNome(pessoaNome, pessoa);
    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<PessoaModel> listarNomeContaining(@PathVariable String nomeContaining){
        return pessoaService.listarNomeContaining(nomeContaining);
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<PessoaModel> buscar(@PathVariable Long pessoaId){
//        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);

//        if(pessoa.isPresent()){
//            return ResponseEntity.ok(pessoa.get());
//        }
//        return ResponseEntity.notFound().build();

        return pessoaService.buscarPessoa(pessoaId);

    }

    @PostMapping
    public PessoaModel cadastrar(@Valid @RequestBody PessoaModel pessoaModel){
        Pessoa novaPessoa = pessoaAssembler.toEntity(pessoaModel);
        Pessoa pessoa1 = pessoaService.cadastrar(novaPessoa);

        return pessoaAssembler.toModel(pessoa1);

    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<PessoaModel> editar(@Valid @PathVariable  Long pessoaId, @RequestBody Pessoa pessoa){

        return pessoaService.editar(pessoaId,pessoa);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> remover(@PathVariable Long pessoaId){
        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        pessoaService.excluir(pessoaId);

        return ResponseEntity.noContent().build();
    }

}
