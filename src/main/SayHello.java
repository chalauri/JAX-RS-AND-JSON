package main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.xml.ws.BindingType;

@Path("/hello")
public class SayHello {

	@Path("/say")
	@GET
	@Produces("text/plain")
	public String get() {

		return "HELLO";
	}

	@Path("/{param}")
	@GET
	@Produces("text/plain")
	public String params(@PathParam("param") String param) {

		String res = "Hello " + param;

		return res;
	}

	@Path("/query")
	@GET
	@Produces("text/plain")
	public String query(@QueryParam("param") String param) {

		String res = "Hello " + param;

		return res;
	}
	
	@Path("/post")
	@POST
	@Consumes("application/json")
	public Response post(Student student) {

		String res = "First Name : " + student.getName() + "   Age : " + student.getAge();

		return Response.status(200).entity(res).build();
	}
	
}
