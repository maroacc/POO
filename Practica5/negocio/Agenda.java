//Clase agenda
//poseen un vector de personas

package Practica5.negocio;

import Practica5.util.Leer;
import Practica5.dominio.Persona;

public class Agenda

{  Persona personas[] = new Persona[10];

  public void crearPersona(Persona persona)
  { for(int i=0;i<personas.length;i++)
       if(personas[i]==null)
         {
            personas[i] = persona;
            i=personas.length;
         }

  }


}
