/**
 *
 */
package com.dyoma.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Nika
 *
 */
@XmlRootElement
public class Student {

	private String firstName;
	private String lastName;

	public Student() {
	};

	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	};

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
