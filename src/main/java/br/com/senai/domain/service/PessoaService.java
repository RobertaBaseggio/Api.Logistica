package br.com.senai.domain.service;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.EntregaModel;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler  pessoaAssembler;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa) {

        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail()).isPresent();

        if (emailValidation) {
            throw new NegocioException("Já existe uma pessoa com este e-mail cadastrado");
        }
        return pessoaRepository.save(pessoa);
    }

        @Transactional
        public void excluir(Long pessoaId){

        pessoaRepository.deleteById(pessoaId);

            throw new NegocioException("Pessoa deletada");

        }

        public Pessoa buscar(Long pessoaId){
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(()->new NegocioException("Pessoa não encontrada."));
        }

    public ResponseEntity<PessoaModel> buscarPessoa(Long pessoaId) {
        return pessoaRepository.findById(pessoaId).map(entrega -> {

            return ResponseEntity.ok(pessoaAssembler.toModel(entrega));
        })
                .orElseThrow(()-> new NegocioException("Pessoa não encontrada"));

    }

    public List<PessoaModel> listar(Pessoa pessoa){

        boolean ListValidation = pessoaRepository.findAll().isEmpty();

        if (ListValidation) {
            throw new NegocioException("Não existe nenhuma pessoa cadastrada");
        }

        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    public List<PessoaModel> listarPorNome(String nome){

        boolean nomeValidation = pessoaRepository.findByNome(nome).isEmpty();

        if (nomeValidation) {
            throw new NegocioException("Não existe nenhuma pessoa cadastrada com este nome");
        }

        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNome(nome));
    }


    public List<PessoaModel> listarNomeContaining(String nomeContaining){

        boolean containingValidation = pessoaRepository.findByNomeContaining(nomeContaining).isEmpty();

        if (containingValidation) {
            throw new NegocioException("Não encontrado");
        }

        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNomeContaining(nomeContaining));
    }

    public ResponseEntity<PessoaModel> editar(Long pessoaId, Pessoa pessoa){
        if(!pessoaRepository.existsById(pessoaId)){
            throw new NegocioException("Id não encontrado");
        }

        pessoa.setId(pessoaId);
        pessoa = pessoaRepository.save(pessoa);

        return ResponseEntity.ok(pessoaAssembler.toModel(pessoa));
    }


}
