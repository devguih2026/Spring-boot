package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Url;
import java.util.Optional;

// Ao herdar JpaRepository, ganhamos métodos como save(), findAll() e delete()
public interface UrlRepository extends JpaRepository<Url, Long> {
    
    // Método customizado: O Spring gera o SQL automaticamente 
    // apenas lendo o nome "findByCodigoCurto"
    Optional<Url> findByCodigoCurto(String codigoCurto);
}