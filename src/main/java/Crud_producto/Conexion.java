
package Crud_producto;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/Supermercado";
    String user="root";
    String pass="12345678";
    public Connection Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
           
        } catch (Exception e) {
            System.out.println("error:");
            System.out.println(e);
        }      
        return con;  
    }
  public static void main(String[] args) {
           Conexion sp = new Conexion();
           System.out.println(sp.Conectar());
  
  }
}
