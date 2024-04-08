package ru.zinovev.springboot.project.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.zinovev.springboot.project.models.Role;

import java.util.Collection;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
}
