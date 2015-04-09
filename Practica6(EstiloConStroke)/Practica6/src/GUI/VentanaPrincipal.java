package GUI;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.geom.Point2D;


public class VentanaPrincipal extends javax.swing.JFrame {

    private String []fuentesSistema;
    
    
    public VentanaPrincipal() {
        
        initComponents();
        //Iniciamos el Lienzo con la herramienta punto seleccionada.
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.LINEA);
        //Para que el botón de punto aparezca seleccionado.
        //this.BotonLapiz.doClick();
        this.BotonLinea.doClick();
        this.dialogoAbout.setSize(600, 200);
        this.dialogoAbout.setLocationRelativeTo(null);
        this.spinnerGrosor.setValue(10);
        this.lienzo1.setGrosorLinea(10);
        
        //this.BotonHerramientas.doClick();
        this.panelHerramientas.setVisible(false);
        
        
        System.out.println(fuentesSistema.length);
        for(int i=0; i<fuentesSistema.length; i++)
            System.out.println(fuentesSistema[i]);
        
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
        BotonHerramientas = new javax.swing.JToggleButton();
        PanelSur = new javax.swing.JPanel();
        jPanelColoresYRelleno = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botonNegro = new javax.swing.JToggleButton();
        botonVerde = new javax.swing.JToggleButton();
        botonRojo = new javax.swing.JToggleButton();
        botonBlanco = new javax.swing.JToggleButton();
        botonAzul = new javax.swing.JToggleButton();
        botonAmarillo = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonRelleno = new javax.swing.JCheckBox();
        GraphicsEnvironment ge;
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fuentesSistema = ge.getAvailableFontFamilyNames();
        listaFuentes = new javax.swing.JComboBox(this.fuentesSistema);
        jPanelInfo = new javax.swing.JPanel();
        barraInfoHerramienta = new javax.swing.JLabel();
        coordenadas = new javax.swing.JLabel();
        PanelCentro = new javax.swing.JPanel();
        panelHerramientas = new javax.swing.JPanel();
        labelGrosor = new javax.swing.JLabel();
        spinnerGrosor = new javax.swing.JSpinner();
        botonSeleccion = new javax.swing.JCheckBox();
        lienzo1 = new GUI.Lienzo();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        botonNuevoMenuArchivo = new javax.swing.JMenuItem();
        botonAbrirMenuArchivo = new javax.swing.JMenuItem();
        botonGuardarMenuArchivo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        checkboxColoresMenuVer = new javax.swing.JCheckBoxMenuItem();
        checkboxInformacionMenuVer = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        jMenu5.setText("jMenu5");

        jMenuItem3.setText("jMenuItem3");
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("jMenuItem4");
        jMenu5.add(jMenuItem4);

        popUpAjustes.add(jMenu5);

        dialogoAbout.setTitle("About OpenMOJ");

        labelCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cc.png"))); // NOI18N
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
        BotonLapiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Lapiz.gif"))); // NOI18N
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
        BotonLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Linea.gif"))); // NOI18N
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
        BotonRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Rectangulo.gif"))); // NOI18N
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
        BotonOvalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ovalo.gif"))); // NOI18N
        BotonOvalo.setFocusable(false);
        BotonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonOvalo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOvaloActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonOvalo);

        BotonHerramientas.setText("Herramientas");
        BotonHerramientas.setFocusable(false);
        BotonHerramientas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonHerramientas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotonHerramientas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHerramientasActionPerformed(evt);
            }
        });
        jToolBar1.add(BotonHerramientas);

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

        jPanelColoresYRelleno.setPreferredSize(new java.awt.Dimension(615, 70));
        jPanelColoresYRelleno.setLayout(new java.awt.BorderLayout());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAzul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAmarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelColoresYRelleno.add(jPanel2, java.awt.BorderLayout.LINE_START);
        jPanelColoresYRelleno.add(jSeparator1, java.awt.BorderLayout.PAGE_END);

        botonRelleno.setText("Relleno");
        botonRelleno.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonRellenoStateChanged(evt);
            }
        });
        botonRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRellenoActionPerformed(evt);
            }
        });
        jPanelColoresYRelleno.add(botonRelleno, java.awt.BorderLayout.LINE_END);
        jPanelColoresYRelleno.add(listaFuentes, java.awt.BorderLayout.CENTER);

        PanelSur.add(jPanelColoresYRelleno, java.awt.BorderLayout.PAGE_START);

        jPanelInfo.setLayout(new java.awt.BorderLayout());

        barraInfoHerramienta.setText("Punto");
        jPanelInfo.add(barraInfoHerramienta, java.awt.BorderLayout.LINE_START);

        coordenadas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coordenadas.setText("Coordenadas");
        jPanelInfo.add(coordenadas, java.awt.BorderLayout.LINE_END);

        PanelSur.add(jPanelInfo, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        PanelCentro.setBackground(new java.awt.Color(240, 240, 240));
        PanelCentro.setMaximumSize(new java.awt.Dimension(32767, 32100));
        PanelCentro.setLayout(new java.awt.BorderLayout());

        panelHerramientas.setBackground(new java.awt.Color(153, 153, 153));

        labelGrosor.setText("Grosor:");

        spinnerGrosor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerGrosorStateChanged(evt);
            }
        });

        botonSeleccion.setText("Seleccion");
        botonSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHerramientasLayout = new javax.swing.GroupLayout(panelHerramientas);
        panelHerramientas.setLayout(panelHerramientasLayout);
        panelHerramientasLayout.setHorizontalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHerramientasLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelGrosor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addComponent(botonSeleccion)
                .addGap(0, 11, Short.MAX_VALUE))
        );
        panelHerramientasLayout.setVerticalGroup(
            panelHerramientasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHerramientasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGrosor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerGrosor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonSeleccion)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        PanelCentro.add(panelHerramientas, java.awt.BorderLayout.LINE_END);

        lienzo1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzo1MouseMoved(evt);
            }
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lienzo1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        PanelCentro.add(lienzo1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        botonNuevoMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NuevoBoceto.GIF"))); // NOI18N
        botonNuevoMenuArchivo.setText("Nuevo");
        botonNuevoMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoMenuArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(botonNuevoMenuArchivo);

        botonAbrirMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/folder265.png"))); // NOI18N
        botonAbrirMenuArchivo.setText("Abrir");
        botonAbrirMenuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirMenuArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(botonAbrirMenuArchivo);

        botonGuardarMenuArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Guardar.gif"))); // NOI18N
        botonGuardarMenuArchivo.setText("Guardar");
        jMenu1.add(botonGuardarMenuArchivo);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ver");

        checkboxColoresMenuVer.setSelected(true);
        checkboxColoresMenuVer.setText("Colores");
        jMenu3.add(checkboxColoresMenuVer);

        checkboxInformacionMenuVer.setSelected(true);
        checkboxInformacionMenuVer.setText("Información");
        jMenu3.add(checkboxInformacionMenuVer);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Ayuda");

        jMenuItem2.setText("Ajustes");
        jMenu4.add(jMenuItem2);

        jMenuItem1.setText("Sobre OpenMOJ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

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
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.PUNTO);
    }//GEN-LAST:event_BotonLapizActionPerformed

    private void botonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegroActionPerformed
        this.lienzo1.setColor(Color.BLACK);
    }//GEN-LAST:event_botonNegroActionPerformed

    private void BotonLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLineaActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Línea");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta linea:
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.LINEA);
    }//GEN-LAST:event_BotonLineaActionPerformed

    private void BotonRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRectanguloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Rectángulo");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta rectángulo:
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.RECTANGULO);
    }//GEN-LAST:event_BotonRectanguloActionPerformed

    private void BotonOvaloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonOvaloActionPerformed
        //Mensaje en la barra de estado inferior:
        this.barraInfoHerramienta.setText("Óvalo");
        //Enviamoss mensaje a Lienzo para que se seleccione la herramienta óvalo:
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.OVALO);
    }//GEN-LAST:event_BotonOvaloActionPerformed

    private void botonRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRellenoActionPerformed
        if(botonRelleno.isSelected()){
            this.lienzo1.setRelleno(true);
            //System.out.println("Figuras rellens");
        }
        if(!botonRelleno.isSelected()){
            this.lienzo1.setRelleno(false);
        }
    }//GEN-LAST:event_botonRellenoActionPerformed

    private void botonRellenoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonRellenoStateChanged
    
    }//GEN-LAST:event_botonRellenoStateChanged

    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        this.lienzo1.setColor(Color.RED);
    }//GEN-LAST:event_botonRojoActionPerformed

    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
        this.lienzo1.setColor(Color.BLUE);
    }//GEN-LAST:event_botonAzulActionPerformed

    private void botonBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBlancoActionPerformed
        this.lienzo1.setColor(Color.WHITE);
    }//GEN-LAST:event_botonBlancoActionPerformed

    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
        this.lienzo1.setColor(Color.YELLOW);
    }//GEN-LAST:event_botonAmarilloActionPerformed

    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        this.lienzo1.setColor(Color.GREEN);
    }//GEN-LAST:event_botonVerdeActionPerformed

    private void botonNuevoMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoMenuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevoMenuArchivoActionPerformed

    private void botonAbrirMenuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirMenuArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAbrirMenuArchivoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.out.println("Pulsado About");
        this.dialogoAbout.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void lienzo1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzo1MouseDragged
        this.setCoordenadas(evt.getPoint());
    }//GEN-LAST:event_lienzo1MouseDragged

    private void lienzo1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lienzo1MouseMoved
        this.setCoordenadas(evt.getPoint());
    }//GEN-LAST:event_lienzo1MouseMoved

    private void spinnerGrosorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerGrosorStateChanged
        //Cuando el estado del spinner cambiar se manda un mensaje al lienzo para que cambie el valor del grosor de la linea.
        this.lienzo1.setGrosorLinea((int)this.spinnerGrosor.getValue());
    }//GEN-LAST:event_spinnerGrosorStateChanged

    private void botonSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionActionPerformed
         if(botonSeleccion.isSelected()){
            this.lienzo1.setModoSeleccion(true);
            //System.out.println("Figuras rellens");
        }
        if(!botonSeleccion.isSelected()){
            this.lienzo1.setModoSeleccion(false);
        }
    }//GEN-LAST:event_botonSeleccionActionPerformed

    private void BotonHerramientasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHerramientasActionPerformed
           if(this.panelHerramientas.isVisible())
            this.panelHerramientas.setVisible(false);
        else
            this.panelHerramientas.setVisible(true);
    }//GEN-LAST:event_BotonHerramientasActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonHerramientas;
    private javax.swing.JToggleButton BotonLapiz;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JToggleButton BotonOvalo;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JLabel barraInfoHerramienta;
    private javax.swing.JMenuItem botonAbrirMenuArchivo;
    private javax.swing.JToggleButton botonAmarillo;
    private javax.swing.JToggleButton botonAzul;
    private javax.swing.JToggleButton botonBlanco;
    private javax.swing.JMenuItem botonGuardarMenuArchivo;
    private javax.swing.JToggleButton botonNegro;
    private javax.swing.JMenuItem botonNuevoMenuArchivo;
    private javax.swing.JCheckBox botonRelleno;
    private javax.swing.JToggleButton botonRojo;
    private javax.swing.JCheckBox botonSeleccion;
    private javax.swing.JToggleButton botonVerde;
    private javax.swing.JCheckBoxMenuItem checkboxColoresMenuVer;
    private javax.swing.JCheckBoxMenuItem checkboxInformacionMenuVer;
    private javax.swing.JLabel coordenadas;
    private javax.swing.JDialog dialogoAbout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelColoresYRelleno;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelCC;
    private javax.swing.JLabel labelGrosor;
    private GUI.Lienzo lienzo1;
    private javax.swing.JComboBox listaFuentes;
    private javax.swing.JPanel panelHerramientas;
    private javax.swing.JPopupMenu popUpAjustes;
    private javax.swing.JSpinner spinnerGrosor;
    // End of variables declaration//GEN-END:variables
}
