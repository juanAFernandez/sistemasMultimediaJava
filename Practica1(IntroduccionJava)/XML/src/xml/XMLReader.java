package xml;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;


public class XMLReader {
    
    public static void main(String argv[]){
        System.out.println("Reader");
        
        try {
            File fXmlFile = new File("/home/juan/file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            System.out.println("Root");
            
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
    
}
