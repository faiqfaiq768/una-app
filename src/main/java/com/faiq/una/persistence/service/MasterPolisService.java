package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterPolis;

import java.util.List;
import java.util.Optional;

public interface MasterPolisService {
    MasterPolis getById(Long id);
    List<MasterPolis> getAll();
    Optional<MasterPolis> getByIdOptional(Long id);
    MasterPolis create(MasterPolis masterPolis);
    MasterPolis update(MasterPolis masterPolis);
    MasterPolis remove(Long id);
    Long countAll();
}
