package com.uptc.frm.rediscache.service;

import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.jpa.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewService {

    @Autowired
    private NewRepository newRepository;

    public List<New> findAll() {
        return newRepository.findAll();
    }

    public void create(New newEntity) {
        newRepository.save(newEntity);
    }

    public New findById(Long id) {
        return newRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        newRepository.deleteById(id);
    }

    public New update(Long id, New newEntity) {
        New newEntityBd = findById(id);
        if(newEntityBd != null){
            newEntityBd.setHeadline(newEntity.getHeadline());
            newEntityBd.setText(newEntity.getText());
            newEntityBd.setDate(newEntity.getDate());
            return newRepository.save(newEntityBd);
        }
        throw new RuntimeException("New not found");
    }
}
