package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface MasterJenisAsuransiService {
    MasterJenisAsuransi getByKode(String kode);
    List<MasterJenisAsuransi> getAll();
    Optional<MasterJenisAsuransi> getById(String kode);
    MasterJenisAsuransi create(MasterJenisAsuransi masterJenisAsuransi);
    MasterJenisAsuransi update(MasterJenisAsuransi masterJenisAsuransi);
    MasterJenisAsuransi remove(String id);
}
