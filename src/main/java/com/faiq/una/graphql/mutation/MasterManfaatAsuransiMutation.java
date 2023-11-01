package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.form.MasterManfaatAsuransiForm;
import com.faiq.una.persistence.entity.MasterManfaatAsuransi;
import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.service.MasterManfaatAsuransiService;
import com.faiq.una.persistence.service.MasterPlanAsuransiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterManfaatAsuransiMutation implements GraphQLMutationResolver {
    private final MasterManfaatAsuransiService masterManfaatAsuransiService;
    private final MasterPlanAsuransiService masterPlanAsuransiService;

    public MasterManfaatAsuransi createMasterManfaatAsuransi(MasterManfaatAsuransiForm form){
        MasterPlanAsuransi masterPlanAsuransi = this.masterPlanAsuransiService.getById(form.getMasterPlanAsuransiId());
        MasterManfaatAsuransi masterManfaatAsuransi = new MasterManfaatAsuransi();
        masterManfaatAsuransi.setMasterPlanAsuransi(masterPlanAsuransi);
        masterManfaatAsuransi.setManfaat(form.getManfaat());
        masterManfaatAsuransi.setNominal(form.getNominal());
        masterManfaatAsuransi.setCreateBy(form.getCreateBy().toUpperCase());
        masterManfaatAsuransi.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterManfaatAsuransiService.create(masterManfaatAsuransi);
    }

    public MasterManfaatAsuransi updateMasterManfaatAsuransi(MasterManfaatAsuransiForm form) {
        Optional<MasterManfaatAsuransi> manfaatAsuransi = this.masterManfaatAsuransiService.getByIdOptional(form.getId());
        MasterManfaatAsuransi masterManfaatAsuransi = new MasterManfaatAsuransi();
        if (manfaatAsuransi.isPresent()){
            masterManfaatAsuransi = manfaatAsuransi.get();
            MasterPlanAsuransi masterPlanAsuransi = this.masterPlanAsuransiService.getById(form.getMasterPlanAsuransiId());
            masterManfaatAsuransi.setMasterPlanAsuransi(masterPlanAsuransi);
            masterManfaatAsuransi.setManfaat(form.getManfaat());
            masterManfaatAsuransi.setNominal(form.getNominal());
            masterManfaatAsuransi.setUpdateBy(form.getUpdateBy().toUpperCase());
            masterManfaatAsuransi.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            this.masterManfaatAsuransiService.update(masterManfaatAsuransi);
        }
        return masterManfaatAsuransi;
    }

    public MasterManfaatAsuransi removeMasterManfaatAsuransi(Long id) {
        return this.masterManfaatAsuransiService.remove(id);
    }
}
