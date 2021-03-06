package br.com.senai.api.model;

import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
public class EntregaDTO {


    private Long id;
    private PessoaDTO nomePessoa;
    private DestinatarioDTO destinatario;
    private BigDecimal taxa;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
    private StatusEntrega status;


}
