package com.cognizant.orm_learn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {}
