package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.repository.MasterPlanAsuransiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterPlanAsuransiServiceImpl implements MasterPlanAsuransiService {
    @Autowired
    private MasterPlanAsuransiRepository masterPlanAsuransiRepository;

    @Override
    public MasterPlanAsuransi getById(Long id) {
        Optional<MasterPlanAsuransi> masterPlanAsuransi = this.masterPlanAsuransiRepository.findById(id);
        return masterPlanAsuransi.orElse(null);
    }

    @Override
    public List<MasterPlanAsuransi> getAll() {
        return this.masterPlanAsuransiRepository.findAll();
    }

    @Override
    public Optional<MasterPlanAsuransi> getByIdOptional(Long id) {
        return this.masterPlanAsuransiRepository.findById(id);
    }

    @Override
    @Transactional
    public MasterPlanAsuransi create(MasterPlanAsuransi masterPlanAsuransi) {
        return this.masterPlanAsuransiRepository.save(masterPlanAsuransi);
    }

    @Override
    @Transactional
    public MasterPlanAsuransi update(MasterPlanAsuransi masterPlanAsuransi) {
        return this.masterPlanAsuransiRepository.save(masterPlanAsuransi);
    }

    @Override
    @Transactional
    public MasterPlanAsuransi remove(Long id) {
        Optional<MasterPlanAsuransi> masterJenisAsuransi = this.masterPlanAsuransiRepository.findById(id);
        if (masterJenisAsuransi.isPresent()){
            this.masterPlanAsuransiRepository.deleteById(id);
        }
        return masterJenisAsuransi.orElse(null);
    }
}
