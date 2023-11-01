package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.repository.MasterJenisAsuransiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterJenisAsuransiServiceImpl implements MasterJenisAsuransiService {

    @Autowired
    private MasterJenisAsuransiRepository masterJenisAsuransiRepository;

    @Override
    public MasterJenisAsuransi getByKode(String kode) {
        Optional<MasterJenisAsuransi> masterJenisAsuransi = this.masterJenisAsuransiRepository.findById(kode);
        return masterJenisAsuransi.orElse(null);
    }

    @Override
    public List<MasterJenisAsuransi> getAll() {
        return this.masterJenisAsuransiRepository.findAll();
    }

    @Override
    public Optional<MasterJenisAsuransi> getById(String kode) {
        return this.masterJenisAsuransiRepository.findById(kode);
    }

    @Override
    @Transactional
    public MasterJenisAsuransi create(MasterJenisAsuransi masterJenisAsuransi) {
        return this.masterJenisAsuransiRepository.save(masterJenisAsuransi);
    }

    @Override
    @Transactional
    public MasterJenisAsuransi update(MasterJenisAsuransi masterJenisAsuransi) {
        return this.masterJenisAsuransiRepository.save(masterJenisAsuransi);
    }

    @Override
    @Transactional
    public MasterJenisAsuransi remove(String kode) {
        Optional<MasterJenisAsuransi> masterJenisAsuransi = this.masterJenisAsuransiRepository.findById(kode);
        if (masterJenisAsuransi.isPresent()){
            this.masterJenisAsuransiRepository.deleteById(kode);
        }
        return masterJenisAsuransi.orElse(null);
    }
}
