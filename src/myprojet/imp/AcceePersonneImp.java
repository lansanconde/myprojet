package myprojet.imp;



import java.util.List;

import javax.ejb.Stateless;

import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myprojet.entities.Person;


@Stateless(name = "acceePersonne", description = "EJB pour accèder aux  persones")
@TransactionManagement(TransactionManagementType.CONTAINER)

public class AcceePersonneImp{

	 @PersistenceContext(unitName = "MyDataSource")
	 EntityManager em;
	 
	public Person findPerson(long personId) {
		return em.find(Person.class, personId);
	}

	
	public List<Person> findAllPersons() {
		// TODO Auto-generated method stub
		 return em.createQuery("Select p From Person p", Person.class)
	                .getResultList();
	}

	

	
	
}
