package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.repository.MasterJenisKelaminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterJenisKelaminServiceImpl implements MasterJenisKelaminService {
    @Autowired
    private MasterJenisKelaminRepository masterJenisKelaminRepository;

    @Override
    public MasterJenisKelamin getByKode(Character kode) {
        Optional<MasterJenisKelamin> masterJenisKelamin = this.masterJenisKelaminRepository.findById(kode);
        return masterJenisKelamin.orElse(null);
    }

    @Override
    public List<MasterJenisKelamin> getAll() {
        return this.masterJenisKelaminRepository.findAll();
    }

    @Override
    public Optional<MasterJenisKelamin> getById(Character kode) {
        return this.masterJenisKelaminRepository.findById(kode);
    }

    @Override
    @Transactional
    public MasterJenisKelamin create(MasterJenisKelamin masterJenisAsuransi) {
        return this.masterJenisKelaminRepository.save(masterJenisAsuransi);
    }

    @Override
    @Transactional
    public MasterJenisKelamin update(MasterJenisKelamin masterJenisAsuransi) {
        return this.masterJenisKelaminRepository.save(masterJenisAsuransi);
    }

    @Override
    @Transactional
    public MasterJenisKelamin remove(Character kode) {
        Optional<MasterJenisKelamin> masterJenisAsuransi = this.masterJenisKelaminRepository.findById(kode);
        if (masterJenisAsuransi.isPresent()){
            this.masterJenisKelaminRepository.deleteById(kode);
        }
        return masterJenisAsuransi.orElse(null);
    }
}
