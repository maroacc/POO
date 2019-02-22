//Clase agenda
//Posee una base de datos formada por un vector de personas

package Practica5.negocio;

import Practica5.util.Leer;
import Practica5.dominio.Persona;

public class Agenda

{  private Persona personas[] = new Persona[10];

  //Agrega una nueva persona a la base de datos
  public void crearPersona(Persona persona)
  { for(int i=0;i<personas.length;i++)
       if(personas[i]==null)
         {
            personas[i] = persona;
            i=personas.length;
         }

  }

  //Busca una persona según su NIF
  //Devuelve -1 si no se ha encontrado a la persona
  public int buscarPersona(String nif)
  { //Posicion de la persona a buscar en el vector
    int posicion = -1;
    Persona persona = new Persona(nif);
    for(int i=0;i<personas.length;i++)
    { if(personas[i]!=null)
         {
            if (persona.equals(personas[i]))
              { posicion = i;
              }

         }
    }
         return posicion;
  }

  public void eliminarPersona(int posicion)
  { personas[posicion] = null;

  }

  public void modificarPersona(int posicion, String nombre, int edad, String nif)
  { personas[posicion].setNombre(nombre);
    personas[posicion].setEdad(edad);
    personas[posicion].setNif(nif);
  }

  public Persona mostrarElemento(int posicion)
  { return personas[posicion];
  }


}
