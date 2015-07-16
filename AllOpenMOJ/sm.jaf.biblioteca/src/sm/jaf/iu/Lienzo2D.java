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
import java.awt.Cursor;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.SwingUtilities;
//Añadimos toda la librería:
import sm.jaf.graficos.*;


/**
 * Implementa el linezo sobre el que se realiza el dibujo de las figuras.
 * Se trata de un panel de Java Swing que posee algunos vectores donde se almacenan todas las figuras y 
 * textos que usuario introduzca. Posee los métodos necesarios para realizar el dibujado de los vectores.
 * Además implementa toda la gestión de eventos del ratón que conforma la mayor parte de la interactividad 
 * con el usuario.
 * 
 * @author Juan A. Fernández Sánchez
 */
public class Lienzo2D extends javax.swing.JPanel {

    Figura figura;
    
    /**
     * Dimensiones del lienzo.
     */
    int anchoLienzo;
    int altoLienzo;
    
    
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
    
    /**
     * Variable de control para el proceso de creación del objeto polilinea.
     */
    private boolean bloqueadaCreacionPolilinea=false;
    
    
    /**
     * Vector de almacenamiento para los objetos de tipo de Figura.
     */
    protected ArrayList <Figura> vShape = new ArrayList();
    
    /**
     * Vector de almacenamiento para los objetos de tipo texto.
     */
    protected ArrayList <Texto> vTextos = new ArrayList();
    
    /**
     * Puntos de ratón recogidos en ciertos momentos de la interacción con el usuario.
     */
    private Point pA, pB;
    
    private boolean rellenoBoolean, modoSeleccion, mejoraRenderizacion, transparencia;

    
    // ##Cursores## //
    java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
    Image iconoManoAbierta = toolkit.getImage("/home/juan/Documentos/SegundoCuatrimestre1415/SMM/sistemasMultimediaJava/AllOpenMOJ/sm.jaf.biblioteca/src/extras/openHand.png");
    Image iconoManoCerrada = toolkit.getImage("/home/juan/Documentos/SegundoCuatrimestre1415/SMM/sistemasMultimediaJava/AllOpenMOJ/sm.jaf.biblioteca/src/extras/closeHand.png");    
    Cursor cursorManoAbierta = toolkit.createCustomCursor(iconoManoAbierta , new Point(this.getX(),this.getY()), "");
    Cursor cursorManoCerrada = toolkit.createCustomCursor(iconoManoCerrada , new Point(this.getX(),this.getY()), "");
    
    
   
    /**
     * Objeto temporal para cuando se hace una selección de una figura.
     */
    int figuraMoviendo;

    //Idem que figuraMoviendo pero para texto.
    int textoMoviendo;
    
    /**
     * Variable para la selección de herramienta de dibujo.
     */
    private Herramienta tipoHerramienta;

    
    
    /**
     * Constructor.
     */
    public Lienzo2D() {
        initComponents();
        mejoraRenderizacion=false;
        trazo=new Trazo();
        rellenoPadre=null;
        anchoLienzo=altoLienzo=300;
        
 
    }
   
    /**
     * Modifica el tamaño del linezo de dibujo.
     * @param anchoL Nuevo valor para el ancho del lienzo.
     * @param altoL Nuevo valor para el alto del lienzo.
     */
    public void setDimensionesLienzo(int anchoL, int altoL){
        anchoLienzo=anchoL;
        altoLienzo=altoL;
    }
    
    
    
    // ## FUNCIONES PARA ESTABLECER PARAMETROS DESDE EL PADRE QUE SERÁN LOS DE USO EN LA CREACIÓN DE FIGURAS NUEVAS ##
    
    /**
     * Especifica si se trata de un lienzo usado en una ventana interna.
     * @param opcion Siendo true dibuja aplica el cliping al dibujar las figura, siendo false como en las 
     * previsualizaciones, no lo aplica.
     */
    public void setCentral(boolean opcion){
        central=opcion;
    }
    
