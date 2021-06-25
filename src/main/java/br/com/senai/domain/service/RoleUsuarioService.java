package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuario;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleUsuarioService {

    private RoleUsuarioRepository roleUsuarioRepository;
    private RoleUsuarioAssembler roleUsuarioAssembler;

    public List<RoleUsuarioDTO> listar(){

        return roleUsuarioAssembler.toCollectionModel(roleUsuarioRepository.findAll());
    }

    @Transactional
    public RoleUsuario cadastrar(RoleUsuario roleUsuario) {

        return roleUsuarioRepository.save(roleUsuario);
    }

    public ResponseEntity<RoleUsuarioDTO> editar(Long roleUsuarioId, RoleUsuario roleUsuario){

        if(!roleUsuarioRepository.existsById(roleUsuarioId)){
            throw new NegocioException("Id não encontrado");
        }

        roleUsuario.setId(roleUsuarioId);
        roleUsuario.setRole_nome_role(roleUsuario.getRole_nome_role());
        roleUsuarioRepository.save(roleUsuario);

        return ResponseEntity.ok(roleUsuarioAssembler.toModel(roleUsuario));
    }
}
