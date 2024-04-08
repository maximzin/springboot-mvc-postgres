package ru.zinovev.springboot.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zinovev.springboot.project.models.Role;
import ru.zinovev.springboot.project.models.User;
import ru.zinovev.springboot.project.repositories.RoleRepository;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").get();
    }
}
