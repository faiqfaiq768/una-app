package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterJenisKelamin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterJenisKelaminRepository extends JpaRepository<MasterJenisKelamin, Character> {
}
