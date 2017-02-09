/**
 *
 */
package com.dyoma;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.dyoma.domain.Student;

/**
 * @author Nika
 *
 */
@Path("/postJSON")
public class PostJSONService {

    //@Produces(MediaType.APPLICATION_JSON)
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getStudentAsJSON(@Context HttpHeaders headers, Student student) {
        System.out.println(student.toString());
        //return Response.ok(student).build();
	}
}
