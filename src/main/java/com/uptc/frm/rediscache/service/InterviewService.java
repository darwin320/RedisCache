package com.uptc.frm.rediscache.service;


import com.uptc.frm.rediscache.jpa.entity.Interview;
import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.jpa.entity.Person;
import com.uptc.frm.rediscache.jpa.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private NewService newService;

    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    public Interview findById(int idInterview) {
        return interviewRepository.findById(idInterview).orElse(null);
    }

    public Interview saveInterview(Interview interview) {
        Person involved = personService.findById(interview.getIdInvolved());
        Person journalist = personService.findById(interview.getIdJournalist());
        New news = newService.findById((long) interview.getIdNews());

        interview.setInvolvedPerson(involved);
        interview.setJournalist(journalist);
        interview.setaNew(news);
        return interviewRepository.save(interview);
    }

    public Interview update(int id, Interview updatedInterview) {
        Interview existingInterview = findById(id);
        if (existingInterview != null) {
            // Actualizar los campos de la entrevista existente con los valores del objeto actualizado
            existingInterview.setIdJournalist(updatedInterview.getIdJournalist());
            existingInterview.setIdInvolved(updatedInterview.getIdInvolved());
            existingInterview.setIdNews(updatedInterview.getIdNews());
            existingInterview.setQuestion(updatedInterview.getQuestion());

            // Guardar la entrevista actualizada
            return interviewRepository.save(existingInterview);
        }
        throw new RuntimeException("Entrevista no encontrada");
    }


    public void delete(int idInterview) {
        interviewRepository.deleteById(idInterview);
    }
}
