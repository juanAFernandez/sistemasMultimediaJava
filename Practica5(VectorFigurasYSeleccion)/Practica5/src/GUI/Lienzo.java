/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static extras.Imprimir.Imprimir;
//import java.awt.geom.Line2D;



/**
 *
 * @author juan
 */
public class Lienzo extends javax.swing.JPanel {

    
    //Sección de variables privadas:
    
    //Para el color:
    private Color color;
    //Para el punto donde se dibuja:
    private Point pA, pB;
    private boolean relleno, sentidoContrario, modoSeleccion;
    
    
    /*
    En esta versión se podrán dibujar muchos objetos y además se podrá interactuar con ellos por lo que será
    necesario mantener una estructura en memoria donde poder almacenarlos. Usaremos una lista de figuras (Shapes) que 
    es lo que usa Graphics2D.
    */
    ArrayList <Shape> vShape = new ArrayList();
    
    
    Linea2D.Double lineaPrueba = new Linea2D.Double();
    private float grosorLinea=10;
    
    enum tipoHerramienta{PUNTO,LINEA,RECTANGULO,OVALO};
    private tipoHerramienta herramienta;
    
    
  
    //Constructor de Lienzo que lláma sólo a initComponents();
    public Lienzo() {
        initComponents();
        relleno=sentidoContrario=false;
    }

    
    
    //Get de color
    public Color getColor(){
        return color;
    }
    //Set de color
    public void setColor(Color color){
        this.color=color;
    }
    //Get de relleno
    public boolean getRelleno(){
        return relleno;
    }
    //Set de relleno
    public void setRelleno(boolean estado){
        relleno=estado;
    }
    //Get herramienta
    public tipoHerramienta getTipoHerramienta(){
        return herramienta;
    }
    //Set herramienta
    public void setTipoHerramienta(tipoHerramienta herramienta){
        this.herramienta=herramienta;
    }
    
    
    
    @Override
    public void paint(Graphics g){
        /*
        Si no llamamos al constructor del padre en la sobrecarga lo único que se vería sería el borde.
        Nosotros hemos definido el fondo blanco, eso está definido dentro del paint padre y tenermos
        que llamarlo para que surja efecto.
        */
        super.paint(g);
        //Ahora usamos la librería Graphics2D
        Graphics2D g2d=(Graphics2D)g;
        
        this.setAtributos(g2d);
                
        
        
        
        //Ahora lo único que hacemos el recorrer el vector de shapes y dibujarlas.
        if(!vShape.isEmpty())
            for(Shape s:vShape) g2d.draw(s);
            
        //Número de objetos:
        System.out.print("Elementos en vShape: "+vShape.size()+"\n");
    }
    
    private void setAtributos(Graphics2D g2d){
        //El grosor de la linea lo cogemos desde una variable de clase que se modifica desde VentanaPrincipal mediante
        //un spinner y el método setGrosorLinea.
        Stroke trazo = new BasicStroke(grosorLinea);
        
        
        g2d.setStroke(trazo);
    }
    
    public void setGrosorLinea(int grosor){
        grosorLinea = grosor;
        this.repaint();
    }
    
    
    private Shape getShapeSeleccionada(Point2D p){
        Imprimir("Buscando coincidencias en "+vShape.size()+" elementos");
        for(Shape s:vShape){
            Imprimir("Objeto de tipo "+s.getClass().getName());
            if(s.contains(p)) 
                return s;
        }
        
        return null;
    }
    
