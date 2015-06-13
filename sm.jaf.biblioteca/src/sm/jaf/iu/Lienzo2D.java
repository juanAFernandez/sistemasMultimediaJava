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
import java.awt.geom.Line2D;
import sm.jaf.graficos.Elipse;
import sm.jaf.graficos.Figura;
import sm.jaf.graficos.Linea;
//import java.awt.geom.Line2D;
import sm.jaf.graficos.Linea2D;
import sm.jaf.graficos.ManoAlzada;
import sm.jaf.graficos.Rectangulo;



/**
 * 
 * @author Juan A. Fernández Sánchez
 */
public class Lienzo2D extends javax.swing.JPanel {

    
    
    /**
     * Variables como color o grosorLinea son solo variables auxiliares que sirve para la creación de las figuras.
     * Estas variables no configurar la forma de dibujara todas las figuras. Son solo usadas para coger
     * las características que el usuario ha establecido a traveś de las herramientas de la Ventana Principal.
     * Esto es especialmente visible cuando no se selecciona ninguna al principio y se empiezan a usar con 
     * sus valores por defecto. 
     * Por eso si el valor del grosor es 1 las figuras que se construyan tendrán el valor 1 pero si el usuario 
     * cambia este valor las nuevas se crearán con el nuevo valor pero las antiguas conservan el suyo propio al
     * ser atributos de la clase Figura, pero son necesarias aquí para la construcción y para la gestión de las
     * herramientas activas del usuario en la vista principal del programa.
     */

  //  private VentanaPrincipal padre;
    
    //Vector de objetos de tipo Shape (Java2D) que es del que heredan todos los tipos que vamos a usar:
    private ArrayList <Figura> vShape = new ArrayList();
    
    private Point pA, pB;
    
    private boolean relleno, sentidoContrario, modoSeleccion, mejoraRenderizacion, transparencia;
    private Color color;
    
    
    /**
     * Objeto temporal para cuando se hace una selección de una figura.
     */
    int figuraMoviendo;
    
    
    /**
     * Para almacenar el grosor de trazado de trabajo en el lienzo.
     * ¿Por qué tendría que tener el Lienzo un grosor si eso es algo propio de las figuras?
     * 
     * Cuando se cambia el grosor del trazado en la ventana principal se está cambiando aquí.
     * 
     */
    private int grosorLinea=1;
    
    
    private Herramienta tipoHerramienta;

    //Constructor de la clase Lienzo2D
    
    /**
     * Necesitamos una referncia directa al padre.
     */
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
    
