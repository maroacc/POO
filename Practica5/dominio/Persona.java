//Clase persona
//poseen un nombre, una edad y un NIF

package Practica5.dominio;


public class Persona
{
  //Atributos de Clase

  //Atributos de instancia
  String nombre;
  int edad;
  String nif;


    //Constructores

    public Persona()
    { this.nombre = null;
      this.edad = 0;
      this.nif = null;
    }

    public Persona(String nif)
    { this.nombre = null;
      this.edad = 0;
      this.nif = nif;
    }

    public Persona(String nombre, int edad, String nif)
    { this.nombre = nombre;
      this.edad = edad;
      this.nif = nif;

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
    public void setNif(String nif)
      { this.nif = nif;

      }

    public String getNif()
      { return nif;

      }
   @Override
   public boolean equals(Object o)
     { Persona persona;
       boolean igual = false;

       if (o instanceof Persona)
        {
           persona = (Persona) o;
           if (persona.getNif().equals(this.getNif()))
            {System.out.println("Son iguales");
            igual = true;}
          else
          { System.out.println("No son iguales");

          }
        }
       return igual;
     }
}
