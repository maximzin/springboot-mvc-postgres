package ru.zinovev.springboot.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.models.RouteString;

@Repository
public interface RouteStringRepository extends JpaRepository<RouteString, Integer> {
	List<RouteString> findByIdDseOrderByNumOper(int id);
}
