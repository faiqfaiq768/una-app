package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterPlanAsuransiRepository extends JpaRepository<MasterPlanAsuransi, Long>, PagingAndSortingRepository<MasterPlanAsuransi, Long> {

}
