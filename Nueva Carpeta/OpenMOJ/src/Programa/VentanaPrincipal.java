package Programa;

import Herramientas.herramientaBrilloContraste;
import Herramientas.herramientaEmborronamiento;
import Herramientas.herramientaEnfoque;
import Herramientas.herramientaEscalar;
import Herramientas.herramientaFronteras;
import Herramientas.herramientaNegativo;
import Herramientas.herramientaOpBinarias;
import Herramientas.herramientaRelieve;
import Herramientas.herramientaRotacion;
import extras.herramientaTexto;
import Herramientas.herramientaUmbralizacion;
import accesorios.Ajustes;
import accesorios.nuevoLienzo;
import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import extras.Herramienta;
import java.awt.BasicStroke;
import java.awt.GraphicsEnvironment;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.jaf.graficos.Linea;
import sm.jaf.graficos.Rectangulo;
import sm.jaf.graficos.Relleno;
import sm.jaf.graficos.Trazo;
import sm.jaf.iu.Lienzo2D;

public class VentanaPrincipal extends JFrame {

    
    private String []fuentesSistema;
    
    
    BufferedImage imagenTemporalParaOperaciones;
    
    private boolean guardar=false;
    private int dimensionMatriz;
    
    public boolean rellenoActivo;
    
    private herramientaEnfoque ventanaHerramientaEnfoque;
    private herramientaRelieve ventanaHerramientaRelieve;
    private herramientaFronteras ventanaHerramientaFronteras;
    private herramientaRotacion ventanaHerramientaRotar;
    private herramientaNegativo ventanaHerramientaNegativo;
    public herramientaBrilloContraste ventanaHerramientaBrilloContraste;
    private herramientaSeno ventanaHerramientaSeno;
    private herramientaUmbralizacion ventanaHerramientaUmbral;
    private herramientaTrazado ventanaHerramientaTrazado;
    private herramientaRelleno ventanaHerramientaRelleno;
    
    
    private VentanaInternaAudioReproductor ventanaInternaAudioReproductor;
    private VentanaInternaAudioGrabador ventanaInternaAudioGrabador;
    
    private VentanaInternaJMFPlayer ventanaInternaJMFPlayer;
    private VentanaInternaCamara ventanaInternaCamara;
    
    private nuevoLienzo ventanaNuevoLienzo;
    
    private Ajustes ventanaAjustes;
    
    private Color colorLienzoDefecto;
    
    private Trazo trazoDefecto;
    private Relleno rellenoDefecto;

    public Herramienta herramienta = Herramienta.PUNTO;
    

    
    public VentanaPrincipal() {
        
        initComponents();
        
        

        
        colorLienzoDefecto = Color.WHITE;
        
        rellenoActivo=false;
        
        /** Ajuste del trazo por defecto. */
        
            trazoDefecto= new Trazo();
            trazoDefecto.setGrosor(1);
            trazoDefecto.setColor(Color.BLACK);
            trazoDefecto.setDecoracionFinalLinea(BasicStroke.CAP_BUTT);
            trazoDefecto.setDecoracionUnionLineas(BasicStroke.JOIN_BEVEL);

            float [] patronDiscontinuidad = new float[8];
            patronDiscontinuidad[0]=10f;        
            for(int i=1; i<8; i++)            
                patronDiscontinuidad[i]=0f;
            trazoDefecto.setPatronDiscontinuidad(patronDiscontinuidad);
        
            
            
        /** Ajuste del relleno por defecto. */    
            
        //Ajustes de la figura del miniLienzoMuestra:
            Point2D a = new Point2D.Double(10,5);
            Point2D b = new Point2D.Double(100,5);

            Linea lineaMuestra = new Linea(a,b);
            lineaMuestra.setTrazo(trazoDefecto);

            this.miniLienzoMuestra.addFigure(lineaMuestra);
            this.miniLienzoMuestra.repaint();
        

        //Ajustes iniciales de miniLienzoRelleno (para que no se vea nada)
            Color fondo;            
            fondo = new Color(214,217,223);
            this.miniLienzoRelleno.setBackground(fondo);
           Point2D puntoA = new Point2D.Double(0,0);
            Point2D puntoB = new Point2D.Double(0,0);
            
            Rectangulo rectangulo= new Rectangulo(puntoA, puntoB);

            rectangulo.setRelleno(false);
            this.miniLienzoRelleno.addFigure(rectangulo);
            this.miniLienzoRelleno.repaint();
        
            //Sólo es un relleno por defecto para la primera vez.
            rellenoDefecto  = new Relleno(Color.CYAN, Color.BLACK, Relleno.Horientacion.HORIZONTAL);
            
        
        /*Colocamos el spinner de grosor al mismo valor con el que se empieza a dibujar en Lienzo2D dentro
        de VentanaInterna */        
        this.spinnerGrosor.setValue(1);
        
        //Iniciamos el Lienzo con la herramienta punto seleccionada.
//        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.LINEA);
        //Para que el botón de punto aparezca seleccionado.
        //this.BotonLapiz.doClick();
//        this.BotonLinea.doClick();
        this.dialogoAbout.setSize(600, 200);
        this.dialogoAbout.setLocationRelativeTo(null);
        
        //botonRojo.setSelected(true);
        //botonRojo.setSelected(rootPaneCheckingEnabled);
        
        //botonRojo.doClick();
        //botonRojo.setSelected(true);
        
        
//        this.spinnerGrosor.setValue(1);
//        this.lienzo1.setGrosorLinea(10);
        
        //this.BotonHerramientas.doClick();
        //this.panelHerramientas.setVisible(false);
        
       
      
        //Para que el JFrame se vea a pantalla completa:
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        
      //  this.panelHerramientasInferior.setPreferredSize(new java.awt.Dimension(615, 140));
        
        
        //this.panelEscritorio.setBackground(Color.red);
        
       
     
        
        
        //Abrimos una ventana al iniciar el programa:
        VentanaInterna ventanaInterna = new VentanaInterna(this);
        //Establecemos la herramienta por defecto.
        ventanaInterna.getLienzo().setTipoHerramienta(herramienta);
        
        //Establecemos un estilo de trazo por defecto al lienzo para que cree las figuras nuevas con esos parámetros:
        ventanaInterna.getLienzo().setTrazo(trazoDefecto);
        ventanaInterna.getLienzo().setRelleno(rellenoDefecto);
        ventanaInterna.getLienzo().setRelleno(rellenoActivo);
        
        
        
        
        
        //Activamos la mejora de alisamiento de dibujo
        ventanaInterna.getLienzo().setMejoraRenderizacion(true);
        this.panelEscritorio.add(ventanaInterna);
        System.out.println("Creando ventana interna incial.");
        ventanaInterna.setVisible(true);
        
        this.botonAlisar.setSelected(true);
        
        
        

        dimensionMatriz=0;
        
        
        
        
        
        
        
        
    }
    
