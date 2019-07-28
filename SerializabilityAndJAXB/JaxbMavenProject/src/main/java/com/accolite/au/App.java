package com.accolite.au;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class App {
	public static void main(String[] args) {
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	private static void unMarshalingExample() {

		try {
			// Creating a file where the xml will be saved
			File file = new File("C:\\Users\\mudita.saxena\\Desktop\\ExamplesFile\\convert_xml.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Employee emp = (Employee) jaxbUnmarshaller.unmarshal(file);
			// printing the details
			System.out.println(emp);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	private static void marshalingExample() {

		Employee customer = new Employee();
		customer.setId(1);
		customer.setName("Mudita");
		customer.setAge(24);
		Address a = new Address();
		a.city = "Rewa";
		a.state = "Madhya Pradesh";
		a.zip = 486001;
		customer.setAddress(a);

		try {
			// Reading the content of xml from file to convert that to object
			File file = new File("C:\\Users\\mudita.saxena\\Desktop\\ExamplesFile\\convert_xml.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
