package xml;

import java.util.ArrayList;
import javax.xml.transform.TransformerException;
import static xml.XMLWriter.escribeXML;
import static extras.Imprimir.Imprimir;
import static xml.XMLReader.leeXML;

public class Programa {
    
    public static void main(String argv[]) throws TransformerException{
      
        Imprimir("programa");
        
        ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
        
        //Introducción de elementos:
        arrayPersonas.add(new Persona("juan",27,322425));
        arrayPersonas.add(new Persona("juan carlos",27,35224));
        arrayPersonas.add(new Persona("juan domingo", 50,3439923));
        
        //Escribimos en XML
        escribeXML(arrayPersonas, "/home/juan/file.xml");
                      
        //Leemos desde XML
        arrayPersonas=leeXML("/home/juan/file.xml");
        
        //Mostramos lo leido:
        for(Persona persona: arrayPersonas)
         Imprimir("Nombre: "+persona.getNombre()+" Edad: "+persona.getEdad()+" DNI: "+persona.getDni());
              
    }
    
}
