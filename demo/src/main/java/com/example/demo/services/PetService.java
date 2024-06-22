package com.example.demo.services;

import com.example.demo.models.Pet;
import com.example.demo.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    private final PetRepository petRepository;
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    public void adicionar(Pet pet) {
        petRepository.adicionar(pet);
    }
    public List<Pet> listar() {
        return petRepository.listar();
    }
    public boolean atualizar(Pet pet) {
        return petRepository.atualizar(pet) != null;
    }
    public boolean remover(int id) {
        return petRepository.remover(id);
    }
}
