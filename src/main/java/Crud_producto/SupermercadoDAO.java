
package Crud_producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Usuario
 */public class SupermercadoDAO {
      PreparedStatement ps;
     ResultSet rs;
    Connection con;
        
    Conexion acceso = new Conexion();
     public void consulta(){
    
        String sql = "Select * from producto";
        
        try     {
            
                  con = acceso.Conectar();
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();

              while(rs.next()){
                   System.out.println("*-------------------------------*");
                    System.out.println("Id:"+" "+ rs.getInt(1));
                     System.out.println("Nombre:"+" " +rs.getString(2));
                      System.out.println("Cantidad:"+ " "+rs.getInt(3));
                       System.out.println("Lugar:"+ " "+rs.getString(4));
                       System.out.println("Fecha:"+ " "+rs.getString(5));    
              }
        
        
    
        } catch(Exception e){
        }
    }
    
    public void ingresar(int id,String nombre , int cantidad  , String lugar ,String fecha){
        
      String sql = "insert into producto (id,nombre,cantidad,lugar,fecha)Values (?,?,?,?,?)";
      try {
          con = acceso.Conectar();
          ps = con.prepareStatement(sql);
          ps.setInt(1, id);
          ps.setString(2,nombre);
          ps.setInt(3,cantidad);
          ps.setString(4,lugar);
          ps.setString(5,fecha);
          ps.executeUpdate();
      } catch(Exception e){      
      }
    
    }
    
    public void modificar(int id,String nombre ,int cantidad , String lugar ,String fecha){
    
            String sql = "update producto set nombre=?,cantidad=?,lugar=?,fecha=? where id=?; ";  
            try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setString(2, nombre );
            ps.setInt(3, cantidad );
            ps.setString(4, lugar );
             ps.setString(5, fecha );
            ps.executeUpdate();
            
            
            } catch (Exception e){
                    }  
        
    }
    
    public void eliminar(int id){
        String sql = "delete from producto where id=? "+id+";";
        try {
       con = acceso.Conectar();
       ps = con.prepareStatement(sql);
        ps.executeUpdate();
        }catch (Exception e) {
        }
    
    }
        
    
}
