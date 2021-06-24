package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.api.model.input.RoleUsuarioInputDTo;
import br.com.senai.domain.model.RoleUsuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class RoleUsuarioAssembler {

    private ModelMapper modelMapper;

    public RoleUsuarioDTO toModel(RoleUsuario roleUsuario){
        return modelMapper.map(roleUsuario, RoleUsuarioDTO.class);
    }

    public List<RoleUsuarioDTO> toCollectionModel(List<RoleUsuario> roles){
    return roles.stream().map(this::toModel).collect(Collectors.toList());
    }

    public  RoleUsuario toEntity(RoleUsuarioInputDTo roleUsuarioInputDTo){
        return modelMapper.map(roleUsuarioInputDTo, RoleUsuario.class);
    }
}
