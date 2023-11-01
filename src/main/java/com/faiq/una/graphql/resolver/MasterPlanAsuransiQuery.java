package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.service.MasterPlanAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterPlanAsuransiQuery implements GraphQLQueryResolver {
    private final MasterPlanAsuransiService masterPlanAsuransiService;

    public List<MasterPlanAsuransi> masterPlanAsuransis(){
        return this.masterPlanAsuransiService.getAll();
    }

    public MasterPlanAsuransi masterPlanAsuransi(Long id){
        return this.masterPlanAsuransiService.getById(id);
    }
}
