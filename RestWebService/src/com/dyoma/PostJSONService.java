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

import launcher.MainApp;
/**
 * @author Nika
 *
 */
@Path("/postJSON")
public class PostJSONService {

    //@Produces(MediaType.APPLICATION_JSON)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void getStudentAsJSON(@Context HttpHeaders headers, Student student) throws InterruptedException {
        System.out.println(student.toString());
        javafx.application.Application.launch(MainApp.class);
        MainApp mainApp = MainApp.waitForMainApp();
        mainApp.setButtonName(student.toString());
	}
}
