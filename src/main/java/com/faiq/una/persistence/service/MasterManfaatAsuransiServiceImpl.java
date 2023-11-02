package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterManfaatAsuransi;
import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.repository.MasterManfaatAsuransiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterManfaatAsuransiServiceImpl implements MasterManfaatAsuransiService {
    @Autowired
    private MasterManfaatAsuransiRepository masterManfaatAsuransiRepository;

    @Override
    public MasterManfaatAsuransi getById(Long id) {
        Optional<MasterManfaatAsuransi> masterManfaatAsuransi = this.masterManfaatAsuransiRepository.findById(id);
        return masterManfaatAsuransi.orElse(null);
    }

    @Override
    public List<MasterManfaatAsuransi> getAll() {
        return this.masterManfaatAsuransiRepository.findAll();
    }

    @Override
    public Optional<MasterManfaatAsuransi> getByIdOptional(Long id) {
        return this.masterManfaatAsuransiRepository.findById(id);
    }

    @Override
    @Transactional
    public MasterManfaatAsuransi create(MasterManfaatAsuransi masterManfaatAsuransi) {
        return this.masterManfaatAsuransiRepository.save(masterManfaatAsuransi);
    }

    @Override
    @Transactional
    public MasterManfaatAsuransi update(MasterManfaatAsuransi masterManfaatAsuransi) {
        return this.masterManfaatAsuransiRepository.save(masterManfaatAsuransi);
    }

    @Override
    @Transactional
    public MasterManfaatAsuransi remove(Long id) {
        Optional<MasterManfaatAsuransi> masterManfaatAsuransi = this.masterManfaatAsuransiRepository.findById(id);
        if (masterManfaatAsuransi.isPresent()){
            this.masterManfaatAsuransiRepository.deleteById(id);
        }
        return masterManfaatAsuransi.orElse(null);
    }

    @Override
    public List<MasterManfaatAsuransi> getByPlanAsuransiId(Long id) {
        return this.masterManfaatAsuransiRepository.findByMasterPlanAsuransiId(id);
    }
}
