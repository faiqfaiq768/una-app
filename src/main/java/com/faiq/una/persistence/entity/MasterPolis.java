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
@Table(name = "master_polis")
public class MasterPolis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomorPolis;
    @ManyToOne
    @JoinColumn(name = "tertanggung_id", referencedColumnName = "id", nullable = false)
    private MasterTertanggung masterTertanggung;
    private Date awalPeriodeAsuransi;
    private Date akhirPeriodeAsuransi;
    @ManyToOne
    @JoinColumn(name = "plan_asuransi_id", referencedColumnName = "id", nullable = false)
    private MasterPlanAsuransi masterPlanAsuransi;
    private String createBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String updateBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
