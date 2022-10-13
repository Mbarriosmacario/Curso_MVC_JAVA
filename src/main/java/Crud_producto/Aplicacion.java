
package Crud_producto;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Aplicacion {
    SupermercadoDAO cl = new SupermercadoDAO();
            Scanner sn = new Scanner(System.in);
            
          public  void main( ){
          //  boolean salir = false ;
       int opcion; 
     
            System.out.println("*-----------*----------*-------*-------*------*-");
            System.out.println("*-----------*---Supermercado M ---*------*--------");
            System.out.println("*-----------*----------*-------*-------*------*---");
            System.out.println(" Consulte Productos (Digite:1)");
            System.out.println("Ingrese Productos(Digite:2)");
            System.out.println("Actualize los Productos(Digite:3)");
            System.out.println("Elimine Producto (Digite:4)");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                       
                        System.out.println("Has seleccionado la opcion 1");
                         System.out.println("-*******--***********-LISTA PRODUCTOS--********------");
                         cl.consulta();
                        
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                         System.out.println("-*******--***********-INGRESAR PRODUCTOS--********------");
                         System.out.println("Ingresa el id");
                          int id = sn.nextInt();
                          sn.nextLine();
                          
                         System.out.println("Ingresa el nombre");
                          String nombre = sn.nextLine();
                         System.out.println("Ingresa el cantidad");
                         int can = sn.nextInt();
                        System.out.println("Ingresa el lugar");
                         String lugar = sn.nextLine();
                        System.out.println("Ingresa el fecha");
                        String fech_ = sn.nextLine();
                        cl.ingresar(id, nombre, can, lugar, fech_);
                       break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        System.out.println("-*******--***********-MODIFICAR PRODUCTOS--********------");
                        cl.consulta();
                        System.out.println("-*******--***********-Elija un id--********------");
                        int cod = sn.nextInt();
                        sn.nextLine();
                                              
                         System.out.println("Ingresa el nombre");
                          String name = sn.nextLine();
                         System.out.println("Ingresa el cantidad");
                         int can_ti = sn.nextInt();
                         sn.nextLine();
                        System.out.println("Ingresa el lugar");
                         String code = sn.nextLine();
                        System.out.println("Ingresa el fecha");
                         String fecha_ = sn.nextLine();
                        cl.modificar(id, nombre, can_ti, lugar, fecha_);
                        
                        
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 3");
                        System.out.println("-*******--***********-ELIMINAR PRODUCTOS--********------");
                        cl.consulta();
                        System.out.println("-*******--***********-Ingrese el id que quiere eliminar--********------");
                         int codigo = sn.nextInt();
                                               
                         cl.eliminar(id);
                         
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
 
    }
  