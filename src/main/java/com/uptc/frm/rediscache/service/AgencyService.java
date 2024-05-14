package com.uptc.frm.rediscache.service;


import com.uptc.frm.rediscache.jpa.entity.Agency;
import com.uptc.frm.rediscache.jpa.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    @Autowired
    private AgencyRepository agencyRepository;
    public List<Agency> findAll() {
        return agencyRepository.findAll();
    }

    public Agency save(Agency agency) {
        return agencyRepository.save(agency);
    }

    public void delete(long id) {
        agencyRepository.deleteById(id);
    }

    public Agency findById(long id) {
        Optional<Agency> agency = agencyRepository.findById(id);
        return agency.orElse(null);
    }

    public Agency update(long id, Agency agency) {
        Agency agency1 = findById(id);
        if (agency1 != null) {
            agency1.setName(agency.getName());
            agency1.setName(agency.getName());
            agency1.setYearRelease(agency.getYearRelease());
            return save(agency1);
        }
        throw new RuntimeException("Agency not found");
    }


}
