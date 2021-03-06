//Clase Granja
//Posee el nombre del Ganadero al que pertenece, una localidad
//Y un vector de animales

package Inter2018.dominio;

public class Granja
{ //Atributos de Clase
  public final int N_MAX_ANIMALES = 10;
  //Atributos de instancia
  private String nombreGanadero;
  private String localidad;
  private Animal animales[] = new Animal[N_MAX_ANIMALES];

  //Constructores

  public Granja()
  { this.setNombreganadero(null);
    this.setLocalidad(null);
  }

  public Granja(String nombreGanadero, String localidad)
  { this.setNombreganadero(nombreGanadero);
    this.setLocalidad(localidad);
  }

  //Getters y setters

  public void setNombreganadero(String nombreGanadero)
    { this.nombreGanadero = nombreGanadero;

    }
  public String getNombreGanadero()
    { return nombreGanadero;

    }

  public void setLocalidad(String localidad)
    { this.localidad = localidad;

    }
  public String getLocalidad()
    { return localidad;

    }

  //Otros Métodos
  public void addAnimal(Animal animal)
    { for (int i = 0; i<animales.length; i++)
        if (animales[i] == null)
          {animales[i] = animal;
          i = animales.length;}

    }
  //Devuelve la cantidad total de pienso necesaria para la Granja
  //Redondea hacia abajo el resultado
  public double cantidadPienso()
    { double cantidadPienso = 0;
      //int cantidadPienso = 0;
      for (int i = 0; i<animales.length; i++)
          if (animales[i] != null)
            cantidadPienso = cantidadPienso + animales[i].comer();
      return Math.floor(cantidadPienso);
    }

  @Override
  public String toString()
    { StringBuilder sb = new StringBuilder();
      sb.append("NOMBRE GANADERO: ")
        .append(this.getNombreGanadero())
        .append(" LOCALIDAD: ")
        .append(this.getLocalidad())
        .append(" CANTIDAD PIENSO: ")
        .append(this.cantidadPienso());
        for (int i = 0; i<animales.length; i++)
            if (animales[i] != null)
              sb.append(animales[i].toString());
      return sb.toString();
    }
}
