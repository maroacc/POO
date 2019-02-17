//Clase agenda
//Posee una base de datos formada por un vector de personas

package Practica5.negocio;

import Practica5.util.Leer;
import Practica5.dominio.Persona;

public class Agenda

{  Persona personas[] = new Persona[10];

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
  public int buscarPersona(NIF)
  {

  }


}
