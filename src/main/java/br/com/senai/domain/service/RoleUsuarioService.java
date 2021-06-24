package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuario;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import lombok.AllArgsConstructor;
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
}
