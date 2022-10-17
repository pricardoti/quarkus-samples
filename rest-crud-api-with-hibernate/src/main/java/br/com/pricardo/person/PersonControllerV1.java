package br.com.pricardo.person;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonControllerV1 {

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/count")
    public long count() {
        return personRepository.count();
    }

    @GET
    public Response listAll() {
        List<Person> persons = personRepository.listAll();
        return (
                persons.isEmpty()
                        ? Response.noContent()
                        : Response.ok(personRepository.listAll())
        ).build();
    }
}
