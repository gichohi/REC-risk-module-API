package com.digitech.rec.risk.api.services;

import java.util.HashMap;
import java.util.List;

import com.digitech.rec.risk.api.models.Branch;
import com.digitech.rec.risk.api.models.CaseNotLife;
import com.digitech.rec.risk.api.models.Cedant;
import com.digitech.rec.risk.api.models.Country;
import com.digitech.rec.risk.api.models.GroupCedant;
import com.digitech.rec.risk.api.models.Region;
import com.digitech.rec.risk.api.models.Report;
import com.digitech.rec.risk.api.models.Slip;

public interface DataService {
    void saveRegions(List<Region> regionList);
    void saveCountries(List<Country> countryList);
    void saveSlips(List<Slip> slipList);
    void saveCases(List<CaseNotLife> caseList);
    void saveCedants(List<Cedant> cedantList);
    void saveGroupCedants(List<GroupCedant> groupCedantList);
    void saveBranches(List<Branch> branchList);
    List<Report> filter(HashMap<String, String> params);
    List<Report> findall();
}