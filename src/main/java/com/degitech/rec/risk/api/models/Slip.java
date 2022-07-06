package com.degitech.rec.risk.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "slips")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Slip {
    @Id
    private String id;

    @Column(name="approval_status")
    private String approvalStatus;

    @Column(name="cedant_id")
    private String cedantId;

    @Column(name="commission_refunded_total")
    private double commissionRefundedTotal;

    @Column(name="confirmation_status")
    private String confirmationStatus;

    @Column(name="is_paid")
    private int isPaid;

    @Column(name="net_amount_total")
    private double netAmountTotal;

    @Temporal(value=TemporalType.DATE)
    @Column(name="publication_date")
    private Date publicationDate;

    private String Reference;

    @Column(name="edited_period")
    private String editedPeriod;

    @Column(name="validation_status")
    private String validationStatus;

    @CreationTimestamp
    @Temporal(value=TemporalType.DATE)
    @Column(name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(value=TemporalType.DATE)
    @Column(name="updated_at")
    private Date updatedAt;
}