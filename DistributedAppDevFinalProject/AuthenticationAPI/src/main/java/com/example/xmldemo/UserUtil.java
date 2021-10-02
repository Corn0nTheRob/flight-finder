/*
 * This class holds the methods to read and write to the xml file.
 */

package com.example.xmldemo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class UserUtil {

	/*
	 * Method to read all the users from the users.xml file.
	 */
	public static List<User> readUsers() {

		Users users = new Users();

		try {
			File usersFile = new File(System.getProperty("java.io.tmpdir") + "users.xml");
			System.out.println("The users.xml file can be found here: " + System.getProperty("java.io.tmpdir"));
			if (usersFile.exists() && !usersFile.isDirectory()) {
					        
	            JAXBContext context = JAXBContext.newInstance(Users.class);
	            Unmarshaller um = context.createUnmarshaller();
	            users = (Users) um.unmarshal(usersFile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users.getUsers();
	}

	/*
	 * Method to write a new user to the users.xml file.
	 */
	public static void registerUser(User user) throws IOException {

		try {
			List<User> users = readUsers();
			users.add(user);
			
			JAXBContext context;
	        BufferedWriter writer = null;
	        writer = new BufferedWriter(new FileWriter(new File(System.getProperty("java.io.tmpdir") + "users.xml")));
	        context = JAXBContext.newInstance(Users.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        m.marshal(new Users(users), writer);
	        writer.close();

      } catch (JAXBException e) {
            e.printStackTrace();
      }

	}
}
