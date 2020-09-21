package cl.csantam.model.dao; 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.csantam.model.entity.State;

public interface StateDao extends JpaRepository<State, Integer>{
	
	public List<State> findByCountry( Integer country);

}
