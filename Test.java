package com.accolite.au;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;

import javax.xml.transform.Source;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;

import javax.xml.transform.TransformerException;

import javax.xml.transform.TransformerFactory;

import javax.xml.transform.dom.DOMSource;

import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

public class Test {

	public static void main(String[] args) {
		MainClass test = new MainClass();

		Servlet s = test.getClass().getAnnotation(Servlet.class);
		;

		System.out.println(s.name() + " " + s.url() + "   " + s.name() + " " + test.getClass());

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.newDocument();

			Element root = doc.createElement("web-app");
			doc.appendChild(root);

			Element subroot1 = doc.createElement("servlet");
			root.appendChild(subroot1);

			Element servletName = doc.createElement("servlet-name");
			servletName.appendChild(doc.createTextNode(s.name().toString()));
			subroot1.appendChild(servletName);

			Element cls = doc.createElement("servlet-class");
			cls.appendChild(doc.createTextNode(test.getClass().toString()));
			subroot1.appendChild(cls);

			Element subroot2 = doc.createElement("servlet-mapping");
			root.appendChild(subroot2);

			Element servletname1 = doc.createElement("Servlet-name");
			servletname1.appendChild(doc.createTextNode(s.name().toString()));
			subroot2.appendChild(servletname1);

			Element url1 = doc.createElement("url-pattern");
			url1.appendChild(doc.createTextNode(s.url().toString()));
			subroot2.appendChild(url1);

			TransformerFactory tFactory = TransformerFactory.newInstance();

			Transformer transformer = tFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "systmId");

			Source sou = new DOMSource(doc);

			Result res = new StreamResult(new FileOutputStream("xmlFile.xml"));

			transformer.transform(sou, res);

			System.out.println("XML File Created Succesfully, Check it in your Project Location");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerConfigurationException e)

		{

			e.printStackTrace();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (TransformerException e) {

			e.printStackTrace();

		}

	}

}