    /**
     * Para cambiar el trazo a aplicar sobre las nuevas figuras que se dibujen.
     * @param nuevoTrazo Objeto de tipo trazo para aplicar a las figuras.
     */
    public void setTrazo(Trazo nuevoTrazo){
        //Se crea el nuevo objeto de tipo trazo.
        trazo = new Trazo();
        //Para hacer una copia después, al no tratarse de un tipo primario no puede realizarse una copia directa.
        trazo.setCopiaTrazo(nuevoTrazo);
    }
    /**
     * Devuelve el tipo de trazo usado.
     * @return Objeto de tipo Trazo 
     */
    public Trazo getTrazo(){
        
        Imprimir("Devolviendo el trazo");
        return trazo;
    }
    
    /**
     * Establece un nuevo tipo de relleno usado en las figuras que lo acepten.
     * @param nuevoRelleno Nuevo relleno a usar por las figuras.
     */
    public void setRelleno(Relleno nuevoRelleno){
        Imprimir("Introduciendo relleno a Lienzo2D del padre");
        rellenoPadre = nuevoRelleno;
        
    }
    /**
     * Devuelve el tipo de relleno usado por las figuras.
     * @return Objeto de tipo Relleno
     * @see sm.jaf.graficos.Relleno.java
     */
    public Relleno getRelleno(){
        return rellenoPadre;
    }
    /**
     * Para conocer si se está o no usando relleno en el dibujado de las figuras.
     * @return True si se están rellenando las figuras y false si no es así.
     */
    public boolean getRellenoBoolean(){
        return rellenoBoolean;
    }
    
    /**
     * Devuelve el tipo de herramienta que se se está usano para dibujar.
     * @return Objeto del tipo enumerado Herramienta.
     * @see extras.Herramienta.java
     */        
    public Herramienta getTipoHerramienta(){        
        return tipoHerramienta;
    }    
    
    /**
     * Establece el tipo de herramienta a usar, el tipo de figura.
     * @param herramienta Objeto de tipo Herramienta para elegir.
     * @see extras.Herramienta.java
     */
    public void setTipoHerramienta(Herramienta herramienta){
        Imprimir("recibido tipo de herramienta");
        this.tipoHerramienta=herramienta;
    }
    
    /**
     * Especifica si las figuras que se añadan al linezo tendrán relleno.
     * @param relleno True si tse quieren rellenas, false en otro caso.
     */
    public void setRelleno(boolean relleno){
        this.rellenoBoolean=relleno;
        Imprimir("Cambiando relleno a "+relleno);
        this.repaint();
    }
    
    /**
     * Aplica la mejora de renderización para que el dibuja mejore haciendo más suave el dibujo.
     * @param mejora True si se quiere suavizar el dibujo, false en otro caso.
     */
    public void setMejoraRenderizacion(boolean mejora){
        this.mejoraRenderizacion=mejora;
        this.repaint();
    }
    
    /**
     * Devuelve la figura con índice pasado del vector que las almacena.
     * @param pos Posición de la figura que queremos sacar del vector de figuras.
     * @return La figura que indicamos con el índice.
     */
    public Figura getFigura(int pos){
        return vShape.get(pos);
    }
    
    /**
     * Elimina una figura del vector que las contiene.
     * @param pos Posición de la figura que queremos eliminar.
     */
    public void delFigura(int pos){
        vShape.remove(pos);
    }
    /**
     * ELimina todas las figuras del vector.
     */
    public void delAllFiguras(){
        vShape.clear();
    }
    
    /**
     * Devuelve el indice del texto que haya sido seleccionado con el ratón en caso de que alguno haya sido.
     * @return Índice del vector de textos del texto seleccionado.
     */
    public int getTextoSeleccionado(){//Sólo es esto lo que se hacía antes, 
        return textoMoviendo;
    }
    
    /**
     * Devuelve el texto indicado por el índice.
     * @param pos Posición del texto en el vector que requeremos recuperar.
     * @return Objeto de tipo Texto.
     * @see sm.jaf.graficos.Texto
     */
    public Texto getText(int pos){
        return vTextos.get(pos);
    }
    
    /**
     * Para cononcer si el vector de textos está vacío.
     * @return True si está vacío, false en otro caso.
     */
    public boolean isEmptyTextos(){
        return vTextos.isEmpty();
    }
    
    /**
     * Añade un texto al vector de textos del lienzo.
     * @param nuevo Objeto de tipo Texto que se añadirá al vector del lienzo.
     * @see sm.jaf.graficos.Texto
     */
    public void setTexto(Texto nuevo){
        vTextos.add(nuevo);
        textoMoviendo=vTextos.indexOf(nuevo);
    }
    
