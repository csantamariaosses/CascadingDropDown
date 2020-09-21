package cl.csantam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cl.csantam.model.entity.Country;
import cl.csantam.model.entity.State;
import cl.csantam.service.CityService;
import cl.csantam.service.CountryService;
import cl.csantam.service.StateService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private CountryService countryService;

	@Autowired
	private StateService stateService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping
	public String home( ModelMap modelMap) {
		modelMap.put("countries", countryService.getAll());
		return "home";
	}
	
	
//	@GetMapping
//	public String loadStateByCountry( ModelMap modelMap,
//			) {
//		modelMap.put("countries", countryService.getAll());
//		return  "home";
//	}
	
	@ResponseBody
	@RequestMapping( value="loadStatesByCountry/{id}", method= RequestMethod.GET)
	public String loadStatesByCountry(@PathVariable("id") int id ) {
		Gson gson = new Gson();
		List<State> states = stateService.findByCountry(id);
		return gson.toJson(  states );
		
	}
	
	
	@ResponseBody
	@RequestMapping( value="loadCitiesByState/{id}", method= RequestMethod.GET)
	public String loadCitiesByState(@PathVariable("id") int id) {
		Gson gson = new Gson();
		return gson.toJson( cityService.findByState( id ));
	}

}
