/**
 *
 */
package com.dyoma;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dyoma.domain.Student;

/**
 * @author Nika
 *
 */
@Path("/postXML")
public class PostXMLService {

	@Produces(MediaType.APPLICATION_XML)
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response getStudentAsXML(@Context HttpHeaders headers, Student student) {
		return Response.ok(student).build();
	}
}
