package com.example.lutalivre.repositorio;

import com.example.lutalivre.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LutadorRepository extends JpaRepository<Lutador, Integer> {
    public List<Lutador> findAllByOrderByForcaGolpeDesc();
}
