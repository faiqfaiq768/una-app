package com.faiq.una.persistence.service;

import com.faiq.una.persistence.entity.MasterPolis;
import com.faiq.una.persistence.repository.MasterPolisRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterPolisServiceImpl implements MasterPolisService {
    @Autowired
    private MasterPolisRepository masterPolisRepository;

    @Override
    public MasterPolis getById(Long id) {
        Optional<MasterPolis> masterTertanggung = this.masterPolisRepository.findById(id);
        return masterTertanggung.orElse(null);
    }

    @Override
    public List<MasterPolis> getAll() {
        return this.masterPolisRepository.findAll();
    }

    @Override
    public Optional<MasterPolis> getByIdOptional(Long id) {
        return this.masterPolisRepository.findById(id);
    }

    @Override
    @Transactional
    public MasterPolis create(MasterPolis masterPolis) {
        return this.masterPolisRepository.save(masterPolis);
    }

    @Override
    @Transactional
    public MasterPolis update(MasterPolis masterPolis) {
        return this.masterPolisRepository.save(masterPolis);
    }

    @Override
    @Transactional
    public MasterPolis remove(Long id) {
        Optional<MasterPolis> masterPolis = this.masterPolisRepository.findById(id);
        if (masterPolis.isPresent()){
            this.masterPolisRepository.deleteById(id);
        }
        return masterPolis.orElse(null);
    }

    @Override
    public Long countAll() {
        return this.masterPolisRepository.count();
    }

    @Override
    public Page<MasterPolis> getAllPagination(Pageable pageable) {
        return this.masterPolisRepository.findAll(pageable);
    }
}
