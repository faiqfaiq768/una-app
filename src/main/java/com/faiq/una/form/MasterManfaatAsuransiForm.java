package com.faiq.una.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterManfaatAsuransiForm extends MasterForm{
    private Long id;
    private Long masterPlanAsuransiId;
    private String manfaat;
    private Double nominal;
}
