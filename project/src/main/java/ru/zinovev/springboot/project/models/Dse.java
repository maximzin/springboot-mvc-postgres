package ru.zinovev.springboot.project.models;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tdse")
public class Dse {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "OboznDse should not be empty")
    @Size(min = 5, max = 30, message = "OboznDSE should be between 5 and 30 characters")
    @Column(name = "obozndse")
    private String oboznDse;

    @NotEmpty(message = "NameDse should not be empty")
    @Size(min = 2, max = 30, message = "NameDSE should be between 5 and 30 characters")
    @Column(name = "namedse")
    private String nameDse;

    @NotEmpty(message = "Material should not be empty")
    @Size(min = 1, max = 30, message = "Material should be between 1 and 30 characters")
    @Column(name = "material")
    private String material;

	public Dse() {}

    public Dse(String oboznDse, String nameDse, String material) {
        this.oboznDse = oboznDse;
        this.nameDse = nameDse;
        this.material = material;
    }
    
    public String getOboznDse() {
		return oboznDse;
	}

	public void setOboznDse(String oboznDse) {
		this.oboznDse = oboznDse;
	}

	public String getNameDse() {
		return nameDse;
	}

	public void setNameDse(String nameDse) {
		this.nameDse = nameDse;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
