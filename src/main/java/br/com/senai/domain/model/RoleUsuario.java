package br.com.senai.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "role_usuarios")
public class RoleUsuario {

    @NotNull
    private long usuarios_id;

    @NotBlank
    private String role_nome_role;

    @Id
    private long id;

}
