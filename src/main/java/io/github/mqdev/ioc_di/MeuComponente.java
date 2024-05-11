package io.github.mqdev.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MeuComponente {
    public String chamarMeuComponente() {
        return "Chamando meu componente";
    }
}
