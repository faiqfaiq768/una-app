package com.faiq.una.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterTertanggungForm extends MasterForm {
    private Long id;
    private String namaLengkap;
    private Character masterJenisKelaminKode;
    private String tanggalLahir;
}
