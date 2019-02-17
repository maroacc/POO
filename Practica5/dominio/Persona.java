//Clase persona
//poseen un nombre, una edad y un NIF

package Practica5.dominio;


public class Persona
{
  //Atributos de Clase

  //Atributos de instancia
  String nombre;
  int edad;
  String NIF;


    //Constructores

    public Persona()
    {

    }

    public Persona(String nombre, int edad, String NIF)
    { this.nombre = nombre;
      this.edad = edad;
      this.NIF = NIF;

    }

    public void setNombre(String nombre)
      { this.nombre = nombre;

      }

    public String getNombre()
      { return nombre;

      }

    public void setEdad(int edad)
      { this.edad = edad;

      }

    public int getEdad()
      { return edad;

      }
    public void setNIF(String NIF)
      { this.NIF = NIF;

      }

    public String getNIF()
      { return NIF;

      }
   @Override
   public boolean equals(Object o)
     { Persona persona;
       boolean igual = false;

       if (o instanceof Persona)
        { persona = (Persona) o;
          if (persona.getNIF() == this.getNIF())
          igual = true;
        }
       return igual;
     }
}
