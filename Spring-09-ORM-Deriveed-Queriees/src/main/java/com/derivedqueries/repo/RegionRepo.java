package com.derivedqueries.repo;

import com.derivedqueries.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region,Integer> {

    List<Region>findByCountry(String country);

    List<Region>findDistinctByCountry(String country);

    //Display all regions with country name includes "Uniited
    List<Region>findByCountryContaining(String part);
    //display all regions with country name includes uniteed in order
    List<Region>findByCountryContainingOrderByCountry(String part);
//display top 2 reegions in canada
    List<Region>findTop2ByCountry(String country);


}
