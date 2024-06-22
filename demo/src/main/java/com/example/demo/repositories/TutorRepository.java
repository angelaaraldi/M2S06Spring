package com.example.demo.repositories;

import com.example.demo.models.Tutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TutorRepository {
    private static List<Tutor> tutores = new ArrayList<>();
    private static int ultimoId;

    public static List<Tutor> getTutores() {
        return tutores;
    }

    public static void setTutores(List<Tutor> tutores) {
        TutorRepository.tutores = tutores;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        TutorRepository.ultimoId = ultimoId;
    }

    public Tutor adicionar(Tutor tutor) {
        TutorRepository.setUltimoId(TutorRepository.getUltimoId()+1);
        Tutor tutorNovo = new Tutor(TutorRepository.getUltimoId(), tutor.getNome());
        TutorRepository.getTutores().add(tutorNovo);
        return tutorNovo;
    }

    public List<Tutor> listar() {
        if (TutorRepository.getTutores() != null) {
            if (TutorRepository.getTutores().isEmpty()) {
                return null;
            }
            return TutorRepository.getTutores();
        }
        return null;
    }

    public Tutor atualizar(Tutor tutor) {
        for (Tutor tutorLista : TutorRepository.getTutores()) {
            if (tutorLista.getId() == tutor.getId()) {
                tutorLista.setNome(tutor.getNome());
                return tutorLista;
            }
        }
        return null;
    }

    public boolean remover(int id) {
        for (Tutor tutor : TutorRepository.getTutores()) {
            if (tutor.getId() == id) {
                TutorRepository.getTutores().remove(tutor);
                return true;
            }
        }
        return false;
    }
}
