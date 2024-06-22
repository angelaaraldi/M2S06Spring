package com.example.demo.controllers;

import com.example.demo.models.Tutor;
import com.example.demo.services.TutorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {
    private final TutorService tutorService;
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }
    @PostMapping
    public void adicionar(@RequestBody Tutor tutor) {
        tutorService.adicionar(tutor);
    }
    @GetMapping
    public List<Tutor> listar() {
        if (tutorService.listar() != null) {
            if (tutorService.listar().isEmpty()) {
                return null;
            }
            return tutorService.listar();
        }
        return null;
    }
    @PutMapping
    public String atualizar(@RequestBody Tutor tutor) {
        return tutorService.atualizar(tutor)?"Tutor atualizado.":"Tutor não encontrado.";
    }
    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        return tutorService.remover(id)?"Tutor removido.":"Tutor não encontrado.";
    }
}
