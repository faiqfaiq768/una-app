package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterManfaatAsuransi;

import java.util.List;
import java.util.Optional;

public interface MasterManfaatAsuransiService {
    MasterManfaatAsuransi getById(Long id);
    List<MasterManfaatAsuransi> getAll();
    Optional<MasterManfaatAsuransi> getByIdOptional(Long id);
    MasterManfaatAsuransi create(MasterManfaatAsuransi masterManfaatAsuransi);
    MasterManfaatAsuransi update(MasterManfaatAsuransi masterManfaatAsuransi);
    MasterManfaatAsuransi remove(Long id);
    List<MasterManfaatAsuransi> getByPlanAsuransiId(Long id);
}
