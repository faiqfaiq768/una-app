package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterPlanAsuransi;

import java.util.List;
import java.util.Optional;

public interface MasterPlanAsuransiService {
    MasterPlanAsuransi getById(Long id);
    List<MasterPlanAsuransi> getAll();
    Optional<MasterPlanAsuransi> getByIdOptional(Long id);
    MasterPlanAsuransi create(MasterPlanAsuransi masterPlanAsuransi);
    MasterPlanAsuransi update(MasterPlanAsuransi masterPlanAsuransi);
    MasterPlanAsuransi remove(Long id);
}
