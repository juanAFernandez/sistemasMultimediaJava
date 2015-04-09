package practica4;

import java.awt.Color;


public class VentanaPrincipal extends javax.swing.JFrame {

    
    public VentanaPrincipal() {
        initComponents();
        this.lienzo1.setTipoHerramienta(Lienzo.tipoHerramienta.PUNTO);
        this.BotonLapiz.doClick();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        GrupoBotonesDibujo = new javax.swing.ButtonGroup();
        GrupoBotonesColores = new javax.swing.ButtonGroup();
        PanelNorte = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        BotonLapiz = new javax.swing.JToggleButton();
        BotonLinea = new javax.swing.JToggleButton();
        BotonRectangulo = new javax.swing.JToggleButton();
        BotonOvalo = new javax.swing.JToggleButton();
        PanelSur = new javax.swing.JPanel();
        barraInfoHerramienta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botonNegro = new javax.swing.JToggleButton();
        botonVerde = new javax.swing.JToggleButton();
        botonRojo = new javax.swing.JToggleButton();
        botonBlanco = new javax.swing.JToggleButton();
        botonAzul = new javax.swing.JToggleButton();
        botonAmarillo = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        botonSeleccion = new javax.swing.JCheckBox();
        PanelCentro = new javax.swing.JPanel();
        lienzo1 = new practica4.Lienzo();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        javax.swing.GroupLayout PanelNorteLayout = new javax.swing.GroupLayout(PanelNorte);
        PanelNorte.setLayout(PanelNorteLayout);
        PanelNorteLayout.setHorizontalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        PanelNorteLayout.setVerticalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorteLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNorte, java.awt.BorderLayout.NORTH);

        PanelSur.setLayout(new java.awt.BorderLayout());

        barraInfoHerramienta.setText("Punto");
        PanelSur.add(barraInfoHerramienta, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(615, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

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

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);
        jPanel1.add(jSeparator1, java.awt.BorderLayout.PAGE_END);

        botonSeleccion.setText("Relleno");
        botonSeleccion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                botonSeleccionStateChanged(evt);
            }
        });
        botonSeleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionActionPerformed(evt);
            }
        });
        jPanel1.add(botonSeleccion, java.awt.BorderLayout.LINE_END);

        PanelSur.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        PanelCentro.setBackground(new java.awt.Color(240, 240, 240));
        PanelCentro.setMaximumSize(new java.awt.Dimension(32767, 32100));
        PanelCentro.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        PanelCentro.add(lienzo1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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

    private void botonSeleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionActionPerformed
        if(botonSeleccion.isSelected()){
            this.lienzo1.setRelleno(true);
            //System.out.println("Figuras rellens");
        }
        if(!botonSeleccion.isSelected()){
            this.lienzo1.setRelleno(false);
        }
    }//GEN-LAST:event_botonSeleccionActionPerformed

    private void botonSeleccionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_botonSeleccionStateChanged
    
    }//GEN-LAST:event_botonSeleccionStateChanged

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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JToggleButton botonAmarillo;
    private javax.swing.JToggleButton botonAzul;
    private javax.swing.JToggleButton botonBlanco;
    private javax.swing.JToggleButton botonNegro;
    private javax.swing.JToggleButton botonRojo;
    private javax.swing.JCheckBox botonSeleccion;
    private javax.swing.JToggleButton botonVerde;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private practica4.Lienzo lienzo1;
    // End of variables declaration//GEN-END:variables
}
