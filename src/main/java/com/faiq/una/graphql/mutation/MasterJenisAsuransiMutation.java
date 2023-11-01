package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.service.MasterJenisAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterJenisAsuransiMutation implements GraphQLMutationResolver {

    private final MasterJenisAsuransiService masterJenisAsuransiService;

    public MasterJenisAsuransi createMasterJenisAsuransi(MasterJenisAsuransi masterJenisAsuransi){
        masterJenisAsuransi.setCreateBy(masterJenisAsuransi.getCreateBy().toUpperCase());
        masterJenisAsuransi.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterJenisAsuransiService.create(masterJenisAsuransi);
    }

    public MasterJenisAsuransi updateMasterJenisAsuransi(MasterJenisAsuransi masterJenisAsuransi) {
        Optional<MasterJenisAsuransi> jenisAsuransi = this.masterJenisAsuransiService.getById(masterJenisAsuransi.getKode());
        MasterJenisAsuransi masterJenisAsuransiUpdate = new MasterJenisAsuransi();
        if (jenisAsuransi.isPresent()){
            masterJenisAsuransiUpdate = jenisAsuransi.get();
            masterJenisAsuransiUpdate.setDeskripsi(masterJenisAsuransi.getDeskripsi());
            masterJenisAsuransiUpdate.setUpdateBy(masterJenisAsuransi.getUpdateBy().toUpperCase());
            masterJenisAsuransiUpdate.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            this.masterJenisAsuransiService.update(masterJenisAsuransiUpdate);
        }
        return masterJenisAsuransiUpdate;
    }

    public MasterJenisAsuransi removeMasterJenisAsuransi(String kode) {
        return this.masterJenisAsuransiService.remove(kode);
    }
}
