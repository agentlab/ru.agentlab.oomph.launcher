/**
 *
 */
package com.dyoma;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public void getStudentAsJSON(@Context HttpHeaders headers, Student student) throws InterruptedException {
        System.out.println(student.toString());
        //javafx.application.Application.launch(MainApp.class);
        //MainApp mainApp = MainApp.waitForMainApp();
        //mainApp.setButtonName(student.toString());
        writeFile(student.toString());
	}

    private void writeFile(String text) {
        // The name of the file to open.
        String fileName = "C:\\eclipse\\oomph-launcher-master3\\git\\ru.agentlab.oomph.launcher\\fakeDB.txt";
        try
        {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(text);
            bufferedWriter.close();
        }
        catch (IOException ex)
        {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
