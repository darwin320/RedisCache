package com.uptc.frm.rediscache.service;

import com.uptc.frm.rediscache.jpa.entity.AgencyNew;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import com.uptc.frm.rediscache.jpa.repository.AgencyNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyNewService {

    @Autowired
    private AgencyNewRepository agencyNewRepository;

    public List<AgencyNew> findAll() {
        return agencyNewRepository.findAll();
    }

    public void create(AgencyNew agencyNew) {
        agencyNewRepository.save(agencyNew);
    }

    public AgencyNew findById(AgencyNewKey id) {
        return agencyNewRepository.findById(id).orElse(null);
    }

    public void deleteById(AgencyNewKey id) {
        agencyNewRepository.deleteById(id);
    }

    public AgencyNew update(AgencyNewKey id, AgencyNew agencyNew) {
        AgencyNew agencyNewBd = findById(id);
        if(agencyNewBd != null){
            agencyNewBd.setCoverageDate(agencyNew.getCoverageDate());
            agencyNewBd.setNewId(agencyNew.getNewId());
            agencyNewBd.setAgencyId(agencyNew.getAgencyId());
            return agencyNewRepository.save(agencyNewBd);
        }
        throw new RuntimeException("New not found");
    }
}
