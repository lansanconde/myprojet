package myprojet.tests;



import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import myprojet.entities.CurriculumVitae;
import myprojet.entities.Person;
import myprojet.entities.User;
import myprojet.imp.AcceeCvImp;
import myprojet.imp.TraitementCvImp;
import myprojet.imp.TraitementPersonneImp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class TestCurriculumVitaeManager {

    @EJB
    AcceeCvImp accee;
    
    @EJB
    TraitementCvImp tc;
    
    @EJB
    TraitementPersonneImp tp;
    User user;

    public TestCurriculumVitaeManager() throws NamingException {
    	 EJBContainer.createEJBContainer().getContext().bind("inject", this);
       
    }
    @Before
    public void setUp() throws Exception {
    	  user = new User();
    }

    @After
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }
    
    @Test
    public void testCreateCv() {
    	
    	//tp.login(user, p1.getId(), "123");
    	CurriculumVitae cv = new CurriculumVitae();    	
    	cv.setTitle("recherceh stage");
    	cv.setAddressWeb("www.cv.com");
    	cv.setDescription("c'est mon cv");
    	cv.setExperiencePro("2 ans expériences");
    	cv.setProjects("projet algo");
    	cv.setFormation("master info");
    	cv.setOther("sport, music "+System.currentTimeMillis());
    	cv.setYear(2019);
    	tc.CreateCV(cv);
    	assertNotNull(accee.findCV(cv.getId()));
    	
    }

     @Test
    public void testFindCv() {
    	//tp.login(user, p1.getId(), "123");
    	CurriculumVitae cv = new CurriculumVitae();    	
    	cv.setTitle("recherceh stage");
    	cv.setAddressWeb("www.cv.com");
    	cv.setDescription("c'est mon cv");
    	cv.setExperiencePro("2 ans expériences");
    	cv.setProjects("projet algo");
    	cv.setFormation("master info");
    	cv.setOther("sport, music "+System.currentTimeMillis());
    	cv.setYear(2019);
    	tc.CreateCV(cv);
     	assertNotNull(accee.findCV(cv.getId()));
     	
    }   

    @Test
    public void testDeletecV() {
    	
    	//tp.login(user, p1.getId(), "123");
    	
    	CurriculumVitae cv = new CurriculumVitae();    	
    	cv.setTitle("recherceh stage");
    	cv.setAddressWeb("www.cv.com");
    	cv.setDescription("c'est mon cv");
    	cv.setExperiencePro("2 ans expériences");
    	cv.setProjects("projet algo");
    	cv.setFormation("master info");
    	cv.setOther("sport, music "+System.currentTimeMillis());
    	cv.setYear(2019);

    	tc.CreateCV(cv);
    	// suppression du cv
    	tc.deleteCV(cv); 
    	assertNull(accee.findCV(cv.getId()));
    }
    
  
    @Test
    public void testUpdateCv() {
    	//tp.login(user, p1.getId(), "123");
    	
    	CurriculumVitae cv = new CurriculumVitae();    	
    	cv.setTitle("recherceh stage");
    	cv.setAddressWeb("www.cv.com");
    	cv.setDescription("c'est mon cv");
    	cv.setExperiencePro("2 ans expériences");
    	cv.setProjects("projet algo");
    	cv.setFormation("master info");
    	cv.setOther("sport, music ");
    	cv.setYear(2019);

    	tc.CreateCV(cv);
    	cv.setTitle("Recherche d'emploi");
    	// suppression du cv
    	tc.updateCv(cv); 
    	
    	CurriculumVitae c = tc.updateCv(cv);
    	assertEquals(c.getTitle(), "Recherche d'emploi");
    }
    
    @Test
    public void testFindAll() {
    	CurriculumVitae cv = new CurriculumVitae();    	
     	cv.setTitle("recherceh stage");
     	cv.setAddressWeb("www.cv.com");
     	cv.setDescription("c'est mon cv");
     	cv.setExperiencePro("2 ans expériences");
     	cv.setProjects("projet algo");
     	cv.setFormation("master info");
     	cv.setOther("sport, music ");
     	cv.setYear(2019);
     	
     	tc.CreateCV(cv);
     	List<CurriculumVitae>  liste = accee.findAllCv();
     	System.out.println(liste);
    }
    
  
    

}
