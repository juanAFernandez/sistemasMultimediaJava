/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jaf.iu;

import static extras.Imprimir.Imprimir;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
//import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import extras.Herramienta;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.RenderingHints;
//import java.awt.geom.Line2D;
import sm.jaf.graficos.Linea2D;

/**
 *
 * @author juan
 */


public class Lienzo2D extends javax.swing.JPanel {

    

    //Vector de objetos de tipo Shape (Java2D) que es del que heredan todos los tipos que vamos a usar:
    ArrayList <Shape> vShape = new ArrayList();
    
    private Point pA, pB;
    
    private boolean relleno, sentidoContrario, modoSeleccion, mejoraRenderizacion, transparencia;
    private Color color;
    int figuraMoviendo;
    private int grosorLinea=1;
    
    
    private Herramienta tipoHerramienta;

    //Constructor de la clase Lienzo2D
    public Lienzo2D() {
        initComponents();
        mejoraRenderizacion=false;
    }

    //Get herramienta
    public Herramienta getTipoHerramienta(){
        
        return tipoHerramienta;
    }    
    //Set herramienta    
    public void setTipoHerramienta(Herramienta herramienta){
        Imprimir("recibido tipo de herramienta");
        this.tipoHerramienta=herramienta;
    }
     //Set de color
    public void setColor(Color color){
        Imprimir("Cambiado color");
        this.color=color;
        //Para que al hacer el cambio de color este se aplique en todas las figuras a través del método setAtributos de paint()
        this.repaint();
    }
    
    public void setRelleno(boolean relleno){
        this.relleno=relleno;
        Imprimir("Cambiando relleno a "+relleno);
        this.repaint();
    }
    
    public void setMejoraRenderizacion(boolean mejora){
        this.mejoraRenderizacion=mejora;
        this.repaint();
    }
    
    
  
    private Shape getShapeSeleccionada(Point2D p){
        for(Shape s:vShape)
            if(s.contains(p)) 
                return s;
        return null;
    }
    
    public void setModoSeleccion(boolean modo){
        this.modoSeleccion=modo;
        System.out.println("Asignado modo seleccion: "+modoSeleccion);
    }
    
    public void setGrosor(int grosor){
        grosorLinea = grosor;
        Imprimir("Cambiando grosor a "+grosor);
        this.repaint();
    }
    
    public void setTransparencia(boolean transparencia){
        this.transparencia=transparencia;
        this.repaint();
    }
    
