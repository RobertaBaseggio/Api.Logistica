package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class OcorrenciaDTO {

    private Long id;
    private String descricao;
    private LocalDateTime dataRegistro;
}
