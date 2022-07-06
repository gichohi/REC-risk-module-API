package com.digitech.rec.risk.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digitech.rec.risk.api.services.DataService;
import com.digitech.rec.risk.api.utils.BranchData;
import com.digitech.rec.risk.api.utils.CaseData;
import com.digitech.rec.risk.api.utils.CedantData;
import com.digitech.rec.risk.api.utils.CountryData;
import com.digitech.rec.risk.api.utils.GroupCedantData;
import com.digitech.rec.risk.api.utils.RegionData;
import com.digitech.rec.risk.api.utils.SlipData;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@PostConstruct
	public void initDb() {
		dataService.saveBranches(BranchData.getbranches());
		dataService.saveRegions(RegionData.getRegions());
		dataService.saveCountries(CountryData.getCountries());
		dataService.saveCases(CaseData.getcases());
		dataService.saveCedants(CedantData.getCedants());
		dataService.saveSlips(SlipData.getSlips());
		dataService.saveGroupCedants(GroupCedantData.getGroupCedants());
	}


}
