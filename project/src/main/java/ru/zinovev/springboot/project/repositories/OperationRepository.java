package ru.zinovev.springboot.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.zinovev.springboot.project.models.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Integer> {

}
