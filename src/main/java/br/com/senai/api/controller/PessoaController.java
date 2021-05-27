package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PessoaController {

    @GetMapping("/pessoas")

    public List<Pessoa> listar(){
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        pessoa1.setNome("Roberta");
        pessoa1.setEmail("Roberta@gmail.com");
        pessoa1.setTelefone("(46)99972-7864");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoa2.setNome("Maria");
        pessoa2.setEmail("maria@gmail.com");
        pessoa2.setTelefone("(47)99772-7664");


        return Arrays.asList(pessoa1, pessoa2);
    }
}
