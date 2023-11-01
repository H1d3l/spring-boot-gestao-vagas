package br.com.hidelbrandorios.springbootgestaovagas.modules.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hidelbrandorios.springbootgestaovagas.modules.company.entities.JobEntity;

import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID>{
    
}
