package com.uptc.frm.rediscache.controller.dto;

import com.uptc.frm.rediscache.jpa.entity.Agency;
import com.uptc.frm.rediscache.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/agency")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @GetMapping("/{idAgency}")
    public Agency getAgencyById(@PathVariable int idAgency) {
        return agencyService.findById(idAgency);
    }

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.findAll();
    }

    @PostMapping
    public Agency save(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @DeleteMapping("/{idAgency}")
    public void deleteById(@PathVariable long idAgency) {
        agencyService.delete(idAgency);
    }

    @PutMapping("/{id}")
    public Agency update(@PathVariable long id,@RequestBody Agency agency) {
        return agencyService.update(id, agency);
    }

}
