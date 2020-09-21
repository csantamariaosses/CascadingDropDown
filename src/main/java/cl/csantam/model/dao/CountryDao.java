package cl.csantam.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.Country;

public interface CountryDao  extends JpaRepository<Country, Integer>{

}
