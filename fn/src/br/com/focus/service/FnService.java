package br.com.focus.service;

import java.util.List;

import br.com.focus.dao.FnDAO;
import br.com.focus.dto.Person;

public class FnService {

	
	public Person getPerson()
	{
		Person p = new Person();
		p.setId(1);
		p.setName("Caio");
		p.setEmail("caio.cavalcanti@embraer.com.br");		
		return p;
	}
	
	public List<Person> getPersons() throws Exception
	{
		FnDAO dao = new FnDAO();
		return dao.getPerson();
	}
	
	public Person insertPerson(Person p) throws Exception
	{
		FnDAO d = new FnDAO();
		return d.createPerson(p);		
	}
	
}
