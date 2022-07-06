package com.digitech.rec.risk.api.services.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitech.rec.risk.api.models.Branch;
import com.digitech.rec.risk.api.models.CaseNotLife;
import com.digitech.rec.risk.api.models.Cedant;
import com.digitech.rec.risk.api.models.Country;
import com.digitech.rec.risk.api.models.GroupCedant;
import com.digitech.rec.risk.api.models.Region;
import com.digitech.rec.risk.api.models.Report;
import com.digitech.rec.risk.api.models.Slip;
import com.digitech.rec.risk.api.repositories.BranchRepository;
import com.digitech.rec.risk.api.repositories.CaseRepository;
import com.digitech.rec.risk.api.repositories.CedantRepository;
import com.digitech.rec.risk.api.repositories.CountryRepository;
import com.digitech.rec.risk.api.repositories.GroupCedantRepository;
import com.digitech.rec.risk.api.repositories.RegionRepository;
import com.digitech.rec.risk.api.repositories.ReportRepository;
import com.digitech.rec.risk.api.repositories.SlipRepository;
import com.digitech.rec.risk.api.services.DataService;

@Service
public class DataServiceImpl implements DataService {

    ReportRepository reportRepository;

    @Autowired
    RegionRepository regionRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CedantRepository cedantRepository;

    @Autowired
    GroupCedantRepository groupCedantRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    CaseRepository caseRepository;

    @Autowired
    SlipRepository slipRepository;

    @Override
    public void saveRegions(List<Region> regionList) {
        for(Region region : regionList){
            regionRepository.save(region);
        }
    }

    @Override
    public void saveCountries(List<Country> countryList) {
        for(Country contry : countryList){
            countryRepository.save(contry);
        }
    }

    @Override
    public void saveSlips(List<Slip> slipList) {
        for(Slip slip : slipList){
            slipRepository.save(slip);
        }
    }

    @Override
    public void saveCases(List<CaseNotLife> caseList) {
        for(CaseNotLife c : caseList){
            caseRepository.save(c);
        }
    }

    @Override
    public void saveCedants(List<Cedant> cedantList) {
        for(Cedant cedant : cedantList){
            cedantRepository.save(cedant);
        }
    }

    @Override
    public void saveGroupCedants(List<GroupCedant> groupCedantList) {
        for(GroupCedant groupCedant : groupCedantList){
            groupCedantRepository.save(groupCedant);
        }
    }

    @Override
    public void saveBranches(List<Branch> branchList) {
        for(Branch branch : branchList){
            branchRepository.save(branch);
        }
    }

    @Override
    public List<Report> filter(HashMap<String, String> params) {
        reportRepository = new ReportRepository();
        return reportRepository.filter(params);
    }

    @Override
    public List<Report> findall() {
        reportRepository = new ReportRepository();
        return reportRepository.findAll();
    }

}