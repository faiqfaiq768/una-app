package com.faiq.una.util;

import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.repository.MasterJenisAsuransiRepository;
import com.faiq.una.persistence.repository.MasterJenisKelaminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DemoData implements CommandLineRunner {
    @Autowired
    private MasterJenisAsuransiRepository masterJenisAsuransiRepository;
    @Autowired
    private MasterJenisKelaminRepository masterJenisKelaminRepository;

    @Override
    public void run(String... args) throws Exception {
        masterJenisAsuransiRepository.save(new MasterJenisAsuransi("PA", "Asuransi Kecelakaan diri","SYSTEM",new Timestamp(System.currentTimeMillis())));
        masterJenisKelaminRepository.save(new MasterJenisKelamin('L',"Laki-laki","SYSTEM",new Timestamp(System.currentTimeMillis())));
    }
}
