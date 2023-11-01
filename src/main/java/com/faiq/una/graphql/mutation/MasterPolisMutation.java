package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.form.MasterPolisForm;
import com.faiq.una.persistence.entity.MasterPlanAsuransi;
import com.faiq.una.persistence.entity.MasterPolis;
import com.faiq.una.persistence.entity.MasterTertanggung;
import com.faiq.una.persistence.service.MasterPlanAsuransiService;
import com.faiq.una.persistence.service.MasterPolisService;
import com.faiq.una.persistence.service.MasterTertanggungService;
import com.faiq.una.util.FaiqDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterPolisMutation implements GraphQLMutationResolver {
    private final MasterTertanggungService masterTertanggungService;
    private final MasterPlanAsuransiService masterPlanAsuransiService;
    private final MasterPolisService masterPolisService;

    public MasterPolis createMasterPolis(MasterPolisForm form) throws ParseException {
        MasterTertanggung masterTertanggung= this.masterTertanggungService.getById(form.getMasterTertanggungId());
        MasterPlanAsuransi masterPlanAsuransi = this.masterPlanAsuransiService.getById(form.getMasterPlanAsuransiId());
        MasterPolis masterPolis= new MasterPolis();

        String yearMonth = FaiqDateFormat.currentYearMonth();
        String countPolis = String.format("%04d", Integer.valueOf(this.masterPolisService.countAll().intValue()+1));;
        String kodeJenisAsuransi = masterPlanAsuransi.getMasterJenisAsuransi().getKode();
        String nomorPolis = kodeJenisAsuransi.concat("-").concat(countPolis).concat("-").concat(yearMonth);
        masterPolis.setNomorPolis(nomorPolis);
        masterPolis.setMasterTertanggung(masterTertanggung);
        masterPolis.setMasterPlanAsuransi(masterPlanAsuransi);
        masterPolis.setAwalPeriodeAsuransi(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getAwalPeriodeAsuransi()));
        masterPolis.setAkhirPeriodeAsuransi(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getAkhirPeriodeAsuransi()));
        masterPolis.setCreateBy(form.getCreateBy().toUpperCase());
        masterPolis.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterPolisService.create(masterPolis);
    }

    public MasterPolis updateMasterPolis(MasterPolisForm form) throws ParseException {
        Optional<MasterPolis> polis = this.masterPolisService.getByIdOptional(form.getId());
        MasterPolis masterPolis = new MasterPolis();
        if (polis.isPresent()){
            masterPolis = polis.get();
            MasterTertanggung masterTertanggung= this.masterTertanggungService.getById(form.getMasterTertanggungId());
            MasterPlanAsuransi masterPlanAsuransi = this.masterPlanAsuransiService.getById(form.getMasterPlanAsuransiId());
            masterPolis.setMasterTertanggung(masterTertanggung);
            masterPolis.setMasterPlanAsuransi(masterPlanAsuransi);
            masterPolis.setAwalPeriodeAsuransi(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getAwalPeriodeAsuransi()));
            masterPolis.setAkhirPeriodeAsuransi(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getAkhirPeriodeAsuransi()));
            this.masterTertanggungService.update(masterTertanggung);
        }
        return masterPolis;
    }

    public MasterPolis removeMasterPolis(Long id) {
        return this.masterPolisService.remove(id);
    }
}
