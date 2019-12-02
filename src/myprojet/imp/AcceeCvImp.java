package myprojet.imp;


import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import myprojet.entities.CurriculumVitae;


@Stateless(name = "acceeCv", description = "EJB pour accéder aux CVs")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcceeCvImp{

	@PersistenceContext(unitName = "MyDataSource")
	 EntityManager em;

	
	public CurriculumVitae findCV(Long n) {
		return em.find(CurriculumVitae.class, n);
	}

	
	public List<CurriculumVitae> findAllCv() {
		// TODO Auto-generated method stub
		 return em.createQuery("Select cv From CurriculumVitae cv", CurriculumVitae.class)
			          .getResultList();
	}
	

}
