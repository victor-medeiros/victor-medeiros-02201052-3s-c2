package com.example.lutalivre.controle;

import com.example.lutalivre.dominio.Golpe;
import com.example.lutalivre.dominio.Lutador;
import com.example.lutalivre.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    // Listando todos os lutadores
    @GetMapping
    public ResponseEntity getLutadores() {
        List<Lutador> lutadores = repository.findAllByOrderByForcaGolpeAsc();
        if (lutadores.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(lutadores);
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getContagemVivos() {
        List<Lutador> lutadores = repository.findAll();

        Long qtdVivos = lutadores.stream().filter(lutador -> lutador.isVivo()).count();
        return ResponseEntity.status(200).body(qtdVivos);
    }

    // Criação de um lutador
    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador) {
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    // Dando golpe em outro lutador
    @PostMapping("/golpe")
    public ResponseEntity postGolpe(@RequestBody int idLutadorBate, @RequestBody int idLutadorApanha) {
        Optional<Lutador> lutadorbate = repository.findById(idLutadorBate);
        Optional<Lutador> lutadorApanha = repository.findById(idLutadorApanha);

//        if (!lutadorbate.isPresent() || !lutadorApanha.isPresent()) {
//            return ResponseEntity.status(404).body("Ambos devem estar vivos");
//        }
//        lutadorApanha.get().setVida(lutadorbate.get().getForcaGolpe());

        List<Lutador> lutadores = new ArrayList<>();
        lutadores.add(lutadorbate.get());
        lutadores.add(lutadorApanha.get());
        return ResponseEntity.status(201).body(lutadores);
    }

    @PostMapping("/{id}/concentrar")
    public ResponseEntity postConcentrar(@PathVariable Integer id) {
        Optional<Lutador> lutador = repository.findById(id);
        if (!lutador.isPresent()) return ResponseEntity.status(404).build();

        if (lutador.get().getConcentracoesRealizadas() == 3) {
            return ResponseEntity.status(400).body("Lutador já se concentrou 3 vezes!");
        }
        lutador.get().setConcentracoesRealizadas();
        return ResponseEntity.status(201).build();
    }
}
