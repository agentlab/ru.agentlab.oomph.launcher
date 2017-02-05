/**
 *
 */
package com.dyoma;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.dyoma.domain.Student;

/**
 * @author Nika
 *
 */
@Path("/getXML")
public class RestXMLService {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudentAsXML(@Context HttpHeaders headers) {
		Student student = new Student("Veronika", "Dyoma");
		return student;
	}
}
