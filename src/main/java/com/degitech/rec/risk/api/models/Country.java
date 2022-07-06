package com.degitech.rec.risk.api.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    private String id;

    private String code;

    private String name;

    @Column(name = "region_id")
    private String regionId;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}