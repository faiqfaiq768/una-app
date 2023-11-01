package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterTertanggung;
import com.faiq.una.persistence.repository.MasterTertanggungRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterTertanggungServiceImpl implements MasterTertanggungService {
    @Autowired
    private MasterTertanggungRepository masterTertanggungRepository;

    @Override
    public MasterTertanggung getById(Long id) {
        Optional<MasterTertanggung> masterTertanggung = this.masterTertanggungRepository.findById(id);
        return masterTertanggung.orElse(null);
    }

    @Override
    public List<MasterTertanggung> getAll() {
        return this.masterTertanggungRepository.findAll();
    }

    @Override
    public Optional<MasterTertanggung> getByIdOptional(Long id) {
        return this.masterTertanggungRepository.findById(id);
    }

    @Override
    @Transactional
    public MasterTertanggung create(MasterTertanggung masterTertanggung) {
        return this.masterTertanggungRepository.save(masterTertanggung);
    }

    @Override
    @Transactional
    public MasterTertanggung update(MasterTertanggung masterTertanggung) {
        return this.masterTertanggungRepository.save(masterTertanggung);
    }

    @Override
    @Transactional
    public MasterTertanggung remove(Long id) {
        Optional<MasterTertanggung> masterManfaatAsuransi = this.masterTertanggungRepository.findById(id);
        if (masterManfaatAsuransi.isPresent()){
            this.masterTertanggungRepository.deleteById(id);
        }
        return masterManfaatAsuransi.orElse(null);
    }
}
