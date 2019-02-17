//Areas protegidas
//Son un tipo de parque Nacionales
//Además de los atributos de Parque Nacional,
//poseen una subvención del gobierno (en Chelines) y colabora en ellos una ONG
public class AreaProtegida extends ParqueNacional implements Visitable
{
  //Atributos de Clase

  //Atributos de instancia
  int subvencion;
  String ONG;


    //Constructores

    public AreaProtegida()
    {
      
    }

    public AreaProtegida(  String nombre, int extension, int numeroEspeciesAnimales,   int subvencion, String ONG)
      { super.setNombre(nombre);
        super.setExtension(extension);
        super.setNumeroEspeciesAnimales(numeroEspeciesAnimales);
        this.setSubvencion(subvencion);
        this.setONG(ONG);

      }

  //Getters y setters

  public void setSubvencion(int subvencion)
    { this.subvencion = subvencion;

    }

  public int getSubvencion()
    { return subvencion;

    }

  public void setONG(String ONG)
    { this.ONG = ONG;

    }

  public String getONG()
    { return ONG;

    }

  @Override
  public String mostrarInformacion()
    { return super.mostrarInformacion() + "\nSubvencion: " + this.getSubvencion() + "\nONG: " + this.getONG();

    }

  @Override
  public String visitar(String guia)
    { return "\nVisitando área protegida " + super.getNombre() + " con el guía " + guia;

    }
}
