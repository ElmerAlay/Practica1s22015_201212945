import ListaObjetos.*;
import Objetos.*;
import MatrizOrtogonal.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class CargaObjetos extends javax.swing.JFrame implements ActionListener {
    
    public Lista lista;
    public Mario mario;
    public Objeto ObjetoTemporal;
    public MatrizOrtogonal matriz;
    public MatrizOrtogonal ma[][];
    public NodoOrtogonal nodo[][], nodo2[][];
    public Castillo castillo;
    public MostrarObjetos mo;
    public Prueba pu;
    public String archivo_txt;
    ImageIcon icono;
    String nombre, tipo, ruta, rutas[], nombres[], tipos[], nombresMatriz[][], tiposMatriz[][];
    int cantidadMario, cantidadCastillo, filas, columnas;
    public int contador;
    
    public CargaObjetos() {
        initComponents();
        filas = 2;
        columnas = 4;
        //contador=0;
        ruta = "C:\\Users\\Elmer\\Documents\\NetBeansProjects\\MarioBros\\src\\mariobros\\";
        lista = new Lista();
        mario = new Mario();
        nombresMatriz = new String[100][100];
        tiposMatriz = new String[100][100];
        ma = new MatrizOrtogonal[100][100];
        nodo = new NodoOrtogonal[100][100];
        castillo = new Castillo();
        matriz = new MatrizOrtogonal();
        mo = new MostrarObjetos();
        mo.setVisible(false);
        mo.btn_Modificar.addActionListener(this);
        mo.btn_Eliminar.addActionListener(this);
        mo.btn_Avanzar.addActionListener(this);
        pu = new Prueba();
        pu.setVisible(false);
        pu.btn_Actualizar.addActionListener(this);
        pu.btn_Colocar.addActionListener(this);
        pu.btn_Agregar.addActionListener(this);
        pu.btn_Graficar.addActionListener(this);
        pu.btn_EliminarObjetoTablero.addActionListener(this);
        pu.jPanel1.setPreferredSize(new Dimension(14000,14000));
        cantidadMario = 0;
        cantidadCastillo = 0;
        icono = new ImageIcon();
        HabilitarComponentes(false);
    }
    
    public void HabilitarComponentes(boolean bool){
        cbx_TipoObjeto.setEnabled(bool);
        txt_Nombre.setEnabled(bool);
        btn_Agregar.setEnabled(bool);
    }
    
    public ImageIcon obtenerIcono(){
        if(cbx_TipoObjeto.getSelectedItem().equals("Suelo")){
            icono = new ImageIcon(ruta+"Suelo2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Bloque")){
            icono = new ImageIcon(ruta+"pared2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Goomba")){
            icono = new ImageIcon(ruta+"Goomba2.png");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Koopa")){
            icono = new ImageIcon(ruta+"Koopa2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Ficha")){
            icono = new ImageIcon(ruta+"Ficha2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Hongo de Vida")){
            icono = new ImageIcon(ruta+"Hongo2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Mario Bros")){
            icono = new ImageIcon(ruta+"Mario2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        if(cbx_TipoObjeto.getSelectedItem().equals("Castillo")){
            icono = new ImageIcon(ruta+"Castillo2.jpg");
            this.lbl_ImagenMuestra.setIcon(icono);
        }
        return icono;
    }
    
    public void CrearLabel(int length){
        mo.label = new JLabel[length];
        mo.labelNombres = new JLabel[length];
        mo.labelTipos = new JLabel[length];
        mo.labelPosicion = new JLabel[length];

        for(int i=0; i<length; i++){
            mo.label[i] = new JLabel();
            mo.label[i].setBounds(60, mo.y, 100, 100);
            mo.label[i].setText("Objeto no. " + i);
            mo.label[i].setHorizontalAlignment(SwingConstants.CENTER);
            mo.jPanel1.add(mo.label[i], null);
            
            mo.labelNombres[i] = new JLabel();
            mo.labelNombres[i].setBounds(210, mo.y, 100, 100);
            mo.labelNombres[i].setText("Nombre no. " + i);
            mo.labelNombres[i].setHorizontalAlignment(SwingConstants.CENTER);
            mo.jPanel1.add(mo.labelNombres[i], null);
            
            mo.labelTipos[i] = new JLabel();
            mo.labelTipos[i].setBounds(350, mo.y, 100, 100);
            mo.labelTipos[i].setText("Tipo no. " + i);
            mo.labelTipos[i].setHorizontalAlignment(SwingConstants.CENTER);
            mo.jPanel1.add(mo.labelTipos[i], null);
            
            mo.labelPosicion[i] = new JLabel();
            mo.labelPosicion[i].setBounds(10, mo.y, 30, 100);
            mo.labelPosicion[i].setText("" + (i+1));
            mo.labelPosicion[i].setHorizontalAlignment(SwingConstants.CENTER);
            mo.jPanel1.add(mo.labelPosicion[i], null);
            
            mo.y += 110;
        }
        
        mo.jPanel1.setPreferredSize(new Dimension(14000,14000));
    }
    
    public void ModificarLista(){
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Digite Posición"));
        Objeto objTemporal = lista.getObjetoAt(posicion-1);
        
        String nombre = JOptionPane.showInputDialog("Ingrese Nombre Deseado");
        
        objTemporal.setNombre(nombre);
    }
    
    public void EliminarLista(){
        int posicion = Integer.parseInt(JOptionPane.showInputDialog("Digite Posición a eliminar"));
        lista.EliminarMedio(posicion-1);
        JOptionPane.showMessageDialog(null, "El número de elementos es " + lista.Length());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel_Principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbx_TipoObjeto = new javax.swing.JComboBox();
        lbl_ImagenMuestra = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        btn_Nuevo = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_Mostrar = new javax.swing.JButton();
        btn_Cargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel1.setText("Elige los objetos que...");

        jLabel2.setFont(new java.awt.Font("Angsana New", 3, 36)); // NOI18N
        jLabel2.setText("...quieres que aparezcan en el juego");

        cbx_TipoObjeto.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        cbx_TipoObjeto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Suelo", "Bloque", "Goomba", "Koopa", "Ficha", "Hongo de Vida", "Mario Bros", "Castillo" }));
        cbx_TipoObjeto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbx_TipoObjetoItemStateChanged(evt);
            }
        });
        cbx_TipoObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_TipoObjetoActionPerformed(evt);
            }
        });

        lbl_ImagenMuestra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mariobros/suelo2.jpg"))); // NOI18N

        jLabel3.setText("Nombre:");

        btn_Nuevo.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        btn_Nuevo.setText("Nuevo");
        btn_Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_NuevoMouseClicked(evt);
            }
        });

        btn_Agregar.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        btn_Agregar.setText("Agregar");
        btn_Agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_AgregarMouseClicked(evt);
            }
        });
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });

        btn_Salir.setFont(new java.awt.Font("Angsana New", 3, 24)); // NOI18N
        btn_Salir.setText("Salir");
        btn_Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_SalirMouseClicked(evt);
            }
        });

        btn_Mostrar.setText("Mostrar Objetos");
        btn_Mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_MostrarMouseClicked(evt);
            }
        });

        btn_Cargar.setText("Cargar Datos");
        btn_Cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CargarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout JPanel_PrincipalLayout = new javax.swing.GroupLayout(JPanel_Principal);
        JPanel_Principal.setLayout(JPanel_PrincipalLayout);
        JPanel_PrincipalLayout.setHorizontalGroup(
            JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel2))
                    .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbx_TipoObjeto, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(lbl_ImagenMuestra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                                .addComponent(btn_Nuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Agregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Salir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_Cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        JPanel_PrincipalLayout.setVerticalGroup(
            JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_TipoObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_ImagenMuestra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanel_PrincipalLayout.createSequentialGroup()
                        .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(JPanel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Nuevo)
                            .addComponent(btn_Agregar)
                            .addComponent(btn_Salir)
                            .addComponent(btn_Mostrar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cargar)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel_Principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_TipoObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_TipoObjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_TipoObjetoActionPerformed

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_NuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_NuevoMouseClicked
        HabilitarComponentes(true);
    }//GEN-LAST:event_btn_NuevoMouseClicked

    private void btn_AgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_AgregarMouseClicked
        try{
            if(cbx_TipoObjeto.getSelectedItem().equals("Mario Bros")){
                mario.setCantidad(cantidadMario);
                cantidadMario++;
            }
            if(cbx_TipoObjeto.getSelectedItem().equals("Castillo")){
                castillo.setCantidad(cantidadCastillo);
                cantidadCastillo++;
            }
            if(mario.getCantidad()>=1 && cbx_TipoObjeto.getSelectedItem().equals("Mario Bros")){
                JOptionPane.showMessageDialog(null, "Sólo se puede agregar un Mario Bros al juego");
                lista.Eliminar();
            }
            if(castillo.getCantidad()>=1 && cbx_TipoObjeto.getSelectedItem().equals("Castillo")){
                JOptionPane.showMessageDialog(null, "Sólo se puede agregar un Castillo al juego");
                lista.Eliminar();
            }
           
            nombre = txt_Nombre.getText();
            tipo = cbx_TipoObjeto.getSelectedItem().toString();
            icono = this.obtenerIcono();
        
            lista.Agregar(new Objeto(nombre, tipo, icono));
            System.out.println(lista.Length());
            JOptionPane.showMessageDialog(null, "El número de elementos de la lista es " + lista.Length());
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e);
        }
    }//GEN-LAST:event_btn_AgregarMouseClicked

    private void btn_SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_SalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_btn_SalirMouseClicked

    private void cbx_TipoObjetoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbx_TipoObjetoItemStateChanged
        this.obtenerIcono();
    }//GEN-LAST:event_cbx_TipoObjetoItemStateChanged

    private void btn_MostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_MostrarMouseClicked
        try{
            int i=0;
            String mostrar = "";
            lista.setSiguienteObjeto();
            rutas = new String[lista.Length()];
            nombres = new String[lista.Length()];
            tipos = new String[lista.Length()];
            Objeto objTemporal = lista.getSiguienteObjeto();
            
            while(objTemporal!=null){
                //mostrar += objTemporal.getNombre() + " - " + objTemporal.getTipo() + " - " + objTemporal.getIcono().toString() + "\n";
                rutas[i] = objTemporal.getIcono().toString();
                nombres[i] = objTemporal.getNombre();
                tipos[i] = objTemporal.getTipo();
                objTemporal = lista.getSiguienteObjeto();
                i++;
            }
            
            for(int  j=0; j<rutas.length;j++){
                mo.label[j].setIcon(new ImageIcon(rutas[j]));
                mo.labelNombres[j].setText(nombres[j]);
                mo.labelTipos[j].setText(tipos[j]);
                System.out.println(rutas[j]);
                System.out.println(nombres[j]);
                System.out.println(tipos[j]);
            }
          
            mo.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos: " + e);
        } 
    }//GEN-LAST:event_btn_MostrarMouseClicked

    private void btn_CargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CargarMouseClicked
        CrearLabel(lista.Length());
    }//GEN-LAST:event_btn_CargarMouseClicked

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
            java.util.logging.Logger.getLogger(CargaObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargaObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargaObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargaObjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargaObjetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel_Principal;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Cargar;
    private javax.swing.JButton btn_Mostrar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JComboBox cbx_TipoObjeto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_ImagenMuestra;
    private javax.swing.JTextField txt_Nombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(mo.btn_Modificar==e.getSource()){
            try{
                this.ModificarLista();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al modificar: " + ex);
            }
        }
        if(mo.btn_Eliminar==e.getSource()){
            try{
                this.EliminarLista();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al eliminar: " + ex);
            }
        }
        if(mo.btn_Avanzar==e.getSource()){
            try{
                if(mo.cbx_FormaSacarObjetos.getSelectedItem().equals("Pila")){
                    Objeto objTemporal=lista.getObjetoAt(lista.Length()-1);
                    String ruta = objTemporal.getIcono().toString();
                    String nombre = objTemporal.getNombre();
                    
                    pu.setVisible(true);
                    pu.lbl_ObjetoActual.setIcon(new ImageIcon(ruta));
                    mo.setVisible(false);
                }else if(mo.cbx_FormaSacarObjetos.getSelectedItem().equals("Cola")){
                    int posicion=0;
                    Objeto objTemporal=lista.getObjetoAt(posicion);
                    String ruta = objTemporal.getIcono().toString();
                    String nombre = objTemporal.getNombre();
                    
                    pu.setVisible(true);
                    pu.lbl_ObjetoActual.setIcon(new ImageIcon(ruta));
                    mo.setVisible(false);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error en aplicación:" + ex);
            }
        }
        if(pu.btn_Colocar==e.getSource()){
            try{
                int x=Integer.parseInt(JOptionPane.showInputDialog("Digite la posición de fila en donde desea colocar el objeto"));
                int y=Integer.parseInt(JOptionPane.showInputDialog("Digite la posición de columna en donde desea colocar el objeto"));
                
                if(y<columnas && x<filas){
                    if(mo.cbx_FormaSacarObjetos.getSelectedItem().equals("Pila")){
                        int tamaño=lista.Length()-1;
                        Objeto objTemporal=lista.getObjetoAt(tamaño);
                        String ruta = objTemporal.getIcono().toString();
                        String nombre = objTemporal.getNombre();
                        String tipo = objTemporal.getTipo();
                        contador = 0;
                        
                        if(tipo.equals("Suelo")){
                            ruta = this.ruta + "suelo3.png";
                        }else if(tipo.equals("Bloque")){
                            ruta = this.ruta + "pared3.png";
                        }else if(tipo.equals("Goomba")){
                            ruta = this.ruta + "goomba3.png";
                        }else if(tipo.equals("Koopa")){
                            ruta = this.ruta + "koopa3.png";
                        }else if(tipo.equals("Ficha")){
                            ruta = this.ruta + "moneda3.png";
                        }else if(tipo.equals("Hondo de Vida")){
                            ruta = this.ruta + "hongo3.png";
                        }else if(tipo.equals("Mario Bros")){
                            ruta = this.ruta + "mario3.png";
                        }else if(tipo.equals("Castillo")){
                            ruta = this.ruta + "castillo3.png";
                        }
                    
                        JLabel label[] = new JLabel[lista.Length()];
                        label[contador] = new JLabel();
                        label[contador].setBounds(y*30, x*30, 30, 30);
                        label[contador].setIcon(new ImageIcon(ruta));
                        pu.jPanel1.add(label[contador], null);
                        
                        matriz.insertar(nombre,x, y);
                        ma[x][y] = new MatrizOrtogonal();
                        ma[x][y].insertar(nombre, x, y);
                        
                        nodo[x][y]= new NodoOrtogonal(nombre,x,y);
                        System.out.println(nodo[x][y].getDato());
                        
                        nombresMatriz[x][y] = nombre;
                        tiposMatriz[x][y] = tipo;
                        
                        lista.Eliminar();
                        contador++;
                    }else if(mo.cbx_FormaSacarObjetos.getSelectedItem().toString().equals("Cola")){
                        int tamaño=0;
                        if(tamaño<lista.Length()){
                            Objeto objTemporal=lista.getObjetoAt(tamaño);
                            String ruta = objTemporal.getIcono().toString();
                            String nombre = objTemporal.getNombre();
                            String tipo = objTemporal.getTipo();
                            contador = 0;
                        
                            if(tipo.equals("Suelo")){
                                ruta = this.ruta + "suelo3.png";
                            }else if(tipo.equals("Bloque")){
                                ruta = this.ruta + "pared3.png";
                            }else if(tipo.equals("Goomba")){
                                ruta = this.ruta + "goomba3.png";
                            }else if(tipo.equals("Koopa")){
                                ruta = this.ruta + "koopa3.png";
                            }else if(tipo.equals("Ficha")){
                                ruta = this.ruta + "moneda3.png";
                            }else if(tipo.equals("Hondo de Vida")){
                                ruta = this.ruta + "hongo3.png";
                            }else if(tipo.equals("Mario Bros")){
                                ruta = this.ruta + "mario3.png";
                            }else if(tipo.equals("Castillo")){
                                ruta = this.ruta + "castillo3.png";
                            }
                    
                            JLabel label[] = new JLabel[lista.Length()];
                            label[contador] = new JLabel();
                            label[contador].setBounds(y*30, x*30, 30, 30);
                            label[contador].setIcon(new ImageIcon(ruta));
                            pu.jPanel1.add(label[contador], null);
                        
                            matriz.insertar(nombre,x, y);
                            ma[x][y] = new MatrizOrtogonal();
                            ma[x][y].insertar(nombre, x, y);
                        
                            nodo[x][y]= new NodoOrtogonal(nombre,x,y);
                            System.out.println(nodo[x][y].getDato());
                        
                            nombresMatriz[x][y] = nombre;
                            tiposMatriz[x][y] = tipo;
                        
                            lista.EliminarPrimero();
                            contador++;
                        }
                        tamaño++;
                    }
                    pu.jPanel1.revalidate();
                }else {
                    JOptionPane.showMessageDialog(null, "No existe la posición indicada", "Error posicion", 0);
                }
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Lista Vacía:" + ex);
            }   
        }
        if(pu.btn_Actualizar==e.getSource()){
            try{
                if(mo.cbx_FormaSacarObjetos.getSelectedItem().equals("Pila")){
                    int tamaño=lista.Length()-1;
                    Objeto objTemporal=lista.getObjetoAt(tamaño);
                    String ruta = objTemporal.getIcono().toString();
                    String nombre = objTemporal.getNombre();
                
                    pu.lbl_ObjetoActual.setIcon(new ImageIcon(ruta));
                }else if(mo.cbx_FormaSacarObjetos.getSelectedItem().equals("Cola")){
                    int tamaño=0;
                    Objeto objTemporal=lista.getObjetoAt(tamaño);
                    String ruta = objTemporal.getIcono().toString();
                    String nombre = objTemporal.getNombre();
                
                    pu.lbl_ObjetoActual.setIcon(new ImageIcon(ruta));
                    tamaño++;
                }       
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Lista Vacía");
            }
            
        }
        if(pu.btn_Agregar==e.getSource()){
            try{
                if(pu.cbx_FilaColumna.getSelectedItem().toString().equals("Fila")){
                    this.filas++;
                    JOptionPane.showMessageDialog(null, "El no. de filas ahora es " + this.filas);
                }else {
                    this.columnas++;
                    JOptionPane.showMessageDialog(null, "El no. de columnas ahora es " + this.columnas);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al ingresar");
            }       
        }
        if(pu.btn_Graficar==e.getSource()){
            try{
                this.llenarMatriz(this.filas, this.columnas);
                if(pu.cbx_Graficar.getSelectedItem().equals("Lista")){
                    this.Graficar(); 
                    this.CrearArchivo();
                    this.Dibujar();
                }else if(pu.cbx_Graficar.getSelectedItem().equals("Matriz")){
                    this.GraficarMatriz(this.filas, this.columnas);
                    this.CrearArchivo();
                    this.Dibujar();
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al graficar: " + ex);
            }
        }
        if(pu.btn_EliminarObjetoTablero==e.getSource()){
            try{
                int x = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué posición en fila desea eliminar?"));
                int y = Integer.parseInt(JOptionPane.showInputDialog(null, "Qué posición en columna desea eliminar?"));
                String dato = nombresMatriz[x][y];
                String tipo = tiposMatriz[x][y];
                String ruta=null;
                
                if(tipo.equals("Suelo")){
                    ruta = this.ruta + "suelo2.jpg";
                }else if(tipo.equals("Bloque")){
                    ruta = this.ruta + "pared2.jpg";
                }else if(tipo.equals("Goomba")){
                    ruta = this.ruta + "goomba2.png";
                }else if(tipo.equals("Koopa")){
                    ruta = this.ruta + "koopa2.jpg";
                }else if(tipo.equals("Ficha")){
                    ruta = this.ruta + "Ficha2.jpg";
                }else if(tipo.equals("Hongo de Vida")){
                    ruta = this.ruta + "Hongo2.jpg";
                }else if(tipo.equals("Mario Bros")){
                    ruta = this.ruta + "Mario2.jpg";
                }else if(tipo.equals("Castillo")){
                    ruta = this.ruta + "Castillo2.jpg";
                }
                
                lista.Agregar(new Objeto(dato, tipo, new ImageIcon(ruta)));
                nombresMatriz[x][y]=null;
                pu.lbl_ObjetoActual.setIcon(new ImageIcon(ruta));
                contador=0;
                JOptionPane.showMessageDialog(null, "El no. de elementos en la lista es: " + lista.Length());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al intentar eliminar objeto: " + ex);
            }
        }
    }
    
    
    public void llenarMatriz(int filas, int columnas){
        nodo2 = new NodoOrtogonal[this.filas][this.columnas];
       
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                nodo2[i][j] = new NodoOrtogonal(nombresMatriz[i][j], i, j);
            }
        }
        
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                System.out.println(nodo2[i][j].getDato() + " en posicion x = " + i  + " y = " + j);
            }
        }
    }
    
    public void GraficarMatriz(int filas, int columnas){
        try{
            int indice[][] = new int[filas][columnas];

            archivo_txt = "digraph G {\n";
            
            for(int i=0; i<filas; i++){
                for(int j=0; j<columnas; j++){
                    if((i+1)<filas && (j+1)<columnas){
                        archivo_txt += (nombresMatriz[i][j+1]+i+""+(j+1)) +"->"+ (nombresMatriz[i][j]+i+""+j) + ";\n";
                        archivo_txt += (nombresMatriz[i][j]+i+""+j) +"->"+ (nombresMatriz[i][j+1]+i+""+(j+1)) + ";\n";
                        archivo_txt += (nombresMatriz[i][j]+i+""+j) +"->"+ (nombresMatriz[i+1][j]+(i+1)+""+j) + ";\n";
                        archivo_txt += (nombresMatriz[i+1][j]+(i+1)+""+j) +"->"+ (nombresMatriz[i][j]+i+""+j) + ";\n";
                    }
                }
            }
            archivo_txt = archivo_txt + "}";
            System.out.println(archivo_txt);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al graficar: " + ex);
        }
    }
    
    public void Graficar(){
        try{
            int nodos = lista.Length();
            int indice = 0;
		
            archivo_txt = "digraph G {\n";
            archivo_txt = archivo_txt + "raíz;\n";
		
            while(indice<nodos){
                ObjetoTemporal = this.lista.getObjetoAt(indice);
		archivo_txt = archivo_txt + ObjetoTemporal.getNombre() + ";\n";
		archivo_txt = archivo_txt + ObjetoTemporal.getTipo() + ";\n";
		archivo_txt = archivo_txt + ObjetoTemporal.getNombre() + "->" + ObjetoTemporal.getTipo() + ";\n";
			
		archivo_txt = archivo_txt + "raíz -> " + ObjetoTemporal.getNombre() + ";\n";
			
		indice++;
            }
		
            archivo_txt = archivo_txt + "}";
            System.out.println(archivo_txt);
	}catch(Exception e){
            System.out.println("Error al graficar");
	}
    }
    
    public void CrearArchivo(){
	try{
            File archivo = new File("C:/textoObjeto.txt");
            FileWriter escribir = new FileWriter(archivo, true);
			
            escribir.write(archivo_txt);
            escribir.close();
			
	}catch(Exception e){
            System.out.println("Error al escribir");
	}		
    }
    
    public void Dibujar(){
	try{
            String dotPath = "C:/Program Files (x86)/Graphviz2.39/bin/dot.exe";
            String fileInputPath = "C:/textoObjeto.txt";
            String fileOutputPath = "C:/imagenLista.jpg";
            String tParam = "-Tjpg";
            String tOParam = "-o";
			
            String [] cmd = new String[5];
			
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
			
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);
	}catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error al dibujar");
            System.out.println("Error al dibujar");
	}finally{
			
	}		
    }
}
