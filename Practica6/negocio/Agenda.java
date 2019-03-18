//Clase agenda
//Posee una base de datos formada por un vector de personas

package Practica6.negocio;

import java.util.ArrayList;
import Practica6.util.Leer;
import Practica6.dominio.Persona;

public class Agenda

  {private ArrayList personas = new ArrayList();

  //Agrega una nueva persona a la base de datos
  public void crearPersona(Persona persona)
  { personas.add(persona);

  }

  //Busca una persona según su NIF
  //Devuelve -1 si no se ha encontrado a la persona
  public int buscarPersona(String nif)
  { Persona persona = new Persona(nif);
    int posicion = personas.indexOf(persona);
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
  {
      Persona persona = (Persona) personas.get(posicion);
      return persona;

  }


}
