package ru.zinovev.springboot.project.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.repositories.DseRepository;

@Service
@Transactional(readOnly = true)
public class DseService {
	
	private final DseRepository dseRepository;
	
	@Autowired
	public DseService(DseRepository dseRepository) {
		this.dseRepository = dseRepository;
	}
	
	public List<Dse> findAll() {
		return dseRepository.findAll(Sort.by(Sort.Direction.ASC, "oboznDse"));
	}
	
	public Dse findOne(int id) {
		Optional<Dse> foundDse = dseRepository.findById(id);
		
		return foundDse.orElse(null);
	}
	
	@Transactional
	public void saveDse(Dse dse) {
		dseRepository.save(dse);
	}
	
	@Transactional
	public void updateDse(int id, Dse updatedDse) {
		updatedDse.setId(id);
		dseRepository.save(updatedDse);
	}
	
	@Transactional
	public void deleteDse(int id) {
		dseRepository.deleteById(id);
	}
	
}
