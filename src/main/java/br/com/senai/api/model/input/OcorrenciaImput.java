package br.com.senai.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class OcorrenciaImput {

    @NotBlank
    private String descricao;
}