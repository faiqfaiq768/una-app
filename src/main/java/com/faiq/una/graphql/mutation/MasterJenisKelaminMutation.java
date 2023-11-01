package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.service.MasterJenisKelaminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterJenisKelaminMutation implements GraphQLMutationResolver {
    private final MasterJenisKelaminService masterJenisKelaminService;

    public MasterJenisKelamin createMasterJenisKelamin(MasterJenisKelamin masterJenisKelamin){
        masterJenisKelamin.setCreateBy(masterJenisKelamin.getCreateBy().toUpperCase());
        masterJenisKelamin.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterJenisKelaminService.create(masterJenisKelamin);
    }

    public MasterJenisKelamin updateMasterJenisKelamin(MasterJenisKelamin masterJenisKelamin) {
        Optional<MasterJenisKelamin> jenisKelamin = this.masterJenisKelaminService.getById(masterJenisKelamin.getKode());
        MasterJenisKelamin masterJenisKelaminUpdate = new MasterJenisKelamin();
        if (jenisKelamin.isPresent()){
            masterJenisKelaminUpdate = jenisKelamin.get();
            masterJenisKelaminUpdate.setJenisKelamin(masterJenisKelamin.getJenisKelamin());
            masterJenisKelaminUpdate.setUpdateBy(masterJenisKelamin.getUpdateBy().toUpperCase());
            masterJenisKelaminUpdate.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            this.masterJenisKelaminService.update(masterJenisKelaminUpdate);
        }
        return masterJenisKelaminUpdate;
    }

    public MasterJenisKelamin removeMasterJenisKelamin(char kode) {
        return this.masterJenisKelaminService.remove(kode);
    }
}
