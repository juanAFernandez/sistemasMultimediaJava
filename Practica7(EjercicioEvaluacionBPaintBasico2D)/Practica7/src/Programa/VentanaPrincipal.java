package Programa;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Point2D;
import javax.swing.BorderFactory;


public class VentanaPrincipal extends javax.swing.JFrame {

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
        this.spinnerGrosor.setValue(10);
//        this.lienzo1.setGrosorLinea(10);
        
        //this.BotonHerramientas.doClick();
        //this.panelHerramientas.setVisible(false);
        
       
        //Añadimos los bordes a las cajas de herramientas de la sección inferior:
        this.panelColores.setBorder(BorderFactory.createTitledBorder("Color"));
        this.panelGrosor.setBorder(BorderFactory.createTitledBorder("Grosor"));
        this.panelPropiedades.setBorder(BorderFactory.createTitledBorder(""));
        
        
        //this.panelEscritorio.setBackground(Color.red);
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
        barraInfoHerramienta = new javax.swing.JLabel();
        coordenadas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        setTitle("Open MOJ (Media Over Java) P6");

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
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        PanelNorteLayout.setVerticalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorteLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNorte, java.awt.BorderLayout.NORTH);

        PanelSur.setLayout(new java.awt.BorderLayout());

        panelHerramientasInferior.setPreferredSize(new java.awt.Dimension(615, 70));
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

        panelHerramientasInferior.add(panelColores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 74));

        botonRelleno.setText("Relleno");

        botonTransparencia.setText("Transparencia");

        botonAlisar.setText("Alisar");

        botonEditar.setText("Editar");

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
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRelleno)
                    .addComponent(botonTransparencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPropiedadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAlisar)
                    .addComponent(botonEditar))
                .addContainerGap())
        );

        panelHerramientasInferior.add(panelPropiedades, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, -1));

        panelGrosor.setLayout(new java.awt.BorderLayout());
        panelHerramientasInferior.add(panelGrosor, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 0, 80, -1));
        panelHerramientasInferior.add(spinnerGrosor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 50, -1));

        PanelSur.add(panelHerramientasInferior, java.awt.BorderLayout.PAGE_START);

        jPanelInfo.setLayout(new java.awt.BorderLayout());

        barraInfoHerramienta.setText("Punto");
        jPanelInfo.add(barraInfoHerramienta, java.awt.BorderLayout.LINE_START);

        coordenadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coordenadas.setText("Coordenadas");
        jPanelInfo.add(coordenadas, java.awt.BorderLayout.LINE_END);
        jPanelInfo.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        PanelSur.add(jPanelInfo, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout panelEscritorioLayout = new javax.swing.GroupLayout(panelEscritorio);
        panelEscritorio.setLayout(panelEscritorioLayout);
        panelEscritorioLayout.setHorizontalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );
        panelEscritorioLayout.setVerticalGroup(
            panelEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        getContentPane().add(panelEscritorio, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        botonNuevoMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/NuevoBoceto.GIF"))); // NOI18N
        botonNuevoMenuArchivo.setText("Nuevo");
        botonNuevoMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonNuevoMenuArchivo);

        botonAbrirMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/folder265.png"))); // NOI18N
        botonAbrirMenuArchivo.setText("Abrir");
        botonAbrirMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirMenuArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(botonAbrirMenuArchivo);

        botonGuardarMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.gif"))); // NOI18N
        botonGuardarMenuArchivo.setText("Guardar");
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
    
    /*
    Hay que usar el action porque lo que estamos haciendo es ejecutar acciones sobre el botón
    */
    private void BotonLapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLapizActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Punto");
        //Enviamos mensaje a Lienzo para que se seleccione la herramienta punto:
//        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.PUNTO);
    }//GEN-LAST:event_BotonLapizActionPerformed

    private void botonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegroActionPerformed
  //      this.lienzo1.setColor(Color.BLACK);
    }//GEN-LAST:event_botonNegroActionPerformed

    private void BotonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLineaActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Línea");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta linea:
    //    this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.LINEA);
    }//GEN-LAST:event_BotonLineaActionPerformed

    private void BotonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRectanguloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Rectángulo");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta rectángulo:
//        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.RECTANGULO);
    }//GEN-LAST:event_BotonRectanguloActionPerformed

    private void BotonOvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOvaloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Óvalo");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta óvalo:
 //       this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.OVALO);
    }//GEN-LAST:event_BotonOvaloActionPerformed

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
 //       this.lienzo1.setColor(Color.RED);
    }//GEN-LAST:event_botonRojoActionPerformed

    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
   //     this.lienzo1.setColor(Color.BLUE);
    }//GEN-LAST:event_botonAzulActionPerformed

    private void botonBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBlancoActionPerformed
   //     this.lienzo1.setColor(Color.WHITE);
    }//GEN-LAST:event_botonBlancoActionPerformed

    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
  //      this.lienzo1.setColor(Color.YELLOW);
    }//GEN-LAST:event_botonAmarilloActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
   //     this.lienzo1.setColor(Color.GREEN);
    }//GEN-LAST:event_botonVerdeActionPerformed

    private void botonNuevoMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoMenuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoMenuArchivoActionPerformed

    private void botonAbrirMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirMenuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAbrirMenuArchivoActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonLapiz;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JToggleButton BotonOvalo;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JLabel barraInfoHerramienta;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelCC;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JPanel panelColores;
    private javax.swing.JDesktopPane panelEscritorio;
    private javax.swing.JPanel panelGrosor;
    private javax.swing.JPanel panelHerramientasInferior;
    private javax.swing.JPanel panelPropiedades;
    private javax.swing.JPopupMenu popUpAjustes;
    private javax.swing.JSpinner spinnerGrosor;
    // End of variables declaration//GEN-END:variables
}
