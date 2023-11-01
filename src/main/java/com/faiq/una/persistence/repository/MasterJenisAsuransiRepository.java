package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterJenisAsuransiRepository extends JpaRepository<MasterJenisAsuransi, String> {

}
