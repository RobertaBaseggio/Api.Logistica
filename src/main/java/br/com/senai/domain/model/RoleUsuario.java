package br.com.senai.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "role_usuarios")
public class RoleUsuario {

    private long usuarios_id;

    private String role_nome_role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
