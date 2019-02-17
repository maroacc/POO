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
import Practica5.negocio.Agenda;


public class App
{
  //Atributos de clase persona para ser leidos por teclado
  String nombre;
  int edad;
  String NIF;

  public static void main(String args[])
  { //Opcion del menu a introducir por teclado:
    String opcion;
    Agenda agenda1;

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
                    this.crearPersona();
                    break;
           case "2":
                    this.buscarPersona();
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

  public Persona leerDatosPersona()
    {

  }

  public void crearPersona()
  {   //Lectura de los atributos de persona
      System.out.println("Introduzca los datos sobre la persona a crear: ");
      System.out.println("Nombre: ");
      nombre = Leer.porTeclado();
      System.out.println("Edad: ");
      edad   = Integer.parseInt(Leer.porTeclado());
      System.out.println("NIF: ");
      NIF    = Leer.porTeclado();

      //Instancia de persona
      Persona persona = new Persona(nombre, edad, NIF);

      //Agregar la persona a la agenda
      agenda1.crearPersona(persona);
  }
 public void buscarPersona()
 {   //Lectura del NIF de la persona a buscar
     System.out.println("Introduzca el NIF de la persona que desea buscar: ");
     System.out.println("NIF: ");
     NIF    = Leer.porTeclado();

     //Buscar la persona en la agenda
     agenda1.buscarPersona();
 }

}
