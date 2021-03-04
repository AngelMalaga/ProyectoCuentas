/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pawtowta
 */
public class Operaciones {
    
    private BigDecimal dato = new BigDecimal("0");
    public BigDecimal parse(String data)
    {
        //Dato test
       // String currency="S/.444,8";  
        
        
         
         try {
           // Number num = NumberFormat.getNumberInstance().parse(data.replaceAll("[^\\d.,]","")); // se convierte a number format y se eliminan comas
          
           DecimalFormat df = new DecimalFormat();
            df.setParseBigDecimal( true );
           // String cam = num.toString(); // se convierte a string el NumberFormat
            
           // dato = (BigDecimal) df.parse(cam); // forma anterior
            dato = (BigDecimal) df.parse(data.replaceAll("S/","")); // nueva forma
            
           //System.out.println("data:"+dato);
 
         
            
        } catch (ParseException ex) {
            Logger.getLogger(Form_CProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dato;
        
        
        
    }
    
    public String formato(BigDecimal data)
    {
        String pattern = "#,##0.00;¤-#,##0.00"; 
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance();  
        decimalFormat.applyPattern(pattern);
        String Pdata = decimalFormat.format(data);
         return Pdata;
        
    }
    
     public String FSoles(BigDecimal data)
    {
        String pattern = "¤#,##0.00;¤-#,##0.00"; 
        DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getNumberInstance();  
        decimalFormat.applyPattern(pattern);
        String Pdata = decimalFormat.format(data);
         return Pdata;
        
    }
     
     public Boolean Nvalid (String dato)
    {
   
		try {
			Integer.parseInt(dato);
			return true;
		} catch (NumberFormatException nfe){		
			return false;
		}
	
        
    }
     
     public BigDecimal ConIgv(BigDecimal data)
     {
         
        return null;
         
     }
     
     public BigDecimal SinIgv(BigDecimal data)
     {
         
         return null;
     }
    
}
