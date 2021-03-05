/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuentas;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.h2.jdbc.JdbcSQLException;


public class Conexion {

    
    public static final int DUPLICATE_KEY_1 = 23505 ;
    
    Connection con = conectar();
    public Connection conectar(){
        Connection con = null;
        try{
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:C:\\Users\\User\\Desktop\\DataBase\\Facturas","Angel","");
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error1 "+ex);
        }
        return con;
    }
    
    
    
    public ResultSet consultar(String data, String data1, String data2)  //consultar datos
    {
        
        String consultar = "";
       // String ID = "ID_PRODUCTO";
       // String NAME = "DESCRIPCION";
       // String Pi = "NPIEZA"; 
        //Connection con = conectar();
        ResultSet rs = null;
       
        switch(data)
        {
            case "P":
                consultar = "select * from PRODUCTO ";            
                break;
                
            case "PBN":
                consultar = "select * from PRODUCTO WHERE DESCRIPCION LIKE '%"+data1+"%'";            
                break;
                
            case "PBP":
                consultar = "select * from PRODUCTO WHERE NPIEZA LIKE '%"+data1+"%'";            
                break;    
            
            case "PBID":
                consultar = "select * from PRODUCTO WHERE ID_PRODUCTO LIKE '%"+data1+"%'";            
                break;
                
             case "PBC": 
    
                int Ndata = Integer.parseInt(data1); 
                
                consultar = "select * from PRODUCTO WHERE CPIEZA = '"+Ndata+"' AND TMODELO = '"+data2+"'";    
                 
                break;   
                
 
                
            case "C":
                consultar = "select * from CLIENTE ";
                break;
                
            case "CB":
                consultar = "select * from CLIENTE ";
                break;
                
            case "F":
                consultar = "select * from FACTURA ";
                break;
                
            case "FB":
                consultar = "select * from FACTURA ";
                break;    
    
        }
        
        try{
            PreparedStatement ps =con.prepareStatement(consultar);
            rs = ps.executeQuery();
            
        }catch(Exception ex){
            System.err.println("Error_de_consulta: "+ex);
        }finally{
            try{
            }catch(Exception ex){
            }
        }
        
        return rs;
    }
    /*
    public ResultSet Insertar() //insertar datos
    {
        //Ejemplo de mandar datos
        Connection con = conectar();
        try{
        
        PreparedStatement    stmt = con.prepareStatement("INSERT INTO libros VALUES (?,?,?,?,?)");
        stmt.setString(1,"da");
        stmt.setInt(2,2);
        stmt.setString(3,"da2");
        stmt.setString(4,"da3");
        stmt.setString(5,"da4");
        stmt.executeUpdate();
        }
        
        catch(Exception ex)
        {
            System.err.println("ErrorInsertar "+ex);
        }
        
        return null; 
    }
    */
    
    public ResultSet InsertDataP(int IDData, String mod, String des,int CPi,int NPi,int cant, BigDecimal cost, int data3) throws SQLException
    {
        //Manda datos String
        Connection con = conectar();
        
       switch(data3)
       {
           case 1:
                try{
                 
                    PreparedStatement    stmt = con.prepareStatement("INSERT INTO PRODUCTO  VALUES (?,?,?,?,?,?,?)");
                    stmt.setInt(1,IDData);
                    stmt.setString(2,mod);
                    stmt.setString(3,des);
                    stmt.setInt(4,CPi);
                    stmt.setInt(5,NPi);
                    stmt.setInt(6,cant);
                    stmt.setBigDecimal(7, cost);
                   
                    
                    
                    stmt.executeUpdate();
        }
        
        catch(JdbcSQLException ex)
        {
              String msg = "Advertencia";
              String msg2 = "";
                if (DUPLICATE_KEY_1 == ex.getErrorCode ()) {
                    // manejar la excepcion de la manera que corresponda segun la logica de negocio, posiblemente agregando un mensaje de error; tambien se
                    // podria levantar la excepcion a una capa superior mediante "throw e";
                    msg = "El registro ya se encuentra en la base de datos";
                    msg2 = "ID repetida";
                }
                JOptionPane.showMessageDialog(null, msg, msg2, JOptionPane.PLAIN_MESSAGE);
            System.err.println("ErrorInsertar "+ex.getErrorCode());
        }
      
               break;
               
           case 2:
                   
                   
               break;
                   
       }
       
       
        /*try{
        
        PreparedStatement    stmt = con.prepareStatement("INSERT INTO libros VALUES (?,?,?,?,?)");
        stmt.setString(1,"da");
        stmt.setInt(2,2);
        stmt.setString(3,"da2");
        stmt.setString(4,"da3");
        stmt.setString(5,"da4");
        stmt.executeUpdate();
        }
        
        catch(Exception ex)
        {
            System.err.println("ErrorInsertar "+ex);
        }
        */
        return null; 
    }
    
    public ResultSet InsertDataF(int IDCliente, String NFactura, String NCliente ,int RUC,Date Date,int IDP, BigDecimal cost) throws SQLException
    {
        //Manda datos String
        Connection con = conectar();
       
       
                try{
                 
                    PreparedStatement    stmt = con.prepareStatement("INSERT INTO FACTURA  VALUES (?,?,?,?,?,?,?)");
                    stmt.setInt(1,IDCliente);
                    stmt.setString(2,NFactura);
                    stmt.setString(3,NCliente);
                    stmt.setInt(4,RUC);
                    stmt.setDate(5,Date);
                    stmt.setInt(6,IDP);
                    stmt.setBigDecimal(7, cost);
                   
                    
                    
                    stmt.executeUpdate();
        }
        
        catch(JdbcSQLException ex)
        {
              String msg = "Advertencia";
              String msg2 = "";
                if (DUPLICATE_KEY_1 == ex.getErrorCode ()) {
                    // manejar la excepcion de la manera que corresponda segun la logica de negocio, posiblemente agregando un mensaje de error; tambien se
                    // podria levantar la excepcion a una capa superior mediante "throw e";
                    msg = "El registro ya se encuentra en la base de datos";
                    msg2 = "ID repetida";
                }
                JOptionPane.showMessageDialog(null, msg, msg2, JOptionPane.PLAIN_MESSAGE);
            System.err.println("ErrorInsertar "+ex.getErrorCode());
        }
      
       
       
       
        /*try{
        
        PreparedStatement    stmt = con.prepareStatement("INSERT INTO libros VALUES (?,?,?,?,?)");
        stmt.setString(1,"da");
        stmt.setInt(2,2);
        stmt.setString(3,"da2");
        stmt.setString(4,"da3");
        stmt.setString(5,"da4");
        stmt.executeUpdate();
        }
        
        catch(Exception ex)
        {
            System.err.println("ErrorInsertar "+ex);
        }
        */
        return null; 
    }
    
    
    
    public static void main(String[] args) {
      //Conexion con = new Conexion();
     // Connection con = conectar();
        //ResultSet rs = con.consultar();
       /* 
        try{
            while(rs.next()){
        JOptionPane.showMessageDialog(null, rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
       */
    }
   
    
}