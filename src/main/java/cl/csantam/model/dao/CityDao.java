package cl.csantam.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.City;

public interface CityDao extends JpaRepository<City, Integer> {
	public List<City> findByState(Integer id);
}
