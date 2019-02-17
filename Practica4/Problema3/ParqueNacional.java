//Parques Nacionales
//Poseen nombre, extensión (km cuadrados)y Nº de especies de animales

public abstract class ParqueNacional
{
  //Atributos de Clase

  //Atributos de instancia
  String nombre;
  int extension;
  int numeroEspeciesAnimales;


//Getters y setters
  public void setNombre(String nombre)
    { this.nombre = nombre;

    }

  public String getNombre()
    { return nombre;

    }

  public void setExtension(int extension)
    { this.extension = extension;

    }

  public int getExtension()
    { return extension;

    }

  public void setNumeroEspeciesAnimales(int numeroEspeciesAnimales)
    { this.numeroEspeciesAnimales = numeroEspeciesAnimales;

    }

  public int getNumeroEspeciesAnimales()
    { return numeroEspeciesAnimales;

    }
  public String mostrarInformacion()
    { return "Nombre: " + this.getNombre() + "\nExtensión: " + this.getExtension() + " km2\nNº Especies Animales: " + this.getNumeroEspeciesAnimales();

    }
}
