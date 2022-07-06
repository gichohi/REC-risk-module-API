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
@Table(name = "regions")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    private String id;

    private String code;

    private String name;

    @UpdateTimestamp
    @Column(name="updated_at")
    @Temporal(value=TemporalType.DATE)
    private Date updatedAt;
}