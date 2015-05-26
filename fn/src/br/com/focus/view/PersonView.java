package br.com.focus.view;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import br.com.focus.dto.Person;

@XmlRootElement()
public class PersonView {

	private List<Person> people;

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}	
		
}
