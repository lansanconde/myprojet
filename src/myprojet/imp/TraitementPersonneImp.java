package myprojet.imp;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myprojet.entities.Person;
import myprojet.entities.User;


@Stateful(name = "traitementPersonne", description = "EJB de traiment des personnes")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TraitementPersonneImp{

	 @PersistenceContext(unitName = "MyDataSource")
	 EntityManager em;
	    
	
	public User newUser() {
		// TODO Auto-generated method stub
		return null;
	}


	public Person CreatePerson(Person p) {
			if (p.getId() == null) {
	            em.persist(p);
	        } else {
	            p = em.merge(p);
	        }
	        return p;
		//System.out.println("Utilisateur non identifier");
	}

	

	public Person  updatePerson(Person p) {
			p = em.merge(p);
	        em.persist(p); 
		
		return  p;
        
	}

	
	public boolean login(User user, long personId, String password) {
		Person person = em.find(Person.class, personId);
		if(person==null) {
			return false;
		}
		if(!person.getPassword().equals(password)) {
			return false;
		}
		String email = person.getEmail();
		user.setEmail(email);
		user.setPassword(password);
		System.out.println("utilsateur connecté avec le email: "+person.getEmail());
		return true;
	}
	
	
	
	public void deletePersonne(Person p) {
			p = em.merge(p);
	        em.remove(p);
		
	}
	
	public boolean checkUser(User user) {
		if(user.getEmail()!=null && user.getPassword()!=null) {
				return true;
			}
			System.out.println("Utilisateur non identifier identifiant ");
			return false;
		
	}

	
	
}
