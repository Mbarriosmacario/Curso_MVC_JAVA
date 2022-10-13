
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
                    System.out.println("codigo:"+" "+ rs.getInt(1));
                     System.out.println("Nombre:"+" " +rs.getString(4));
                      System.out.println("Ciudad:"+ " "+rs.getString(2));
                       System.out.println("Telefono:"+ " "+rs.getString(3));
                           
              }
        
        
    
        } catch(Exception e){
        }
    }
    
    public void crear(int codigo,String nombre ,String Ciudad , String Telefono){
        
      String sql = "insert into alumno (codigo,nombre,Ciudad,Telefono)Values (?,?,?,?)";
      try {
          con = acceso.Conectar();
          ps = con.prepareStatement(sql);
          ps.setInt(1, codigo);
          ps.setString(4,nombre);
          ps.setString(2,Ciudad);
          ps.setString(3,Telefono);
          ps.executeUpdate();
      } catch(Exception e){      
      }
    
    }
    
    public void modificar(int codigo,String nombre ,String Ciudad , String Telefono){
    
            String sql = "update alumno set nombre=?,Ciudad=?,Telefono=? where codigo=?; ";  
            try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(4, nombre );
            ps.setString(2, Ciudad );
            ps.setString(3, Telefono );
            ps.executeUpdate();
            
            
            } catch (Exception e){
                    }  
        
    }
    
    public void eliminar(int codigo){
        String sql = "delete from alumno where codigo=? "+codigo+";";
        try {
       con = acceso.Conectar();
       ps = con.prepareStatement(sql);
        ps.executeUpdate();
        }catch (Exception e) {
        }
    
    }
    
    public static void main(String[] args){
         ColegioDAO cl = new ColegioDAO();      
         cl.listar();
         //System.out.println("*----------*-------------*--------*");
         //cl.modificar(2,"Luis","Peten","45896378");
        //   cl.crear(3, "Maria", "Guatemala", "45896378"); 
        //cl.listar();
         System.out.println("*----------*-------------*--------*");
         cl.eliminar(2);
         cl.listar();
         
         
    }
    
    
}
