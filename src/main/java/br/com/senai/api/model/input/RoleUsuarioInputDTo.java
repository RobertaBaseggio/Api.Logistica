package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Setter
@Getter
public class RoleUsuarioInputDTo {

    private long usuarios_id;
    private String role_nome_role;

}
