package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterManfaatAsuransi;
import com.faiq.una.persistence.service.MasterManfaatAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterManfaatAsuransiQuery implements GraphQLQueryResolver {
    private final MasterManfaatAsuransiService masterManfaatAsuransiService;

    public List<MasterManfaatAsuransi> masterManfaatAsuransis(){
        return this.masterManfaatAsuransiService.getAll();
    }

    public MasterManfaatAsuransi masterManfaatAsuransi(Long id){
        return this.masterManfaatAsuransiService.getById(id);
    }
}
