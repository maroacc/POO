//Aplicacion de una agenda en conosla
//muestra el siguiente menú al usuario:
//1.Crear Persona
//2.Buscar Persona
//3.Eliminar persona
//4.Modificar Persona
//5.Mostrar lista
//9.Salir

package Practica5.ui;

import Practica5.util.Leer;
import Practica5.dominio.Persona;

public class App
{
  //Atributos de clase persona para ser leidos por teclado
  String nombre;
  int edad;
  String NIF;
  Persona personas[] = new Persona[10];

  public static void main(String args[])
  { //Opcion del menu a introducir por teclado:
    String opcion;
    //Instancia de la clase leer para poder leer por tecldo
    Leer leer;



    //Mostrar el menu por pantalla
    System.out.println("##################################");
    System.out.println("#####         AGENDA         #####");
    System.out.println("##################################");
    System.out.println("####   1. CREAR PERSONA      #####");
    System.out.println("#####  2. BUSCAR PERSONA     #####");
    System.out.println("#####  3. ELIMINAR PERSONA   #####");
    System.out.println("#####  4. MODIFICAR PERSONA  #####");
    System.out.println("#####  5. MOSTRAR LISTA      #####");
    System.out.println("##################################");
    System.out.println("#####  9. SALIR              #####");

    //Leer la opcion del menu seleccionada
    opcion = Leer.porTeclado();

       switch (opcion) {
           case "1":
                       for(int i=0;i<personas.length;i++)
                         if(personas[i]==null)
                         {
                            personas[i] = crearPersona;
                            i=personas.length;
                         }
                    break;
           case "2":
                    break;
           case "3":
                    break;
           case "4":
                    break;
           case "5":
                    break;
           case "6":
                    break;

           default: System.out.println("Opcion invalida");
                    break;
       }
  }

  public Persona crearPersona()
  {   System.out.println("Nombre: ");
      nombre = Leer.porTeclado();
      System.out.println("Edad: ");
      edad   = Integer.parseInt(Leer.porTeclado());
      System.out.println("NIF: ");
      NIF    = Leer.porTeclado();

      Persona persona = new Persona(nombre, edad, NIF);
      return Persona;
  }


}