    public void setAtributos(Graphics2D g2d){
        //Declaramos un objeto de tipo stroke para cambiar atributos del trazo
        Stroke trazo;
        //Lo creamos con e cosntructor que sólo acepta el parámetro de grosor de linea.
        trazo = new BasicStroke(grosorLinea);
        //Aplicamos el estilo creado al objeto Graphics2D
        g2d.setStroke(trazo);      
        
        /*
        Paint rellenoPaint;
        rellenoPaint = Color.BLACK;//new Color(color.getRed(),color.getGreen(),color.getBlue());
        rellenoPaint = color;
        */
        g2d.setPaint(color);
        
        
        if(mejoraRenderizacion){
            //Renderización
            RenderingHints render;
            
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            

            render.put(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHints(render);
        }
        
        if(transparencia){
            Composite comp;
            comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(comp);
        }
        
        
    }
    
    //Sobreescritura del método paint
    @Override 
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        
        
        this.setAtributos(g2d);
        
        /*
        Recorremos el vector y usamos el objeto Graphics2D creado para pintar cada uno de los objetos que contiene el vector
        de figuras.
        */
        if(!vShape.isEmpty())
            for(Shape s:vShape){
                //Imprimir(s.getClass().getName());
                if( (s.getClass().getName().contains("Rectangle") || s.getClass().getName().contains("Ellipse")) && relleno==true)
                    g2d.fill(s);
                else
                    g2d.draw(s);                                              
            }
        
        
        
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
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    
        //Obtenemos el primer punto necesario al presionar (sin soltar) el ratón en cualquier parte del frame.        
        pA=evt.getPoint();
        
        //Si el modo selección de figuras está activo:
        if(modoSeleccion==true){
            if(getShapeSeleccionada((Point2D)pA)!=null){
                System.out.println("Figura seleccionada"+getShapeSeleccionada((Point2D)pA));
                //Obtenermos una referencia a la figura en el vector:
                figuraMoviendo=vShape.indexOf(getShapeSeleccionada((Point2D)pA));
                System.out.println("figura: "+figuraMoviendo);
            }else{
                System.out.println("no se ha seleccionado ninguna figura");
                figuraMoviendo=-1;
            }
        }else{
        //Añadimos una nueva figura al vector de figuras al presionar el ratón, dependiendo del tipo de figura
        //que esté seleccionada en las herramientas.
       // vShape.add(new Line2D.Double());
        
         
        if(this.tipoHerramienta==Herramienta.PUNTO){
            //Mientras que no tenemos la clase propia punto lo haremos con un Rectángulo sin suficiente ancho y alto como para que se vea
            vShape.add(new Rectangle2D.Double(pA.x, pA.y, 2, 2));
            //No necesitamos otro punto para dibujar un punto, por eso redibujamos todo ya:
            this.repaint();
        }else
        if(this.tipoHerramienta==Herramienta.LINEA){
            vShape.add(new Linea2D());
        }else 
        if(this.tipoHerramienta==Herramienta.RECTANGULO)
            vShape.add(new Rectangle2D.Double());
        else if(this.tipoHerramienta==Herramienta.OVALO)
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
        
        
        Imprimir("Draggeando en modo seleccion: "+modoSeleccion + "con figura: "+figuraMoviendo);
         if(modoSeleccion==true){
             
             Imprimir("Modo selección en dragged");
             //Imprimir("FiguraMoviendo: " + vShape.get(figuraMoviendo).getClass().getName());
            
             //Si ha seleccionado alguna figura en el pressed tendremos alguna figura que mover
             if(figuraMoviendo!=-1){

                 //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Linea")){
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Linea2D)vShape.get(figuraMoviendo)).setLocation(pB);
                     Imprimir("Intentando mover una linea");

                 //Si se trata de un Rectángulo:
                 }if(vShape.get(figuraMoviendo).getClass().getName().contains("Rectangle"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Rectangle2D)vShape.get(figuraMoviendo)).setFrame(pB.x,pB.y,vShape.get(figuraMoviendo).getBounds2D().getWidth(),vShape.get(figuraMoviendo).getBounds2D().getHeight());                     

                 //Si se trata de una Ellipse:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Ellipse"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Ellipse2D)vShape.get(figuraMoviendo)).setFrame(pB.x,pB.y,vShape.get(figuraMoviendo).getBounds2D().getWidth(),vShape.get(figuraMoviendo).getBounds2D().getHeight());
                 }
         
         }else if(!vShape.isEmpty()){ //Por si el vector está vacío.
       
        /* 
        Accedemos al último elemento del Array y según el tipo de figura que sea hacemos una
        u otra modificación haciendo un casting al tipo de figura que sea para poder acceder a sus métodos. 
        */        
        
        if(this.tipoHerramienta==Herramienta.LINEA){
            /*
            Con los métodos que la clase Line2D tiene para modificar la linea mientras arrastramos el ratón
            debemos modificar los dos puntos con el método setLine.            
            ***Posible mejora de diseño***
            Sería mucho más lógico tener un set para cada uno de los puntos de la linea sin que nos tuviera
            que forzar a usar los dos.
            */
            Imprimir("Creando linea con los puntos A y B");
            ((Linea2D)vShape.get(vShape.size()-1)).setLine(pA, pB);
        }else if(this.tipoHerramienta==Herramienta.RECTANGULO){
            /*
            Para modificarlo tenemos que volver a especificar el primer punto y calcular el ancho y alto del rectángulo
            ***Posible mejora de diseño***
            Un método mucho más útil y simple que debería tener la clase sería aquel que permitiera especificar un nuevo
            rectángulo a partir de dos puntos (haciendo el los cálculos dentro para se pudiera hacer en cualquier dirección y 
            también debería tener un par de métodos set para los dos puntos que representan las esquinas del rectángulo.
            */                      
            //((Rectangle2D)vShape.get(vShape.size()-1)).setRect(pA.x, pA.y, ancho, alto);
            
            //Esta función de Rectangle2D permite enviar solo dos puntos y conseguir que independientemente del lugar donde
            //se encuentren se dibuje un rectangulo entre ellos.
            ((Rectangle2D)vShape.get(vShape.size()-1)).setFrameFromDiagonal(pA, pB);
            
            
        }
        else if(this.tipoHerramienta==Herramienta.OVALO){
            ((Ellipse2D)vShape.get(vShape.size()-1)).setFrameFromDiagonal(pA, pB);
            //((Ellipse2D)vShape.get(vShape.size()-1)).setFrame(pA.x, pA.y, ancho, alto);
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
        //Número de objetos:
        System.out.print("Elementos en vShape: "+vShape.size()+"\n");
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
