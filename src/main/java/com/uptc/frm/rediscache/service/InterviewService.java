package com.uptc.frm.rediscache.service;


import com.uptc.frm.rediscache.jpa.entity.Interview;
import com.uptc.frm.rediscache.jpa.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    public List<Interview> findAll() {
        return interviewRepository.findAll();
    }

    public Interview findById(int idInterview) {
        return interviewRepository.findById(idInterview).orElse(null);
    }

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview update(int id, Interview interview) {
        Interview interviewBd = findById(id);
        if (interviewBd != null) {
            //interviewBd.setIdJournalist(interview.getIdJournalist());
            //interviewBd.setIdInvolved(interview.getIdInvolved());
            //interviewBd.setIdNews(interview.getIdNews());
            interviewBd.setQuestion(interview.getQuestion());
            return saveInterview(interview);
        }
        throw new RuntimeException("Entrevista no encontrada");
    }

    public void delete(int idInterview) {
        interviewRepository.deleteById(idInterview);
    }
}
