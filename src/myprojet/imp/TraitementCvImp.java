package myprojet.imp;

import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import myprojet.entities.CurriculumVitae;
import myprojet.entities.User;

import javax.ejb.TransactionManagementType;




@Stateful(name = "traitementCv", description = "EJB de traiment de cv")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TraitementCvImp{

	@PersistenceContext(unitName = "MyDataSource")
	 EntityManager em;
	
	
	public CurriculumVitae CreateCV(CurriculumVitae cv) {
		
			if (cv.getId() == null) {
	            em.persist(cv);
	        } else {
	        	cv = em.merge(cv);
	        }
		return cv;
	}

	

	public void deleteCV(CurriculumVitae cv) {
			cv = em.merge(cv);
	        em.remove(cv);
	}

	
	public CurriculumVitae  updateCv(CurriculumVitae cv) {
			cv = em.merge(cv);
	        em.persist(cv); 
	        return cv;
	}
	
	public boolean checkUser(User user) {
		if(user.getEmail()!=null && user.getPassword()!=null) {
			
				return true;
			}
			System.out.println("Utilisateur non identifier identifiant ");
			return false;
		
	}


}
