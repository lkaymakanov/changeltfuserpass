package wiz;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.is_bg.ltf.db.common.ConnectionProperties;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;



import java.util.ArrayList;
import java.util.List;

public class XMLReader {
	
		private String filename = "";
		private String [] table  = {"driver", "url",  "user", "pass",  "name"};
		private String conEl = "connection";   //name of connection elements
		
		//list with connections
		private List<ConnectionProperties> connections  = new ArrayList<ConnectionProperties>();
	    
	    
	    //constructor with  filename
	    public XMLReader(String filename) {
			// TODO Auto-generated constructor stub
	    	this.filename = filename;
	    }
	    
	    
	    //parse XML file content
	    public void parseContent(){
	    	
	    	//clear list
	    	connections.clear();
	    	
	    	//read connections
	    	try{
		    	DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		   	    DocumentBuilder db = dbf.newDocumentBuilder();
		    	Document doc= db.parse(filename);       //open the file
		    	NodeList nl = doc.getElementsByTagName(conEl);  //

		    	List<String> coonectionsprop = new ArrayList<String>();
		 		for(int i=0;i<nl.getLength();i++)
		 		{
		 			coonectionsprop.clear();
		 			for(int j=0; j < table.length; j++)
		 			{
		 			   
		 			   String val = doc.getElementsByTagName(table[j]).item(i).getChildNodes().item(0).getNodeValue();
		 			   coonectionsprop.add(val);
		 			   System.out.println(table[j] + " = " + val);
		 			}
		 			connections.add(new ConnectionProperties(coonectionsprop));
		 			System.out.println();
		 		}
	    	}catch (Exception e) {
				// TODO: handle exception
	    		System.out.println("Exception occured in parseContent method...");
			}
		 		
		 		
	    }


		public List<ConnectionProperties> getConnections() {
			return connections;
		}
	    
}















/*NodeList nameNlc=    doc.getElementsByTagName("diver");
 Element nameElements=(Element)nameNlc.item(i);
 String nameTagValue=nameElements.getChildNodes().item(0).getNodeValue();
 
 
 NodeList authorNlc=    doc.getElementsByTagName("url");
 Element authorElements=(Element)authorNlc.item(i);
 String authorTagValue=authorElements.getChildNodes().item(0).getNodeValue();
 
 NodeList dateNlc=    doc.getElementsByTagName("publication-date");
 Element dateElements=(Element)dateNlc.item(i);
 String dateTagValue=dateElements.getChildNodes().item(0).getNodeValue();
 
 System.out.println("name :"+nameTagValue);    
 System.out.println("author :"+authorTagValue);    
 System.out.println("publication-date :"+dateTagValue);    */