    public void desactivaRelleno(){
        Imprimir("Desactiva Relleno");
        this.miniLienzoRelleno.delFigura(0);
         Point2D puntoA = new Point2D.Double(0,0);
            Point2D puntoB = new Point2D.Double(0,0);
            
            Rectangulo rectangulo= new Rectangulo(puntoA, puntoB);

            rectangulo.setRelleno(false);
            this.miniLienzoRelleno.addFigure(rectangulo);
            this.miniLienzoRelleno.repaint();
        
            //Quitamos el checkbox
            this.botonRelleno.setSelected(false);
            
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        GrupoBotonesDibujo = new javax.swing.ButtonGroup();
        GrupoBotonesColores = new javax.swing.ButtonGroup();
        popUpAjustes = new javax.swing.JPopupMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        dialogoAbout = new javax.swing.JDialog();
        labelCC = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        PanelNorte = new javax.swing.JPanel();
        panelComplementario = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        botonDirectoNuevo = new javax.swing.JButton();
        botonDirectoAbrir = new javax.swing.JButton();
        botonDirectoGuardar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        buttonLapiz = new javax.swing.JToggleButton();
        buttonLinea = new javax.swing.JToggleButton();
        buttonQuadCurve = new javax.swing.JToggleButton();
        buttonCubicCurve = new javax.swing.JToggleButton();
        buttonRectangulo = new javax.swing.JToggleButton();
        buttonElipse = new javax.swing.JToggleButton();
        buttonRoundRectangulo = new javax.swing.JToggleButton();
        buttonTexto = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        panelTrazoColoresHerramientas = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        botonRelleno = new javax.swing.JCheckBox();
        botonAlisar = new javax.swing.JCheckBox();
        botonTransparencia = new javax.swing.JCheckBox();
        botonEditar = new javax.swing.JCheckBox();
        botonRELLENO = new javax.swing.JButton();
        miniLienzoRelleno = new sm.jaf.iu.Lienzo2D();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        miniLienzoMuestra = new sm.jaf.iu.Lienzo2D();
        spinnerGrosor = new javax.swing.JSpinner();
        botonEditarNombre = new javax.swing.JButton();
        botonNegro = new javax.swing.JToggleButton();
        botonRojo = new javax.swing.JToggleButton();
        botonAzul = new javax.swing.JToggleButton();
        botonBlanco = new javax.swing.JToggleButton();
        botonAmarillo = new javax.swing.JToggleButton();
        botonVerde = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        PanelSur = new javax.swing.JPanel();
        jPanelInfo = new javax.swing.JPanel();
        nfoHerramienta = new javax.swing.JLabel();
        coordenadas = new javax.swing.JLabel();
        separadorBarraInfo = new javax.swing.JSeparator();
        panelEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        botonNuevoMenuArchivo = new javax.swing.JMenuItem();
        botonAbrirMenuArchivo = new javax.swing.JMenuItem();
        botonGuardarMenuArchivo = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        botonAbrirAudio = new javax.swing.JMenuItem();
        botonGrabarAudio = new javax.swing.JMenuItem();
        botonAbrirWebCam = new javax.swing.JMenuItem();
        botonDeshacer = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        botonRehacer = new javax.swing.JMenuItem();
        menuEdicion = new javax.swing.JMenu();
        botonBarraEstado = new javax.swing.JCheckBoxMenuItem();
        botonHerramientasDibujo = new javax.swing.JCheckBoxMenuItem();
        botonHistograma = new javax.swing.JCheckBoxMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        botonMenuEdicionBrillo = new javax.swing.JMenuItem();
        botonNegativo = new javax.swing.JMenuItem();
        botonMenuHerramientasEmborronar = new javax.swing.JMenuItem();
        botonFronteras = new javax.swing.JMenuItem();
        botonMenuRelieve = new javax.swing.JMenuItem();
        botonRotar = new javax.swing.JMenuItem();
        botonMenuherramientaEnfoque = new javax.swing.JMenuItem();
        botonEscalar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        botonOperacionBinarias = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        botonMenuAbout = new javax.swing.JMenu();
        botonAboutInfo = new javax.swing.JMenuItem();
        botonAjustes = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        jMenu5.setText("jMenu5");

        jMenuItem3.setText("jMenuItem3");
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jMenu5.add(jMenuItem4);

        popUpAjustes.add(jMenu5);

        dialogoAbout.setTitle("About OpenMOJ");

        labelCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cc.png"))); // NOI18N
        dialogoAbout.getContentPane().add(labelCC, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("OpenMOJ");
        jPanel1.add(jLabel2, java.awt.BorderLayout.CENTER);

        dialogoAbout.getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open MOJ (Media Over Java)");

        PanelNorte.setLayout(new java.awt.BorderLayout());

        panelComplementario.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        botonDirectoNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconNew.png"))); // NOI18N
        botonDirectoNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDirectoNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(botonDirectoNuevo);

        botonDirectoAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconFolder.png"))); // NOI18N
        botonDirectoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDirectoAbrirActionPerformed(evt);
            }
        });
        jPanel4.add(botonDirectoAbrir);

        botonDirectoGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconSave.png"))); // NOI18N
        botonDirectoGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDirectoGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(botonDirectoGuardar);

        panelComplementario.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setMaximumSize(new java.awt.Dimension(10, 32767));
        jPanel5.add(jSeparator5);

        GrupoBotonesDibujo.add(buttonLapiz);
        buttonLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lapiz.gif"))); // NOI18N
        buttonLapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLapizActionPerformed(evt);
            }
        });
        jPanel5.add(buttonLapiz);

        GrupoBotonesDibujo.add(buttonLinea);
        buttonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Linea.gif"))); // NOI18N
        buttonLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLineaActionPerformed(evt);
            }
        });
        jPanel5.add(buttonLinea);

        GrupoBotonesDibujo.add(buttonQuadCurve);
        buttonQuadCurve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/quadcurve.gif"))); // NOI18N
        buttonQuadCurve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonQuadCurveActionPerformed(evt);
            }
        });
        jPanel5.add(buttonQuadCurve);

        GrupoBotonesDibujo.add(buttonCubicCurve);
        buttonCubicCurve.setText("CC");
        buttonCubicCurve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCubicCurveActionPerformed(evt);
            }
        });
        jPanel5.add(buttonCubicCurve);

        GrupoBotonesDibujo.add(buttonRectangulo);
        buttonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Rectangulo.gif"))); // NOI18N
        buttonRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRectanguloActionPerformed(evt);
            }
        });
        jPanel5.add(buttonRectangulo);

        GrupoBotonesDibujo.add(buttonElipse);
        buttonElipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ovalo.gif"))); // NOI18N
        buttonElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonElipseActionPerformed(evt);
            }
        });
        jPanel5.add(buttonElipse);

        GrupoBotonesDibujo.add(buttonRoundRectangulo);
        buttonRoundRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/RoundRectangulo.gif"))); // NOI18N
        buttonRoundRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRoundRectanguloActionPerformed(evt);
            }
        });
        jPanel5.add(buttonRoundRectangulo);

        GrupoBotonesDibujo.add(buttonTexto);
        buttonTexto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Texto.gif"))); // NOI18N
        buttonTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTextoActionPerformed(evt);
            }
        });
        jPanel5.add(buttonTexto);

        panelComplementario.add(jPanel5, java.awt.BorderLayout.CENTER);

        PanelNorte.add(panelComplementario, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel6.add(jSeparator4, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        panelTrazoColoresHerramientas.setLayout(new java.awt.BorderLayout());

        botonRelleno.setText("Relleno");
        botonRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRellenoActionPerformed(evt);
            }
        });

        botonAlisar.setText("Alisar");
        botonAlisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlisarActionPerformed(evt);
            }
        });

        botonTransparencia.setText("Transparencia");
        botonTransparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransparenciaActionPerformed(evt);
            }
        });

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonRELLENO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/settings.png"))); // NOI18N
        botonRELLENO.setContentAreaFilled(false);
        botonRELLENO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRELLENOActionPerformed(evt);
            }
        });

        miniLienzoRelleno.setPreferredSize(new java.awt.Dimension(70, 70));

        javax.swing.GroupLayout miniLienzoRellenoLayout = new javax.swing.GroupLayout(miniLienzoRelleno);
        miniLienzoRelleno.setLayout(miniLienzoRellenoLayout);
        miniLienzoRellenoLayout.setHorizontalGroup(
            miniLienzoRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        miniLienzoRellenoLayout.setVerticalGroup(
            miniLienzoRellenoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jLabel4.setText("Trazo:");

        miniLienzoMuestra.setBackground(javax.swing.UIManager.getDefaults().getColor("ArrowButton.background"));

        javax.swing.GroupLayout miniLienzoMuestraLayout = new javax.swing.GroupLayout(miniLienzoMuestra);
        miniLienzoMuestra.setLayout(miniLienzoMuestraLayout);
        miniLienzoMuestraLayout.setHorizontalGroup(
            miniLienzoMuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        miniLienzoMuestraLayout.setVerticalGroup(
            miniLienzoMuestraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        spinnerGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerGrosorStateChanged(evt);
            }
        });

        botonEditarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/settings.png"))); // NOI18N
        botonEditarNombre.setContentAreaFilled(false);
        botonEditarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarNombreActionPerformed(evt);
            }
        });

        botonNegro.setBackground(new java.awt.Color(1, 1, 1));
        botonNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNegroActionPerformed(evt);
            }
        });

        botonRojo.setBackground(new java.awt.Color(255, 0, 0));
        botonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRojoActionPerformed(evt);
            }
        });

        botonAzul.setBackground(new java.awt.Color(0, 0, 255));
        botonAzul.setPreferredSize(new java.awt.Dimension(15, 15));
        botonAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAzulActionPerformed(evt);
            }
        });

        botonBlanco.setBackground(new java.awt.Color(255, 255, 255));
        botonBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBlancoActionPerformed(evt);
            }
        });

        botonAmarillo.setBackground(new java.awt.Color(255, 255, 51));
        botonAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAmarilloActionPerformed(evt);
            }
        });

        botonVerde.setBackground(new java.awt.Color(0, 204, 0));
        botonVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerdeActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonEditarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(miniLienzoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEditarNombre)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(miniLienzoMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jSeparator3)
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(botonRELLENO, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addComponent(botonRelleno)
                        .addGap(18, 18, 18)))
                .addComponent(miniLienzoRelleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEditar)
                    .addComponent(botonTransparencia)
                    .addComponent(botonAlisar))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(botonAlisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonTransparencia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditar))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addComponent(botonRELLENO)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botonRelleno))
                        .addComponent(miniLienzoRelleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelTrazoColoresHerramientas.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel3.add(panelTrazoColoresHerramientas, java.awt.BorderLayout.CENTER);

        PanelNorte.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelNorte, java.awt.BorderLayout.NORTH);

        PanelSur.setLayout(new java.awt.BorderLayout());

        jPanelInfo.setLayout(new java.awt.BorderLayout());

        nfoHerramienta.setText("Punto");
        jPanelInfo.add(nfoHerramienta, java.awt.BorderLayout.LINE_START);

        coordenadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coordenadas.setText("Coordenadas");
        jPanelInfo.add(coordenadas, java.awt.BorderLayout.LINE_END);
        jPanelInfo.add(separadorBarraInfo, java.awt.BorderLayout.PAGE_START);

        PanelSur.add(jPanelInfo, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        getContentPane().add(panelEscritorio, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        botonNuevoMenuArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        botonNuevoMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconNew.png"))); // NOI18N
        botonNuevoMenuArchivo.setText("Nuevo");
        botonNuevoMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonNuevoMenuArchivo);

        botonAbrirMenuArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        botonAbrirMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconFolder.png"))); // NOI18N
        botonAbrirMenuArchivo.setText("Abrir");
        botonAbrirMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirMenuArchivo);

        botonGuardarMenuArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        botonGuardarMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconSave.png"))); // NOI18N
        botonGuardarMenuArchivo.setText("Guardar");
        botonGuardarMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonGuardarMenuArchivo);
        menuArchivo.add(jSeparator1);

        botonAbrirAudio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        botonAbrirAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/openAudio24x24.png"))); // NOI18N
        botonAbrirAudio.setText("AbrirAudio");
        botonAbrirAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirAudioActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirAudio);

        botonGrabarAudio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        botonGrabarAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/record24x24.png"))); // NOI18N
        botonGrabarAudio.setText("GrabarAudio");
        botonGrabarAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGrabarAudioActionPerformed(evt);
            }
        });
        menuArchivo.add(botonGrabarAudio);

        botonAbrirWebCam.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        botonAbrirWebCam.setText("Abrir WebCam");
        botonAbrirWebCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirWebCamActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirWebCam);

        jMenuBar1.add(menuArchivo);

        botonDeshacer.setText("Editar");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/back.png"))); // NOI18N
        jMenuItem7.setText("Deshacer");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        botonDeshacer.add(jMenuItem7);

        botonRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/return.png"))); // NOI18N
        botonRehacer.setText("Rehacer");
        botonRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRehacerActionPerformed(evt);
            }
        });
        botonDeshacer.add(botonRehacer);

        jMenuBar1.add(botonDeshacer);

        menuEdicion.setText("Ver");

        botonBarraEstado.setSelected(true);
        botonBarraEstado.setText("Barra de estado");
        botonBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBarraEstadoActionPerformed(evt);
            }
        });
        menuEdicion.add(botonBarraEstado);

        botonHerramientasDibujo.setSelected(true);
        botonHerramientasDibujo.setText("Herramientas de dibujo");
        botonHerramientasDibujo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHerramientasDibujoActionPerformed(evt);
            }
        });
        menuEdicion.add(botonHerramientasDibujo);

        botonHistograma.setSelected(true);
        botonHistograma.setText("Histogramas");
        botonHistograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonHistogramaActionPerformed(evt);
            }
        });
        menuEdicion.add(botonHistograma);

        jMenuBar1.add(menuEdicion);

        menuHerramientas.setText("Herramientas");

        botonMenuEdicionBrillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloContrasteMini.png"))); // NOI18N
        botonMenuEdicionBrillo.setText(" Brillo y Contraste");
        botonMenuEdicionBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuEdicionBrilloActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonMenuEdicionBrillo);

        botonNegativo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/negative.png"))); // NOI18N
        botonNegativo.setText("Negativo");
        botonNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNegativoActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonNegativo);

        botonMenuHerramientasEmborronar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/emborronamiento.png"))); // NOI18N
        botonMenuHerramientasEmborronar.setText("Emborranamiento");
        botonMenuHerramientasEmborronar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuHerramientasEmborronarActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonMenuHerramientasEmborronar);

        botonFronteras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/deteccionBordes.png"))); // NOI18N
        botonFronteras.setText("Detección fronteras");
        botonFronteras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFronterasActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonFronteras);

        botonMenuRelieve.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/relieve.png"))); // NOI18N
        botonMenuRelieve.setText("Relieve");
        botonMenuRelieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuRelieveActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonMenuRelieve);

        botonRotar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/rotate.png"))); // NOI18N
        botonRotar.setText("Rotar");
        botonRotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRotarActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonRotar);

        botonMenuherramientaEnfoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/enfoque.png"))); // NOI18N
        botonMenuherramientaEnfoque.setText("Enfoque");
        botonMenuherramientaEnfoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuherramientaEnfoqueActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonMenuherramientaEnfoque);

        botonEscalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/scale.png"))); // NOI18N
        botonEscalar.setText("Escalar");
        botonEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEscalarActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonEscalar);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/umbralizacion.png"))); // NOI18N
        jMenuItem2.setText("Umbralizacion");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuHerramientas.add(jMenuItem2);

        botonOperacionBinarias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/plus_subtraction.png"))); // NOI18N
        botonOperacionBinarias.setText("Op. Binarias");
        botonOperacionBinarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOperacionBinariasActionPerformed(evt);
            }
        });
        menuHerramientas.add(botonOperacionBinarias);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/seno.png"))); // NOI18N
        jMenuItem1.setText("FuncionSeno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuHerramientas.add(jMenuItem1);

        jMenuBar1.add(menuHerramientas);

        botonMenuAbout.setText("Ayuda");

        botonAboutInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/info.png"))); // NOI18N
        botonAboutInfo.setText("Sobre MOJ");
        botonAboutInfo.setToolTipText("");
        botonMenuAbout.add(botonAboutInfo);

        botonAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/settings.png"))); // NOI18N
        botonAjustes.setText("Ajustes");
        botonAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAjustesActionPerformed(evt);
            }
        });
        botonMenuAbout.add(botonAjustes);

        jMenuBar1.add(botonMenuAbout);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /*
    public void setStroke(Stroke nuevoStroke){
        strokeIntermedio=nuevoStroke;
    }
    */
    public void setCoordenadas(Point2D puntoRaton){
        this.coordenadas.setText("x "+(int)puntoRaton.getX()+" y "+(int)puntoRaton.getY());
    }
    
    
    public Color getColorLiezoDefecto(){
        return colorLienzoDefecto;
    }
    
 
    
    public void saluda(){
        Imprimir("hola desde ventana principal");
    }
    
    public void setTrazoDefecto(Trazo nuevoTrazo){
        
        Imprimir("Grabando trazo por defecto");
        
        //Cuando hacemos esto deben de reajustarse las herramientas de selección
        this.spinnerGrosor.setValue(nuevoTrazo.getGrosor());
        
        
        trazoDefecto.setCopiaTrazo(nuevoTrazo);
        
        
        this.miniLienzoMuestra.getFigura(0).setTrazo(nuevoTrazo);
       this.miniLienzoMuestra.repaint();
        
    }
    public Trazo getTrazoDefecto(){
        return trazoDefecto;
    }
    public Relleno getRellenoDefecto(){
        return rellenoDefecto;
    }
    public void setRellenoDefecto(Relleno nuevoRelleno){
 
     //   if(this.botonRELLENO.isSelected()){
            
            Imprimir("Ajustando relleno por defecto");
            
            rellenoDefecto = nuevoRelleno;
            this.miniLienzoRelleno.delFigura(0);

                  //Ajustes de la figura del miniLienzoRelleno
                Point2D puntoA = new Point2D.Double(0,0);
                Point2D puntoB = new Point2D.Double(70,70);


                Rectangulo rectangulo = new Rectangulo(puntoA, puntoB);
                //rellenoDefecto  = new Relleno(rellenoDe, Color.BLACK, Relleno.Horientacion.HORIZONTAL);

                rectangulo.setRelleno(rellenoDefecto);
                rectangulo.setRelleno(true);

                this.miniLienzoRelleno.addFigure(rectangulo);
                this.miniLienzoRelleno.repaint();
        
                
         //Como estamos activando el fondo tambien activamos el checkbutton
                this.botonRelleno.setSelected(true);
    }
            
    
    
    /**
     * Para cambiar el grosor en la herramienta de la Ventana Principal.
     * Esta función no cambia el grosor por defecto para nuevas ventanas internas del escritorio ya que esas
     * variables de inicio están definidas en el objeto Lienzo2D que contiene la VentanaInterna.
     * @param grosor Valor del nuevo grosor.
     */
    public void setHerramientaGrosor(int grosor){
        Imprimir("intento de cambio de grosor al padre a "+grosor);
        
       this.spinnerGrosor.setValue(grosor);
       miniLienzoMuestra.getFigura(0).getTrazo().setGrosor((int)spinnerGrosor.getValue());
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
       
    }
    
    public int getHerramientaGrosor(){
        return (int)this.spinnerGrosor.getValue();
    }
    
    public JDesktopPane getPanelEscritorio(){
        return this.panelEscritorio;
    }
    
    
    
    /**
     * Función que implementa las acciones a realizar al pulsar sobre nuevo documento.
     * @param evt Evento que se le pasa al pinchar sobre el botón.
     */
    private void botonNuevoMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoMenuArchivoActionPerformed
       
        /* El encargado de construir el nuevo lienzo sera la ventana nuevoLienzo que podrá a disposición
        del usuario algunas opciones, creará el lienzo y lo añadirá a una nueva ventana dentro del panel 
        de este pardre, por eso se lo pasamos por parámetro.
        Más info en nuevoLienzo.java*/
        
        //Se inicializa el objeto nuevoLienzo 
        ventanaNuevoLienzo=new nuevoLienzo(this);
        
        //Se hace visible
        ventanaNuevoLienzo.setVisible(true);
                
    }//GEN-LAST:event_botonNuevoMenuArchivoActionPerformed

    public JDesktopPane getEscritorio(){
        return this.panelEscritorio;
    }
    
    //Acción sobre el botón abrir:
    private void botonAbrirMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirMenuArchivoActionPerformed
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            try{
                File f = dlg.getSelectedFile();
                Imprimir("Abriendo "+f.getPath());
                
                //Con ImageIO.read realizamos realmente la lectura de la imagen y la cargamos en la variable img
                BufferedImage img = ImageIO.read(f);
                
                
                //Aqui ya tenemos en el objeto img la imagen que hemos cargado desde la ruta que guardada en f.
                
                /* Las operaciones quet endríamos que hacer para ver el procesado de la imagen:
                RescaleOp rop = new RescaleOp(1.0F, 100.0F, null);
                BufferedImage imagenResultado = rop.filter(img, null);
                */
                
                Imprimir("Tam: "+img.getHeight());
                
                Imprimir("open");
                VentanaInterna vi = new VentanaInterna(this);
                
                vi.getLienzo().setImage(img);
                
                //Lo que mandaríamos para ver el ejemplo de procesado.
                //vi.getLienzo().setImage(imagenResultado);
                
                
                this.panelEscritorio.add(vi);
                vi.setTitle(f.getName());
                vi.setVisible(true);
                
                Imprimir("fin");
            }catch(Exception ex){
                //Si ocurre algun error al cargar la imagen mostramos una ventana de aviso.
               // JOptionPane.showMessageDialog(this,"Error al leer la imagen", "Error", JOptionPane.WARNING_MESSAGE);
                
             //   System.err.println("Error al leer la imagen: "+ex);
            }
        }
    }//GEN-LAST:event_botonAbrirMenuArchivoActionPerformed

    
    //Acción sobre el botón guardar:
    private void botonGuardarMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarMenuArchivoActionPerformed
        
        Imprimir("Intentado guardar imagen");
        
        //Seleccionamos la ventana seleccionada:
        VentanaInterna ventanaInternaSeleccionada = (VentanaInterna)panelEscritorio.getSelectedFrame();
        if(ventanaInternaSeleccionada!=null){
            JFileChooser dlg = new JFileChooser();
            dlg.setSelectedFile(new File( ((VentanaInterna)panelEscritorio.getSelectedFrame()).getNombreVentana()  ));
            int resp = dlg.showSaveDialog(this);
            if(resp==JFileChooser.APPROVE_OPTION){
                
                try{
                    BufferedImage img =ventanaInternaSeleccionada.getLienzo().getImage();
                    
                    if(img!=null){
                        File f = dlg.getSelectedFile();
                        ImageIO.write(img, "jpg",f);
                        ventanaInternaSeleccionada.setTitle(f.getName());
                    }else{
                        JOptionPane.showMessageDialog(this, "No hay imagen que guardar");
                    }
                }catch(Exception ex){
                    System.err.println("Error al guardar la imagen"+ex);
                }
              
            }
        }else{
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una ventana.");
        }
        
        
        
       
    }//GEN-LAST:event_botonGuardarMenuArchivoActionPerformed

    
    private void botonMenuEdicionBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuEdicionBrilloActionPerformed
        ventanaHerramientaBrilloContraste = new herramientaBrilloContraste(this);
        ventanaHerramientaBrilloContraste.setVisible(true);        
        
        
        //ventanaHerramientaBrillo.setVisible(true);
        //Imprimir("Pulsando boton abrir ventana");
        
        
    }//GEN-LAST:event_botonMenuEdicionBrilloActionPerformed

    public Lienzo2D getMiniLienzo(){
        return this.miniLienzoMuestra;
    }
    
    private void botonMenuHerramientasEmborronarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuHerramientasEmborronarActionPerformed
        

        //ventanaHerramientaEmborronamiento.setVisible(true);
        
        Imprimir("Pulsando boton abrir ventana herramienta emborronamiento");
        
        herramientaEmborronamiento ventana = new herramientaEmborronamiento(this);
        //ventana.setPadre((VentanaPrincipal)this);
        
        ventana.setVisible(true);
        
    }//GEN-LAST:event_botonMenuHerramientasEmborronarActionPerformed

    private void botonMenuherramientaEnfoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuherramientaEnfoqueActionPerformed
       
        //Creamos el objeto de este tipo
        ventanaHerramientaEnfoque= new herramientaEnfoque(this);
        //Lanzamos la ventana
        ventanaHerramientaEnfoque.setVisible(true);
        
    }//GEN-LAST:event_botonMenuherramientaEnfoqueActionPerformed

    private void botonMenuRelieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuRelieveActionPerformed
        ventanaHerramientaRelieve = new herramientaRelieve(this);
        
        ventanaHerramientaRelieve.setVisible(true);
    }//GEN-LAST:event_botonMenuRelieveActionPerformed

    private void botonFronterasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFronterasActionPerformed
        ventanaHerramientaFronteras = new herramientaFronteras(this);
        ventanaHerramientaFronteras.setVisible(true);
    }//GEN-LAST:event_botonFronterasActionPerformed

    private void botonRotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRotarActionPerformed
        ventanaHerramientaRotar = new herramientaRotacion(this);
        ventanaHerramientaRotar.setVisible(true);
    }//GEN-LAST:event_botonRotarActionPerformed

    private void botonNegativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegativoActionPerformed
        ventanaHerramientaNegativo = new herramientaNegativo(this);
        ventanaHerramientaNegativo.setVisible(true);
    }//GEN-LAST:event_botonNegativoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ventanaHerramientaSeno = new herramientaSeno(this);
        ventanaHerramientaSeno.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ventanaHerramientaUmbral = new herramientaUmbralizacion(this);
        ventanaHerramientaUmbral.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void botonAbrirAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirAudioActionPerformed

        
        
        //Primero tiene que abrir un fichero          
        //Creamos el explorador de ficheros
        JFileChooser dlg = new JFileChooser();
        //Personalizamos el nombre de la ventana
        dlg.setDialogTitle("Abrir fichero de audio");
        FileFilter filter;        
        dlg.setFileFilter(null);          
        int resp = dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            try{
                 File f = dlg.getSelectedFile();
                Imprimir("Abriendo "+f.getPath());
                System.out.println(this.ventanaInternaJMFPlayer = VentanaInternaJMFPlayer.getInstance(f));
                this.panelEscritorio.add(ventanaInternaJMFPlayer);
                this.ventanaInternaJMFPlayer.setVisible(true);
            }catch(Exception ex){              
                System.err.println("Error al leer fichero: "+ex);
            }
        } 
        
        /*
        //Primero tiene que abrir un fichero          
        //Creamos el explorador de ficheros
        JFileChooser dlg = new JFileChooser();
        //Personalizamos el nombre de la ventana
        dlg.setDialogTitle("Abrir fichero de audio");
        FileFilter filter;        
        dlg.setFileFilter(null);          
        int resp = dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            try{
                 File f = dlg.getSelectedFile();
                Imprimir("Abriendo "+f.getPath());
                ventanaInternaAudioReproductor = new VentanaInternaAudioReproductor(f);
        ventanaInternaAudioReproductor.setVisible(true);
            }catch(Exception ex){              
                System.err.println("Error al leer fichero: "+ex);
            }
        }      
        */
        
        
        
    }//GEN-LAST:event_botonAbrirAudioActionPerformed

    private void botonGrabarAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGrabarAudioActionPerformed
          //Primero tiene que abrir un fichero
          JFileChooser dlg = new JFileChooser();
          
        int resp = dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            try{
                 File f = dlg.getSelectedFile();
                Imprimir("Abriendo "+f.getPath());
                ventanaInternaAudioGrabador = new VentanaInternaAudioGrabador(f);
                ventanaInternaAudioGrabador.setVisible(true);

            }catch(Exception ex){
              
                System.err.println("Error al leer fichero: "+ex);
            }
        }
        
    }//GEN-LAST:event_botonGrabarAudioActionPerformed

    private void botonAbrirWebCamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirWebCamActionPerformed
                        
        ventanaInternaCamara = VentanaInternaCamara.getInstance();
        this.panelEscritorio.add(ventanaInternaCamara);
        ventanaInternaCamara.setVisible(true);
        
    }//GEN-LAST:event_botonAbrirWebCamActionPerformed

    private void botonAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAjustesActionPerformed
        
        ventanaAjustes = new Ajustes(this);
        ventanaAjustes.setVisible(true);
        
    }//GEN-LAST:event_botonAjustesActionPerformed

    private void botonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegroActionPerformed
        System.out.println("Pulsado boton NEGRO en ventana principal");
        if(panelEscritorio.getSelectedFrame()!=null){
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.BLACK);
            miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.BLACK);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonNegroActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        System.out.println("Pulsado boton VERDE en ventana principal");
        if(panelEscritorio.getSelectedFrame()!=null){
        ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.GREEN);
            miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.GREEN);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonVerdeActionPerformed

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null){
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.RED);
            
            miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.RED);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonRojoActionPerformed

    private void botonBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBlancoActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null){
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.WHITE);
            miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.WHITE);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonBlancoActionPerformed

    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null){
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.BLUE);
            miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.BLUE);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonAzulActionPerformed

    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null){
        ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setColor(Color.YELLOW);
        miniLienzoMuestra.getFigura(0).getTrazo().setColor(Color.YELLOW);
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_botonAmarilloActionPerformed

    private void botonRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRellenoActionPerformed
        if(botonRelleno.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setRelleno(true);
            
            
            rellenoActivo=true;
            
            this.miniLienzoRelleno.delFigura(0);
            
              //Ajustes de la figura del miniLienzoRelleno
            Point2D puntoA = new Point2D.Double(0,0);
            Point2D puntoB = new Point2D.Double(70,70);
            
       
            Rectangulo rectangulo = new Rectangulo(puntoA, puntoB);
         
            
            rectangulo.setRelleno(rellenoDefecto);
            rectangulo.setRelleno(true);
            
            this.miniLienzoRelleno.addFigure(rectangulo);
            this.miniLienzoRelleno.repaint();

            
        }
        if(!botonRelleno.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setRelleno(false);
            
            rellenoActivo=false;
                      
            Color fondo;            
            fondo = new Color(214,217,223);
            this.miniLienzoRelleno.setBackground(fondo);
            Point2D rellenoA = new Point2D.Double(0,0);
            Point2D rellenoB = new Point2D.Double(0,0);
                        
         //   rectanguloRelleno.setRelleno(true);
            this.miniLienzoRelleno.getFigura(0).cambiarPosicion(rellenoA, rellenoB);
            this.miniLienzoRelleno.repaint();
           // this.miniLienzoRelleno.getFigura(0).cambiarPosicion(null, null);
            
        }
    }//GEN-LAST:event_botonRellenoActionPerformed

    private void botonTransparenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTransparenciaActionPerformed
        if(botonTransparencia.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTransparencia(true);
        }
        if(!botonTransparencia.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTransparencia(false);
        }
    }//GEN-LAST:event_botonTransparenciaActionPerformed

    private void botonAlisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlisarActionPerformed
        if(botonAlisar.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setMejoraRenderizacion(true);
        }
        if(!botonAlisar.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setMejoraRenderizacion(false);
        }
    }//GEN-LAST:event_botonAlisarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        if(botonEditar.isSelected())
        if(panelEscritorio.getSelectedFrame()!=null)
        ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setModoSeleccion(true);

        if(!botonEditar.isSelected())
        if(panelEscritorio.getSelectedFrame()!=null)
        ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setModoSeleccion(false);

    }//GEN-LAST:event_botonEditarActionPerformed

    private void spinnerGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerGrosorStateChanged

        if((int)spinnerGrosor.getValue()<=0){
            Imprimir("No se puede usar un numero menor o igual a 0 como grosor del trazado.");
            //Mostramos un mensaje
            JOptionPane.showMessageDialog(this, "¿Estas seguro de querer usar un grosor igual a 0?", "Mala idea", JOptionPane.WARNING_MESSAGE);
            spinnerGrosor.setValue(1);
        }if(panelEscritorio.getSelectedFrame()!=null){
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().getTrazo().setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.getFigura(0).getTrazo().setGrosor((int)spinnerGrosor.getValue());
            //miniLienzoMuestra.setGrosor((int)spinnerGrosor.getValue());
             miniLienzoMuestra.repaint();
        }
    }//GEN-LAST:event_spinnerGrosorStateChanged

    private void botonEditarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarNombreActionPerformed
        
        ventanaHerramientaTrazado = new herramientaTrazado(this);
        ventanaHerramientaTrazado.setVisible(true);             
        
    }//GEN-LAST:event_botonEditarNombreActionPerformed

    private void botonRELLENOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRELLENOActionPerformed
        ventanaHerramientaRelleno = new herramientaRelleno(this);
        ventanaHerramientaRelleno.setVisible(true);             
        
    }//GEN-LAST:event_botonRELLENOActionPerformed

    private void botonEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEscalarActionPerformed
        herramientaEscalar ventanaHerramientaEscalar = new herramientaEscalar(this);
        ventanaHerramientaEscalar.setVisible(true);
    }//GEN-LAST:event_botonEscalarActionPerformed

    private void botonOperacionBinariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOperacionBinariasActionPerformed
        herramientaOpBinarias opbinarias = new herramientaOpBinarias(this);
        opbinarias.setVisible(true);
    }//GEN-LAST:event_botonOperacionBinariasActionPerformed

    private void botonRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRehacerActionPerformed
        JOptionPane.showMessageDialog(this, "Esta funcionalidad aún no se ha implementado.","Oups!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonRehacerActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JOptionPane.showMessageDialog(this, "Esta funcionalidad aún no se ha implementado.","Oups!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void botonHistogramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHistogramaActionPerformed
         JOptionPane.showMessageDialog(this, "Esta funcionalidad aún no se ha implementado.","Oups!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botonHistogramaActionPerformed

    private void botonBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBarraEstadoActionPerformed
        //Si el botón queda seleccionado.
        if(botonBarraEstado.isSelected())
            jPanelInfo.setVisible(true);
        if(!botonBarraEstado.isSelected())
            jPanelInfo.setVisible(false);
            
    }//GEN-LAST:event_botonBarraEstadoActionPerformed

    private void botonHerramientasDibujoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonHerramientasDibujoActionPerformed
        //Si el botón queda seleccionado.
        if(botonHerramientasDibujo.isSelected()){
            panelTrazoColoresHerramientas.setVisible(true);
            panelComplementario.setVisible(true);
        }
        if(!botonHerramientasDibujo.isSelected()){
            panelTrazoColoresHerramientas.setVisible(false);
            panelComplementario.setVisible(false);
        }
    }//GEN-LAST:event_botonHerramientasDibujoActionPerformed

    private void botonDirectoNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDirectoNuevoActionPerformed
       ventanaNuevoLienzo=new nuevoLienzo(this);        
        //Se hace visible
        ventanaNuevoLienzo.setVisible(true);
    }//GEN-LAST:event_botonDirectoNuevoActionPerformed

    private void botonDirectoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDirectoAbrirActionPerformed
         JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            try{
                File f = dlg.getSelectedFile();
                Imprimir("Abriendo "+f.getPath());
                
                //Con ImageIO.read realizamos realmente la lectura de la imagen y la cargamos en la variable img
                BufferedImage img = ImageIO.read(f);
                
                
                //Aqui ya tenemos en el objeto img la imagen que hemos cargado desde la ruta que guardada en f.
                
                /* Las operaciones quet endríamos que hacer para ver el procesado de la imagen:
                RescaleOp rop = new RescaleOp(1.0F, 100.0F, null);
                BufferedImage imagenResultado = rop.filter(img, null);
                */
                
                Imprimir("Tam: "+img.getHeight());
                
                Imprimir("open");
                VentanaInterna vi = new VentanaInterna(this);
                
                vi.getLienzo().setImage(img);
                
                //Lo que mandaríamos para ver el ejemplo de procesado.
                //vi.getLienzo().setImage(imagenResultado);
                
                
                this.panelEscritorio.add(vi);
                vi.setTitle(f.getName());
                vi.setVisible(true);
                
                Imprimir("fin");
            }catch(Exception ex){
                //Si ocurre algun error al cargar la imagen mostramos una ventana de aviso.
               // JOptionPane.showMessageDialog(this,"Error al leer la imagen", "Error", JOptionPane.WARNING_MESSAGE);
                
             //   System.err.println("Error al leer la imagen: "+ex);
            }
        }
    }//GEN-LAST:event_botonDirectoAbrirActionPerformed

    private void botonDirectoGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDirectoGuardarActionPerformed
         
        Imprimir("Intentado guardar imagen");
        
        //Seleccionamos la ventana seleccionada:
        VentanaInterna ventanaInternaSeleccionada = (VentanaInterna)panelEscritorio.getSelectedFrame();
        if(ventanaInternaSeleccionada!=null){
            JFileChooser dlg = new JFileChooser();
            dlg.setSelectedFile(new File( ((VentanaInterna)panelEscritorio.getSelectedFrame()).getNombreVentana()  ));
            int resp = dlg.showSaveDialog(this);
            if(resp==JFileChooser.APPROVE_OPTION){
                
                try{
                    BufferedImage img =ventanaInternaSeleccionada.getLienzo().getImage();
                    
                    if(img!=null){
                        File f = dlg.getSelectedFile();
                        ImageIO.write(img, "jpg",f);
                        ventanaInternaSeleccionada.setTitle(f.getName());
                    }else{
                        JOptionPane.showMessageDialog(this, "No hay imagen que guardar");
                    }
                }catch(Exception ex){
                    System.err.println("Error al guardar la imagen"+ex);
                }
              
            }
        }else{
            JOptionPane.showMessageDialog(this, "Tienes que seleccionar una ventana.");
        }
    }//GEN-LAST:event_botonDirectoGuardarActionPerformed

    private void buttonLapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLapizActionPerformed
            
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Lápiz");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.PUNTO); 
        
    }//GEN-LAST:event_buttonLapizActionPerformed

    private void buttonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLineaActionPerformed
                
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Línea");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.LINEA); 
        
    }//GEN-LAST:event_buttonLineaActionPerformed

    private void buttonQuadCurveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonQuadCurveActionPerformed
             //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Curva cuadrática");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.CURVA_CUADRATICA); 
    }//GEN-LAST:event_buttonQuadCurveActionPerformed

    private void buttonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRectanguloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Rectángulo");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.RECTANGULO); 

        
    }//GEN-LAST:event_buttonRectanguloActionPerformed

    private void buttonRoundRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRoundRectanguloActionPerformed
       //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Rectángulo redondeado");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.RECTANGULO_REDONDEADO); 
    }//GEN-LAST:event_buttonRoundRectanguloActionPerformed

    private void buttonElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonElipseActionPerformed
          
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Óvalo");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.OVALO); 
        
        
    }//GEN-LAST:event_buttonElipseActionPerformed

    private void buttonCubicCurveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCubicCurveActionPerformed
              //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Curva cubica");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.CURVA_CUBICA); 
    }//GEN-LAST:event_buttonCubicCurveActionPerformed

    private void buttonTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTextoActionPerformed
        this.nfoHerramienta.setText("Texto");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.TEXTO);    
    }//GEN-LAST:event_buttonTextoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JMenuItem botonAboutInfo;
    private javax.swing.JMenuItem botonAbrirAudio;
    private javax.swing.JMenuItem botonAbrirMenuArchivo;
    private javax.swing.JMenuItem botonAbrirWebCam;
    private javax.swing.JMenuItem botonAjustes;
    private javax.swing.JCheckBox botonAlisar;
    private javax.swing.JToggleButton botonAmarillo;
    private javax.swing.JToggleButton botonAzul;
    private javax.swing.JCheckBoxMenuItem botonBarraEstado;
    private javax.swing.JToggleButton botonBlanco;
    private javax.swing.JMenu botonDeshacer;
    private javax.swing.JButton botonDirectoAbrir;
    private javax.swing.JButton botonDirectoGuardar;
    private javax.swing.JButton botonDirectoNuevo;
    private javax.swing.JCheckBox botonEditar;
    private javax.swing.JButton botonEditarNombre;
    private javax.swing.JMenuItem botonEscalar;
    private javax.swing.JMenuItem botonFronteras;
    private javax.swing.JMenuItem botonGrabarAudio;
    private javax.swing.JMenuItem botonGuardarMenuArchivo;
    private javax.swing.JCheckBoxMenuItem botonHerramientasDibujo;
    private javax.swing.JCheckBoxMenuItem botonHistograma;
    private javax.swing.JMenu botonMenuAbout;
    private javax.swing.JMenuItem botonMenuEdicionBrillo;
    private javax.swing.JMenuItem botonMenuHerramientasEmborronar;
    private javax.swing.JMenuItem botonMenuRelieve;
    private javax.swing.JMenuItem botonMenuherramientaEnfoque;
    private javax.swing.JMenuItem botonNegativo;
    private javax.swing.JToggleButton botonNegro;
    private javax.swing.JMenuItem botonNuevoMenuArchivo;
    private javax.swing.JMenuItem botonOperacionBinarias;
    private javax.swing.JButton botonRELLENO;
    private javax.swing.JMenuItem botonRehacer;
    private javax.swing.JCheckBox botonRelleno;
    private javax.swing.JToggleButton botonRojo;
    private javax.swing.JMenuItem botonRotar;
    private javax.swing.JCheckBox botonTransparencia;
    private javax.swing.JToggleButton botonVerde;
    private javax.swing.JToggleButton buttonCubicCurve;
    private javax.swing.JToggleButton buttonElipse;
    private javax.swing.JToggleButton buttonLapiz;
    private javax.swing.JToggleButton buttonLinea;
    private javax.swing.JToggleButton buttonQuadCurve;
    private javax.swing.JToggleButton buttonRectangulo;
    private javax.swing.JToggleButton buttonRoundRectangulo;
    private javax.swing.JToggleButton buttonTexto;
    private javax.swing.JLabel coordenadas;
    private javax.swing.JDialog dialogoAbout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelCC;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JMenu menuHerramientas;
    private sm.jaf.iu.Lienzo2D miniLienzoMuestra;
    private sm.jaf.iu.Lienzo2D miniLienzoRelleno;
    private javax.swing.JLabel nfoHerramienta;
    private javax.swing.JPanel panelComplementario;
    private javax.swing.JDesktopPane panelEscritorio;
    private javax.swing.JPanel panelTrazoColoresHerramientas;
    private javax.swing.JPopupMenu popUpAjustes;
    private javax.swing.JSeparator separadorBarraInfo;
    private javax.swing.JSpinner spinnerGrosor;
    // End of variables declaration//GEN-END:variables

    
}
