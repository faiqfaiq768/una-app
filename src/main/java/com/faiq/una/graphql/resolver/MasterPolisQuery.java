package com.faiq.una.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.faiq.una.persistence.entity.MasterPolis;
import com.faiq.una.persistence.service.MasterPolisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MasterPolisQuery implements GraphQLQueryResolver {
    private final MasterPolisService masterPolisService;

    public List<MasterPolis> masterPolisList(){
        return this.masterPolisService.getAll();
    }

    public MasterPolis masterPolis(Long id){
        return this.masterPolisService.getById(id);
    }
}
