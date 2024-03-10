package ru.zinovev.springboot.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.zinovev.springboot.project.models.Dse;
import ru.zinovev.springboot.project.models.RouteString;

@Repository
public interface DseRepository extends JpaRepository<Dse, Integer> {
}
