package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterPolis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterPolisRepository extends JpaRepository<MasterPolis, Long> {

}
