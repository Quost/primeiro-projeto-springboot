package io.github.mqdev.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("/primeira-controller")
public class PrimeiraController {

    @GetMapping("/primeiro-metodo/{path-param}")
    public String primeiroMetodo(@PathVariable("path-param") String pathParam) {
        return "Primeiro método da primeira controller. Passando path param: " + pathParam;
    }

    @GetMapping("/segundo-metodo")
    public String segundoMetodo(@RequestParam String queryParam) {
        return "Segundo método da primeira controller. Passando query param: " + queryParam;
    }

    @GetMapping("/terceiro-metodo")
    public String terceiroMetodo(@RequestParam Map<String, String> allQueryParams) {
        return "Terceiro método da primeira controller. Passando todos os query params: " + allQueryParams.entrySet();
    }

    @PostMapping("/quarto-metodo")
    public String quartoMetodo(@RequestBody Pessoa pessoa) {
        return "Quarto método da primeira controller. Passado seguinte pessoa vai body: " + pessoa.nome + " "
                + pessoa.sobrenome;
    }

    @PostMapping("/quinto-metodo")
    public String quintoMetodo(@RequestHeader("Authorization") String authorization) {
        return "Quinto método da primeira controller. Passado seguinte header: " + authorization;
    }

    @PostMapping("/sexto-metodo")
    public String sextoMetodo(@RequestHeader Map<String, String> allHeaders) {
        return "Sexto método da primeira controller. Passado todos os headers: " + allHeaders.entrySet();
    }

    @GetMapping("/setimo-metodo")
    public ResponseEntity<Object> setimoMetodo() {
        return ResponseEntity.status(400)
                .body("Setimo método da primeira controller. Retornando ResponseEntity com status 400");
    }

    @GetMapping("/oitavo-metodo")
    public ResponseEntity<Object> oitavoMetodo() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Oitavo método da primeira controller. Retornando ResponseEntity com status 201");
    }

    @GetMapping("/nono-metodo/{id}")
    public ResponseEntity<Object> nonoMetodo(@PathVariable("id") String id) {
        var pessoa = new Pessoa("Maria", "Silva");

        if (id.equals("1")) {
            return ResponseEntity.status(HttpStatus.OK).body(pessoa);

        } else {
            return ResponseEntity.badRequest()
                    .body("Nono método da primeira controller. Retornando ResponseEntity com status 404 e id: " + id);

        }
    }

    record Pessoa(String nome, String sobrenome) {}

}
