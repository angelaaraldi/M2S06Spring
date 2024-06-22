package com.example.demo.services;

import com.example.demo.models.Tutor;
import com.example.demo.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {
    private final TutorRepository tutorRepository;
    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }
    public void adicionar(Tutor tutor) {
        tutorRepository.adicionar(tutor);
    }
    public List<Tutor> listar() {
        return tutorRepository.listar();
    }
    public boolean atualizar(Tutor tutor) {
        return tutorRepository.atualizar(tutor) != null;
    }
    public boolean remover(int id) {
        return tutorRepository.remover(id);
    }
}
