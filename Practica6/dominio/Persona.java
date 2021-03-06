//Clase persona
//poseen un nombre, una edad y un NIF

package Practica6.dominio;


public class Persona
{
  //Atributos de Clase

  //Atributos de instancia
  private String nombre;
  private int edad;
  private String nif;


    //Constructores

    public Persona()
    { this.setNombre(null);
      this.setEdad(0);
      this.setNif(null);
    }

    public Persona(String nif)
    { this.setNombre(null);
      this.setEdad(0);
      this.setNif(nif);
    }

    public Persona(String nombre, int edad, String nif)
    { this.setNombre(nombre);
      this.setEdad(edad);
      this.setNif(nif);

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
            {igual = true;
            }
        }
       return igual;
     }


  @Override
  public String toString()
    { StringBuilder sb = new StringBuilder();
      sb.append("NOMBRE: ")
        .append(nombre)
        .append(" EDAD: ")
        .append(edad)
        .append(" NIF: ")
        .append(nif);

        return sb.toString();
    }
}
