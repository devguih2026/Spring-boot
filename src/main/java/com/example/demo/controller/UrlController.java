package com.example.demo.controller;

import com.example.demo.model.Url;
import com.example.demo.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import java.util.UUID;

@RestController // Define que esta classe responde a requisições via navegador/API
public class UrlController {

    @Autowired // Injeção de Dependência: o Spring entrega o Repository pronto para uso
    private UrlRepository repository;

    // Rota para criar o link: localhost:8080/encurtar?url=google.com
    @GetMapping("/encurtar")
    public String encurtar(@RequestParam String url) {
        
        // Garante que a URL tenha o protocolo para o redirecionamento funcionar
        if (!url.startsWith("http")) {
            url = "https://" + url;
        }

        // Gera uma sequência aleatória de 6 caracteres
        String codigo = UUID.randomUUID().toString().substring(0, 6);
        
        // Criamos o objeto e preenchemos os dados
        Url novaUrl = new Url();
        novaUrl.setUrlOriginal(url);
        novaUrl.setCodigoCurto(codigo);
        
        // Salvamos no banco de dados
        repository.save(novaUrl);
        
        return "Link criado com sucesso! Use este endereco: http://localhost:8080/" + codigo;
    }

    // Rota dinâmica: localhost:8080/907eee
    @GetMapping("/{codigo}") // O {codigo} é uma variável que vem na URL
    public RedirectView redirecionar(@PathVariable String codigo) {
        
        // Busca no banco pelo código. Se não achar, dá erro.
        Url urlEncontrada = repository.findByCodigoCurto(codigo)
                .orElseThrow(() -> new RuntimeException("URL não encontrada no sistema"));
        
        // Retorna um comando de redirecionamento para o navegador
        return new RedirectView(urlEncontrada.getUrlOriginal());
    }
}