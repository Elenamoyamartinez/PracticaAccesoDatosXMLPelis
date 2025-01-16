package com.mycompany.practicaaccesodatosxmlpelis;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class PracticaAccesoDatosXMLPelis 
{
       public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el dato por el que deseas buscar");
        String respuesta = sc.nextLine();
        
        
        // Refrencia al fichero XML
        File file1 = new File("src\\main\\java\\xml\\xmlData1.xml");
        
        // DocumentBuilderFactory y DocumentBuilder van a generar un documentoxml vacio en memoria
        DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
        DocumentBuilder db1 = dbf1.newDocumentBuilder();
        
        // Se vuelca el contenido del fichero xml al objeto document1 (parse)
        Document document1 = db1.parse(file1);
        
        // Transformar el texto Unicode del contenido xml (normalize)
        document1.getDocumentElement().normalize();
        
        // Extraer el nombre del nodo
        // System.out.println("Elemento raiz: " + document1.getDocumentElement().getNodeName());
        
        // Volcar los nodos contenidos en el nodo indicado (nodo principal) a través de su nombre de etiqueta
        NodeList nodeList1 = document1.getElementsByTagName("pelicula");
        
        boolean encontrado = false; // Variable para rastrear si se encontró algún resultado
        
        // Recorrer la lista de los nodos extraidos 
        for(int i = 0; i < nodeList1.getLength(); i++)
        {
            // Se extrae el nodo actual
            Node node1 = nodeList1.item(i);
            // Se obtiene el nombre del nodo actual
            // System.out.println("\nElemento actual: " + node1.getNodeName());
  
            if(node1.getNodeType() == Node.ELEMENT_NODE)
            {
                // Se realiza una referencia de elemento nodo hijo de la lista de elementos node1
                Element element1 = (Element) node1;
                
               if(element1.getElementsByTagName("director").item(0).getTextContent().contains(respuesta) || 
                       element1.getElementsByTagName("titulo").item(0).getTextContent().contains(respuesta) || 
                       element1.getElementsByTagName("actor").item(0).getTextContent().contains(respuesta))
               {
                    System.out.println("\nDirector: " + element1.getElementsByTagName("director").item(0).getTextContent());
                    System.out.println("Titulo: " + element1.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Actor: " + element1.getElementsByTagName("actor").item(0).getTextContent());
                    encontrado = true;
               }
              if(!encontrado)
               {
                    System.out.println("\nNo existen resultados con la búsqueda que deseas");
               }
            }
        }
        sc.close();
    }
}
