package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterManfaatAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterManfaatAsuransiRepository extends JpaRepository<MasterManfaatAsuransi, Long> {
    List<MasterManfaatAsuransi> findByMasterPlanAsuransiId(Long id);
}
