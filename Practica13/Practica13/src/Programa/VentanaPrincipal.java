package Programa;

import static extras.Imprimir.Imprimir;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import extras.Herramienta;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;

public class VentanaPrincipal extends JFrame {

    private String []fuentesSistema;
    BufferedImage imagenTemporalParaOperaciones;
    
    private boolean guardar=false;
    private int dimensionMatriz;
    
    private herramientaEnfoque ventanaHerramientaEnfoque;
    private herramientaRelieve ventanaHerramientaRelieve;
    private herramientaFronteras ventanaHerramientaFronteras;
    private herramientaRotar ventanaHerramientaRotar;
    private herramientaNegativo ventanaHerramientaNegativo;
    private herramientaBrilloContraste ventanaHerramientaBrilloContraste;
    private herramientaSeno ventanaHerramientaSeno;
    private herramientaUmbral ventanaHerramientaUmbral;
    
    private VentanaInternaAudioReproductor ventanaInternaAudioReproductor;
    private VentanaInternaAudioGrabador ventanaInternaAudioGrabador;
    
    private VentanaInternaJMFPlayer ventanaInternaJMFPlayer;
    private VentanaInternaCamara ventanaInternaCamara;
    
    
    public VentanaPrincipal() {
        
        initComponents();
        //Iniciamos el Lienzo con la herramienta punto seleccionada.
//        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.LINEA);
        //Para que el botón de punto aparezca seleccionado.
        //this.BotonLapiz.doClick();
        this.BotonLinea.doClick();
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
        ventanaInterna.getLienzo().setTipoHerramienta(Herramienta.LINEA);
        ventanaInterna.getLienzo().setColor(Color.BLACK);
        this.panelEscritorio.add(ventanaInterna);
        System.out.println("Creando ventana interna incial.");
        ventanaInterna.setVisible(true);
        
        //Ajustes particulares:
        
        // ##Ventana de herramienta BRILLO ##//
        nivelBrillo.setText("0");
        
        // ##Ventana de herramientas EMBORRONAMIENTO ##//
        this.jPanel14.setBorder(BorderFactory.createTitledBorder("Tipo"));
        this.jPanel15.setBorder(BorderFactory.createTitledBorder("Matriz"));
        this.jPanel13.setBorder(BorderFactory.createTitledBorder("Pasadas"));
        
        dimensionMatriz=0;
        
        
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
        ventanaHerramientaBrillo = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        botonGuardarBrillo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        sliderBrillo2 = new javax.swing.JSlider();
        jPanel6 = new javax.swing.JPanel();
        nivelBrillo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ventanaHerramientaEmborronamiento = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        botonReiniciarEmborronamiento = new javax.swing.JButton();
        botonCancelarEmborronamiento = new javax.swing.JButton();
        botonAceptarEmborronamiento = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        textoEmborronamiento = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        botonTipoBinomial = new javax.swing.JRadioButton();
        botonTipoMedio = new javax.swing.JRadioButton();
        jPanel15 = new javax.swing.JPanel();
        textoMatrizEmborronamiento = new javax.swing.JLabel();
        botonMas = new javax.swing.JButton();
        botonMenos = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        grupoBotonesTipoEmborronamiento = new javax.swing.ButtonGroup();
        PanelNorte = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        BotonLapiz = new javax.swing.JToggleButton();
        BotonLinea = new javax.swing.JToggleButton();
        BotonRectangulo = new javax.swing.JToggleButton();
        BotonOvalo = new javax.swing.JToggleButton();
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
        menuEdicion = new javax.swing.JMenu();
        botonMenuEdicionBarraEstado = new javax.swing.JMenuItem();
        botonMenuHerramientasEmborronar = new javax.swing.JMenuItem();
        botonMenuherramientaEnfoque = new javax.swing.JMenuItem();
        botonMenuRelieve = new javax.swing.JMenuItem();
        botonFronteras = new javax.swing.JMenuItem();
        botonRotar = new javax.swing.JMenuItem();
        botonNegativo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        botonMenuEdicionBrillo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        botonMenuAbout = new javax.swing.JMenu();

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

        ventanaHerramientaBrillo.setTitle("Brillo");
        ventanaHerramientaBrillo.setAlwaysOnTop(true);
        ventanaHerramientaBrillo.setBackground(java.awt.Color.lightGray);
        ventanaHerramientaBrillo.setBounds(new java.awt.Rectangle(0, 0, 400, 200));
        ventanaHerramientaBrillo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ventanaHerramientaBrilloComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                ventanaHerramientaBrilloComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        ventanaHerramientaBrillo.getContentPane().add(jPanel8, java.awt.BorderLayout.PAGE_END);

        jButton6.setText("jButton6");
        ventanaHerramientaBrillo.getContentPane().add(jButton6, java.awt.BorderLayout.PAGE_START);

        botonGuardarBrillo.setText("jButton7");
        botonGuardarBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarBrilloActionPerformed(evt);
            }
        });
        ventanaHerramientaBrillo.getContentPane().add(botonGuardarBrillo, java.awt.BorderLayout.PAGE_END);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 130));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(400, 65));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout());

        sliderBrillo2.setMaximum(255);
        sliderBrillo2.setMinimum(-255);
        sliderBrillo2.setValue(0);
        sliderBrillo2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderBrillo2StateChanged(evt);
            }
        });
        jPanel5.add(sliderBrillo2, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        nivelBrillo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        nivelBrillo.setText("nivel");
        jPanel6.add(nivelBrillo);

        jPanel5.add(jPanel6, java.awt.BorderLayout.LINE_END);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel4.setText("Brillo:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brillo.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.add(jPanel7, java.awt.BorderLayout.LINE_START);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        ventanaHerramientaBrillo.getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        ventanaHerramientaEmborronamiento.setTitle("Emborronamiento");
        ventanaHerramientaEmborronamiento.setAlwaysOnTop(true);
        ventanaHerramientaEmborronamiento.setBackground(java.awt.Color.lightGray);
        ventanaHerramientaEmborronamiento.setBounds(new java.awt.Rectangle(0, 0, 400, 300));
        ventanaHerramientaEmborronamiento.setMinimumSize(new java.awt.Dimension(500, 237));
        ventanaHerramientaEmborronamiento.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ventanaHerramientaEmborronamientoComponentShown(evt);
            }
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                ventanaHerramientaEmborronamientoComponentHidden(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        botonReiniciarEmborronamiento.setText("Reiniciar");
        jPanel9.add(botonReiniciarEmborronamiento);

        botonCancelarEmborronamiento.setText("Cancelar");
        jPanel9.add(botonCancelarEmborronamiento);

        botonAceptarEmborronamiento.setText("Aceptar");
        jPanel9.add(botonAceptarEmborronamiento);

        ventanaHerramientaEmborronamiento.getContentPane().add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        textoEmborronamiento.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        textoEmborronamiento.setForeground(new java.awt.Color(204, 204, 204));
        textoEmborronamiento.setText("Emborronamiento");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(textoEmborronamiento)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(textoEmborronamiento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ventanaHerramientaEmborronamiento.getContentPane().add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));

        grupoBotonesTipoEmborronamiento.add(botonTipoBinomial);
        botonTipoBinomial.setText("Binomial");

        grupoBotonesTipoEmborronamiento.add(botonTipoMedio);
        botonTipoMedio.setText("Medio");
        botonTipoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTipoMedioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(botonTipoMedio)
                .addGap(27, 27, 27)
                .addComponent(botonTipoBinomial)
                .addGap(49, 49, 49))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonTipoMedio)
                    .addComponent(botonTipoBinomial))
                .addGap(27, 27, 27))
        );

        jPanel12.add(jPanel14);

        jPanel15.setBackground(new java.awt.Color(204, 204, 204));

        textoMatrizEmborronamiento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        textoMatrizEmborronamiento.setText("3 x 3");

        botonMas.setText("+");
        botonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMasActionPerformed(evt);
            }
        });

        botonMenos.setText("-");
        botonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(botonMenos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoMatrizEmborronamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonMas)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoMatrizEmborronamiento)
                    .addComponent(botonMas)
                    .addComponent(botonMenos))
                .addGap(12, 12, 12))
        );

        jPanel12.add(jPanel15);

        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel6.setText("0");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("15");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jPanel11.add(jPanel13, java.awt.BorderLayout.CENTER);

        ventanaHerramientaEmborronamiento.getContentPane().add(jPanel11, java.awt.BorderLayout.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open MOJ (Media Over Java) P10");

        jToolBar1.setRollover(true);

        BotonLapiz.setBackground(new java.awt.Color(10, 0, 255));
        GrupoBotonesDibujo.add(BotonLapiz);
        BotonLapiz.setForeground(new java.awt.Color(253, 2, 2));
        BotonLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Lapiz.gif"))); // NOI18N
        BotonLapiz.setFocusable(false);
        BotonLapiz.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLapiz.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonLapiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLapizActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonLapiz);

        GrupoBotonesDibujo.add(BotonLinea);
        BotonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Linea.gif"))); // NOI18N
        BotonLinea.setFocusable(false);
        BotonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLineaActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonLinea);

        GrupoBotonesDibujo.add(BotonRectangulo);
        BotonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Rectangulo.gif"))); // NOI18N
        BotonRectangulo.setFocusable(false);
        BotonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRectanguloActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonRectangulo);

        GrupoBotonesDibujo.add(BotonOvalo);
        BotonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ovalo.gif"))); // NOI18N
        BotonOvalo.setFocusable(false);
        BotonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonOvalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOvaloActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonOvalo);

        javax.swing.GroupLayout PanelNorteLayout = new javax.swing.GroupLayout(PanelNorte);
        PanelNorte.setLayout(PanelNorteLayout);
        PanelNorteLayout.setHorizontalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        PanelNorteLayout.setVerticalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorteLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
            .addGap(0, 621, Short.MAX_VALUE)
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
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

        botonAbrirWebCam.setText("Abrir WebCam");
        botonAbrirWebCam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirWebCamActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirWebCam);

        jMenuBar1.add(menuArchivo);

        menuEdicion.setText("Edición");

        botonMenuEdicionBarraEstado.setText("Ver barra de estado");
        menuEdicion.add(botonMenuEdicionBarraEstado);

        botonMenuHerramientasEmborronar.setText("Emborranamiento");
        botonMenuHerramientasEmborronar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuHerramientasEmborronarActionPerformed(evt);
            }
        });
        menuEdicion.add(botonMenuHerramientasEmborronar);

        botonMenuherramientaEnfoque.setText("Enfoque");
        botonMenuherramientaEnfoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuherramientaEnfoqueActionPerformed(evt);
            }
        });
        menuEdicion.add(botonMenuherramientaEnfoque);

        botonMenuRelieve.setText("Relieve");
        botonMenuRelieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuRelieveActionPerformed(evt);
            }
        });
        menuEdicion.add(botonMenuRelieve);

        botonFronteras.setText("Detección fronteras");
        botonFronteras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFronterasActionPerformed(evt);
            }
        });
        menuEdicion.add(botonFronteras);

        botonRotar.setText("Rotar");
        botonRotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRotarActionPerformed(evt);
            }
        });
        menuEdicion.add(botonRotar);

        botonNegativo.setText("Negativo");
        botonNegativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNegativoActionPerformed(evt);
            }
        });
        menuEdicion.add(botonNegativo);

        jMenuItem2.setText("Umbralizacion");
        jMenuItem2.setToolTipText("");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuEdicion.add(jMenuItem2);

        jMenuBar1.add(menuEdicion);

        jMenu1.setText("Herramientas");

        botonMenuEdicionBrillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/brilloContrasteMini.png"))); // NOI18N
        botonMenuEdicionBrillo.setText(" Brillo y Contraste");
        botonMenuEdicionBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMenuEdicionBrilloActionPerformed(evt);
            }
        });
        jMenu1.add(botonMenuEdicionBrillo);

        jMenuItem1.setText("FuncionSeno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        botonMenuAbout.setText("About");
        jMenuBar1.add(botonMenuAbout);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void setCoordenadas(Point2D puntoRaton){
        this.coordenadas.setText("x "+(int)puntoRaton.getX()+" y "+(int)puntoRaton.getY());
    }
    
    public void saluda(){
        Imprimir("hola desde ventana principal");
    }
    
    public void setColor(Color color){        
        
       Imprimir("Cambiando herramienta de color a "+color.toString()); 
       
       if(color==Color.BLACK){
           Imprimir("cambiando a negro");
           this.GrupoBotonesColores.clearSelection();
        //   this.GrupoBotonesColores.setSelected(botonNegro.getModel(), true);
       }
       if(color==Color.RED){
           Imprimir("cambiando a rojo");
           this.GrupoBotonesColores.clearSelection();
         //  this.GrupoBotonesColores.setSelected(botonNegro.getModel(), true);
       }
    }
    
    public void setGrosor(int grosor){
       // this.spinnerGrosor.setValue(grosor);
    }
    
    
    public JDesktopPane getPanelEscritorio(){
        return this.panelEscritorio;
    }
    
    
    
    /*
    Hay que usar el action porque lo que estamos haciendo es ejecutar acciones sobre el botón
    */
    private void BotonLapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLapizActionPerformed
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Punto");        
        //Tenemos que enviar un mensaje a la ventana seleccionada:
        if(panelEscritorio.getSelectedFrame()!=null)
            //((VentanaInterna)panelEscritorio.getSelectedFrame()).setHerramienta(Herramienta.PUNTO);
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.PUNTO);
        
        
        this.GrupoBotonesColores.clearSelection();
