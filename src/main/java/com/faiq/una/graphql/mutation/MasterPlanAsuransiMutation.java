package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.form.MasterPlanAsuransiForm;
import com.faiq.una.persistence.entity.MasterJenisAsuransi;
import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.service.MasterJenisAsuransiService;
import com.faiq.una.persistence.service.MasterPlanAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterPlanAsuransiMutation implements GraphQLMutationResolver {
    private final MasterPlanAsuransiService masterPlanAsuransiService;
    private final MasterJenisAsuransiService masterJenisAsuransiService;

    public MasterPlanAsuransi createMasterPlanAsuransi(MasterPlanAsuransiForm form){
        MasterJenisAsuransi masterJenisAsuransi = this.masterJenisAsuransiService.getByKode(form.getMasterJenisAsuransiKode());
        MasterPlanAsuransi masterPlanAsuransi = new MasterPlanAsuransi();
        masterPlanAsuransi.setMasterJenisAsuransi(masterJenisAsuransi);
        masterPlanAsuransi.setPlanAsuransi(form.getPlanAsuransi());
        masterPlanAsuransi.setPremi(form.getPremi());
        masterPlanAsuransi.setCreateBy(form.getCreateBy().toUpperCase());
        masterPlanAsuransi.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterPlanAsuransiService.create(masterPlanAsuransi);
    }

    public MasterPlanAsuransi updateMasterPlanAsuransi(MasterPlanAsuransiForm form) {
        Optional<MasterPlanAsuransi> planAsuransi = this.masterPlanAsuransiService.getByIdOptional(form.getId());
        MasterPlanAsuransi masterPlanAsuransi = new MasterPlanAsuransi();
        if (planAsuransi.isPresent()){
            masterPlanAsuransi = planAsuransi.get();
            MasterJenisAsuransi masterJenisAsuransi = this.masterJenisAsuransiService.getByKode(form.getMasterJenisAsuransiKode());
            masterPlanAsuransi.setMasterJenisAsuransi(masterJenisAsuransi);
            masterPlanAsuransi.setPlanAsuransi(form.getPlanAsuransi());
            masterPlanAsuransi.setPremi(form.getPremi());
            masterPlanAsuransi.setUpdateBy(form.getUpdateBy().toUpperCase());
            masterPlanAsuransi.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            this.masterPlanAsuransiService.update(masterPlanAsuransi);
        }
        return masterPlanAsuransi;
    }

    public MasterPlanAsuransi removeMasterPlanAsuransi(Long id) {
        return this.masterPlanAsuransiService.remove(id);
    }
}
