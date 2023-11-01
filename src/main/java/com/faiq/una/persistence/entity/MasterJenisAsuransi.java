package com.faiq.una.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "master_jenis_asuransi")
public class MasterJenisAsuransi implements Serializable {
    @Id
    private String kode;
    private String deskripsi;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public MasterJenisAsuransi(String kode, String deskripsi, String createBy, Date createAt) {
        this.kode = kode;
        this.deskripsi = deskripsi;
        this.createBy = createBy;
        this.createAt = createAt;
    }
}
