package xml;

import static extras.Imprimir.Imprimir;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/* ##IMPORTS */


 

public class XMLWriter {
    
   
    
    
    public static void escribeXML(ArrayList<Persona> arrayPersonas, String ruta) throws TransformerConfigurationException, TransformerException {
        
        /*
        ArrayList<Persona> arrayPersonas = new ArrayList<Persona>();
        
        //Introducción de elementos:
        arrayPersonas.add(new Persona("juan",27,322425));
        arrayPersonas.add(new Persona("cr7",27,35224));
        arrayPersonas.add(new Persona("alcalde", 50,3439923));
        */
   
        try {
            /*
            Define una APP fábrica que permite a las aplicaciones para obtener un analizador que produce árboles de objetos DOM de documentos XML.
            */
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            
            
            /*
            Con el objeto creado docFactor llamando a su método newDocumentBuilder() conseguirmos un objeto de tipo DocumentBuilder
            
            newDocumentBuilder() devuelve una nueva instancia de DocumentBuilder.
            
            
            Un objeto de tipo DocumentBuilder define una API que obtiene el DOM(Document Objetc Model)
            
            */
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            
            /*
            Se usa el objeto creado antes para con "newDocument()" conseguir una instancia del tipo Document
            Se obtiene una nueva instancia de un documento DOM para construir el árbol DOM
            */
            // root elements            
            Document doc = docBuilder.newDocument();
            /*
            Este documento representa un documento XML al completo.
            */
            
            
            
            Element rootElement = doc.createElement("MOJFile");
            //append: añadir
            //child: hijo
            doc.appendChild(rootElement);
          
            
           
            
            for(Persona persona : arrayPersonas){
                //Imprimir(persona.getNombre());
                
                //Creamos un objeto en xml con el nombre de la clase como tag.
                Element elementoEnXML=doc.createElement((String)persona.getClass().getSimpleName());
                //Añadimos el elemento al root del documento.
                rootElement.appendChild(elementoEnXML);
                
                
                //Pasamos los el nombre de todas las variables con sus contenidos:
                
                //Obtenemos las variables que tiene:
                Field[] variables = Persona.class.getDeclaredFields();              
                for(Field variable: variables){
                    //Obtenemos el nombre de la variable:
                    Element tagVariable = doc.createElement(variable.getName());
                    if(variable.getName().contains("nombre"))
                        tagVariable.appendChild(doc.createTextNode(persona.getNombre()));
                    if(variable.getName().contains("edad"))
                        tagVariable.appendChild(doc.createTextNode(Integer.toString(persona.getEdad())));
                    if(variable.getName().contains("dni"))
                        tagVariable.appendChild(doc.createTextNode(Integer.toString(persona.getDni())));
                    elementoEnXML.appendChild(tagVariable);
                }
             
            }
            
            //Escribimos la información en el fichero XML
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            
            //StreamResult result = new StreamResult(System.out);
            StreamResult result = new StreamResult(new File(ruta));
            
            transformer.transform(source,result);
            
          
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
