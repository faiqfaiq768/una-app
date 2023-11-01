package com.faiq.una.persistence.repository;

import com.faiq.una.persistence.entity.MasterTertanggung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTertanggungRepository extends JpaRepository<MasterTertanggung, Long> {
}
