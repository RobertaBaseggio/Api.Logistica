package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaModel {

    private long id;
    private String nomePessoa;
    private String emailPessoa;
    private String telefone;

}
