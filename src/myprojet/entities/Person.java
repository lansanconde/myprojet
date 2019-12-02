package myprojet.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Personne")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Column
    private String name;
    
    @Column
    private String firstName;

	
	@Column
    private  String email;
    
    @Column
    private String webSite;
    
    @Column
    private String birthDay;
    
    @Column
    private String password;
    
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST },
		      fetch = FetchType.LAZY, mappedBy = "person")
			  private CurriculumVitae cv;
    
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST },
		      fetch = FetchType.LAZY, mappedBy = "owner")
    		  private Set<Person> persons;  
    @ManyToOne(optional = true)
	   @JoinColumn(name = "owner")
    private Person owner;
    
    public void setPerson(Person person) {
    	this.owner = person;
    }
    
    public void addPerson(Person person) {
    	if (persons == null) {
	    	  persons = new HashSet<>();
	      }
	      persons.add(person);
	      person.setPerson(this);
	}    
    

    public void setCv(CurriculumVitae cv) {
    	 if (cv == null) {
             if (this.cv != null) {
                 this.cv.setPerson(null);
             }
         }
         else {
             cv.setPerson(this);
         }
         this.cv = cv;
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/* à faire : chaque personne peut renseigner un cv*/
}
