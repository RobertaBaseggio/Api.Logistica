package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class DestinatarioInput {

    @NotBlank
    public String nome;

    @NotBlank
    public String logradouro;

    @NotBlank
    public String numero;

    @NotBlank
    public String complemento;

    @NotBlank
    public String bairro;
}
