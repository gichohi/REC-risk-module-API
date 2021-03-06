package com.digitech.rec.risk.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitech.rec.risk.api.models.Cedant;

@Repository
public interface CedantRepository extends JpaRepository<Cedant, String>{
}
