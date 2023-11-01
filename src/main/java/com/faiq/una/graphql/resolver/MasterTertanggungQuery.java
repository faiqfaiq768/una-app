package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterTertanggung;
import com.faiq.una.persistence.service.MasterTertanggungService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterTertanggungQuery implements GraphQLQueryResolver {
    private final MasterTertanggungService masterTertanggungService;

    public List<MasterTertanggung> masterTertanggungs(){
        return this.masterTertanggungService.getAll();
    }

    public MasterTertanggung masterTertanggung(Long id){
        return this.masterTertanggungService.getById(id);
    }
}
