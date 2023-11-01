package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.service.MasterJenisKelaminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterJenisKelaminQuery implements GraphQLQueryResolver {
    private final MasterJenisKelaminService masterJenisKelaminService;

    public List<MasterJenisKelamin> masterJenisKelamins(){
        return this.masterJenisKelaminService.getAll();
    }

    public MasterJenisKelamin masterJenisKelamin(char kode){
        return this.masterJenisKelaminService.getByKode(kode);
    }
}
