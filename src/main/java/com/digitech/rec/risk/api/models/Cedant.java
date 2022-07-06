package com.digitech.rec.risk.api.models;

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
@Table(name = "cedants")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cedant {

    @Id
    private String id;

    private String code;

    private String name;

    private String color1;

    private String color2;

    private String contact;

    @Column(name="country_id")
    private String countryId;

    private String email;

    @Column(name="group_cedant_id")
    private String groupCedantId;

    @Column(name="region_id")
    private String regionId;

    private String logo;

    @Column(name="currency_id")
    private String currencyId;

    @Column(name="reinsurance_id")
    private String reinsuranceId;

    @Column(name="types_cedants_id")
    private String typeCedantId;

    @CreationTimestamp
    @Temporal(value=TemporalType.DATE)
    @Column(name="created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(value=TemporalType.DATE)
    @Column(name="updated_at")
    private Date updatedAt;
    
}

