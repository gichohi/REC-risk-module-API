package com.digitech.rec.risk.api.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.digitech.rec.risk.api.models.Report;

public class ReportRepository {
    private final EntityManagerFactory em;

    public ReportRepository() {
        em = Persistence.createEntityManagerFactory("jpa-h2-return-multiple-entities");
    }

    public List<Report> findAll() {
        List<Report> reportList = new ArrayList<Report>();
        EntityManager entityManager = em.createEntityManager();
        String queryString = "select slips.reference, countries.name as country," + 
        "cedants.name as cedants," + 
        "slips.validation_status, slips.confirmation_status, slips.publication_date," +
        "branches.name as branch, cases.premium_ht * 0.36 as REC " +
        "from slips, cedants, countries, cases, branches " +
        "where slips.cedant_id = cedants.id " +
        "and countries.id = cedants.country_id " +
        "and cases.cedant_id = cedants.id " +
        "and cases.branch_id = branches.id";
        
        Query query = entityManager.createNativeQuery(queryString);
        List<Object[]> resultList = query.getResultList();
        for (Object[] arrObjects: resultList) {
            Report report = new Report();
            report.setReference((String) arrObjects[0]);
            report.setCountry((String) arrObjects[1]);
            report.setCedant((String) arrObjects[2]);
            report.setValidationStatus((String) arrObjects[3]);
            report.setConfirmationStatus((String) arrObjects[4]);
            report.setPublicationDate((Date) arrObjects[5]);
            report.setBranch((String) arrObjects[6]);
            report.setRec((BigDecimal) arrObjects[7]);
            reportList.add(report);
        }
        
        return reportList;
    }
    
    /*
     To filter the records...
     */
    public List<Report> filter(HashMap<String, String> params) {
        List<Report> reportList = new ArrayList<Report>();
        EntityManager entityManager = em.createEntityManager();
        String queryString = "select slips.reference, countries.name as country," + 
        "cedants.name as cedants," + 
        "slips.validation_status, slips.confirmation_status, slips.publication_date," +
        "branches.name as branch, cases.premium_ht * 0.36 as REC " +
        "from slips, cedants, countries, cases, branches, regions, group_cedants " +
        "where slips.cedant_id = cedants.id " +
        "and countries.id = cedants.country_id " +
        "and cases.cedant_id = cedants.id " +
        "and cases.branch_id = branches.id " +
        "and regions.id = countries.region_id " +
        "and group_cedants.id = cedants.group_cedant_id";
        List<String> regions = new ArrayList<>();
        List<String> countries = new ArrayList<>();
        List<String> cedants = new ArrayList<>();
        List<String> cedantGroups = new ArrayList<>();
        List<String> branches = new ArrayList<>();
        List<String> validationStatuses = new ArrayList<>();
        List<String> confirmationStatuses = new ArrayList<>();

        for (Map.Entry<String, String> set :
             params.entrySet()) {
             String key = set.getKey();
             String value = set.getValue();
             if(key.equals("region")){
                queryString += " and regions.name in (:regions)";
                regions = Arrays.asList(value.split(","));
             }
             if(key.equals("country")){
                queryString += " and countries.name in (:countries)";
                countries = Arrays.asList(value.split(","));
             }
             if(key.equals("branch")){
                queryString += " and branches.name in (:branches)";
                branches = Arrays.asList(value.split(","));
             }
             if(key.equals("cedant")){
                queryString += " and cedants.name in (:cedants)";
                cedants = Arrays.asList(value.split(","));
             }
             if(key.equals("cedant_group")){
                queryString += " and group_cedants.name in (:cedantGroups)";
                cedantGroups = Arrays.asList(value.split(","));
             }
             if(key.equals("validation_status")){
                queryString += " and slips.validations_status in (:validationStatuses)";
                validationStatuses = Arrays.asList(value.split(","));
             }
             if(key.equals("confirmation_status")){
                queryString += " and slips.confirmation_status in (:confirmationStatuses)";
                confirmationStatuses = Arrays.asList(value.split(","));
             }
        }

        Query query = entityManager.createNativeQuery(queryString);
        if(regions.size() > 0){
            query.setParameter("regions", regions);
        }
        if(countries.size() > 0){
            query.setParameter("countries", countries);
        }
        if(branches.size() > 0){
            query.setParameter("branches", branches);
        }
        if(cedants.size() > 0){
            query.setParameter("cedants", cedants);
        }
        if(cedantGroups.size() > 0){
            query.setParameter("cedantGroups", cedantGroups);
        }
        if(validationStatuses.size() > 0){
            query.setParameter("validationStatuses", validationStatuses);
        }
        if(confirmationStatuses.size() > 0){
            query.setParameter("confirmationStatuses", confirmationStatuses);
        }
        List<Object[]> resultList = query.getResultList();
        for (Object[] arrObjects: resultList) {
            Report report = new Report();
            report.setReference((String) arrObjects[0]);
            report.setCountry((String) arrObjects[1]);
            report.setCedant((String) arrObjects[2]);
            report.setValidationStatus((String) arrObjects[3]);
            report.setConfirmationStatus((String) arrObjects[4]);
            report.setPublicationDate((Date) arrObjects[5]);
            report.setBranch((String) arrObjects[6]);
            report.setRec((BigDecimal) arrObjects[7]);
            reportList.add(report);
        }
        
        return reportList;
    }

}