     //Set/Get de color
    public void setColor(Color color){
        Imprimir("Cambiado color");
        this.color=color;
        //Para que al hacer el cambio de color este se aplique en todas las figuras a través del método setAtributos de paint()
        this.repaint();
    }
    public Color getColor(){
        return color;
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
    
    
  /*
    private Shape getShapeSeleccionada(Point2D p){
        for(Figura s:vShape)
            if(s.contains(p)) 
                return s;
        return null;
    }
    
    */
    
    public Figura getFigura(int pos){
        return vShape.get(pos);
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
    public int getGrosor(){
        return grosorLinea;
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
 
        if(mejoraRenderizacion){
            //Renderización
            RenderingHints render;
            
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
            

            render.put(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHints(render);
        }
        
        
        /*
        Recorremos el vector y usamos el objeto Graphics2D creado para pintar cada uno de los objetos que contiene el vector
        de figuras.
        */
        
            if(!vShape.isEmpty())
                for(Figura figura:vShape){
                    figura.dibujateEn(g2d);
                   /*
                   //Imprimir(s.getClass().getName());
                    if( (s.getClass().getName().contains("Rectangle") || s.getClass().getName().contains("Ellipse")) && relleno==true)
                        g2d.fill(s);
                    else
                        g2d.draw(s);                                              
                    */
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

   
    public void  addFigure(Figura figura){
        vShape.add(figura);
        this.repaint();
    }
    
    public Figura getFiguraSeleccionada(Point2D puntoClicado){
        
        //Se recorre todas las figuras almacenadas en el vector a ver en cual coincide el punto. Cuando
        //damos con ella la devolvemos
        for(Figura figura: vShape)
            if(figura.contiene(puntoClicado))
                return figura;
        /* En el caso de que el niguna función devolviera true significaría que el punto no pertenece a ninguna y devolvemos null
        para indicarlo asi. */
        return null;
    }
    
    /**
     * Gestion del evento presionar ratón.
     * @param evt Evento en gestión.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    
        //Obtenemos el primer punto necesario al presionar (sin soltar) el ratón en cualquier parte del frame.        
        pA=evt.getPoint();
        
        
        //Si se encuentra seleccionado el modo "selección" porque se quiere editar alguna figura:
        if(modoSeleccion==true){
            
            //Con el punto obtenido buscamos en el vector de figuras amacenadas aquella que hayamos podido seleccionar.
            Figura figura = getFiguraSeleccionada(pA);
            
            //Si ha ocurrido una selección:
            if(figura!=null){                
                                
                //Extraemos la posición dentro del vector de figuras de esta para tenerla localizada.
                figuraMoviendo = vShape.indexOf(figura);
                
                System.out.println("Se ha seleccionado una figura n1 "+figuraMoviendo+" : "+figura.toString());
                
            //Si no ha ocurrido una selección:
            }else{
                
                System.out.println("No se ha seleccionado ninguna figura.");
            
                //Para controlar que no se ha seleccionado ninguna figura del vector se usa el valor de control -1
                figuraMoviendo=-1;
                
             }
            
            
        //Si no se encuentra en el modo selección (entonces se quiere dibujar):
        }else{
        
                //Objeto temporal al que aplicaremos características antes de introducirlo en el vector.
                Figura figuraTemporal;

                if(this.tipoHerramienta==Herramienta.PUNTO){
                
                    figuraTemporal = new ManoAlzada();
                    //Aplicamos el color 
                    figuraTemporal.setColor(color);
                    
                    /**
                     * No tendría que estar cogiendo el grosor predeterminado de aquí, ya que no es una propiedad del lienzo
                     * sino de la ventana principa, de los ajustes por defecto de los selecctores de herramientas.
                     * 
                     */
                    
                    figuraTemporal.setGrosorTrazo(grosorLinea);
                    
                    ((ManoAlzada)figuraTemporal).addPunto(pA);
                    
                    vShape.add(figuraTemporal);
                    
                    
                
                }else
                //Si ha sido seleccionada la herramienta LINEA del buttonGroup
                if(this.tipoHerramienta==Herramienta.LINEA){
                    //Construimos la figura como una Linea
                    figuraTemporal = new Linea();

                    //Aplicamos el color 
                    figuraTemporal.setColor(color);
                    figuraTemporal.setGrosorTrazo(grosorLinea);

                    vShape.add(figuraTemporal);

                }else 
                if(this.tipoHerramienta==Herramienta.RECTANGULO){
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Rectangulo();

                    figuraTemporal.setColor(color);
                    figuraTemporal.setGrosorTrazo(grosorLinea);

                    //Si  ha espeficado quse quiere que la figu esté rellena
                    if(relleno)
                        ((Rectangulo)figuraTemporal).setRelleno(true);
                    
                    vShape.add(figuraTemporal);
                }
                
                else if(this.tipoHerramienta==Herramienta.OVALO){
                    
                    System.out.println("Añadiendo figura ovalo");
                    
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Elipse();

                    figuraTemporal.setColor(color);
                    figuraTemporal.setGrosorTrazo(grosorLinea);
                    
                    //Si  ha espeficado quse quiere que la figu esté rellena
                    if(relleno)
                        ((Elipse)figuraTemporal).setRelleno(true);

                    vShape.add(figuraTemporal);

                }
                
         
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
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Linea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */
                         ((Linea)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
 

                 //Si se trata de un Rectángulo:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Rectangulo"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Rectangulo)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                 
                 //Si se trata de una Ellipse:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Elipse"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Elipse)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                  
             } 
         
         //Si no se encuentra en el modo selección entonces se está creando una figura (modificando la ultima creada) añadiendole coordenadas nuevas.
         }else  if(!vShape.isEmpty()){ //Por si el vector está vacío.
       
        /* 
        Accedemos al último elemento del Array y según el tipo de figura que sea hacemos una
        u otra modificación haciendo un casting al tipo de figura que sea para poder acceder a sus métodos. 
        */        
        
        if(this.tipoHerramienta==Herramienta.PUNTO){
            
            ((ManoAlzada)vShape.get(vShape.size()-1)).addPunto(pB);
        }else
             
        if(this.tipoHerramienta==Herramienta.LINEA){
            /*
            Con los métodos que la clase Line2D tiene para modificar la linea mientras arrastramos el ratón
            debemos modificar los dos puntos con el método setLine.            
            ***Posible mejora de diseño***
            Sería mucho más lógico tener un set para cada uno de los puntos de la linea sin que nos tuviera
            que forzar a usar los dos.
            */
            Imprimir("Creando linea con los puntos A y B");
            ((Linea)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);
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
            ((Rectangulo)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);
            
            
        }
        
        else if(this.tipoHerramienta==Herramienta.OVALO){
            ((Elipse)vShape.get(vShape.size()-1)).cambiarPosicion(pA,pB);
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
