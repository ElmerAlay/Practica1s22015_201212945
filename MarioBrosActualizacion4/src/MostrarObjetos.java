
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class MostrarObjetos extends javax.swing.JFrame {
    public int x, y;
    public String ruta[], nombres[], tipos[];
    public JLabel label[], labelNombres[], labelTipos[], labelPosicion[];
    public ImageIcon icono;
    public CargaObjetos obj;
    
    public MostrarObjetos() {
        initComponents();
        //icono = new ImageIcon("C:\\Users\\Elmer\\Documents\\NetBeansProjects\\MarioBros\\src\\mariobros\\suelo2.jpg");
        x=y=100;
        this.setTitle("Objetos en en juego");
        //CrearLabel(150);
        //MostrarLabel(0, icono);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_Modificar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbx_FormaSacarObjetos = new javax.swing.JComboBox();
        btn_Avanzar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel1.setText("Imagen");

        jLabel4.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel6.setText("Tipo");

        jLabel8.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel8.setText("No.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(72, 72, 72)
                .addComponent(jLabel4)
                .addGap(86, 86, 86)
                .addComponent(jLabel6)
                .addContainerGap(1264, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addContainerGap(909, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        btn_Modificar.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        btn_Modificar.setText("Modificar");
        btn_Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ModificarMouseClicked(evt);
            }
        });

        btn_Eliminar.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        btn_Eliminar.setText("Eliminar");

        btn_Salir.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        btn_Salir.setText("Salir");
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        jLabel2.setText("Forma de sacar los objetos:");

        cbx_FormaSacarObjetos.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        cbx_FormaSacarObjetos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pila", "Cola" }));

        btn_Avanzar.setFont(new java.awt.Font("Angsana New", 3, 18)); // NOI18N
        btn_Avanzar.setText("Avanzar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Modificar)
                .addGap(18, 18, 18)
                .addComponent(btn_Eliminar)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Avanzar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbx_FormaSacarObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(btn_Salir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Modificar)
                        .addComponent(btn_Eliminar)
                        .addComponent(btn_Salir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbx_FormaSacarObjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Avanzar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
       this.dispose();
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void btn_ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ModificarMouseClicked

    }//GEN-LAST:event_btn_ModificarMouseClicked

    /**
     * @param args the command line arguments
     */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarObjetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Avanzar;
    public javax.swing.JButton btn_Eliminar;
    public javax.swing.JButton btn_Modificar;
    public javax.swing.JButton btn_Salir;
    public javax.swing.JComboBox cbx_FormaSacarObjetos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
