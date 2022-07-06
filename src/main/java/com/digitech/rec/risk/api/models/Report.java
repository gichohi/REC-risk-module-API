package com.digitech.rec.risk.api.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    String reference;
    String country;
    String cedant;
    String validationStatus;
    String confirmationStatus;
    Date publicationDate;
    String branch;
    BigDecimal rec;
}
