package com.uptc.frm.rediscache.jpa.repository;

import com.uptc.frm.rediscache.jpa.entity.AgencyNew;
import com.uptc.frm.rediscache.jpa.entity.key.AgencyNewKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyNewRepository extends JpaRepository<AgencyNew, AgencyNewKey>{
}
