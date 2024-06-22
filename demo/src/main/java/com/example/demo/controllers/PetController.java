package com.example.demo.controllers;

import com.example.demo.models.Pet;
import com.example.demo.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }
    @PostMapping
    public void adicionar(@RequestBody Pet pet) {
        petService.adicionar(pet);
    }
    @GetMapping
    public List<Pet> listar() {
        if (petService.listar() != null) {
            if (petService.listar().isEmpty()) {
                return null;
            }
            return petService.listar();
        }
        return null;
    }
    @PutMapping
    public String atualizar(@RequestBody Pet pet) {
        return petService.atualizar(pet)?"Pet atualizado.":"Pet não encontrado.";
    }
    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        return petService.remover(id)?"Pet removido.":"Pet não encontrado.";
    }
}
