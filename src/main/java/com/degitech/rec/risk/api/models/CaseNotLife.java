package com.degitech.rec.risk.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cases")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CaseNotLife {
    @Id
    private String id;

    private String branch;

    @Column(name="branch_id")
    private String branchId;

    @Column(name="cedant_id")
    private String cedantId;

    @Column(name="policy_number")
    private String policyNumber;

    @Column(name="premium_ht")
    private double premiumHt;

    @UpdateTimestamp
    @Column(name="updated_at")
    @Temporal(value=TemporalType.DATE)
    private Date updatedAt;

}
