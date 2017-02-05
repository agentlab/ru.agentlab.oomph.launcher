/**
 *
 */
package com.dyoma.client;

import javax.ws.rs.core.MediaType;

import com.dyoma.domain.Student;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * @author Nika
 *
 */
public class RestClient {

	public static void main(String args[]) {

		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/RestWebService/rest/postXML");

		Student student = new Student("Veronika", "Dyoma");

		Student studentFromRest = webResource.type(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML).post(new GenericType<Student>() {
		}, student);

		System.out.println(studentFromRest);
	}
}
