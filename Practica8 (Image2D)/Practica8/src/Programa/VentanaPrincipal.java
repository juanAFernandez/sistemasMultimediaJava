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
import javax.imageio.ImageIO;

public class VentanaPrincipal extends JFrame {

    private String []fuentesSistema;
    
    
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
        
        
        this.spinnerGrosor.setValue(1);
//        this.lienzo1.setGrosorLinea(10);
        
        //this.BotonHerramientas.doClick();
        //this.panelHerramientas.setVisible(false);
        
       
        //Añadimos los bordes a las cajas de herramientas de la sección inferior:
        this.panelColores.setBorder(BorderFactory.createTitledBorder("Color"));
        this.panelGrosor.setBorder(BorderFactory.createTitledBorder("Grosor"));
        this.panelPropiedades.setBorder(BorderFactory.createTitledBorder(""));
        
        //Para que el JFrame se vea a pantalla completa:
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(500, 500);
        
        this.panelHerramientasInferior.setPreferredSize(new java.awt.Dimension(615, 140));
        
        
        //this.panelEscritorio.setBackground(Color.red);
        
        
        //Abrimos una ventana al iniciar el programa:
        VentanaInterna ventanaInterna = new VentanaInterna(this);
        ventanaInterna.getLienzo().setTipoHerramienta(Herramienta.LINEA);
        ventanaInterna.getLienzo().setColor(Color.BLACK);
        this.panelEscritorio.add(ventanaInterna);
        System.out.println("Creando ventana interna incial.");
        ventanaInterna.setVisible(true);
        
        
        
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
        PanelNorte = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        BotonLapiz = new javax.swing.JToggleButton();
        BotonLinea = new javax.swing.JToggleButton();
        BotonRectangulo = new javax.swing.JToggleButton();
        BotonOvalo = new javax.swing.JToggleButton();
        PanelSur = new javax.swing.JPanel();
        panelHerramientasInferior = new javax.swing.JPanel();
        panelColores = new javax.swing.JPanel();
        botonNegro = new javax.swing.JToggleButton();
        botonVerde = new javax.swing.JToggleButton();
        botonRojo = new javax.swing.JToggleButton();
        botonBlanco = new javax.swing.JToggleButton();
        botonAzul = new javax.swing.JToggleButton();
        botonAmarillo = new javax.swing.JToggleButton();
        panelPropiedades = new javax.swing.JPanel();
        botonRelleno = new javax.swing.JCheckBox();
        botonTransparencia = new javax.swing.JCheckBox();
        botonAlisar = new javax.swing.JCheckBox();
        botonEditar = new javax.swing.JCheckBox();
        panelGrosor = new javax.swing.JPanel();
        spinnerGrosor = new javax.swing.JSpinner();
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
        menuEdicion = new javax.swing.JMenu();
        botonMenuEdicionBarraEstado = new javax.swing.JMenuItem();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Open MOJ (Media Over Java) P8");

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

