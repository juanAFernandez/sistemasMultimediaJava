/*
        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, either version 3 of the License, or
        (at your option) any later version.
        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
        GNU General Public License for more details.
        You should have received a copy of the GNU General Public License
        along with this program. If not, see <http://www.gnu.org/licenses/>.
      
        Copyright 2015 Juan A. Fernández Sánchez
*/
package sm.jaf.iu;

import static extras.Imprimir.Imprimir;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import extras.Herramienta;
import extras.herramientaTexto;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import sm.jaf.graficos.Arco;
import sm.jaf.graficos.CurvaCuadratica;
import sm.jaf.graficos.CurvaCubica;
import sm.jaf.graficos.Elipse;
import sm.jaf.graficos.Figura;
import sm.jaf.graficos.Linea;
import sm.jaf.graficos.ManoAlzada;
import sm.jaf.graficos.Polilinea;
import sm.jaf.graficos.Rectangulo;
import sm.jaf.graficos.RectanguloRedondeado;
import sm.jaf.graficos.Relleno;
import sm.jaf.graficos.Texto;
import sm.jaf.graficos.Trazo;



/**
 * 
 * @author Juan A. Fernández Sánchez
 */
public class Lienzo2D extends javax.swing.JPanel {

    
    
    /**
     * Variables trazo son solo variables auxiliares que sirve para la creación de las figuras.
     * Estas variables no configurar la forma de dibujara todas las figuras. Son solo usadas para coger
     * las características que el usuario ha establecido a traveś de las herramientas de la Ventana Principal.
     * Esto es especialmente visible cuando no se selecciona ninguna al principio y se empiezan a usar con 
     * sus valores por defecto. 
     * Por eso si el valor del grosor es 1 las figuras que se construyan tendrán el valor 1 pero si el usuario 
     * cambia este valor las nuevas se crearán con el nuevo valor pero las antiguas conservan el suyo propio al
     * ser atributos de la clase Figura, pero son necesarias aquí para la construcción y para la gestión de las
     * herramientas activas del usuario en la vista principal del programa.
     */

    private boolean central=false;
    
    /**
     * El trazo contiene toda la información de trazada.
     * Desde el color hasta el grosor, la continuidad y los adornos.
     */
    private Trazo trazo;

    /**
     * El relleno en el caso de que se use.
     */
    private Relleno rellenoPadre;
    
    private boolean bloqueadaCreacionPolilinea=false;
    
    
    //Vector de objetos de tipo Shape (Java2D) que es del que heredan todos los tipos que vamos a usar:
    protected ArrayList <Figura> vShape = new ArrayList();
    
    protected ArrayList <Texto> vTextos = new ArrayList();
    
    private Point pA, pB;
    
    private boolean rellenoBoolean, modoSeleccion, mejoraRenderizacion, transparencia;

    
    private BufferedImage img;
   
    /**
     * Objeto temporal para cuando se hace una selección de una figura.
     */
    int figuraMoviendo;

    //Idem que figuraMoviendo pero para texto.
    int textoMoviendo;
    
    private Herramienta tipoHerramienta;

    //Constructor de la clase Lienzo2D
    
    /**
     * Necesitamos una referncia directa al padre.
     */
    public Lienzo2D() {
        initComponents();
        mejoraRenderizacion=false;
        trazo=new Trazo();
        rellenoPadre=null;
        
 
    }
   

    
    
    
    // ## FUNCIONES PARA ESTABLECER PARAMETROS DESDE EL PADRE QUE SERÁN LOS DE USO EN LA CREACIÓN DE FIGURAS NUEVAS ##
    
    public void setCentral(boolean opcion){
        central=opcion;
    }
    
    public void setTrazo(Trazo nuevoTrazo){
        trazo = new Trazo();
        trazo.setCopiaTrazo(nuevoTrazo);
                
                
        Imprimir("Cambiado tipo de trazo");
    }
    public Trazo getTrazo(){
        
        Imprimir("Devolviendo el trazo");
        return trazo;
    }
    
