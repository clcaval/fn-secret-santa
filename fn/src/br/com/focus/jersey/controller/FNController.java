package br.com.focus.jersey.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.focus.dto.Person;
import br.com.focus.service.FnService;
import br.com.focus.view.PersonView;

import com.sun.jersey.api.client.ClientResponse.Status;

@Path("/fn")
public class FNController {
	
	@Path("/getTeste")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTeste() {
	
		Response resp;
		try
		{			
			resp = Response.ok("olar mundinho.").build();		
		} catch (Exception e) {
			String stackTrace = e.getMessage();
			resp = Response.status(Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()+"\nStacktrace:"+stackTrace).build();
		}
		return resp;
	}
	
	@Path("/getPerson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson() {
	
		Response resp;
		try
		{			
			FnService fnServ = new FnService();
			Person p = fnServ.getPerson();
			resp = Response.ok(p).build();			
		} catch (Exception e) {
			String stackTrace = e.getMessage();
			resp = Response.status(Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()+"\nStacktrace:"+stackTrace).build();
		}
		return resp;
	}
	
	@Path("/getPersons")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersons() {
	
		Response resp;
		try
		{			
			FnService fnServ = new FnService();
			PersonView v = new PersonView();
			v.setPeople(fnServ.getPersons());
			resp = Response.ok(v).build();			
		} catch (Exception e) {
			String stackTrace = e.getMessage();
			resp = Response.status(Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()+"\nStacktrace:"+stackTrace).build();
		}
		return resp;
	}
	
	@Path("/insertPerson")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertPerson(Person _p) {
	
		Response resp;
		try
		{			
			FnService fnServ = new FnService();
			Person p = fnServ.insertPerson(_p);			
			resp = Response.ok(p).build();
		} catch (Exception e) {
			String stackTrace = e.getMessage();
			resp = Response.status(Status.INTERNAL_SERVER_ERROR).
					entity(e.getMessage()+"\nStacktrace:"+stackTrace).build();
		}
		return resp;
	}
	
}
