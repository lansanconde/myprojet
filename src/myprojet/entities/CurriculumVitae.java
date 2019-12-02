package myprojet.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "CV")
public class CurriculumVitae implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String title;
    
    @Column
    private Integer year;
    
    @Lob
    @Column
    private String experiencePro;
    
    @Lob
    @Column
    private String formation;
    
    @Lob
    @Column
    private String projects;
    
    @Lob
    @Column
    private String other;

    @Lob
    @Column
    private String description;
    

	@Column
    private String addressWeb;
    
    


    public CurriculumVitae() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;
    
    public void setPerson(Person person) {
    	this.person = person;
	}
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getExperiencePro() {
		return experiencePro;
	}

	public void setExperiencePro(String experiencePro) {
		this.experiencePro = experiencePro;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddressWeb() {
		return addressWeb;
	}

	public void setAddressWeb(String addressWeb) {
		this.addressWeb = addressWeb;
	}
}