        panelHerramientasInferior.setPreferredSize(new java.awt.Dimension(615, 120));
        panelHerramientasInferior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonNegro.setBackground(new java.awt.Color(1, 1, 1));
        GrupoBotonesColores.add(botonNegro);
        botonNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNegroActionPerformed(evt);
            }
        });

        botonVerde.setBackground(new java.awt.Color(0, 204, 0));
        GrupoBotonesColores.add(botonVerde);
        botonVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerdeActionPerformed(evt);
            }
        });

        botonRojo.setBackground(new java.awt.Color(255, 0, 0));
        GrupoBotonesColores.add(botonRojo);
        botonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRojoActionPerformed(evt);
            }
        });

        botonBlanco.setBackground(new java.awt.Color(255, 255, 255));
        GrupoBotonesColores.add(botonBlanco);
        botonBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBlancoActionPerformed(evt);
            }
        });

        botonAzul.setBackground(new java.awt.Color(0, 0, 255));
        GrupoBotonesColores.add(botonAzul);
        botonAzul.setPreferredSize(new java.awt.Dimension(15, 15));
        botonAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAzulActionPerformed(evt);
            }
        });

        botonAmarillo.setBackground(new java.awt.Color(255, 255, 51));
        GrupoBotonesColores.add(botonAmarillo);
        botonAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAmarilloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelColoresLayout = new javax.swing.GroupLayout(panelColores);
        panelColores.setLayout(panelColoresLayout);
        panelColoresLayout.setHorizontalGroup(
            panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColoresLayout.createSequentialGroup()
                .addGroup(panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelColoresLayout.createSequentialGroup()
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelColoresLayout.createSequentialGroup()
                        .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelColoresLayout.setVerticalGroup(
            panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelColoresLayout.createSequentialGroup()
                .addGroup(panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAzul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelColoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelHerramientasInferior.add(panelColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 110));

        botonRelleno.setText("Relleno");
        botonRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRellenoActionPerformed(evt);
            }
        });

        botonTransparencia.setText("Transparencia");
        botonTransparencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTransparenciaActionPerformed(evt);
            }
        });

        botonAlisar.setText("Alisar");
        botonAlisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlisarActionPerformed(evt);
            }
        });

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPropiedadesLayout = new javax.swing.GroupLayout(panelPropiedades);
        panelPropiedades.setLayout(panelPropiedadesLayout);
        panelPropiedadesLayout.setHorizontalGroup(
            panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPropiedadesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRelleno)
                    .addComponent(botonAlisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonTransparencia)
                    .addComponent(botonEditar))
                .addGap(24, 24, 24))
        );
        panelPropiedadesLayout.setVerticalGroup(
            panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPropiedadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRelleno)
                    .addComponent(botonTransparencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAlisar)
                    .addComponent(botonEditar))
                .addContainerGap())
        );

        panelHerramientasInferior.add(panelPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 240, 70));

        panelGrosor.setLayout(new java.awt.BorderLayout());

        spinnerGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerGrosorStateChanged(evt);
            }
        });
        panelGrosor.add(spinnerGrosor, java.awt.BorderLayout.CENTER);

        panelHerramientasInferior.add(panelGrosor, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 80, 70));

        PanelSur.add(panelHerramientasInferior, java.awt.BorderLayout.PAGE_START);

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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(panelEscritorio, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        botonNuevoMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconNew.png"))); // NOI18N
        botonNuevoMenuArchivo.setText("Nuevo");
        botonNuevoMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonNuevoMenuArchivo);

        botonAbrirMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconFolder.png"))); // NOI18N
        botonAbrirMenuArchivo.setText("Abrir");
        botonAbrirMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirMenuArchivo);

        botonGuardarMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/iconSave.png"))); // NOI18N
        botonGuardarMenuArchivo.setText("Guardar");
        botonGuardarMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonGuardarMenuArchivo);

        jMenuBar1.add(menuArchivo);

        menuEdicion.setText("Edición");

        botonMenuEdicionBarraEstado.setText("Ver barra de estado");
        menuEdicion.add(botonMenuEdicionBarraEstado);

        jMenuBar1.add(menuEdicion);

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
           this.GrupoBotonesColores.setSelected(botonNegro.getModel(), true);
       }
       if(color==Color.RED){
           Imprimir("cambiando a rojo");
           this.GrupoBotonesColores.clearSelection();
           this.GrupoBotonesColores.setSelected(botonNegro.getModel(), true);
       }
    }
    
    public void setGrosor(int grosor){
        this.spinnerGrosor.setValue(grosor);
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
        this.GrupoBotonesColores.setSelected(botonRojo.getModel(), true);
        //botonRojo.setOpaque(true);
        botonRojo.setFocusPainted(true);
        botonRojo.setBorderPainted(true);
        botonRojo.setContentAreaFilled(true);
       
        /*
        ¿Cómo hacer que se marque el borde como se encuentra al principio?
        */
        
        
    }//GEN-LAST:event_BotonLapizActionPerformed

    private void botonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegroActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.BLACK); 
    }//GEN-LAST:event_botonNegroActionPerformed

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

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.RED);         
    }//GEN-LAST:event_botonRojoActionPerformed

    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.BLUE); 
    }//GEN-LAST:event_botonAzulActionPerformed

    private void botonBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBlancoActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.WHITE); 
    }//GEN-LAST:event_botonBlancoActionPerformed

    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.YELLOW); 
    }//GEN-LAST:event_botonAmarilloActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        if(panelEscritorio.getSelectedFrame()!=null)
            ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setColor(Color.GREEN); 
    }//GEN-LAST:event_botonVerdeActionPerformed

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
                //COn ImageIO.read realizamos realmente la lectura de la imagen y la cargamos en la variable img
                BufferedImage img = ImageIO.read(f);
                VentanaInterna vi = new VentanaInterna(this);
                vi.getLienzo().setImage(img);
                this.panelEscritorio.add(vi);
                vi.setTitle(f.getName());
                vi.setVisible(true);
            }catch(Exception ex){
            System.err.println("Error al leer la imagen");
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
        }if(panelEscritorio.getSelectedFrame()!=null)
           ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setGrosor((int)spinnerGrosor.getValue()); 
    }//GEN-LAST:event_spinnerGrosorStateChanged

    private void botonRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRellenoActionPerformed
        if(botonRelleno.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
           ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setRelleno(true);
        }
        if(!botonRelleno.isSelected()){
            if(panelEscritorio.getSelectedFrame()!=null)
           ((VentanaInterna)panelEscritorio.getSelectedFrame()).getLienzo().setRelleno(false);
        }
    }//GEN-LAST:event_botonRellenoActionPerformed

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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonLapiz;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JToggleButton BotonOvalo;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JMenuItem botonAbrirMenuArchivo;
    private javax.swing.JCheckBox botonAlisar;
    private javax.swing.JToggleButton botonAmarillo;
    private javax.swing.JToggleButton botonAzul;
    private javax.swing.JToggleButton botonBlanco;
    private javax.swing.JCheckBox botonEditar;
    private javax.swing.JMenuItem botonGuardarMenuArchivo;
    private javax.swing.JMenu botonMenuAbout;
    private javax.swing.JMenuItem botonMenuEdicionBarraEstado;
    private javax.swing.JToggleButton botonNegro;
    private javax.swing.JMenuItem botonNuevoMenuArchivo;
    private javax.swing.JCheckBox botonRelleno;
    private javax.swing.JToggleButton botonRojo;
    private javax.swing.JCheckBox botonTransparencia;
    private javax.swing.JToggleButton botonVerde;
    private javax.swing.JLabel coordenadas;
    private javax.swing.JDialog dialogoAbout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelCC;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JLabel nfoHerramienta;
    private javax.swing.JPanel panelColores;
    private javax.swing.JDesktopPane panelEscritorio;
    private javax.swing.JPanel panelGrosor;
    private javax.swing.JPanel panelHerramientasInferior;
    private javax.swing.JPanel panelPropiedades;
    private javax.swing.JPopupMenu popUpAjustes;
    private javax.swing.JSeparator separadorBarraInfo;
    private javax.swing.JSpinner spinnerGrosor;
    // End of variables declaration//GEN-END:variables
}
