/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

import static cuentas.HUB.Op;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import org.h2.jdbc.JdbcSQLException;
import static cuentas.HUB.con;
import static cuentas.HUB.Op;

/**
 *
 * @author Pawtowta
 */
public class Form_CProductos extends javax.swing.JFrame {

    /**
     * Creates new form Cargar_productos
     */
    
    int ID = 0;
    String des = "";
    int cant = 0;
    Boolean RID = false;
    String NPi = "";
    String CPi = "";
    String Model = "";
    //double cost = 0;
    DefaultTableModel TModelOne ;
    BigDecimal cost = new BigDecimal("0");
    //Operaciones Op = new Operaciones();
  // public  Conexion con = new Conexion();
   
       
    
    public Form_CProductos() {
        initComponents();
         COM_Modelo.setEnabled(false);  
         TXT_NPieza.setEnabled(false);
         TXT_CPieza.setEnabled(false);
        TModelOne = new DefaultTableModel(){
 
        @Override
        public boolean isCellEditable(int rowIndex,int columnIndex){return false;}  //modificado añadido override

        };
        
       // DefaultTableModel modelo1 =  (DefaultTableModel) JTable1.getModel();
        TModelOne.addColumn("ID");
        TModelOne.addColumn("Modelo");
        TModelOne.addColumn("Descripcion");
        TModelOne.addColumn("C.Pieza");
        TModelOne.addColumn("N.Pieza");
        TModelOne.addColumn("Cantidad");
        TModelOne.addColumn("Costo");
        
        this.JTable1.setModel(TModelOne);
        
         /*
            if(CHEC_Perforador.isSelected())
            {
              
         COM_Modelo.setEnabled(true);
            }
            */
           CHEC_Perforador.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent e) {
             if(CHEC_Perforador.isSelected())
            {   
              COM_Modelo.setEnabled(true);
              TXT_NPieza.setEnabled(true);
              TXT_CPieza.setEnabled(true);
            }else{
              COM_Modelo.setEnabled(false);  
              TXT_NPieza.setEnabled(false);
              TXT_CPieza.setEnabled(false);
             }
          }
         });
    
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Btn_Añadir = new javax.swing.JButton();
        BTN_Cancelar = new javax.swing.JButton();
        TXT_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TXT_Descripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TXT_Cantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BTN_Editar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable1 = new javax.swing.JTable();
        Btn_Aceptar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        TXTF_Costo = new javax.swing.JFormattedTextField();
        BTN_AcepEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TXT_NPieza = new javax.swing.JTextField();
        TXT_CPieza = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CHEC_Perforador = new javax.swing.JCheckBox();
        COM_Modelo = new javax.swing.JComboBox<>();

        jFormattedTextField1.setText("jFormattedTextField1");

        jFormattedTextField2.setText("jFormattedTextField2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID_Producto :");

        Btn_Añadir.setText("Añadir");
        Btn_Añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AñadirActionPerformed(evt);
            }
        });

        BTN_Cancelar.setText("Cancelar");
        BTN_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Descripcion :");

        jLabel3.setText("Cantidad :");

        TXT_Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CantidadActionPerformed(evt);
            }
        });

        jLabel4.setText("Costo");

        BTN_Editar.setText("Editar");
        BTN_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EditarActionPerformed(evt);
            }
        });

        JTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JTable1);

        Btn_Aceptar.setText("Aceptar");
        Btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AceptarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        TXTF_Costo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00;¤-#,##0.00"))));
        TXTF_Costo.setToolTipText("");
        TXTF_Costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTF_CostoActionPerformed(evt);
            }
        });

        BTN_AcepEdit.setText("Aceptar");
        BTN_AcepEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AcepEditActionPerformed(evt);
            }
        });

        jLabel5.setText("S/.");

        TXT_CPieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CPiezaActionPerformed(evt);
            }
        });

        jLabel6.setText("Modelo :");

        jLabel7.setText("C.Pieza :");

        jLabel8.setText("N.Pieza :");

        CHEC_Perforador.setText("Perforador?");
        CHEC_Perforador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CHEC_PerforadorActionPerformed(evt);
            }
        });

        COM_Modelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GBH-11", "GSH-11", "GBH-12" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BTN_Cancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_Aceptar)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_CPieza)
                            .addComponent(TXTF_Costo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXT_Cantidad)
                            .addComponent(TXT_NPieza, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TXT_ID)
                            .addComponent(TXT_Descripcion, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CHEC_Perforador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(COM_Modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_AcepEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_Editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Añadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Btn_Eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_Editar)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_AcepEdit)
                        .addGap(13, 13, 13)
                        .addComponent(CHEC_Perforador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(TXT_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_Añadir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TXT_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXT_NPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXT_CPieza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTF_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addGap(3, 3, 3)
                .addComponent(COM_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Aceptar)
                    .addComponent(BTN_Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CancelarActionPerformed
        // TODO add your handling code here:
        HUB hub = new HUB();
        hub.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_BTN_CancelarActionPerformed
   //Valida datos Numericos
   /* public Boolean validar (String dato)
    {
   
		try {
			Integer.parseInt(dato);
			return true;
		} catch (NumberFormatException nfe){		
			return false;
		}
	
        
    }*/
  
    //convierte a big decimal
    public static BigDecimal parse(final String amount) throws ParseException {
    final NumberFormat format = NumberFormat.getNumberInstance();
    if (format instanceof DecimalFormat) {
        ((DecimalFormat) format).setParseBigDecimal(true);
    }
    return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]",""));
    
}
    
    
    private void Btn_AñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AñadirActionPerformed
        // TODO add your handling code here:
        
        
      
       
        
        if(Op.Nvalid(TXT_ID.getText()) && !TXT_ID.getText().equals(""))
        {
   
        if(!TXT_Descripcion.getText().equals("") && !TXT_Cantidad.getText().equals("") && !TXTF_Costo.getText().equals("")  )        
        {
            ID = Integer.parseInt(TXT_ID.getText());
            cant = Integer.parseInt(TXT_Cantidad.getText());
            des = TXT_Descripcion.getText();
            cost = Op.parse((TXTF_Costo.getText()));
            
            if(CHEC_Perforador.isSelected())
            {
              
               
                
                NPi = TXT_NPieza.getText();
                CPi = TXT_CPieza.getText();
                
                //System.out.println(COM_Modelo.getSelectedIndex());
                ComBox();
               /* switch(COM_Modelo.getSelectedIndex())
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
                        
                                
                }*/
            
            }else{
               NPi = "0";
               CPi = "0";
               Model = "none";
            }
            
            
            BigDecimal Big = new BigDecimal("2.5");
           // System.out.println("ModoNuevo:"+Big);
           // System.out.println("ConComa:"+Op.formato(Op.parse(("8,5"))));
           // System.out.println("ConPunto:"+Op.parse(("8.5")));
            
            
           //Se busca ID repedita antes de añadir datos 
           if(JTable1.getRowCount()>0)
           {
         for (int i = 0; i < JTable1.getRowCount(); i++) {
         System.out.println("Registro número: "+i);
         System.out.println("ID: "+JTable1.getValueAt(i, 0));
         System.out.println("ID: "+ID);
       
         if(JTable1.getValueAt(i, 0).toString().equals(String.valueOf(ID)))
         {
             RID = true;
             JOptionPane.showMessageDialog(null, "ID Repetida");
             break;
         } 
         else
         {
            RID = false;
         }
        }
           }
           
         if(RID == false)
         {
          // añadir filas al Jtable
          TModelOne.addRow(new Object[]{ID,Model,des,NPi,CPi,cant,"S/"+Op.formato(cost)});
            //Limpiado de casillas
         TXT_ID.setText("");
         TXT_Descripcion.setText("");
         TXT_Cantidad.setText("");
         TXTF_Costo.setText("");
         TXT_CPieza.setText("");
         TXT_NPieza.setText("");
         Model = "";
         
         
         }
          }
        
        }
    }//GEN-LAST:event_Btn_AñadirActionPerformed

    private void TXTF_CostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTF_CostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTF_CostoActionPerformed

    private void TXT_CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CantidadActionPerformed

     
   
       
    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        // TODO add your handling code here:
        if(JTable1.getSelectedRow()>= 0 )
        {
        int Lrow ;
        Lrow = JTable1.getSelectedRow();    
        JTable1.setValueAt("",Lrow ,0);
        JTable1.setValueAt("",Lrow ,1);
        JTable1.setValueAt("",Lrow ,2);
        JTable1.setValueAt("",Lrow ,3);
        TModelOne.removeRow(Lrow); 
        
        }
        String currency="S/.444,889";  
        
      //  fort.formato(Op.parse(currency));
       // String pattern = "#,##0.00;¤-#,##0.00";
       // DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance();  
       // decimalFormat.applyPattern(pattern);
       // BigDecimal b = Op.parse(currency);
       String big = Op.formato(Op.parse(currency));
        //Op.parse(big);
        
       // System.out.println("data:"+Op.parse(big));
         //System.out.println("ConSingnos:"+big);
       
       // currency.replaceAll("[^\\d.,]","");
       // BigDecimal bigDecimalCurrency = new BigDecimal(currency);
      
        //dato = bigDecimalCurrency; 
        
       /* try {
            Number num = NumberFormat.getNumberInstance().parse(currency.replaceAll("[^\\d.,]",""));
            DecimalFormat df = new DecimalFormat();
            df.setParseBigDecimal( true );
            String cam = num.toString();
            
            dato = (BigDecimal) df.parse(cam);
           System.out.println("data:"+dato);
 
         
            
        } catch (ParseException ex) {
            Logger.getLogger(Form_CProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
       
     //  Op.parse(currency);
        
 
   
    }//GEN-LAST:event_Btn_EliminarActionPerformed
    
    public void ComBox()
    {
        switch(COM_Modelo.getSelectedIndex())
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
    
    int row ;
    String idFila,FModel,FDescrip,FNPi,FCPi,FCost,FCant;
    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        // TODO add your handling code here:
                              
      
      if(JTable1.getSelectedRow()>= 0 )
        {   
            if(CHEC_Perforador.isSelected())
            {
                row = JTable1.getSelectedRow();    
                idFila = JTable1.getValueAt(row, 0).toString();
                FModel = JTable1.getValueAt(row, 1).toString();
                FDescrip = JTable1.getValueAt(row, 2).toString();
                FNPi = JTable1.getValueAt(row, 3).toString();
                FCPi = JTable1.getValueAt(row, 4).toString();
                FCant = JTable1.getValueAt(row,5).toString();
                FCost = JTable1.getValueAt(row,6).toString();
                
                TXT_ID.setText(idFila);
                TXT_Descripcion.setText(FDescrip);
                COM_Modelo.setSelectedItem(FModel);
                TXT_NPieza.setText(FNPi);
                TXT_CPieza.setText(FCPi);
                TXT_Cantidad.setText(FCant);
                TXTF_Costo.setText(FCost);
            }else{
                row = JTable1.getSelectedRow();    
                idFila = JTable1.getValueAt(row, 0).toString();
                FDescrip = JTable1.getValueAt(row, 2).toString();
                FCant = JTable1.getValueAt(row,5).toString();
                FCost = JTable1.getValueAt(row,6).toString();
                
                TXT_ID.setText(idFila);
                TXT_Descripcion.setText(FDescrip);
                TXT_Cantidad.setText(FCant);
                TXTF_Costo.setText(FCost);
      
            }
     
     
    
     
     
     
     
        }
     //System.out.print(idFila + ":" + FDescrip+":"+FCant+":"+FCost+"--");
    }//GEN-LAST:event_BTN_EditarActionPerformed

    private void BTN_AcepEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AcepEditActionPerformed
        // TODO add your handling code here:
       // int rowIndex = JTable1.getSelectedRow();
       // int colIndex = JTable1.getSelectedColumn();
      //  System.out.print(rowIndex+":"+colIndex+"--");
      
      //Setea el JTable con nuevos valores de los TextFields
       if(Op.Nvalid(TXT_ID.getText()) && !TXT_ID.getText().equals(""))
        {
   
        if(!TXT_Descripcion.getText().equals("") && !TXT_Cantidad.getText().equals("") && !TXTF_Costo.getText().equals("")  )        
        {
            if(CHEC_Perforador.isSelected())
            {
        JTable1.setValueAt(TXT_ID.getText(),row ,0);
        ComBox();
        JTable1.setValueAt(Model,row ,1);
        JTable1.setValueAt(TXT_Descripcion.getText(),row ,2);
        JTable1.setValueAt(TXT_CPieza.getText(),row ,3);
        JTable1.setValueAt(TXT_NPieza.getText(),row ,4);
        JTable1.setValueAt(TXT_Cantidad.getText(),row ,5);
        JTable1.setValueAt(TXTF_Costo.getText(),row ,6);
        
         TXT_ID.setText("");
         TXT_Descripcion.setText("");
         TXT_Cantidad.setText("");
         TXTF_Costo.setText("");
         TXT_CPieza.setText("");
         TXT_NPieza.setText("");
         Model = "";
            }else{
        JTable1.setValueAt(TXT_ID.getText(),row ,0);
        //JTable1.setValueAt(Model,row ,1);
        Model = "";  
        JTable1.setValueAt(TXT_Descripcion.getText(),row ,2);
        JTable1.setValueAt(TXT_Cantidad.getText(),row ,5);
        JTable1.setValueAt(TXTF_Costo.getText(),row ,6);
        
        TXT_ID.setText("");
         TXT_Descripcion.setText("");
         TXT_Cantidad.setText("");
         TXTF_Costo.setText("");
         TXT_CPieza.setText("");
         TXT_NPieza.setText("");
         Model = "";    
            }
         // System.out.println("ConSingnos:"+TXTF_Costo.getText());
         }
        }
    }//GEN-LAST:event_BTN_AcepEditActionPerformed
   
   
    

    private void Btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AceptarActionPerformed
// TODO add your handling code here:
        /* saca datos de tabla
        for (int i = 0; i < JTable1.getRowCount(); i++) {
        System.out.println("Registro número: "+i);
        System.out.println("ID: "+JTable1.getValueAt(i, 0));
        System.out.println("NOMBRE: "+JTable1.getValueAt(i, 1));
        System.out.println("TELÉFONO: "+JTable1.getValueAt(i, 2));
        System.out.println("TELÉFONO: "+JTable1.getValueAt(i, 3));
        }
         */
    
           
  //Manda datos
     for (int i = 0; i < JTable1.getRowCount(); i++) {
             int d1 = Integer.valueOf( JTable1.getValueAt(i, 0).toString());
             String d2 = JTable1.getValueAt(i, 1).toString();
             String d3 = JTable1.getValueAt(i, 2).toString();
             int d4 = Integer.valueOf(JTable1.getValueAt(i, 3).toString());
             int d5 = Integer.valueOf(JTable1.getValueAt(i, 4).toString());
             int d6 = Integer.valueOf(JTable1.getValueAt(i, 5).toString());
             BigDecimal d7 = Op.parse(JTable1.getValueAt(i, 6).toString());
          //   BigDecimal d4 = Op.parse(JTable1.getValueAt(i, 3).toString().replaceAll("S/",""));//Reemplaza el signo soles para q no salga error en parse
             
             
            // System.out.println("convercion:"+d4);
             
         try {
             con.InsertDataP(d1, d2, d3, d4, d5, d6, d7, 1);
         } catch (SQLException ex) {
                  System.err.println("Error_mandar_datos: "+ex);
         }
       
         System.out.println("ID: "+ d1);
         System.out.println("NOMBRE: "+d2);
         System.out.println("cantidad: "+d3);
         System.out.println("cost: "+d4);
        }
         
 
    }//GEN-LAST:event_Btn_AceptarActionPerformed

    private void TXT_CPiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CPiezaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CPiezaActionPerformed

    private void CHEC_PerforadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CHEC_PerforadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CHEC_PerforadorActionPerformed


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
            java.util.logging.Logger.getLogger(Form_CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_CProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_CProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_AcepEdit;
    private javax.swing.JButton BTN_Cancelar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton Btn_Aceptar;
    private javax.swing.JButton Btn_Añadir;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JCheckBox CHEC_Perforador;
    private javax.swing.JComboBox<String> COM_Modelo;
    private javax.swing.JTable JTable1;
    private javax.swing.JFormattedTextField TXTF_Costo;
    private javax.swing.JTextField TXT_CPieza;
    private javax.swing.JTextField TXT_Cantidad;
    private javax.swing.JTextField TXT_Descripcion;
    private javax.swing.JTextField TXT_ID;
    private javax.swing.JTextField TXT_NPieza;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}