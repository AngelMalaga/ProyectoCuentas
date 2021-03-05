/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

//import com.sun.tools.javac.util.ArrayUtils;
import static cuentas.HUB.con;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pawtowta
 */
public class F_Añadir extends javax.swing.JFrame {

    /**
     * Creates new form F_Añadir
     */
    DefaultTableModel modelo1 ;
    Operaciones Op = new Operaciones();
   
    String data = "";
    String tipo = "";
    String Model = "";
    Boolean mode = false;
    String[] Cdato ;

    public F_Añadir() {
        initComponents();
        TXT_Buscar.setEnabled(false);
        TXT_Cantidad.setEnabled(false);
        ResultSet reult = con.consultar("P","none","");
        COM_BModel.setEnabled(false);
        modelo1 = new DefaultTableModel(){
              

        @Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}  //modificado añadido override

        };
       
        modelo1.addColumn("ID");
        modelo1.addColumn("Modelo");
        modelo1.addColumn("Descripcion");
        modelo1.addColumn("C.Pieza");
        modelo1.addColumn("N.Pieza");
        modelo1.addColumn("Cantidad");
        modelo1.addColumn("Costo");
        
        
        this.JTable3.setModel(modelo1);
        
        
         
       
        
        CHEC_Name.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent e) {
             if(CHEC_Name.isSelected())
            {   
              CHEC_Id.setEnabled(false);
              CHEC_Lista.setEnabled(false);  
              CHEC_NPi.setEnabled(false);  
              TXT_Buscar.setEnabled(true);
              TXT_Cantidad.setEnabled(true);
              tipo = "PBN";
             
            }else{
             
              CHEC_Id.setEnabled(true);
              CHEC_Lista.setEnabled(true);  
              CHEC_NPi.setEnabled(true);  
              TXT_Buscar.setEnabled(false);
              TXT_Cantidad.setEnabled(false);
              
             }
          }
         });
        
         CHEC_Id.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent e) {
             if(CHEC_Id.isSelected())
            {   
              CHEC_Name.setEnabled(false);
              CHEC_Lista.setEnabled(false);  
              CHEC_NPi.setEnabled(false);  
              TXT_Buscar.setEnabled(true);
              TXT_Cantidad.setEnabled(true);
              tipo = "PBID";
             
            }else{
              CHEC_Name.setEnabled(true);
              CHEC_Lista.setEnabled(true);  
              CHEC_NPi.setEnabled(true);  
              TXT_Buscar.setEnabled(false);
              TXT_Cantidad.setEnabled(false);
              
             }
          }
         });
         
          CHEC_Lista.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent e) {
             if(CHEC_Lista.isSelected())
            {   
              CHEC_Id.setEnabled(false);
              CHEC_Name.setEnabled(false);  
              CHEC_NPi.setEnabled(false);  
              TXT_Buscar.setEnabled(true);
              COM_BModel.setEnabled(true);
              TXT_Cantidad.setEnabled(true);
              mode = true;
              tipo = "PBC";
             
            }else{
              CHEC_Id.setEnabled(true);
              CHEC_Name.setEnabled(true);  
              CHEC_NPi.setEnabled(true);  
              TXT_Buscar.setEnabled(false);
              COM_BModel.setEnabled(false);
              TXT_Cantidad.setEnabled(false);
              mode = false;
              
             }
          }
         });
          
           CHEC_NPi.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent e) {
             if(CHEC_NPi.isSelected())
            {   
              CHEC_Id.setEnabled(false);
              CHEC_Lista.setEnabled(false);  
              CHEC_Name.setEnabled(false);  
              TXT_Buscar.setEnabled(true);
              TXT_Cantidad.setEnabled(true);
              tipo = "PBP";
             
            }else{
              CHEC_Id.setEnabled(true);
              CHEC_Lista.setEnabled(true);  
              CHEC_Name.setEnabled(true);  
              TXT_Buscar.setEnabled(false);
              TXT_Cantidad.setEnabled(false);
              
             }
          }
         });
           
           mostrar(reult);
           /*
            try {
            while (reult.next())
            {
                System.out.println (reult.getInt (1) + " ");
                
                modelo1.addRow(new Object[]{reult.getInt (1),reult.getString(2),reult.getString(3),reult.getInt(4),reult.getInt(5),reult.getInt(6),"S/"+Op.formato(reult.getBigDecimal(7))});
                //Op.formato(Op.parse((reult.getString(4))))
                
              //   System.out.print("ConComa:" +Op.formato(Op.parse((reult.getString(4))))); 
              //   System.out.print("ConComa2:" +reult.getBigDecimal(4)); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Form_añadir.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    
     public void ComBox()
    {
        switch(COM_BModel.getSelectedIndex())
                {
                    case 0:
                        Model = "GBH-11"; 
                        break;
                        
                    case 1:
                        Model = "GSH-11";
                        break;
                        
                    case 2:
                        Model = "GBH-12";
                        break;
                        
                                
                }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTable3 = new javax.swing.JTable();
        BTN_Cancelar = new javax.swing.JButton();
        BTN_Aceptar = new javax.swing.JButton();
        TXT_Buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        CHEC_Lista = new javax.swing.JCheckBox();
        CHEC_Id = new javax.swing.JCheckBox();
        CHEC_NPi = new javax.swing.JCheckBox();
        CHEC_Name = new javax.swing.JCheckBox();
        COM_BModel = new javax.swing.JComboBox<>();
        TXT_Cantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTable3);

        BTN_Cancelar.setText("Cancelar");
        BTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CancelarActionPerformed(evt);
            }
        });

        BTN_Aceptar.setText("Aceptar");
        BTN_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AceptarActionPerformed(evt);
            }
        });

        TXT_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("BUSCAR :");

        CHEC_Lista.setText("En lista");

        CHEC_Id.setText("Por ID");

        CHEC_NPi.setText("Por N.pieza");

        CHEC_Name.setText("Por nombre");
        CHEC_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CHEC_NameMouseClicked(evt);
            }
        });

        COM_BModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GBH-11", "GSH-11", "GBH-12" }));

        TXT_Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_CantidadKeyReleased(evt);
            }
        });

        jLabel2.setText("Cantidad:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_Cancelar)
                        .addGap(379, 379, 379)
                        .addComponent(BTN_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(TXT_Cantidad))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CHEC_Lista)
                            .addComponent(CHEC_Id)
                            .addComponent(COM_BModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CHEC_Name)
                            .addComponent(CHEC_NPi))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(CHEC_Lista)
                    .addComponent(CHEC_NPi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CHEC_Id)
                    .addComponent(CHEC_Name)
                    .addComponent(TXT_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(COM_BModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Cancelar)
                    .addComponent(BTN_Aceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     //Form_añadir FADD = new Form_añadir(); //USAR HERENCIAS Y STATIC
    private void BTN_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AceptarActionPerformed
        // TODO add your handling code here:
        
     
          int row = JTable3.getSelectedRow(); 
         // System.out.println(JTable3.getRowCount());
          
     if(!TXT_Cantidad.getText().isEmpty()) 
     {
      if(CHEC_Lista.isSelected())
        {       
            //System.out.println(JTable3.getRowCount());
        
            
          for(int i = 0;i < JTable3.getRowCount();i++)
         {
            int cod = Integer.parseInt(JTable3.getValueAt(i, 0).toString());
            String Model = JTable3.getValueAt(i, 1).toString();
            String des = JTable3.getValueAt(i, 2).toString();
            String NPi = JTable3.getValueAt(i, 4).toString();
            BigDecimal cost = Op.parse(JTable3.getValueAt(i, 6).toString());
            Form_añadir.Add(cod, des, cost, Cdato[i], Model, NPi);
         }
          
          
          }else
         
            if(JTable3.getSelectedRow()>= 0 )
           {
           
          int cod = Integer.parseInt(JTable3.getValueAt(row, 0).toString());
          String Model = JTable3.getValueAt(row, 1).toString();
          String des = JTable3.getValueAt(row, 2).toString();
          String NPi = JTable3.getValueAt(row, 4).toString();
          BigDecimal cost =  Op.parse(JTable3.getValueAt(row, 6).toString());
          Form_añadir.Add(cod, des, cost,Cdato[0], Model, NPi);
        
          
           }
        //this.setVisible(false);
     }else{
         JOptionPane.showMessageDialog(null, "Indicar una cantidad de producto");
     }  
    }//GEN-LAST:event_BTN_AceptarActionPerformed
   
    public void ClearArray()
    {
         for(int i = 0;i < JTable3.getRowCount();i++)
         {
              
         }
    }

    private void BTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_BTN_CancelarActionPerformed

    private void CHEC_NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CHEC_NameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CHEC_NameMouseClicked
     
    public void mostrar(ResultSet data)
    {
        
        try {
            while (data.next())
            {
               // System.out.println (data.getInt (1) + " ");
                
                modelo1.addRow(new Object[]{data.getInt (1),data.getString(2),data.getString(3),data.getInt(4),data.getInt(5),data.getInt(6),"S/"+Op.formato(data.getBigDecimal(7))});
                //Op.formato(Op.parse((reult.getString(4))))
                
              //   System.out.print("ConComa:" +Op.formato(Op.parse((reult.getString(4))))); 
              //   System.out.print("ConComa2:" +reult.getBigDecimal(4)); 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Form_añadir.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    // DETECTA AL APRETAR UNA TECLA ***************************************************
    private void TXT_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarKeyReleased
        // TODO add your handling code here:
        if(mode == true )
        {
            String in = TXT_Buscar.getText();
             if(!in.isEmpty())
                 {
                   ComBox();
                   modelo1.setRowCount(0);
                // String in = TXT_Buscar.getText();
                   String[] dato = in.split(",");
         
                      for(int i = 0; i < dato.length;i++)
                       {
                       // System.out.println(dato[i]);
                        //modelo1.setRowCount(0);
                           if( !in.isEmpty() && Op.Nvalid(dato[i]) == false){
                           JOptionPane.showMessageDialog(null, "El valor no es numerico");
                           //TXT_Buscar.setText("");
                           }else{
                           
                        ResultSet result = con.consultar(tipo,dato[i],Model);
                        mostrar(result); 
                           }
                       }
                  }
        
         
        
        }else{
         modelo1.setRowCount(0);
         ResultSet result = con.consultar(tipo,TXT_Buscar.getText(),"");
         mostrar(result); 
        }
        
        
    }//GEN-LAST:event_TXT_BuscarKeyReleased
 
    private void TXT_CantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_CantidadKeyReleased
        // TODO add your handling code here:
         String ib = TXT_Cantidad.getText();
         String[] dato = ib.split("-");
       
         
          for(int i = 0; i < dato.length;i++)
                       {
                       // System.out.println(dato[i]);
                        //modelo1.setRowCount(0);
                           if( !ib.isEmpty() && Op.Nvalid(dato[i]) == false){
                           JOptionPane.showMessageDialog(null, "El valor no es numerico");
                           TXT_Cantidad.setText("");
                           }else{
                               Cdato=dato;
                           }
                       }
         
    }//GEN-LAST:event_TXT_CantidadKeyReleased

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
            java.util.logging.Logger.getLogger(F_Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Añadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new F_Añadir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Aceptar;
    private javax.swing.JButton BTN_Cancelar;
    private javax.swing.JCheckBox CHEC_Id;
    private javax.swing.JCheckBox CHEC_Lista;
    private javax.swing.JCheckBox CHEC_NPi;
    private javax.swing.JCheckBox CHEC_Name;
    private javax.swing.JComboBox<String> COM_BModel;
    private javax.swing.JTable JTable3;
    private javax.swing.JTextField TXT_Buscar;
    private javax.swing.JTextField TXT_Cantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
