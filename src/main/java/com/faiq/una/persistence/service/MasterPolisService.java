package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterPolis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    Page<MasterPolis> getAllPagination(Pageable pageable);
}
