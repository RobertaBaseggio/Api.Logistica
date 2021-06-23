package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTO {

    private String email;
    private String senha;
}
