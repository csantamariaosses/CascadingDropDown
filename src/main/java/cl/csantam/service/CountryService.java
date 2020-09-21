package cl.csantam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.CountryDao;
import cl.csantam.model.entity.Country;

@Service
public class CountryService {

	@Autowired
	CountryDao countryDao;
	
	public List<Country> getAll() {
		return countryDao.findAll();
	}
	
	public Country find(int id) {
		return countryDao.findById(id).get();
	}
}
