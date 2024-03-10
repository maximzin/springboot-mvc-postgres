package ru.zinovev.springboot.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.models.Operation;
import ru.zinovev.springboot.project.repositories.DseRepository;
import ru.zinovev.springboot.project.repositories.OperationRepository;

@Service
@Transactional(readOnly = true)
public class OperationService {

	private final OperationRepository operationRepository;
	
	@Autowired
	public OperationService(OperationRepository operationRepository) {
		this.operationRepository = operationRepository;
	}
	
	public List<Operation> findAll() {
		return operationRepository.findAll();
	}
	
	public Operation findOne(int id) {
		Optional<Operation> foundOperation = operationRepository.findById(id);
		
		return foundOperation.orElse(null);
	}
	
	@Transactional
	public void saveOperation(Operation operation) {
		operationRepository.save(operation);
	}
	
	@Transactional
	public void updateOperation(int id, Operation updatedOperation) {
		updatedOperation.setId(id);
		operationRepository.save(updatedOperation);
	}
	
	@Transactional
	public void deleteOperation(int id) {
		operationRepository.deleteById(id);
	}
}
