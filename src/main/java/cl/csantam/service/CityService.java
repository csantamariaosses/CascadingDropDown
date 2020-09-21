package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.CityDao;
import cl.csantam.model.entity.City;


@Service
public class CityService {
	
	@Autowired
	private CityDao cityDao;
	
	public List<City> findByState( int id ) {
		List<City> cities = cityDao.findByState(id);
		return cities;
	}
	
}
