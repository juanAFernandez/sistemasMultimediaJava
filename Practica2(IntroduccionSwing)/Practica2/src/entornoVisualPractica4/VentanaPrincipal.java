package entornoVisualPractica4;


public class VentanaPrincipal extends javax.swing.JFrame {

    
    public VentanaPrincipal() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BotonNegro = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        PanelCentro = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        BotonLapiz.setBackground(new java.awt.Color(10, 0, 255));
        GrupoBotonesDibujo.add(BotonLapiz);
        BotonLapiz.setForeground(new java.awt.Color(253, 2, 2));
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
        BotonLinea.setFocusable(false);
        BotonLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BotonLinea);

        GrupoBotonesDibujo.add(BotonRectangulo);
        BotonRectangulo.setFocusable(false);
        BotonRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BotonRectangulo);

        GrupoBotonesDibujo.add(BotonOvalo);
        BotonOvalo.setFocusable(false);
        BotonOvalo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotonOvalo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BotonOvalo);

        javax.swing.GroupLayout PanelNorteLayout = new javax.swing.GroupLayout(PanelNorte);
        PanelNorte.setLayout(PanelNorteLayout);
        PanelNorteLayout.setHorizontalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );
        PanelNorteLayout.setVerticalGroup(
            PanelNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNorteLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNorte, java.awt.BorderLayout.NORTH);

        PanelSur.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Punto");
        PanelSur.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(615, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        BotonNegro.setBackground(new java.awt.Color(1, 1, 1));
        GrupoBotonesColores.add(BotonNegro);
        BotonNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonNegroActionPerformed(evt);
            }
        });

        jToggleButton3.setBackground(new java.awt.Color(0, 204, 0));
        GrupoBotonesColores.add(jToggleButton3);

        jToggleButton4.setBackground(new java.awt.Color(255, 0, 0));
        GrupoBotonesColores.add(jToggleButton4);

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        GrupoBotonesColores.add(jToggleButton1);

        jToggleButton2.setBackground(new java.awt.Color(0, 0, 255));
        GrupoBotonesDibujo.add(jToggleButton2);

        jToggleButton5.setBackground(new java.awt.Color(255, 255, 51));
        GrupoBotonesColores.add(jToggleButton5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonNegro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToggleButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_START);
        jPanel1.add(jSeparator1, java.awt.BorderLayout.PAGE_END);

        jCheckBox1.setText("Relleno");
        jPanel1.add(jCheckBox1, java.awt.BorderLayout.LINE_END);

        PanelSur.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PanelSur, java.awt.BorderLayout.PAGE_END);

        PanelCentro.setBackground(new java.awt.Color(240, 240, 240));
        PanelCentro.setMaximumSize(new java.awt.Dimension(32767, 32100));

        javax.swing.GroupLayout PanelCentroLayout = new javax.swing.GroupLayout(PanelCentro);
        PanelCentro.setLayout(PanelCentroLayout);
        PanelCentroLayout.setHorizontalGroup(
            PanelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );
        PanelCentroLayout.setVerticalGroup(
            PanelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLapizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLapizActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonLapizActionPerformed

    private void BotonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonNegroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonNegroActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotonLapiz;
    private javax.swing.JToggleButton BotonLinea;
    private javax.swing.JToggleButton BotonNegro;
    private javax.swing.JToggleButton BotonOvalo;
    private javax.swing.JToggleButton BotonRectangulo;
    private javax.swing.ButtonGroup GrupoBotonesColores;
    private javax.swing.ButtonGroup GrupoBotonesDibujo;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JPanel PanelNorte;
    private javax.swing.JPanel PanelSur;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
