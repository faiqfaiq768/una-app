package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.service.MasterJenisAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterJenisAsuransiQuery implements GraphQLQueryResolver {
    private final MasterJenisAsuransiService masterJenisAsuransiService;

    public List<MasterJenisAsuransi> masterJenisAsuransis(){
        return this.masterJenisAsuransiService.getAll();
    }

    public MasterJenisAsuransi masterJenisAsuransi(String kode){
        return this.masterJenisAsuransiService.getByKode(kode);
    }

}
