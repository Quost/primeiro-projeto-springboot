package io.github.mqdev.ioc_di;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/component")
public class MeuControllerComponente {

    @Autowired
    MeuComponente meuComponente;
    
    @GetMapping("/")
    public String chamarMeuComponente() {
        return meuComponente.chamarMeuComponente();
    }
    
}
