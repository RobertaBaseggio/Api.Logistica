package br.com.senai.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column( name = "destinatario_nome")
    public String nome;

    @Column( name = "destinatario_logradouro")
    public String logradouro;

    @Column( name = "destinatario_numero")
    public String numero;

    @Column( name = "destinatario_complemento")
    public String complemento;

    @Column( name = "destinatario_bairro")
    public String bairro;

}
