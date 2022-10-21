
package Crud_producto;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author Usuario
 */public class SupermercadoDAO {
      PreparedStatement ps;
     ResultSet rs;
    Connection con;
        
    Conexion acceso = new Conexion();
     public ArrayList<producto> consulta(){
    
        String sql = "Select * from producto";
        
        try     {
            
                  con = acceso.Conectar();
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();
                  ArrayList<producto> datos = new ArrayList<producto>();
                  

              while(rs.next()){
                  producto cel = new producto();
                  cel.setCodigo(rs.getInt(1));
                  cel.setNombre(rs.getString(2));
                  cel.setCantidad(rs.getInt(3));
                  cel.setLugar(rs.getString(4));
                  cel.setFecha(rs.getString(5));
                 datos.add(cel);
                                            
              }
            return datos;
    
        } catch(Exception e){
            
        }
        return null;
       
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
    
    public void buscar(int id){
    
    String sql = "Select * from productos where id = "+id;
      try{
      con = acceso.Conectar();
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();
      if (rs.next()){
        Modificar_java mv = new Modificar_java();
        mv.modificar_vista(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
        mv.setVisible(true);
        
      
      }
      }catch (Exception e) {
        }
    }
    public void buscar1(int id){
    
    String sql = "Select * from productos where id = "+id;
      try{
      con = acceso.Conectar();
                  ps = con.prepareStatement(sql);
                  rs = ps.executeQuery();
      if (rs.next()){
        Eliminar_java lim = new Eliminar_java();
        lim.t_cod.setText(rs.getInt(1)+"");  
        lim.t_nombre.setText(rs.getString(2));  
        lim.t_can.setText(rs.getInt(3)+"");  
        lim.t_lu.setText( rs.getString(4)); 
        lim.t_fe.setText(rs.getString(5));
        lim.setVisible(true);
        
      
      }
      }catch (Exception e) {
        }
    }
    
    
   public static void  main(String[] args){
    SupermercadoDAO dl = new SupermercadoDAO();
    dl.consulta();
    
    
    }
        
    
}
