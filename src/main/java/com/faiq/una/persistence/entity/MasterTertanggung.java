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
@Table(name = "master_tertanggung")
public class MasterTertanggung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String namaLengkap;
    @ManyToOne
    @JoinColumn(name = "kode_jenis_kelamin", referencedColumnName = "kode", nullable = false)
    private MasterJenisKelamin masterJenisKelamin;
    private Date tanggalLahir;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
