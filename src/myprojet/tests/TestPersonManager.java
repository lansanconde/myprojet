package myprojet.tests;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
import myprojet.imp.AcceePersonneImp;
import myprojet.imp.TraitementCvImp;
import myprojet.imp.TraitementPersonneImp;


public class TestPersonManager {

	@EJB
    TraitementPersonneImp tm;
	@EJB
    AcceePersonneImp accee;
	
	@EJB
    TraitementCvImp tCv;
	
	
    User user;
	Person p1;
	Person p2;
	Person p3;
	CurriculumVitae cv;
    
    public TestPersonManager() throws NamingException {
    	EJBContainer.createEJBContainer().getContext().bind("inject", this);
    }
    
    @Before
    public void setUp() throws Exception {
    	
    	user =  new User();
    	// creation d'un cv
    	cv = new CurriculumVitae();
    	cv.setTitle("recherceh stage");
    	cv.setAddressWeb("www.cv.com");
    	cv.setDescription("c'est mon cv");
    	cv.setExperiencePro("2 ans expériences");
    	cv.setProjects("projet algo");
    	cv.setFormation("master info");
    	cv.setOther("sport, music ");
    	cv.setYear(2019);   
    }

    @After
    public void tearDown() throws Exception {
        EJBContainer.createEJBContainer().close();
    }

    @Test
    public void testCreatePerson() {
    	// personne 1
    	p1 = new Person();
    	p1.setBirthDay("18/02/1989");
    	p1.setEmail("latty@gmail.com");
    	p1.setFirstName("latty");
    	p1.setName("FALL "+System.currentTimeMillis());
    	p1.setPassword("123");
    	p1.setWebSite("wwww.com");
    	
    	// personne 2
    	p2 = new Person();
    	p2.setBirthDay("18/02/1989");
    	p2.setEmail("aziz@gmail.com");
    	p2.setFirstName("latty "+System.currentTimeMillis());
    	p2.setName("aziz");
    	p2.setPassword("123");
    	p2.setWebSite("wwww.com");
    	
    	p3 = new Person();
    	p3.setBirthDay("18/02/1989");
    	p3.setEmail("latty@gmail.com");
    	p3.setFirstName("latty "+System.currentTimeMillis());
    	p3.setName("FALL");
    	p3.setPassword("123");
    	p3.setWebSite("wwww.com");
    	p1.setCv(cv);
    	// p1 creer p2
    	p1.addPerson(p2);
    	tm.CreatePerson(p1);
    	tm.CreatePerson(p3);
        assertNotNull(accee.findPerson(p1.getId()));
       
    }

    @Test
    public void testupdatePerson() {
    	// personne 2
    	p2 = new Person();
    	p2.setBirthDay("18/02/1989");
    	p2.setEmail("aziz@gmail.com");
    	p2.setFirstName("latty "+ System.currentTimeMillis());
    	p2.setName("aziz "+System.currentTimeMillis());
    	p2.setPassword("123");
    	p2.setWebSite("wwww.com");
    	
    	p2.setName("Chriss");
    	Person p = tm.updatePerson(p2);
    	assertEquals(p.getName(), "Chriss");
    }
    @Test
    public void TestdeletePersonne() {
    	p3 = new Person();
    	p3.setBirthDay("18/02/1989");
    	p3.setEmail("latty@gmail.com");
    	p3.setFirstName("latty");
    	p3.setName("FALL " +System.currentTimeMillis());
    	p3.setPassword("123");
    	p3.setWebSite("wwww.com");
    	tm.CreatePerson(p3);
    	tm.deletePersonne(p3);
    	assertNull(accee.findPerson(p3.getId()));
    	
    }
   
    
    @Test
    public void TestFindPerson() {
    	
    	p1 = new Person();
    	p1.setBirthDay("18/02/1989");
    	p1.setEmail("latty@gmail.com");
    	p1.setFirstName("latty");
    	p1.setName("FALL "+ System.currentTimeMillis());
    	p1.setPassword("123");
    	p1.setWebSite("wwww.com");
    	
    	tm.CreatePerson(p1);
    	Person  pTm = accee.findPerson(p1.getId());
    	assertEquals(pTm.getName(), p1.getName());
    }
    
    @Test
    public void TestFindAllPerson() {
    	List<Person>  pTm = accee.findAllPersons();
    	System.out.println(pTm);
    }
}
