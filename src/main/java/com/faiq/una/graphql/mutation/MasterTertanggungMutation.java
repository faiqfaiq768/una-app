package com.faiq.una.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.faiq.una.form.MasterTertanggungForm;
import com.faiq.una.persistence.entity.MasterJenisKelamin;
import com.faiq.una.persistence.entity.MasterTertanggung;
import com.faiq.una.persistence.service.MasterJenisKelaminService;
import com.faiq.una.persistence.service.MasterTertanggungService;
import com.faiq.una.util.FaiqDateFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MasterTertanggungMutation implements GraphQLMutationResolver {
    private final MasterTertanggungService masterTertanggungService;
    private final MasterJenisKelaminService masterJenisKelaminService;

    public MasterTertanggung createMasterTertanggung(MasterTertanggungForm form) throws ParseException {
        MasterJenisKelamin masterJenisKelamin = this.masterJenisKelaminService.getByKode(form.getMasterJenisKelaminKode());
        MasterTertanggung masterTertanggung = new MasterTertanggung();
        masterTertanggung.setMasterJenisKelamin(masterJenisKelamin);
        masterTertanggung.setNamaLengkap(form.getNamaLengkap());
        masterTertanggung.setTanggalLahir(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getTanggalLahir()));
        masterTertanggung.setCreateBy(form.getCreateBy().toUpperCase());
        masterTertanggung.setCreateAt(new Timestamp(System.currentTimeMillis()));
        return this.masterTertanggungService.create(masterTertanggung);
    }

    public MasterTertanggung updateMasterTertanggung(MasterTertanggungForm form) throws ParseException {
        Optional<MasterTertanggung> tertanggung = this.masterTertanggungService.getByIdOptional(form.getId());
        MasterTertanggung masterTertanggung = new MasterTertanggung();
        if (tertanggung.isPresent()){
            masterTertanggung = tertanggung.get();
            MasterJenisKelamin masterJenisKelamin = this.masterJenisKelaminService.getByKode(form.getMasterJenisKelaminKode());
            masterTertanggung.setMasterJenisKelamin(masterJenisKelamin);
            masterTertanggung.setNamaLengkap(form.getNamaLengkap());
            masterTertanggung.setTanggalLahir(FaiqDateFormat.ddMMyyyyToPostgreSql(form.getTanggalLahir()));
            masterTertanggung.setUpdateBy(form.getUpdateBy().toUpperCase());
            masterTertanggung.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            this.masterTertanggungService.update(masterTertanggung);
        }
        return masterTertanggung;
    }

    public MasterTertanggung removeMasterTertanggung(Long id) {
        return this.masterTertanggungService.remove(id);
    }
}
