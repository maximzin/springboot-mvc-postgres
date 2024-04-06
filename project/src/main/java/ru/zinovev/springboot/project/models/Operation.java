package ru.zinovev.springboot.project.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "toperations")
public class Operation {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 5, max = 40, message = "Name should be between 5 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 10000, message = "Code should be between 5 and 10 characters")
    @Max(value = 999999999, message = "Code should be between 5 and 10 characters")
    @Column(name = "code")
    private int code;

    @Column(name = "priznakchpu")
    private boolean priznakChpu;

    public Operation() {}

    public Operation (String name, int code, boolean priznakChpu) {
        this.name = name;
        this.code = code;
        this.priznakChpu = priznakChpu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean getPriznakChpu() {
        return priznakChpu;
    }

    public void setPriznakChpu(boolean priznakChpu) {
        this.priznakChpu = priznakChpu;
    }

}

