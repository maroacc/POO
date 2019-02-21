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
    // variable que guardaá el NIF pedido al usuario para realizar las funciones de la App
    String nif;
    //Instancia de la agenda
    Agenda agenda1 = new Agenda();

  do{  //Mostrar el menu por pantalla
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
    System.out.println("##################################");

    //Leer la opcion del menu seleccionada
    opcion = Leer.porTeclado();
    System.out.println("OPCION: " + opcion);
      switch (opcion) {
           case "1":
                    crearPersona(agenda1);
                    break;
           case "2":
                    //Lectura del NIF de la persona a buscar
                    System.out.println("Introduzca el NIF de la persona que desea buscar: ");
                    System.out.println("NIF: ");
                    nif = Leer.porTeclado();

                    int posicion = buscarPersona(agenda1, nif);
                    if (posicion == -1)
                      System.out.println("No existe la persona buscada.");
                    else
                      System.out.println("La persona se encuentra en la posicion " + posicion + " de la agenda.");
                    break;
           case "3":
                    //Lectura del NIF de la persona a eliminar
                    System.out.println("Introduzca el NIF de la persona que desea eliminar: ");
                    System.out.println("NIF: ");
                    nif = Leer.porTeclado();
                    eliminarPersona(agenda1, nif);

                    break;
           case "4":
                   //Lectura del NIF de la persona a MODIFICAR
                   System.out.println("Introduzca el NIF de la persona cuyos datos desea modificar: ");
                   System.out.println("NIF: ");
                   nif = Leer.porTeclado();
                   modificarPersona(agenda1, nif);

                    break;
           case "5":
                    System.out.println("Mostrando la Agenda de contactos: ");
                    mostrarLista(agenda1);
                    break;
           case "9":
                    break;

           default: System.out.println("Opcion invalida");
                    break;}
    } while (opcion.equals("9")==false);
  }

  // public Persona leerDatosPersona()
  //   {
  //
  // }

  private static void crearPersona(Agenda agenda1)
  {

     //Lectura de los atributos de persona
      System.out.println("Introduzca los datos sobre la persona a crear: ");
      System.out.println("Nombre: ");
      String nombre = Leer.porTeclado();
      System.out.println("Edad: ");
      int edad   = Integer.parseInt(Leer.porTeclado());
      System.out.println("NIF: ");
      String nif    = Leer.porTeclado();

      //Instancia de persona
      Persona persona = new Persona(nombre, edad, nif);

      //Agregar la persona a la agenda
      agenda1.crearPersona(persona);
  }

//Busca una personas
//Devuelve -1 si no existe la persona buscada
 private static int buscarPersona(Agenda agenda1, String nif)
 {
     //Guarda la posicion del vector en la que se encuentra la persona buscada
     int posicion;

     //Buscar la persona en la agenda
     posicion = agenda1.buscarPersona(nif);

     return posicion;
 }

 //Elimina una persona
  private static void eliminarPersona(Agenda agenda1, String nif)
  {   //Guarda la posicion del vector en la que se encuentra la persona buscada
      int posicion;
      //Buscar la persona en la agenda
      posicion = agenda1.buscarPersona(nif);
      if (posicion == -1)
        { System.out.println("La persona que desea eliminar no existe en la agenda");
        }
     else
       //Elimina a la persona que se encuentra en la posicion del vector escogida
       agenda1.eliminarPersona(posicion);
  }

  //Elimina una persona
   private static void modificarPersona(Agenda agenda1, String nif)
   {   //Guarda la posicion del vector en la que se encuentra la persona buscada
       int posicion;
       //Buscar la persona en la agenda
       posicion = agenda1.buscarPersona(nif);
       if (posicion == -1)
         { System.out.println("La persona que desea modificar no existe en la agenda");
         }
      else
        { //Lectura de los atributos de persona
           System.out.println("Introduzca los datos sobre la persona a crear: ");
           System.out.println("Nombre: ");
           String nombre = Leer.porTeclado();
           System.out.println("Edad: ");
           int edad   = Integer.parseInt(Leer.porTeclado());
           System.out.println("NIF: ");
           nif    = Leer.porTeclado();

            //Modifica a la persona que se encuentra en la posicion del vector escogida
            agenda1.modificarPersona(posicion, nombre, edad, nif);
        }
   }

  //Muestra la agenda
   private static void mostrarLista(Agenda agenda1)
   {  for (int posicion = 0; posicion < 10; posicion++)
     { Persona persona = agenda1.mostrarElemento(posicion);
       if (persona != null)
         {System.out.println("NOMBRE: "+ persona.getNombre() + " EDAD: " + persona.getEdad()+ "NIF: " + persona.getNif());
         }
     }
   }

}
