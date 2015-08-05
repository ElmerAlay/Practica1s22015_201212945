
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class MostrarObjetos extends javax.swing.JFrame {
    
    public int x, y;
    public JLabel labelImagenes[];
   
    public MostrarObjetos() {
        initComponents();
        //length = 0;
        //icono = new ImageIcon();
        //mostrarImagenesLabel(length, icono);
    }

    public void mostrarImagenesLabel(int length, ImageIcon icono){
        
        x = lbl_Mario.getX();
        y = lbl_Mario.getY();
        labelImagenes = new JLabel[length];
        
        for(int i=0; i<=length; i++){
            labelImagenes[i].setBounds(this.x, this.y, 100, 100);
            labelImagenes[i].setIcon(icono);
            this.JPanel_MostrarObjetos.add(this.labelImagenes[i]);
            this.y += 20;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JPanel_MostrarObjetos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_Mario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel1.setText("Imagen");

        jLabel2.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        jLabel3.setText("Tipo");

        lbl_Mario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mariobros/Mario2.jpg"))); // NOI18N

        jLabel5.setText("Mario");

        jLabel6.setText("Mario");

        javax.swing.GroupLayout JPanel_MostrarObjetosLayout = new javax.swing.GroupLayout(JPanel_MostrarObjetos);
        JPanel_MostrarObjetos.setLayout(JPanel_MostrarObjetosLayout);
        JPanel_MostrarObjetosLayout.setHorizontalGroup(
            JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_MostrarObjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Mario))
                .addGap(71, 71, 71)
                .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(88, 88, 88))
        );
        JPanel_MostrarObjetosLayout.setVerticalGroup(
            JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_MostrarObjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPanel_MostrarObjetosLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(JPanel_MostrarObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)))
                    .addGroup(JPanel_MostrarObjetosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Mario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(JPanel_MostrarObjetos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarObjetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_MostrarObjetos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Mario;
    // End of variables declaration//GEN-END:variables
}
