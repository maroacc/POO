//Clase agenda
//Posee una base de datos formada por un vector de personas

package Practica5.negocio;

import java.util.ArrayList;
import Practica5.util.Leer;
import Practica5.dominio.Persona;

public class Agenda

{  private ArrayList personas = new ArrayList();

  //Agrega una nueva persona a la base de datos
  public void crearPersona(Persona persona)
  { personas.add(persona);

  }

  //Busca una persona según su NIF
  //Devuelve -1 si no se ha encontrado a la persona
  public int buscarPersona(String nif)
  { //Posicion de la persona a buscar en el vector
    int posicion = -1;
    Persona persona = new Persona(nif);

    posicion = personas.indexOf(persona);
    return posicion;
  }

  public void eliminarPersona(int posicion)
  { personas.remove(posicion);

  }

  public void modificarPersona(int posicion, String nombre, int edad, String nif)
  { Persona persona = (Persona) personas.get(posicion);
    persona.setNombre(nombre);
    persona.setEdad(edad);
    persona.setNif(nif);
  }

  public Persona mostrarElemento(int posicion)
  { Persona persona = (Persona) personas.get(posicion);
    return persona;
  }


}
