package com.faiq.una.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterPolisForm extends MasterForm{
    private Long id;
    private String nomorPolis;
    private Long masterTertanggungId;
    private String awalPeriodeAsuransi;
    private String akhirPeriodeAsuransi;
    private Long masterPlanAsuransiId;
}
