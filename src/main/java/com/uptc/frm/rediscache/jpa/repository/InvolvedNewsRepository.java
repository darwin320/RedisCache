package com.uptc.frm.rediscache.jpa.repository;

import com.uptc.frm.rediscache.jpa.entity.InvolvedNews;
import com.uptc.frm.rediscache.jpa.entity.key.InvolvedNewsKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvolvedNewsRepository extends JpaRepository<InvolvedNews, InvolvedNewsKey> {

}
