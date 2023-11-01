package com.faiq.una.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterPlanAsuransiForm extends MasterForm {
    private Long id;
    private String masterJenisAsuransiKode;
    private String planAsuransi;
    private Double premi;
}
