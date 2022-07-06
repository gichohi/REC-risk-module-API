package com.digitech.rec.risk.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.digitech.rec.risk.api.models.Report;
import com.digitech.rec.risk.api.services.DataService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
@Slf4j
public class ApiController {

    private final DataService dataService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Report>> getAllProjects() {
        log.info("Find all records");
        List<Report> projectList = dataService.findall();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping(path = "/filter")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Report>> filterRecords(
            @RequestParam Optional<String> region,
            @RequestParam Optional<String> country,
            @RequestParam Optional<String> branch,
            @RequestParam Optional<String> cedant_group,
            @RequestParam Optional<String> cedant,
            @RequestParam Optional<String> confirmation_status,
            @RequestParam Optional<String> verification_status,
            @RequestParam Optional<String> published_date,
            @RequestParam Optional<String> edited_period) {
        log.info("Filter Records");
        HashMap<String, String> params = new HashMap<>();

        region.ifPresent(s -> params.put("region", s));
        country.ifPresent(s -> params.put("country", s));
        branch.ifPresent(s -> params.put("branch", s));
        cedant_group.ifPresent(s -> params.put("cedant_group", s));
        cedant.ifPresent(s -> params.put("cedant", s));
        confirmation_status.ifPresent(s -> params.put("confirmation_status", s));
        verification_status.ifPresent(s -> params.put("verification_status", s));
        published_date.ifPresent(s -> params.put("published_date", s));
        edited_period.ifPresent(s -> params.put("edited_period", s));
        List<Report> projectList = dataService.filter(params);
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }
}
