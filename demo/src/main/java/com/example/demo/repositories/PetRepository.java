package com.example.demo.repositories;

import com.example.demo.models.Pet;
import com.example.demo.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PetRepository {
    private static List<Pet> pets = new ArrayList<>();
    private static int ultimoId;

    public static List<Pet> getPets() {
        return pets;
    }

    public static void setPets(List<Pet> pets) {
        PetRepository.pets = pets;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        PetRepository.ultimoId = ultimoId;
    }

    public Pet adicionar(Pet pet) {
        PetRepository.setUltimoId(PetRepository.getUltimoId()+1);
        Pet petNovo = new Pet(PetRepository.getUltimoId(), pet.getNome());
        PetRepository.getPets().add(petNovo);
        return petNovo;
    }

    public List<Pet> listar() {
        if (PetRepository.getPets() != null) {
            if (PetRepository.getPets().isEmpty()) {
                return null;
            }
            return PetRepository.getPets();
        }
        return null;
    }

    public Pet atualizar(Pet pet) {
        for (Pet petLista : PetRepository.getPets()) {
            if (petLista.getId() == pet.getId()) {
                petLista.setNome(pet.getNome());
                return petLista;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        for (Pet pet : PetRepository.getPets()) {
            if (pet.getId() == id) {
                PetRepository.getPets().remove(pet);
                return true;
            }
        }
        return false;
    }

    public void atribuirTutor(int id, Pet pet) {
        for (Tutor tutor : TutorRepository.getTutores()) {
            if (tutor.getId() == id) {
                pet.setTutor(tutor);
                break;
            }
        }
    }
}
