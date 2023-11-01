package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterManfaatAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterManfaatAsuransiRepository extends JpaRepository<MasterManfaatAsuransi, Long> {
}
