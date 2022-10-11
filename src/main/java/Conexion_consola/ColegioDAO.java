
package Conexion_consola;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ColegioDAO {
     PreparedStatement ps;
     ResultSet rs;
    Connection con;
        
    conexion acceso = new conexion();
    
    public void listar(){
    
        String sql = "Select * from alumno";
        
        try     {
            
                  con = acceso.Conectar();
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();

              while(rs.next()){
                   System.out.println("*-------------------------------*");
                    System.out.println("Id:"+" "+ rs.getInt(1));
                     System.out.println("Nombre:"+" " +rs.getString(4));
                      System.out.println("Ciudad:"+ " "+rs.getString(2));
                       System.out.println("Telefono:"+ " "+rs.getString(3));
                           
              }
        
        
    
        } catch(Exception e){
        }
    }
    
    public static void main(String[] args){
         ColegioDAO cl = new ColegioDAO();
         cl.listar();
    }
    
    
}
