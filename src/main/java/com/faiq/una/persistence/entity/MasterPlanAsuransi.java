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
@Table(name = "master_plan_asuransi")
public class MasterPlanAsuransi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "jenis_asuransi_kode", referencedColumnName = "kode", nullable = false)
    private MasterJenisAsuransi masterJenisAsuransi;
    private String planAsuransi;
    private Double premi;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
