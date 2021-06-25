package br.com.senai.api.controller;


import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.api.model.input.RoleUsuarioInputDTo;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.model.RoleUsuario;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import br.com.senai.domain.service.RoleUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleUsuarioController {

    private RoleUsuarioService roleUsuarioService;


    @GetMapping
    public List<RoleUsuarioDTO> listar(){

        return roleUsuarioService.listar();
    }

    @PutMapping("/{roleUsuarioId}")
    public ResponseEntity<RoleUsuarioDTO> editar(@Valid @PathVariable Long roleUsuarioId,
                                                 @RequestBody RoleUsuario roleUsuario){

        return roleUsuarioService.editar(roleUsuarioId, roleUsuario);
    }

}