    public void setRelleno(Relleno nuevoRelleno){
        Imprimir("Introduciendo relleno a Lienzo2D del padre");
        rellenoPadre = nuevoRelleno;
        
    }
    public Relleno getRelleno(){
        return rellenoPadre;
    }
    public boolean getRellenoBoolean(){
        return rellenoBoolean;
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
    


    
    public void setRelleno(boolean relleno){
        this.rellenoBoolean=relleno;
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
    public void delFigura(int pos){
        vShape.remove(pos);
    }
    public int getTextoSeleccionado(){//Sólo es esto lo que se hacía antes, 
        return textoMoviendo;
    }
    public Texto getText(int pos){
        return vTextos.get(pos);
    }
    public boolean isEmptyTextos(){
        return vTextos.isEmpty();
    }
    
    public void setTexto(Texto nuevo){
        vTextos.add(nuevo);
        textoMoviendo=vTextos.indexOf(nuevo);
    }
    
    public void setModoSeleccion(boolean modo){
        
        //Cambiamos el modoSeleccion a true o false según lo que nos digan
        this.modoSeleccion=modo;
        
        
        
        System.out.println("Asignado modo seleccion: "+modoSeleccion);
        //>>>>>
        

        /**
         * No afecta a todas las figuras igual.
         * Hasta ahora sólo teníamos figuras que su edición era moverlas por el plano, pero al incuir las curvas cuadraticas y cúbicas
         * y el arco las posibilidades de edición aumentan y en concreto para esas figuras el modo edición
         * implica mandarles un mensaje para que activen ciertos elementos, además de por supuesto poner siempre la variable
         * modoSeleccion a como nos digan para que al pinchar se realicen ciertas acciones sobre esos nuevos puntos de control.
         */
        
        if(modo==true){
            //Podemos decirle a todas las figuras del vector que se entra en modo editar para que dibujen sus puntos de control.        
            //Para eso recorremos el vector:
            //POR AHORA SOLO VAMOS A PROBAR CON LA CURVA
            //Le decimos a las figuras de tipo Curva que se está en modo edición.
            for(Figura figura: vShape){
                if(figura.getClass().getName().contains("Cuadratica"))
                    ((CurvaCuadratica)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Cubica"))
                    ((CurvaCubica)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Arco"))
                    ((Arco)figura).setModoEdicion(true);                                
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo"))
                    ((Rectangulo)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Polilinea"))
                    ((Polilinea)figura).setModoEdicion(true);
            }

            //Se repinta el vector para que se pinten los puntos de control que se han activado en las figuras de tipo Curva.
            this.repaint();
        }else{
            //Le decimos a todas las figuras que no:
            for(Figura figura: vShape){
                if(figura.getClass().getName().contains("Cuadratica"))
                    ((CurvaCuadratica)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Cubica"))
                    ((CurvaCubica)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Arco"))
                    ((Arco)figura).setModoEdicion(false);
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo"))
                    ((Rectangulo)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Polilinea"))
                    ((Polilinea)figura).setModoEdicion(false);
            }
            
            this.repaint();

        }
        
    }
  
    public void setTransparencia(boolean transparencia){
        this.transparencia=transparencia;
        this.repaint();
    }
    
    /*
    public void setAtributos(Graphics2D g2d){
        //Declaramos un objeto de tipo stroke para cambiar atributos del trazo
        Stroke trazo;
        //Lo creamos con e cosntructor que sólo acepta el parámetro de grosor de linea.
        trazo = new BasicStroke(grosorLinea);
        //Aplicamos el estilo creado al objeto Graphics2D
        g2d.setStroke(trazo);      

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
        
        
    }*/
    
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
        
     //   Imprimir("Nombre del objeto"+this.getClass().);
            //Habría que conseguir que esto sólo se hiciera para la sección central
                //Pruebas de recorte:
        if(central){
                Shape clipArea = new Rectangle2D.Double(0,0,300,300);
                g2d.setClip(clipArea);
                //fin de prueba de recorte                                
                Figura clip = new Rectangulo();
                clip.cambiarPosicion(new Point2D.Double(0, 0), new Point2D.Double(299,299));
                Trazo miTrazo = new Trazo();
                float patron[] = {10,10,2,10,0,0,0,0};
                miTrazo.setPatronDiscontinuidad(patron);
                miTrazo.setColor(Color.GRAY);
                clip.setTrazo(miTrazo);                
               // Shape clipArea2 = new Rectangle2D.Double(0,0,199,199);
                //g2d.draw(clipArea2);
                clip.dibujateEn(g2d);
        }

            Imprimir("Dibujando "+vShape.size()+"figuras en el plano");
            //Si el vector de figuras no está vacío se recorre y se imprime.
            if(!vShape.isEmpty())

                for(Figura figura:vShape){
                    figura.dibujateEn(g2d);
                    Imprimir(figura.toString());
                   /*
                   //Imprimir(s.getClass().getName());
                    if( (s.getClass().getName().contains("Rectangle") || s.getClass().getName().contains("Ellipse")) && relleno==true)
                        g2d.fill(s);
                    else
                        g2d.draw(s);                                              
                    */
                }
        
            //Después de recorrer el vector de figuras se recorre el vector de textos:
            if(!vTextos.isEmpty())
                for(Texto texto: vTextos)
                    texto.dibujateEn(g2d);
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 204, 204));
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
    
      public Texto getTextoSeleccionado(Point2D puntoClicado){
        
        //Se recorre todas los textos almacenadas en el vector a ver en cual coincide el punto. Cuando
        //damos con ella la devolvemos
        for(Texto texto: vTextos)
            if(texto.contiene(puntoClicado))
                return texto;
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
            
            Texto texto = getTextoSeleccionado(pA);
            
            
                    //Si ha ocurrido una selección de una figura
                  
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
                    
                    //Si ha ocurrido una selección de un texto
                  
                    if(texto!=null){                

                        //Extraemos la posición dentro del vector de textos de esta para tenerla localizada.
                        textoMoviendo = vTextos.indexOf(texto);

                        System.out.println("Se ha seleccionado el texto num  "+textoMoviendo+" : "+texto.toString());

                    //Si no ha ocurrido una selección:
                    }else{

                        System.out.println("No se ha seleccionado ningun texto.");

                        //Para controlar que no se ha seleccionado ninguna figura del vector se usa el valor de control -1
                        textoMoviendo=-1;

                    }
            
                    
                    
            
        //Si no se encuentra en el modo selección (entonces se quiere dibujar):
            
        // ## ACCIÓN DE DIBUJADO ## //
            
        }else{
                // ### POLILINEA (aclaración) ###
                /*Si pulsamos una vez y estamos trabajando con la figura polilinea se queda bloqueado el dibujo en
                ella de forma que cualquier click que podamos hacer siguiente añade un punto a esta figura. 
                En el caso de que no queramos seguir dibujando esta figura hacemos doble click y el cerrojo será 
                abierto.
                */
            
                //Objeto temporal al que aplicaremos características antes de introducirlo en el vector.
                Figura figuraTemporal;
                

                if(this.tipoHerramienta==Herramienta.PUNTO){
                
                    figuraTemporal = new ManoAlzada();
                    
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);


                    
                    ((ManoAlzada)figuraTemporal).addPunto(pA);
                    
                    vShape.add(figuraTemporal);
                    
                    
                
                }else
                //Si ha sido seleccionada la herramienta LINEA del buttonGroup
                if(this.tipoHerramienta==Herramienta.LINEA){
                    //Construimos la figura como una Linea
                    figuraTemporal = new Linea();

                    //Aplicamos el color 
               //     figuraTemporal.getTrazo().setColor(color);
                    
                    
                    //PRUEBA EXPLOSIVA//
                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                //Si ha sido seleccionada la herramienta LINEA del buttonGroup
                if(this.tipoHerramienta==Herramienta.POLILINEA){                                        
                    
                    //Si no está bloqueada la creación de una polilinea
                    if(!bloqueadaCreacionPolilinea){
                        
                        
                        Imprimir("CREACION DE FIGURA POLILINEA");
                        
                        //Construimos la figura como una Polilinea:
                        figuraTemporal = new Polilinea();

                        //Añadimos el primer punto que es donde hemos pulsado:
                        ((Polilinea)figuraTemporal).addPunto(pA);

                       //Aplicamos el trazo en uso
                        figuraTemporal.setTrazo(trazo);

                        //Añadimos la figura al vector de figuras.
                        vShape.add(figuraTemporal);
                        
                        //Bloqueamos la creación, para que la proxima acción mousePressed añada puntos y no una figura nueva:
                        bloqueadaCreacionPolilinea=true;
                    }
                    /*Pero si está bloqueada la creación lo que se está haciendo es añadir puntos a una figura previamente
                    creada. Entonces añadimos a la ultima figura del vector y le añadimos puntos.*/
                    else{
                        
                        Imprimir("Añadiendo punto a polilinea");
                        
                        //Accedemos a la ultima figura del vector que será una polilinea y añadimos un nuevo punto.
                        ((Polilinea)vShape.get(vShape.size()-1)).addPunto(pA);
                        //Repintamos para que se vea el proceso de creación.
                        this.repaint();
                    }

                        
                        
                }else 
                     //Si ha sido seleccionada la herramienta Curva Cuadratica del buttonGroup
                if(this.tipoHerramienta==Herramienta.CURVA_CUADRATICA){
                    //Construimos la figura como una Linea
                    figuraTemporal = new CurvaCuadratica();

                    //Aplicamos el color 
               //     figuraTemporal.getTrazo().setColor(color);
                    
                    
                    //PRUEBA EXPLOSIVA//
                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                //Si ha sido seleccionada la herramienta Curva Cúbica del buttonGroup
                if(this.tipoHerramienta==Herramienta.CURVA_CUBICA){
                    //Construimos la figura como una Linea
                    figuraTemporal = new CurvaCubica();

                    //Aplicamos el color 
               //     figuraTemporal.getTrazo().setColor(color);
                    
                    
                    //PRUEBA EXPLOSIVA//
                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                if(this.tipoHerramienta==Herramienta.RECTANGULO){
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Rectangulo();
                   
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);
                    



                    //Si  ha espeficado quse quiere que la figu esté rellena
                    if(rellenoBoolean){
                                            
                        ((Rectangulo)figuraTemporal).setRelleno(rellenoPadre);
                        ((Rectangulo)figuraTemporal).setRelleno(true);
                    }
                    
                    vShape.add(figuraTemporal);
                }
                
                else if(this.tipoHerramienta==Herramienta.RECTANGULO_REDONDEADO){
                    
                    System.out.println("Añadiendo figura rectangulo redondeado");
                    
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new RectanguloRedondeado();

                   
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);

                    
                    //Si  ha espeficado quse quiere que la figura esté rellena 
                   if(rellenoBoolean){
                                            
                        ((RectanguloRedondeado)figuraTemporal).setRelleno(rellenoPadre);
                        ((RectanguloRedondeado)figuraTemporal).setRelleno(true);
                    }

                    vShape.add(figuraTemporal);

                }
                
                else if(this.tipoHerramienta==Herramienta.OVALO){
                    
                    System.out.println("Añadiendo figura ovalo");
                    
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Elipse();

                   
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);

                    
                    //Si  ha espeficado quse quiere que la figu esté rellenar 
                   if(rellenoBoolean){
                                            
                        ((Elipse)figuraTemporal).setRelleno(rellenoPadre);
                        ((Elipse)figuraTemporal).setRelleno(true);
                    }

                    vShape.add(figuraTemporal);

                } else
                    
                    if(this.tipoHerramienta==Herramienta.ARCO){
                    
                    System.out.println("Añadiendo figura ARCO");
                    
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Arco();

                   
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);

                    //Esta figura no tiene relleno porque no puede

                    vShape.add(figuraTemporal);

                } else
                    
                    if(this.tipoHerramienta==Herramienta.TEXTO){
                    
                  
                    
                    herramientaTexto hT = new herramientaTexto(this, pA);
                    hT.setVisible(true);
                    
                    //Tengo que avisar al padre para que habra el menú de la herramienta
                    
                    //Sólo en este caso repintamos ya.
                    this.repaint();
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
        
        
    //    Imprimir("Draggeando en modo seleccion: "+modoSeleccion + "con figura: "+figuraMoviendo);
     //   Imprimir("Draggeando en modo seleccion: "+modoSeleccion + "con texto: "+textoMoviendo);
        
        
        /**
         * Si el modo de selcción está activado se va a editar algo en alguna figura.
         */
         if(modoSeleccion==true){
             
             
             
            
             //Si ha seleccionado alguna figura en el pressed tendremos alguna figura que mover
             if(figuraMoviendo!=-1){

                // Imprimir("Moviendo figura: " + vShape.get(figuraMoviendo).getClass().getName());
                 
                 
                 
                 //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Linea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */
                         ((Linea)vShape.get(figuraMoviendo)).cambiarPosicion2(pA, pB);
                
                //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Polilinea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */
                         ((Polilinea)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA,pB);
                 
                 
                 
                 //Si se trata de una curva cuadrática:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("CurvaCuadratica")){
                     Imprimir("#####Moviendo una curva cuadratica en DRAGGED###");
                     if(vShape.get(figuraMoviendo)!=null)
                         //((CurvaCuadratica)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                         
                         /**
                          * Por ahora no se mueve la figura como el resto.
                          * Sólo se ha programado la gestión de los puntos de control.
                          */
                         ((CurvaCuadratica)vShape.get(figuraMoviendo)).cambiarPuntoControl(pB);
                 }
                 
                 //Si se trata de una curva cubica:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Cubica")){
                     Imprimir("#####Moviendo una curva cubica en DRAGGED###");
                     if(vShape.get(figuraMoviendo)!=null)
                         //((CurvaCuadratica)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                         /**
                          * Por ahora no se mueve la figura como el resto.
                          * Sólo se ha programado la gestión de los puntos de control.
                          */
                         ((CurvaCubica)vShape.get(figuraMoviendo)).cambiarPuntosControl(pB);
                 }
                 
                  //Si se trata de una curva cubica:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Arco")){
                     //Imprimir("#####ARCO CAMBIANDO PUNTOS DE CONTROL###");
                     if(vShape.get(figuraMoviendo)!=null)
                         //((CurvaCuadratica)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                         /**
                          * Por ahora no se mueve la figura como el resto.
                          * Sólo se ha programado la gestión de los puntos de control.
                          */
                         ((Arco)vShape.get(figuraMoviendo)).cambiarPuntosControl(pB);
                 }

                 //Si se trata de un Rectángulo:
                 if(vShape.get(figuraMoviendo).getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo")){
                     Imprimir("Moviendo un rectantulo");
                     if(vShape.get(figuraMoviendo)!=null){
                        // ((Rectangulo)vShape.get(figuraMoviendo)).calcularDiferencias(pA); //El punto A siempre es el mismo
                        // ((Rectangulo)vShape.get(figuraMoviendo)).aplicarDiferencias(pB); //El punto B cambia
                         ((Rectangulo)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
                     }
                 }
                 
                 //Si se trata de un RectánguloRedondeado:
                 if(vShape.get(figuraMoviendo).getClass().getName().contentEquals("sm.jaf.graficos.RectanguloRedondeado")){
                     Imprimir("Moviendo un rectangulo redondeado");
                     if(vShape.get(figuraMoviendo)!=null)
                         ((RectanguloRedondeado)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                 }
                 
                 //Si se trata de una Ellipse:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Elipse"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Elipse)vShape.get(figuraMoviendo)).cambiarPosicion2(pB);
                  
             } 
             
             
             //Si se ha seleccionado agún texto tendremos un texto que mover:
              if(textoMoviendo!=-1){
              Imprimir("Vamos a mover un texto");
                    vTextos.get(textoMoviendo).cambiarPosicion(pB);
              }
         
         //Si NO SE ENCUENTRA EN MODO SELECCIÓN entonces se está creando una figura (modificando la ultima creada) añadiendole coordenadas nuevas,
              //normalmente porque se está haciendo grande...
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
            
        }else 
            
            if(this.tipoHerramienta==Herramienta.CURVA_CUADRATICA){
            /*
            Con los métodos que la clase Line2D tiene para modificar la linea mientras arrastramos el ratón
            debemos modificar los dos puntos con el método setLine.            
            ***Posible mejora de diseño***
            Sería mucho más lógico tener un set para cada uno de los puntos de la linea sin que nos tuviera
            que forzar a usar los dos.
            */
            Imprimir("Creando curva cuadrática con los puntos A y B");
            ((CurvaCuadratica)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);
            
        }else 
            
            if(this.tipoHerramienta==Herramienta.CURVA_CUBICA){
            /*
            Con los métodos que la clase Line2D tiene para modificar la linea mientras arrastramos el ratón
            debemos modificar los dos puntos con el método setLine.            
            ***Posible mejora de diseño***
            Sería mucho más lógico tener un set para cada uno de los puntos de la linea sin que nos tuviera
            que forzar a usar los dos.
            */
            Imprimir("Creando curva cubica con los puntos A y B");
            ((CurvaCubica)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);               
            
        }else 
            
            if(this.tipoHerramienta==Herramienta.RECTANGULO_REDONDEADO){
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
            ((RectanguloRedondeado)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);
            
            
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
        else if(this.tipoHerramienta==Herramienta.ARCO){
            ((Arco)vShape.get(vShape.size()-1)).cambiarPosicion(pA,pB);
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
        //Número de objetos en ambos vectores:
     //   Imprimir("Elementos en vShape: "+vShape.size());
     //   Imprimir("Elementos de texto en vTextos: "+vTextos.size());
        
        if(modoSeleccion==true){
        //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Polilinea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */

                         ((Polilinea)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
        }
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    
    /**
     * Programaicón del doble click de ratón.
     * @param evt 
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        int numTexto;
        Texto texto = new Texto();
        
        if (evt.getClickCount() == 2) {
            
            
            /*Si al hacer doble click estamos trabajando con una polilinea cerramos el objeto, es decir, 
            estamos desbloqueando la creacion de polilineas. Es decir, ahora un nuevo click tras este doble 
            creara un nuevo objeto Polilinea (siempre que la herramienta este seleciconada).
            */
          
            if(tipoHerramienta==Herramienta.POLILINEA){
                this.bloqueadaCreacionPolilinea=false; 
                
                //Además como se habrá interpretado que se quieren añadir dos puntos por lo que quitamos uno.
                ((Polilinea)vShape.get(vShape.size()-1)).cierraPolilinea();
                
                
            }
            
            
            
            
            
            
            //Extraemos el punto de click
            pB=evt.getPoint();
            
            if(modoSeleccion==true){
                
                //Extraemos el texto seleccionado si es que lo hubiese
                texto = getTextoSeleccionado(pB);
                            
                    //Si ha ocurrido una selección de un texto
                  
                    if(texto!=null){                

                        //sacamos el texto que se está moviendo
                        textoMoviendo=vTextos.indexOf(texto);
                        //Extraemos la posición dentro del vector de textos de esta para tenerla localizada.
                        //numTexto = vTextos.indexOf(texto);
                       // System.out.println("double clicked en texto "+texto.getText());
                        
                        //Abrimos la herramienta de texto pasando el texto que queremos modificar.
                        herramientaTexto hT = new herramientaTexto(this, texto);
                        Imprimir("Abriendo "+texto.getText());
                        hT.setVisible(true);
                        
                    }
                
            }
            
                
        }
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  
}
