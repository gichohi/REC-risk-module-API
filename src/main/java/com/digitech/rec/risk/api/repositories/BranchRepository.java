package com.digitech.rec.risk.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitech.rec.risk.api.models.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String>{
    
}