    public void setModoSeleccion(boolean modo){
        this.modoSeleccion=modo;
        System.out.println("Asignado modo seleccion: "+modoSeleccion);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    int figuraMoviendo;
    //Gestión del evento presión del ratón en cualquier botón:
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        
        
        
        /*
        Obtenemos el primer punto necesario al presionar (sin soltar) el ratón en cualquier
        parte del frame.
        */
        pA=evt.getPoint();
        
        if(modoSeleccion==true){
            if(getShapeSeleccionada((Point2D)pA)!=null){
                System.out.println("Figura seleccionada"+getShapeSeleccionada((Point2D)pA));
                //Obtenermos una referencia a la figura en el vector:
                figuraMoviendo=vShape.indexOf(getShapeSeleccionada((Point2D)pA));
                System.out.println("figura: "+figuraMoviendo);
            }else
                System.out.println("no se ha seleccionado ninguna figura");
        }else{
        //Añadimos una nueva figura al vector de figuras al presionar el ratón, dependiendo del tipo de figura
        //que esté seleccionada en las herramientas.
       // vShape.add(new Line2D.Double());
        
         
        
        if(this.herramienta==tipoHerramienta.LINEA)
            vShape.add(new Linea2D.Double());
        else if(this.herramienta==tipoHerramienta.RECTANGULO)
            vShape.add(new Rectangle2D.Double());
        else if(this.herramienta==tipoHerramienta.OVALO)
            vShape.add(new Ellipse2D.Double());
        
        
        }
        
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        /*
        Para ver como quedaría la linea conforme vamos dibujando la repintamos mientras
        arrastramos el ratón para al final dibujarla del todo al levantar el click (released).
        */
       
        //Capturamos el segundo punto necesario para construir la linea:
        pB=evt.getPoint();
        
        //Sacamos el último objeto del array:
        //Line2D temporal = (Line2D) vShape.remove(vShape.size()-1);        
        
        //Line2D tmp =(Line2D) vShape.get((vShape.size()-1));
        
        
        
         if(modoSeleccion==true){
             
             System.out.println(vShape.get(figuraMoviendo).getClass().getName());
             
             //Si se trata de un rectángulo:
             if(vShape.get(figuraMoviendo).getClass().getName().contains("Rectangle"))
                 if(vShape.get(figuraMoviendo)!=null)
                     ((Rectangle2D)vShape.get(figuraMoviendo)).setFrame(pB.x,pB.y,vShape.get(figuraMoviendo).getBounds2D().getWidth(),vShape.get(figuraMoviendo).getBounds2D().getHeight());
             //Si se trata de una ellipse:
             if(vShape.get(figuraMoviendo).getClass().getName().contains("Ellipse"))
                 if(vShape.get(figuraMoviendo)!=null)
                     ((Ellipse2D)vShape.get(figuraMoviendo)).setFrame(pB.x,pB.y,vShape.get(figuraMoviendo).getBounds2D().getWidth(),vShape.get(figuraMoviendo).getBounds2D().getHeight());
             
             
         }else{
        //Obtención del ancho y alto del rectángulo a partir del segundo punto:
            int ancho = pB.x-pA.x; //width
            int alto = pB.y-pA.y;  //high
        /* 
        Accedemos al último elemento del Array y según el tipo de figura que sea hacemos una
        u otra modificación haciendo un casting al tipo de figura que sea para poder acceder a sus métodos. 
        */        
        
        if(this.herramienta==tipoHerramienta.LINEA)
            /*
            Con los métodos que la clase Line2D tiene para modificar la linea mientras arrastramos el ratón
            debemos modificar los dos puntos con el método setLine.            
            ***Posible mejora de diseño***
            Sería mucho más lógico tener un set para cada uno de los puntos de la linea sin que nos tuviera
            que forzar a usar los dos.
            */
            ((Linea2D)vShape.get(vShape.size()-1)).setLine(pA, pB);
        else if(this.herramienta==tipoHerramienta.RECTANGULO){
            /*
            Para modificarlo tenemos que volver a especificar el primer punto y calcular el ancho y alto del rectángulo
            ***Posible mejora de diseño***
            Un método mucho más útil y simple que debería tener la clase sería aquel que permitiera especificar un nuevo
            rectángulo a partir de dos puntos (haciendo el los cálculos dentro para se pudiera hacer en cualquier dirección y 
            también debería tener un par de métodos set para los dos puntos que representan las esquinas del rectángulo.
            */                      
            ((Rectangle2D)vShape.get(vShape.size()-1)).setRect(pA.x, pA.y, ancho, alto);
        }
        else if(this.herramienta==tipoHerramienta.OVALO){
            ((Ellipse2D)vShape.get(vShape.size()-1)).setFrame(pA.x, pA.y, ancho, alto);
        }
                        
        }
        
        //Modificamos el objeto extraido seteandolo de nuevo con el punto A y el nuevo punto B a falta de un 
        //método directo para hacer sólo esto con el punto que queramos.
        //temporal.setLine(pA, pB);
        
        //Añadimos el nuevo objeto al array para que se vaya viendo la construcción del mismo mientras hacemos dragged.
        //vShape.add(temporal);
                
        //Como ya está en el vector llamamos a paint para que vuelva a pintar todos los objetos y este en el estado que está.
        this.repaint();        
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        /*
        Registramos el levantamiento del click del ratón
        */
      //  pB=evt.getPoint();
        //Al soltar el botón es cuando se guarda en el vector.

        this.repaint();
      
        
        
    }//GEN-LAST:event_formMouseReleased

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
