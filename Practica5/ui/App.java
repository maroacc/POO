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
  public static void main(String args[])
  { //Opcion del menu a introducir por teclado:
    String opcion;
    //posicion de la agenda
    int posicion;
    //Atributos de clase persona para ser leidos por teclado
    String nombre;
    int edad;
    String NIF;

    //Instancia de la agenda
    Agenda agenda1 = new Agenda();

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
                    crearPersona();
                    break;
           case "2":
                    posicion = buscarPersona();
                    if (posicion == -1)
                      System.out.println("No existe la persona buscada.");
                    else
                      System.out.println("La persona se encuentra en la posicion " + posicion + "de la agenda.");
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

  // public Persona leerDatosPersona()
  //   {
  //
  // }

  private void crearPersona()
  {      Agenda agenda1;

     //Lectura de los atributos de persona
      System.out.println("Introduzca los datos sobre la persona a crear: ");
      System.out.println("Nombre: ");
      String nombre = Leer.porTeclado();
      System.out.println("Edad: ");
      int edad   = Integer.parseInt(Leer.porTeclado());
      System.out.println("NIF: ");
      String NIF    = Leer.porTeclado();

      //Instancia de persona
      Persona persona = new Persona(nombre, edad, NIF);

      //Agregar la persona a la agenda
      agenda1.crearPersona(persona);
  }

//Busca una personas
//Devuelve -1 si no existe la persona buscada
 private int buscarPersona()
 {       Agenda agenda1;

     //Guarda la posicion del vector en la que se encuentra la persona buscada
     int posicion;
     //Lectura del NIF de la persona a buscar
     System.out.println("Introduzca los datos de la persona que desea buscar: ");
     System.out.println("Nombre: ");
     String nombre = Leer.porTeclado();
     System.out.println("Edad: ");
     int edad = Integer.parseInt(Leer.porTeclado());
     System.out.println("NIF: ");
     String NIF = Leer.porTeclado();

     //Instancia de persona
     Persona persona = new Persona(nombre, edad, NIF);

     //Buscar la persona en la agenda
     posicion = agenda1.buscarPersona(persona);

     return posicion;
 }

}
