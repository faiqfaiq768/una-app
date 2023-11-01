package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterJenisKelamin;

import java.util.List;
import java.util.Optional;

public interface MasterJenisKelaminService {
    MasterJenisKelamin getByKode(Character kode);
    List<MasterJenisKelamin> getAll();
    Optional<MasterJenisKelamin> getById(Character kode);
    MasterJenisKelamin create(MasterJenisKelamin masterJenisKelamin);
    MasterJenisKelamin update(MasterJenisKelamin masterJenisKelamin);
    MasterJenisKelamin remove(Character kode);
}
