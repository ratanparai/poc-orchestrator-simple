package com.ratanparai.orchestrator.repository;

import com.ratanparai.orchestrator.model.Olcm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OlcmRepository extends JpaRepository<Olcm, Long>{
    
}