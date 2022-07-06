package com.degitech.rec.risk.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.degitech.rec.risk.api.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
}
