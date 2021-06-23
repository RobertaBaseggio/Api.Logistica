package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaDTO {

    private String nome;
    private String telefone;
    private UsuarioDTO usuario;

}
