package ru.zinovev.springboot.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.models.RouteString;
import ru.zinovev.springboot.project.repositories.RouteStringRepository;

@Service
@Transactional(readOnly = true)
public class RouteStringService {

	private final RouteStringRepository routeStringRepository;
	
	@Autowired
	public RouteStringService(RouteStringRepository routeStringRepository) {
		this.routeStringRepository = routeStringRepository;
	}
	
	public List<RouteString> findByIdDse(int id) {
		return routeStringRepository.findByIdDseOrderByNumOper(id);
	}
	
	@Transactional
	public void saveRouteString(RouteString routeString) {
		routeStringRepository.save(routeString);
	}
	
	@Transactional
	public void deleteRouteString(int id) {
		routeStringRepository.deleteById(id);
	}
}