//        this.GrupoBotonesColores.setSelected(botonRojo.getModel(), true);
        //botonRojo.setOpaque(true);
     //   botonRojo.setFocusPainted(true);
      //  botonRojo.setBorderPainted(true);
     //   botonRojo.setContentAreaFilled(true);
       
        /*
        ¿Cómo hacer que se marque el borde como se encuentra al principio?
        */
        
        
    }//GEN-LAST:event_BotonLapizActionPerformed

    private void BotonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLineaActionPerformed
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Línea");                
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.LINEA);               
    }//GEN-LAST:event_BotonLineaActionPerformed

    private void BotonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRectanguloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Rectángulo");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.RECTANGULO);  
    }//GEN-LAST:event_BotonRectanguloActionPerformed

    private void BotonOvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOvaloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.nfoHerramienta.setText("Óvalo");
        //Tenemos que enviar un mensaje a la ventana seleccionada:       
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setTipoHerramienta(Herramienta.OVALO); 
    }//GEN-LAST:event_BotonOvaloActionPerformed

    private void botonNuevoMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoMenuArchivoActionPerformed
        //Declaramos un nuevo objeto de tipo VentanaInterna
        VentanaInterna ventanaInterna = new VentanaInterna(this);
        //Hacemos algunos ajustes de ese objeto como establecer herramienta por defecto y color por defecto
        ventanaInterna.getLienzo().setTipoHerramienta(Herramienta.LINEA);
        ventanaInterna.getLienzo().setColor(Color.BLACK);
        //Añadimos la ventana interna al objeto de tipo JDesktopPane
        this.panelEscritorio.add(ventanaInterna);
        System.out.println("Pulsado Archivo->Nuevo. Añadido objeto VentanaInterna a panelEscritorio");
        //La hacemos visible:
        ventanaInterna.setVisible(true);
        
        
        BufferedImage img;
        img=new BufferedImage(300,300,BufferedImage.TYPE_INT_RGB);
        ventanaInterna.getLienzo().setImage(img);
        
        
    }//GEN-LAST:event_botonNuevoMenuArchivoActionPerformed

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
                    }
                }catch(Exception ex){
                    System.err.println("Error al guardar la imagen");
                }
              
            }
        }
        
        
        
       
    }//GEN-LAST:event_botonGuardarMenuArchivoActionPerformed

    
    private void botonMenuEdicionBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuEdicionBrilloActionPerformed
        ventanaHerramientaBrilloContraste = new herramientaBrilloContraste(this);
        ventanaHerramientaBrilloContraste.setVisible(true);        
        
        
        //ventanaHerramientaBrillo.setVisible(true);
        //Imprimir("Pulsando boton abrir ventana");
        
        
    }//GEN-LAST:event_botonMenuEdicionBrilloActionPerformed

    private void sliderBrillo2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderBrillo2StateChanged
        Imprimir("Cambio de estdo del slider");
        this.nivelBrillo.setText(Integer.toString(sliderBrillo2.getValue()));
        
         RescaleOp rop = new RescaleOp(1.0F, (float)this.sliderBrillo2.getValue(), null);
        
        VentanaInterna ventanaInternaSeleccionada = (VentanaInterna) (this.panelEscritorio.getSelectedFrame());
        //ventanaInternaSeleccionada.getLienzo().setImage(imagenTemporalParaOperaciones);
        
        //Aplicamos la operación a la copia de la imagen
        if(this.imagenTemporalParaOperaciones!=null){
            //Aplicamos la operación sobre la imagen temporal
            //a: origen b: destino
            //this.imagenTemporalParaOperaciones = rop.filter(imagenTemporalParaOperaciones, imagenTemporalParaOperaciones);
            
            /*Lo que hacemos será aplicar la operación sobre la imagen temporal y su resultado lo llevamos a la imagen del 
            lienzo así siempre tendremos una referencia del original.
                    
            */
            ventanaInternaSeleccionada.getLienzo().setImage(rop.filter(imagenTemporalParaOperaciones, null));
            
            
            
            //Hacemos que se repinte para ver el resultado mientras movemos el slider
            ventanaInternaSeleccionada.getLienzo().repaint();
        }
        
        
    }//GEN-LAST:event_sliderBrillo2StateChanged

    private void ventanaHerramientaBrilloComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ventanaHerramientaBrilloComponentHidden
       Imprimir("Cerrando ventana herramienta BRILLO");
       
       //Si cerramos los cambios de la herramienta no se guardan y la imagen vuelve a su estado original
       VentanaInterna ventanaInternaSeleccionada = (VentanaInterna) (this.panelEscritorio.getSelectedFrame());
       if(!guardar)
        //SI no queremos que se guarden los cambios dejamos la imagen en su estado original, pasandole la guardada (cp de la orig)
        if(ventanaInternaSeleccionada!=null)   
            ventanaInternaSeleccionada.getLienzo().setImage(imagenTemporalParaOperaciones);
       guardar=false;
       if(ventanaInternaSeleccionada!=null)
        ventanaInternaSeleccionada.repaint();
    }//GEN-LAST:event_ventanaHerramientaBrilloComponentHidden

    private void ventanaHerramientaBrilloComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ventanaHerramientaBrilloComponentShown
        Imprimir("Abriendo ventana herramienta BRILLO");
        
        //Dejamos a 0 el slider:
        this.sliderBrillo2.setValue(0);
        
        
        VentanaInterna ventanaInternaSeleccionada = (VentanaInterna) (this.panelEscritorio.getSelectedFrame());
        if(ventanaInternaSeleccionada != null){ //Nos aseguramos de haber seleccionado alguno.
            //Cargamos en nuestra variable privada la imagen que ese lienzo tiene.
            this.imagenTemporalParaOperaciones=ventanaInternaSeleccionada.getLienzo().getImage();
            Imprimir("Imagen desde la ventana seleccionada");
        }
    }//GEN-LAST:event_ventanaHerramientaBrilloComponentShown

    private void botonGuardarBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarBrilloActionPerformed
        /*
        Cuando pulsamos la acción de guardar primero se realiza el cambio definitivo
        en la imagen del lienzo y después se cierra la ventana de la herramienta.
        */
        
        //Cerrar la ventana de la herramienta, equivalente a presionar el boton X.
        guardar=true;
        this.ventanaHerramientaBrillo.setVisible(false);
    }//GEN-LAST:event_botonGuardarBrilloActionPerformed

    private void ventanaHerramientaEmborronamientoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ventanaHerramientaEmborronamientoComponentShown
        
        Imprimir("Entrando en la sección de emborronamiento con parámetros por defecto.");
        
        //Creamos el nucleo de tipo medio (uno de los dos tipos disponibles).
        Kernel k = KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
        
        //Kernel k = KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
        
        //Obtenemos el operador pasándole el kernel
        ConvolveOp cop = new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        //ConvolveOp cop = new ConvolveOp(k,ConvolveOp.EDGE_NO_OP,null);
        
        //Sacamos la imagen
        VentanaInterna ventanaInternaSeleccionada = (VentanaInterna) (this.panelEscritorio.getSelectedFrame());
        if(ventanaInternaSeleccionada != null){ //Nos aseguramos de haber seleccionado alguno.
            //Cargamos en nuestra variable privada la imagen que ese lienzo tiene.
            this.imagenTemporalParaOperaciones=ventanaInternaSeleccionada.getLienzo().getImage();
            Imprimir("Imagen desde la ventana seleccionada");
            
             //Aplicamos el filtro a través de la convolución (operador creado):
        ventanaInternaSeleccionada.getLienzo().setImage(cop.filter(imagenTemporalParaOperaciones, null));
        ventanaInternaSeleccionada.repaint();
        }
        
       
        
    }//GEN-LAST:event_ventanaHerramientaEmborronamientoComponentShown

    private void ventanaHerramientaEmborronamientoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ventanaHerramientaEmborronamientoComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_ventanaHerramientaEmborronamientoComponentHidden

    private void botonMenuHerramientasEmborronarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenuHerramientasEmborronarActionPerformed
        

        //ventanaHerramientaEmborronamiento.setVisible(true);
        
        Imprimir("Pulsando boton abrir ventana herramienta emborronamiento");
        
        herramientaEmborronamiento ventana = new herramientaEmborronamiento(this);
        //ventana.setPadre((VentanaPrincipal)this);
        
        ventana.setVisible(true);
        
    }//GEN-LAST:event_botonMenuHerramientasEmborronarActionPerformed

    private void botonTipoMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTipoMedioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonTipoMedioActionPerformed

    private void botonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMasActionPerformed
        Imprimir("Cambiado de estado spiner de emborronamiento");
        dimensionMatriz++;
        String valor=Integer.toString(dimensionMatriz);
        this.textoMatrizEmborronamiento.setText(valor+" x "+valor);
    }//GEN-LAST:event_botonMasActionPerformed

    private void botonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMenosActionPerformed
        Imprimir("Cambiado de estado spiner de emborronamiento");
        dimensionMatriz--;
        String valor=Integer.toString(dimensionMatriz);
        this.textoMatrizEmborronamiento.setText(valor+" x "+valor);
    }//GEN-LAST:event_botonMenosActionPerformed

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
        ventanaHerramientaRotar = new herramientaRotar(this);
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
        ventanaHerramientaUmbral = new herramientaUmbral(this);
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonLapiz;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JToggleButton BotonOvalo;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JMenuItem botonAbrirAudio;
    private javax.swing.JMenuItem botonAbrirMenuArchivo;
    private javax.swing.JMenuItem botonAbrirWebCam;
    private javax.swing.JButton botonAceptarEmborronamiento;
    private javax.swing.JButton botonCancelarEmborronamiento;
    private javax.swing.JMenuItem botonFronteras;
    private javax.swing.JMenuItem botonGrabarAudio;
    private javax.swing.JButton botonGuardarBrillo;
    private javax.swing.JMenuItem botonGuardarMenuArchivo;
    private javax.swing.JButton botonMas;
    private javax.swing.JButton botonMenos;
    private javax.swing.JMenu botonMenuAbout;
    private javax.swing.JMenuItem botonMenuEdicionBarraEstado;
    private javax.swing.JMenuItem botonMenuEdicionBrillo;
    private javax.swing.JMenuItem botonMenuHerramientasEmborronar;
    private javax.swing.JMenuItem botonMenuRelieve;
    private javax.swing.JMenuItem botonMenuherramientaEnfoque;
    private javax.swing.JMenuItem botonNegativo;
    private javax.swing.JMenuItem botonNuevoMenuArchivo;
    private javax.swing.JButton botonReiniciarEmborronamiento;
    private javax.swing.JMenuItem botonRotar;
    private javax.swing.JRadioButton botonTipoBinomial;
    private javax.swing.JRadioButton botonTipoMedio;
    private javax.swing.JLabel coordenadas;
    private javax.swing.JDialog dialogoAbout;
    private javax.swing.ButtonGroup grupoBotonesTipoEmborronamiento;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelCC;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JLabel nfoHerramienta;
    private javax.swing.JLabel nivelBrillo;
    private javax.swing.JDesktopPane panelEscritorio;
    private javax.swing.JPopupMenu popUpAjustes;
    private javax.swing.JSeparator separadorBarraInfo;
    private javax.swing.JSlider sliderBrillo2;
    private javax.swing.JLabel textoEmborronamiento;
    private javax.swing.JLabel textoMatrizEmborronamiento;
    private javax.swing.JFrame ventanaHerramientaBrillo;
    private javax.swing.JFrame ventanaHerramientaEmborronamiento;
    // End of variables declaration//GEN-END:variables

    
}