    /**
     * Para aplicar el modo selección a las figuras y textos del vector.
     * Si se activa se dibujan junto a la figura todos los puntos de control y se habilita el uso 
     * y selección de los mismos.
     * @param modo True si se quiere habilitar el modo edición, false en otro caso.
     */
    public void setModoSeleccion(boolean modo){
        
        //Cambiamos el modoSeleccion a true o false según el param.
        this.modoSeleccion=modo;
                
        /**
         * No afecta a todas las figuras igual.
         * Hasta ahora sólo teníamos figuras que su edición era moverlas por el plano, pero al incuir las curvas cuadraticas y cúbicas
         * y el arco las posibilidades de edición aumentan y en concreto para esas figuras el modo edición
         * implica mandarles un mensaje para que activen ciertos elementos, además de por supuesto poner siempre la variable
         * modoSeleccion a como nos digan para que al pinchar se realicen ciertas acciones sobre esos nuevos puntos de control.
         */
        
        if(modo==true){
            
            //Podemos decirle a todas las figuras del vector que se entra en modo editar para que dibujen sus puntos de control.        
            for(Figura figura: vShape){
                if(figura.getClass().getName().contains("Cuadratica"))
                    ((CurvaCuadratica)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Cubica"))
                    ((CurvaCubica)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Arco"))
                    ((Arco)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Linea"))
                    ((Linea)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Elipse"))
                    ((Elipse)figura).setModoEdicion(true);
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo"))
                    ((Rectangulo)figura).setModoEdicion(true);
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.RectanguloRedondeado"))
                    ((RectanguloRedondeado)figura).setModoEdicion(true);
                if(figura.getClass().getName().contains("Polilinea"))
                    ((Polilinea)figura).setModoEdicion(true);
            }

            //Se repinta el vector para que se pinten los puntos de control que se han activado en las figuras de tipo Curva.
            this.repaint();
            
        }else{
            
            //Le decimos a todas las figuras que no queremos dibujar los puntos de control:
            for(Figura figura: vShape){
                if(figura.getClass().getName().contains("Cuadratica"))
                    ((CurvaCuadratica)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Cubica"))
                    ((CurvaCubica)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Arco"))
                    ((Arco)figura).setModoEdicion(false);
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo"))
                    ((Rectangulo)figura).setModoEdicion(false);
                if(figura.getClass().getName().contentEquals("sm.jaf.graficos.RectanguloRedondeado"))
                    ((RectanguloRedondeado)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Linea"))
                    ((Linea)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Elipse"))
                    ((Elipse)figura).setModoEdicion(false);
                if(figura.getClass().getName().contains("Polilinea"))
                    ((Polilinea)figura).setModoEdicion(false);
            }
            //Se repita el vector de figuras para que los puntos de control no aparezcan.
            this.repaint();

        }
        
    }
  
    /**
     * Habilita la transparencia entre todas las figuras de los vectores.
     * @param transparencia True si queremos habilitarla y false en otro caso.
     */
    public void setTransparencia(boolean transparencia){
        this.transparencia=transparencia;
        this.repaint();
    }
    
    /**
     * Método más importante de la clase, es quien realiza realmente el pintado de todas las figuras
     * sobre el objeto de tipo Graphics que le es pasado.
     * @param g Entorno donde se realizará el dibujado de todas las figuras.
     */
    @Override 
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
 
        //Si la mejora de renderización está activa se aplican ciertos parámetros al entorno pasado antes de pintar cualquier cosa.
        if(mejoraRenderizacion){
            //Renderización
            RenderingHints render;
            
            render = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);            

            render.put(RenderingHints.KEY_COLOR_RENDERING,
            RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHints(render);
        }
        
        

        /**
         * No sólo hay lienzos donde dibujamos sino que también se usan para previsualizaciones.
         * Si centrall==true se trata de un lienzo en una ventana interna y por tanto requiere cliping
         * y dibujado de borde del mismo.
         */
        if(central){
                                
                //Creamos el borde la zona de cliping.
                Figura clip = new Rectangulo();
                clip.cambiarPosicion(new Point2D.Double(0, 0), new Point2D.Double(anchoLienzo-1,altoLienzo-1));
                Trazo miTrazo = new Trazo();
                float patron[] = {10,10,2,10,0,0,0,0};
                miTrazo.setPatronDiscontinuidad(patron);
                miTrazo.setColor(Color.GRAY);
                clip.setTrazo(miTrazo);                
               // Shape clipArea2 = new Rectangle2D.Double(0,0,199,199);
                //g2d.draw(clipArea2);
                clip.dibujateEn(g2d);
                
                //Creamos una región de clip sobre la figura para que sólo se dibuje lo que hay dentro de ella.
                Shape clipArea = new Rectangle2D.Double(0,0,anchoLienzo,altoLienzo);                
                g2d.setClip(clipArea);
                
        }

            /*Recorremos el vector y usamos el objeto Graphics2D creado para pintar cada uno de los objetos que contiene el vector
            de figuras.*/                
            Imprimir("Dibujando "+vShape.size()+"figuras en el plano");
            //Si el vector de figuras no está vacío se recorre y se diguban todas las figuras que contenga.
            if(!vShape.isEmpty())

                for(Figura fig:vShape){
                    fig.dibujateEn(g2d);
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
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
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

   /**
    * Añade una figura al vector de estas del lienzo.
    * @param figura Objeto de tipo Figura que se añadirá al vector.
    * @see sm.jaf.graficos.Figura
    */
    public void  addFigure(Figura figura){
        vShape.add(figura);
        this.repaint();
    }
    
    /**
     * Para sacar un objeto figura del vector de estas del lienzo si el punto pasado pertenece  ella.
     * @param puntoClicado Punto a comprobar si pertenece a una figura para sacarla del vector.
     * @return Objeto de tipo Figura del vector de estas.
     * @see sm.jaf.graficos.Figura
     */
    public Figura getFiguraSeleccionada(Point2D puntoClicado){
        
        //Se recorre todas las figuras almacenadas en el vector a ver en cual coincide el punto
        for(Figura fig: vShape)
            if(fig.contiene(puntoClicado))
                //En el caso de dar con ella se devuelve
                return fig;
        /* En el caso de que el niguna función devolviera true significaría que el punto no pertenece a ninguna y devolvemos null
        para indicarlo asi. */
        return null;
    }
    
    /**
     * Para obtener el texto del vector de textos que contenca a punto pasado.
     * En caso de que el punto pasado coincida con algún texto se devuelve.
     * @param puntoClicado Punto a comprobar pertenencia con algún texto.
     * @return Objeto Texto al que el punto pasado pertenece en el caso de que haya coincidencia, null en otro caso.
     * @see sm.jaf.graficos.Texto
     */
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
     * Refresca la ultima figura seleccionada con los nuevos parámetros de dibujo, que 
     * han podido cambiar.
     */
    public void aplicarUltimaFigura(){
                                        
          /*Cuando se llama a esta función desde ventana principal antes se ha llamado a alguna que cambia el trazo por defecto
          por tanto se cambia el color de la ultima figura seleccionada.*/
          if(figura!=null){
            //Color
            figura.getTrazo().setColor(this.trazo.getColor());
            //Grosor
            figura.getTrazo().setGrosor(this.trazo.getGrosor());
            //Traoz
            figura.setTrazo(this.trazo);
            this.repaint();
          }
          
      }
      
    /**
     * Gestion del evento presionar ratón.
     * Es la función que se encarga de crear las figuras cuando se dibuja en el lienzo y de realizar los ajustes
     * necesarios para que su modificación pueda realizarse. Además cuando se encuentra e modo edición permite ofrece
     * una interfaz sencilla para conocer si una figura de las ya dibujadas ha sido seleccionada comparandola con un 
     * punto pasado.
     * @param evt Evento en gestión.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
    
        
        //Bloqueamos el uso de esta función sólo para cuando se hace click con el botón izquierdo.
        if(SwingUtilities.isLeftMouseButton(evt)){
        
        
        //Obtenemos el primer punto necesario al presionar (sin soltar) el ratón en cualquier parte del frame.        
        pA=evt.getPoint();
        
        
        //Si se encuentra seleccionado el modo "selección" porque se quiere editar alguna figura:
        if(modoSeleccion==true){
            
            //Con el punto obtenido buscamos en el vector de figuras amacenadas aquella que hayamos podido seleccionar.
            figura = getFiguraSeleccionada(pA);
            
            Texto texto = getTextoSeleccionado(pA);
                        
                    //Si ha ocurrido una selección de una figura                  
                    if(figura!=null){                

                        //Cambiamos el icono
                        this.setCursor(cursorManoCerrada);
                        
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

                         //Cambiamos el icono
                        this.setCursor(cursorManoCerrada);
                        
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
                ella de forma que cualquier click que podamos hacer con posterioridad añade un punto a esta figura. 
                En el caso de que no queramos seguir dibujando esta figura haremos doble click, el último
                punto que añadamos cerrará la figura y el cerrojo será abierto, pudiendo volver a crear otro objeto de 
                tipo polilinea.
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


                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                //Si ha sido seleccionada la herramienta POLINEA del buttonGroup
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

                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                //Si ha sido seleccionada la herramienta Curva Cúbica del buttonGroup
                if(this.tipoHerramienta==Herramienta.CURVA_CUBICA){
                    //Construimos la figura como una Linea
                    figuraTemporal = new CurvaCubica();

                    figuraTemporal.setTrazo(trazo);

                    vShape.add(figuraTemporal);

                }else 
                //Si ha sido seleccionada la herramienta RECTÁNGULO del buttonGroup
                if(this.tipoHerramienta==Herramienta.RECTANGULO){
                    //Construimos la figura como un rectángulo
                    figuraTemporal = new Rectangulo();
                   
                    //Aplicamos el estilo de trazado.
                    figuraTemporal.setTrazo(trazo);
                    
                    //Si ha espeficado quse quiere que la figu esté rellena se aplica 
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

                    //Esta figura no tiene relleno porque no puede.
                    
                    vShape.add(figuraTemporal);

                } else
                    
                    if(this.tipoHerramienta==Herramienta.TEXTO){
                                      
                    //Se avisa al padre para que abra la herramienta de edición de texto.
                    herramientaTexto hT = new herramientaTexto(this, pA);
                    hT.setVisible(true);
                                                            
                    /*Sólo en este caso repintamos ya, para que la edición del texto por la herramienta se
                    vea mientras se realizan los cambios. */
                    this.repaint();
                }
                
         
        }
         
        }//Fin del bloque de ejecución sólo para el botón izquierdo del ratón.
    }//GEN-LAST:event_formMousePressed

    
    
    /**
     * Gestión del evento arrastrar ratón.
     * @param evt Evento en gestión.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
         /*
        Para ver como quedaría la linea conforme vamos dibujando la repintamos mientras
        arrastramos el ratón para al final dibujarla del todo al levantar el click (released).
        Como en fomrMousedPressed bloqueamos para el uso del botón izquierdo del ratón.
        */        
         if(SwingUtilities.isLeftMouseButton(evt)){
                          
         
        //Capturamos el segundo punto necesario para construir la linea:
        pB=evt.getPoint();
        
        /**
         * Si el modo de selcción está activado se va a editar algo en alguna figura.
         */
         if(modoSeleccion==true){
                                  
             //Si ha seleccionado alguna figura en el pressed tendremos alguna figura que mover
             if(figuraMoviendo!=-1){

                // Imprimir("Moviendo figura: " + vShape.get(figuraMoviendo).getClass().getName());
                 
                 //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("ManoAlzada"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */
                         ((ManoAlzada)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
                 
                 //Si se trata de una Linea:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Linea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         /**
                          * Esta forma de proceder nos dará un problema y es que nos moverá 
                          */
                         ((Linea)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
                
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
                         ((CurvaCuadratica)vShape.get(figuraMoviendo)).cambiarPuntoControl(pA, pB);
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
                         ((CurvaCubica)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
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
                         ((RectanguloRedondeado)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
                 }
                 
                 //Si se trata de una Ellipse:
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Elipse"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Elipse)vShape.get(figuraMoviendo)).cambiarPuntosControl(pA, pB);
                  
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
            
            //Esta función de Rectangle2D permite enviar solo dos puntos y conseguir que independientemente del lugar donde
            //se encuentren se dibuje un rectangulo entre ellos.
            ((RectanguloRedondeado)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);
            
            
        }else if(this.tipoHerramienta==Herramienta.RECTANGULO){
            
            //Esta función de Rectangle2D permite enviar solo dos puntos y conseguir que independientemente del lugar donde
            //se encuentren se dibuje un rectangulo entre ellos.
            ((Rectangulo)vShape.get(vShape.size()-1)).cambiarPosicion(pA, pB);                        
        }        
        else if(this.tipoHerramienta==Herramienta.OVALO){
            ((Elipse)vShape.get(vShape.size()-1)).cambiarPosicion(pA,pB);            
        }
        else if(this.tipoHerramienta==Herramienta.ARCO){
            ((Arco)vShape.get(vShape.size()-1)).cambiarPosicion(pA,pB);            
        } 
        
      }
                
        //Como ya está en el vector llamamos a paint para que vuelva a pintar todos los objetos y este en el estado que está.
        this.repaint();  
    }
    }//GEN-LAST:event_formMouseDragged

    /**
     * Implementa las acciones a realizar al hacer released (levantar click) del ratón.
     * Llama a soltar ratón en todas las figuras.
     * @param evt Evento en gestión.
     */
    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

        /**
         * Sea cual sea la figura llamamos a soltarRaton para que realmente modifique la posición de los
         * datos geométricos grabandolos en la nueva posición ofrecida por al ratón en el dragged donde se ha conseguido
         * el punto pB.
         */
        if(modoSeleccion==true && figuraMoviendo!=-1){        
            
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Polilinea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Polilinea)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Linea"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Linea)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("ManoAlzada"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((ManoAlzada)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                                                   
                 if(vShape.get(figuraMoviendo).getClass().getName().contentEquals("sm.jaf.graficos.Rectangulo"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Rectangulo)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contentEquals("sm.jaf.graficos.RectanguloRedondeado"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((RectanguloRedondeado)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Cuadratica"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((CurvaCuadratica)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Cubica"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((CurvaCubica)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
                 
                 if(vShape.get(figuraMoviendo).getClass().getName().contains("Elipse"))
                     if(vShape.get(figuraMoviendo)!=null)
                         ((Elipse)vShape.get(figuraMoviendo)).soltarRaton(pA,pB);
        }
        //Cuando se realice con todos se podrá realizar un bucle normal.      
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    
    /**
     * Programaicón del doble click de ratón.
     * @param evt Evento en gestión.
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
   
        
        
        Texto texto = new Texto();
        //Detectamos contando el número de click que se trata de doble click.
        if (evt.getClickCount() == 2) {
            
            Imprimir("### Doble click ###");
            
            
            if(modoSeleccion){
                /*Si detectamos el doble click del botón derecho del ratón y está en modo edición lo que se quiere hacer
                es eliminar una figura*/
                if(SwingUtilities.isRightMouseButton(evt)){
                    
                    //Sacamos si existe alguna figura donde hemos pulsado.
                    Figura figura=getFiguraSeleccionada(evt.getPoint());
                    //Eliminamos la figura del vector
                    if(figura!=null){
                        vShape.remove(figura);                   
                    }
                    //Después de eliminar la figura repintamos:
                    this.repaint();
                }
            }
            
            
    
            
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

    /**
     * Implementacion del comportamiento del ratón al moverse por el lienzo.
     * Cambia el icono del mouse de los que se cargaron en el constructor si estándo en modo edición se entra dentro de una figura
     * o se selecciona alguno de sus puntos de control.
     * @param evt Evento en gestión.
     */
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
        if(modoSeleccion){
           // Imprimir("Soy un ratón y me estoy moviendo por el plano");
            //Comprueba si en el punto el que estoy hay una figura
            Figura fig = getFiguraSeleccionada(evt.getPoint());
            Texto texto = this.getTextoSeleccionado(evt.getPoint());
                                    
            //Si estoy encima de una figura cambio el icono
            if(fig!=null || texto!=null)
                this.setCursor(cursorManoAbierta);
            //Si no estoy encima de una figura, dejo el cursor como estaba
            else
                this.setCursor(Cursor.getDefaultCursor());            
        }        
        
    }//GEN-LAST:event_formMouseMoved

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  
}
