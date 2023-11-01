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
@Table(name = "master_jenis_kelamin")
public class MasterJenisKelamin implements Serializable {
    @Id
    private Character kode;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    public MasterJenisKelamin(Character kode, String jenisKelamin, String createBy, Date createAt) {
        this.kode = kode;
        this.jenisKelamin = jenisKelamin;
        this.createBy = createBy;
        this.createAt = createAt;
    }
}
