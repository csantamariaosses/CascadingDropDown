package cl.csantam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.csantam.model.dao.StateDao;
import cl.csantam.model.entity.Country;
import cl.csantam.model.entity.State;

@Service
public class StateService {
	
	@Autowired
	private  StateDao stateDao;

	public List<State> findByCountry( int  country) {
		List<State> states = stateDao.findByCountry(country);
		return states;
	}
}
