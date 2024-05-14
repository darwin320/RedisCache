package com.uptc.frm.rediscache.service;

import com.uptc.frm.rediscache.jpa.entity.Agency;
import com.uptc.frm.rediscache.jpa.entity.AgencyNew;
import com.uptc.frm.rediscache.jpa.entity.New;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import com.uptc.frm.rediscache.jpa.repository.AgencyNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyNewService {

    @Autowired
    private AgencyNewRepository agencyNewRepository;

    @Autowired AgencyService agencyService;

    @Autowired NewService newService;

    public List<AgencyNew> findAll() {
        return agencyNewRepository.findAll();
    }

    public void create(AgencyNew agencyNew) {
        New newa = newService.findById(agencyNew.getNewId());
        Agency agency = agencyService.findById(agencyNew.getAgencyId());
        System.out.println(newa);
        System.out.println(agency);
//        agencyNew.setaNew(newa);
//        agencyNew.setAgency(agency);
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
            agencyNewBd.setAgency(agencyNew.getAgency());
            agencyNewBd.setaNew(agencyNew.getaNew());
            agencyNewBd.setCoverageDate(agencyNew.getCoverageDate());
            return agencyNewRepository.save(agencyNewBd);
        }
        throw new RuntimeException("New not found");
    }
}
