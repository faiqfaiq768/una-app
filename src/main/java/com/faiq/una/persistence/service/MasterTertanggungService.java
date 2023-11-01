package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterTertanggung;

import java.util.List;
import java.util.Optional;

public interface MasterTertanggungService {
    MasterTertanggung getById(Long id);
    List<MasterTertanggung> getAll();
    Optional<MasterTertanggung> getByIdOptional(Long id);
    MasterTertanggung create(MasterTertanggung masterTertanggung);
    MasterTertanggung update(MasterTertanggung masterTertanggung);
    MasterTertanggung remove(Long id);
}
