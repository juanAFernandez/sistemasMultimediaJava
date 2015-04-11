package xml;

import static extras.Imprimir.Imprimir;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLReader {
    
    public static ArrayList leeXML(String ruta){
      
        ArrayList<Persona> personas = new ArrayList<Persona>();
        
        
        try {
            File fXmlFile = new File("/home/juan/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            
            //Obtenemos la lista de nodos:
            NodeList nList = doc.getElementsByTagName("Persona");
            
            for(int i=0; i<nList.getLength(); i++){
                Node nNode = nList.item(i);
                
                if(nNode.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    personas.add(
                            
                        new Persona(
                    
                            eElement.getElementsByTagName("nombre").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("dni").item(0).getTextContent())              
                        )
                    );
                }
            }
                 
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
      
        return personas;
    }//Fin main
    
}
