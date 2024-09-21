package com.pandeyar.saxparser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParserDemo {

	
	public static void main(String[] args) {
		
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		
		try {
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document document=db.parse(new File("D:/Arun-Pandey/WorkSpace/NewMAven/src/main/java/saxparser/library1.xml"));
			
			NodeList nodeList=document.getChildNodes();
			for(int i=0; i<nodeList.getLength(); i++){
				Node node=nodeList.item(i);
				String name=node.getLocalName();
				System.out.println("Node Name is "+name);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
